package com.example.universityapp;

import com.example.universityapp.controller.RunController;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class Main implements CommandLineRunner {
    private final RunController runController;
    @Override
    public void run(String... args) throws Exception {
        runController.run();
    }
}
