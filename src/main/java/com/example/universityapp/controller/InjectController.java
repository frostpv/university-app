package com.example.universityapp.controller;

import com.example.universityapp.model.Degree;
import com.example.universityapp.model.Department;
import com.example.universityapp.model.Lector;
import com.example.universityapp.model.Role;
import com.example.universityapp.service.DegreeService;
import com.example.universityapp.service.DepartmentService;
import com.example.universityapp.service.LectorService;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class InjectController implements CommandExecutor {
    private static final String INJECT_COMMAND = "inject";
    private final DepartmentService departmentService;
    private final DegreeService degreeService;
    private final LectorService lectorService;

    @Override
    public void run(String command) {
        createData();
        System.out.println("Injected test data");
    }

    @Override
    public boolean isCommandValid(String command) {
        return command.equals(INJECT_COMMAND);
    }

    private void createData() {
        Degree assistant = Degree.of("ASSISTANT");
        degreeService.save(assistant);
        Degree associateProfessor = Degree.of("ASSOCIATE_PROFESSOR");
        degreeService.save(associateProfessor);
        Degree professor = Degree.of("PROFESSOR");
        degreeService.save(professor);

        Lector ivanov = new Lector();
        ivanov.setName("Ivan Ivanov");
        ivanov.setSalary(1000);
        ivanov.setDegree(degreeService.findByRole(Role.ASSISTANT));
        lectorService.save(ivanov);
        Lector petrov = new Lector();
        petrov.setName("Petro Petrov");
        petrov.setSalary(2000);
        petrov.setDegree(degreeService.findByRole(Role.ASSOCIATE_PROFESSOR));
        lectorService.save(petrov);
        Lector alexandrov = new Lector();
        alexandrov.setName("Sidor Sidorov");
        alexandrov.setSalary(3000);
        alexandrov.setDegree(degreeService.findByRole(Role.PROFESSOR));

        Department historical = new Department();
        historical.setDepartmentName("Historical");
        historical.setHeadOfDepartment(lectorService.findByName("Sidor Sidorov"));
        List<Lector> lawLecturers = new ArrayList<>();
        lawLecturers.add(lectorService.findByName("Petro Petrov"));
        lawLecturers.add(lectorService.findByName("Ivan Ivanov"));
        lawLecturers.add(lectorService.findByName("Sidor Sidorov"));
        historical.setLectorList(lawLecturers);
        departmentService.save(historical);
    }
}
