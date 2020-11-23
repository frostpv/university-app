package com.example.universityapp.controller;

import com.example.universityapp.model.Lector;
import com.example.universityapp.repository.LectorDao;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class SearchController implements CommandExecutor {
    private static final String SEARCH_COMMAND = "global search by";
    private final LectorDao lectorDao;

    @Override
    public void run(String command) {
        String searchWord = command.replaceAll(SEARCH_COMMAND, "").trim();
        List<Lector> lecturersByNameContains
                = lectorDao.findLectorsByNameContainsIgnoreCase(searchWord);
        if (lecturersByNameContains.size() > 0) {
            lecturersByNameContains.forEach(lector -> System.out.println(lector.getName() + ", "));
        } else {
            System.out.println("Not found Lectors with name " + searchWord);
        }
    }

    @Override
    public boolean isCommandValid(String command) {
        return command.contains(SEARCH_COMMAND);
    }
}
