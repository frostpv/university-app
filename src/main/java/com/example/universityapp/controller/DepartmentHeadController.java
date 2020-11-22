package com.example.universityapp.controller;

import com.example.universityapp.model.Lector;
import com.example.universityapp.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("test")
@RequiredArgsConstructor
public class DepartmentHeadController implements CommandExecutor {
    private final DepartmentService departmentService;
    private static final String DEPARTMENT_HEAD_COMMAND = "Who is head of department";

    @Override
    public void run(String command) {
        String departmentName = command.replaceAll(DEPARTMENT_HEAD_COMMAND, "").trim();
        Optional<Lector> lector = Optional.ofNullable(departmentService
                .findByDepartmentNameIgnoreCase(departmentName).getHeadOfDepartment());

        lector.ifPresentOrElse(
                l-> System.out.println("Head of " + departmentName + " department is " + l.getName()),
                ()->System.out.println("Invalid department name" + departmentName));

    }

    @Override
    public boolean isCommandValid(String command) {
        return command.contains(DEPARTMENT_HEAD_COMMAND);
    }
}
