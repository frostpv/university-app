package com.example.universityapp.controller;

import org.springframework.stereotype.Component;

@Component
public class MenuController implements CommandExecutor {
    private static final String HELP_COMMAND = "help";
    private static final String COMMANDS_MENU = "\n List of command: "
            + "\n 1. Who is head of department {department_name}\""
            + "\n 2. Show {department_name} statistics\""
            + "\n 3. Show the average salary for the department {department_name}\""
            + "\n 4. Show count of employee for {department_name}\" "
            + "\n 5. Global search by {template}\""
            + "\n 6. quit for exit"
            + "\n 7. help for print list of commands";

    @Override
    public void run(String string) {
        System.out.println(COMMANDS_MENU);
    }

    @Override
    public boolean isCommandValid(String command) {
        return command.equals(HELP_COMMAND);
    }
}
