package com.example.universityapp.repository;

import com.example.universityapp.model.Lector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LectorDao extends JpaRepository <Lector, Long> {
    List<Lector> findLectorsByNameContainsIgnoreCase(String template);

    Lector findByName(String name);
}
