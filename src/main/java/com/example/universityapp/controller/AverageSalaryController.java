package com.example.universityapp.controller;

import com.example.universityapp.model.Department;
import com.example.universityapp.model.Lector;
import com.example.universityapp.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class AverageSalaryController implements CommandExecutor{
    private static final String AVERAGE_SALARY_COMMAND = "show the average salary for the department";
    private final DepartmentService departmentService;

    @Override
    public void run(String command) {
        String departmentName = command.replaceAll(AVERAGE_SALARY_COMMAND, "").trim();
        Optional<Department> departmentOptional
                = Optional.ofNullable(departmentService.findByDepartmentNameIgnoreCase(departmentName));
        if(departmentOptional.isPresent()) {
            departmentOptional.get().getLectorList().stream()
                    .map(Lector::getSalary)
                    .mapToInt(Integer::intValue)
                    .average()
                    .ifPresentOrElse(x-> System.out.println("The average salary of " + departmentName + " is " + x),
                            ()-> System.out.println("Does not info about average salary of " + departmentName));
        } else {
            System.out.println("Invalid name of department: " + departmentName);
        }
    }

    @Override
    public boolean isCommandValid(String command) {

        return command.contains(AVERAGE_SALARY_COMMAND);
    }
}
