package com.example.universityapp.service.impl;

import com.example.universityapp.model.Degree;
import com.example.universityapp.model.Role;
import com.example.universityapp.repository.DegreeDao;
import com.example.universityapp.service.DegreeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DegreeImpl implements DegreeService {
    private DegreeDao degreeDao;

    @Override
    public void save(Degree degree) {
        degreeDao.save(degree);
    }

    @Override
    public Degree findByRole(Role role) {
        return degreeDao.findByRole(role);
    }
}
