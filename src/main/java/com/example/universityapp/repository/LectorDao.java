package com.example.universityapp.repository;

import com.example.universityapp.model.Lector;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LectorDao extends JpaRepository<Lector, Long> {
    List<Lector> findLectorsByNameContainsIgnoreCase(String template);

    Lector findByName(String name);
}
