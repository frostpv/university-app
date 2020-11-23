package com.example.universityapp.controller;

import com.example.universityapp.model.Department;
import com.example.universityapp.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class CountEmployeeController implements  CommandExecutor{
    private static final String COUNT_OF_EMPLOYEE_COMMAND = "show count of employee for";
    private final DepartmentService departmentService;

    @Override
    public void run(String command) {
        String departmentName = command.replaceAll(COUNT_OF_EMPLOYEE_COMMAND, "").trim();
        Optional<Department> departmentOptional
                = Optional.ofNullable(departmentService.findByDepartmentNameIgnoreCase(departmentName));
        if(departmentOptional.isPresent()) {
            System.out.println(departmentOptional.get().getLectorList().size());
        } else {
            System.out.println("Invalid name of department " + departmentName);
        }
    }

    @Override
    public boolean isCommandValid(String command) {
        return command.contains(COUNT_OF_EMPLOYEE_COMMAND);
    }
}
