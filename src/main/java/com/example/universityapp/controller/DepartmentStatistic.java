package com.example.universityapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Component
public class DepartmentStatistic implements CommandExecutor {
    @Override
    public void run(String string) {

    }

    @Override
    public boolean isCommandValid(String command) {
        return false;
    }
}
