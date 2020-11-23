package com.example.universityapp.service.impl;

import com.example.universityapp.model.Lector;
import com.example.universityapp.repository.LectorDao;
import com.example.universityapp.service.LectorService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LectorServiceImpl implements LectorService {
    private final LectorDao lectorDao;

    @Override
    public void save(Lector lector) {
        lectorDao.save(lector);
    }

    @Override
    public List<Lector> findLectorsByNameContainsIgnoreCase(String template) {
        return lectorDao.findLectorsByNameContainsIgnoreCase(template);
    }

    @Override
    public Lector findByName(String name) {
        return lectorDao.findByName(name);
    }
}
