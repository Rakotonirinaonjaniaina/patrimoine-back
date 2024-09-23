package com.example.patrimoine.repository;

import com.example.patrimoine.model.Patrimoine;
import org.springframework.stereotype.Repository;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

@Repository
public class PatrimoineRepository {
    private final Map<String, Patrimoine> database = new HashMap<>();
    private final Path filePath = Paths.get("patrimoine.txt");

    public Patrimoine findById(String id) {
        return database.get(id);
    }

    public void save(String id, Patrimoine patrimoine) {
        database.put(id, patrimoine);
        writeToDisk(id, patrimoine);
    }

    private void writeToDisk(String id, Patrimoine patrimoine) {
        try {
            String data = id + "," + patrimoine.getPossesseur() + "," + patrimoine.getDerniereModification() + "\n";
            Files.write(filePath, data.getBytes(), java.nio.file.StandardOpenOption.CREATE, java.nio.file.StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
