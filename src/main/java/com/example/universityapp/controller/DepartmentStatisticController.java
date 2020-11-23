package com.example.universityapp.controller;

import com.example.universityapp.model.Degree;
import com.example.universityapp.model.Department;
import com.example.universityapp.model.Lector;
import com.example.universityapp.model.Role;
import com.example.universityapp.service.DepartmentService;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DepartmentStatisticController implements CommandExecutor {
    private static final String STATISTIC_COMMAND_SHOW = "show";
    private static final String STATISTIC_COMMAND_STATISTICS = "statistics";
    private final DepartmentService departmentService;

    @Override
    public void run(String command) {
        String departmentName = command.replaceAll(STATISTIC_COMMAND_SHOW, "")
                .replaceAll(STATISTIC_COMMAND_STATISTICS, "")
                .trim();
        Optional<Department> departmentOptional =
                Optional.ofNullable(departmentService
                        .findByDepartmentNameIgnoreCase(departmentName));
        if (departmentOptional.isPresent()) {
            Map<Role, Long> rolesCountMap = departmentOptional.stream()
                    .map(Department::getLectorList)
                    .flatMap(lectors -> lectors.stream())
                    .map(Lector::getDegree)
                    .map(Degree::getRole)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

            if (rolesCountMap.isEmpty()) {
                System.out.println("In department " + departmentName + " does not exist workers");
            } else {
                StringBuilder result = new StringBuilder();
                for (Map.Entry<Role, Long> roleLongEntry : rolesCountMap.entrySet()) {
                    result.append("\n")
                            .append(roleToString(roleLongEntry.getKey()))
                            .append(" - ")
                            .append(roleLongEntry.getValue());
                }
                System.out.println(result.toString());
            }
        } else {
            System.out.println("Invalid name of department: " + departmentName);
        }

    }

    private String roleToString(Role role) {
        if (role.equals(Role.ASSISTANT)) {
            return "Assistants";
        } else if (role.equals(Role.ASSOCIATE_PROFESSOR)) {
            return "Associate professors";
        } else if (role.equals(Role.PROFESSOR)) {
            return "Professors";
        }
        return role.toString();
    }

    @Override
    public boolean isCommandValid(String command) {
        return command.contains(STATISTIC_COMMAND_SHOW)
                && command.contains(STATISTIC_COMMAND_STATISTICS);
    }
}
