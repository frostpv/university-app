package com.example.universityapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CommandHandler {
    private final List<CommandExecutor> commandExecutorList;

    public void runCommand (String command) {
        commandExecutorList.stream()
                .filter(commandExecutor -> commandExecutor.isCommandValid(command))
                .findFirst().ifPresentOrElse(commandExecutor -> commandExecutor.run(command),
                ()->System.out.println("Invalid command"));
    }
}
