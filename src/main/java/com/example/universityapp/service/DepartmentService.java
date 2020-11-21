package com.example.universityapp.service;

import com.example.universityapp.model.Department;

public interface DepartmentService {
    void save(Department department);

    Department findByDepartmentNameIgnoreCase(String departmentName);
}
