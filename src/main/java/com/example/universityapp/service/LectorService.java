package com.example.universityapp.service;

import com.example.universityapp.model.Lector;

import java.util.List;

public interface LectorService {
    void save(Lector lector);

    List<Lector> findLectorsByNameContainsIgnoreCase(String template);

    Lector findByName(String name);
}
