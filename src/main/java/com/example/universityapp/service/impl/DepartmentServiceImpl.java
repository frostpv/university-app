package com.example.universityapp.service.impl;

import com.example.universityapp.model.Department;
import com.example.universityapp.repository.DepartmentDao;
import com.example.universityapp.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentDao departmentDao;
    @Override
    public void save(Department department) {
        departmentDao.save(department);
    }

    @Override
    public Department findByDepartmentNameIgnoreCase(String departmentName) {
       return departmentDao.findByDepartmentNameIgnoreCase(departmentName);
    }
}
