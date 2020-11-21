package com.example.universityapp.service;

import com.example.universityapp.model.Degree;
import com.example.universityapp.model.Role;

public interface DegreeService {
    void save(Degree degree);

    Degree findByRole(Role role);
}
