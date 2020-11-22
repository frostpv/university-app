package com.example.universityapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.Scanner;

@RequiredArgsConstructor
@Component
public class RunController {
    private final CommandHandler commandHandler;
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String line = scanner.nextLine();
            if (line.equalsIgnoreCase("quit")) {
                System.out.println("xxx");
            } else {
                commandHandler.runCommand(line);
            }
        }
    }
}
