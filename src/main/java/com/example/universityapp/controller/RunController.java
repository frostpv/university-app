package com.example.universityapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class RunController {
    CommandHandler commandHandler;
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
