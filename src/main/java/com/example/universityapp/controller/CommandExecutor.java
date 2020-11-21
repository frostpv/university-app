package com.example.universityapp.controller;

public interface CommandExecutor {
    void run(String string);

    boolean isCommandValid(String command);
}
