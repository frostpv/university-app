package com.example.universityapp.controller;

import java.util.Scanner;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class RunController {
    private final CommandHandler commandHandler;

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String line = scanner.nextLine();
            if (line.equalsIgnoreCase("quit")) {
                System.exit(0);
            } else {
                commandHandler.runCommand(line);
            }
        }
    }
}
