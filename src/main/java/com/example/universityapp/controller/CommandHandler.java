package com.example.universityapp.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CommandHandler {
    private final List<CommandExecutor> commandExecutorList;

    public void runCommand(String command) {
        commandExecutorList.stream()
                .filter(commandExecutor -> commandExecutor.isCommandValid(command.toLowerCase()))
                .findFirst()
                .ifPresentOrElse(commandExecutor -> commandExecutor.run(command.toLowerCase()),
                        () -> System.out.println("Invalid command"));
    }
}
