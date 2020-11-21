package com.example.universityapp.repository;

import com.example.universityapp.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentDao extends JpaRepository<Department, Long> {
    Department findByDepartmentNameIgnoreCase(String departmentName);
}
