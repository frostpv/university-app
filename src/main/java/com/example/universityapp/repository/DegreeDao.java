package com.example.universityapp.repository;

import com.example.universityapp.model.Degree;
import com.example.universityapp.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DegreeDao extends JpaRepository<Degree, Long> {
    Degree findByRole(Role role);
}
