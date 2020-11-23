package com.example.universityapp.controller;

import com.example.universityapp.model.Lector;
import com.example.universityapp.repository.LectorDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;

@RequiredArgsConstructor
@Component
public class SearchController implements CommandExecutor{
    private final static String SEARCH_COMMAND = "global search by";
    private final LectorDao lectorDao;

    @Override
    public void run(String command) {
        String searchWord = command.replaceAll(SEARCH_COMMAND, "").trim();
        List<Lector> lecturersByNameContains = lectorDao.findLecturersByNameContains(searchWord);
        if(lecturersByNameContains.size() > 0) {
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
