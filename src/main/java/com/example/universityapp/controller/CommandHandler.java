package com.example.universityapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CommandHandler {
    private final Map<String, CommandExecutor> commandExecutorList;

    public void runCommand (String command) {
        if(commandExecutorList.containsKey(command)) {
            System.out.println("hello");
        }
    }
}
