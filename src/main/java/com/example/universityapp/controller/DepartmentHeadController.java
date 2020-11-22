package com.example.universityapp.controller;

import com.example.universityapp.model.Department;
import com.example.universityapp.model.Lector;
import com.example.universityapp.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class DepartmentHeadController implements CommandExecutor {
    private final DepartmentService departmentService;
    private static final String DEPARTMENT_HEAD_COMMAND = "Who is head of department";

    @Override
    public void run(String command) {
        System.out.println(1);
        String departmentName = command.replaceAll(DEPARTMENT_HEAD_COMMAND, "").trim();
        Optional.ofNullable(departmentService.findByDepartmentNameIgnoreCase(departmentName))
                .map(Department::getHeadOfDepartment)
                .map(Lector::getName)
                .ifPresentOrElse(
                        n -> System.out.println("Head of " + departmentName + " department is " + n),
                        () -> System.out.println("Incorrect department name " + departmentName)
                );

        //departmentFromDb.ifPresentOrElse(
         //       l-> System.out.println("Head of " + departmentName + " department is " + departmentFromDb.ifPresent(department -> department.getHeadOfDepartment().getName()),

           //     ()->System.out.println("Invalid department name" + departmentName));
    }

    @Override
    public boolean isCommandValid(String command) {
        return command.contains(DEPARTMENT_HEAD_COMMAND);
    }
}
