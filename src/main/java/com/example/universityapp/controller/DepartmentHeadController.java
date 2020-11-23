package com.example.universityapp.controller;

import com.example.universityapp.model.Department;
import com.example.universityapp.service.DepartmentService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DepartmentHeadController implements CommandExecutor {
    private static final String DEPARTMENT_HEAD_COMMAND = "who is head of department";
    private final DepartmentService departmentService;

    @Override
    public void run(String command) {
        String departmentName = command.replaceAll(DEPARTMENT_HEAD_COMMAND, "").trim();
        Optional<Department> departmentOptional =
                Optional.ofNullable(departmentService
                        .findByDepartmentNameIgnoreCase(departmentName));
        if (departmentOptional.isPresent()) {
            System.out.println("Head of " + departmentName + " department is "
                    + departmentOptional.get().getHeadOfDepartment().getName());
        } else {
            System.out.println("Invalid department name " + departmentName);
        }
    }

    @Override
    public boolean isCommandValid(String command) {
        return command.contains(DEPARTMENT_HEAD_COMMAND);
    }
}
