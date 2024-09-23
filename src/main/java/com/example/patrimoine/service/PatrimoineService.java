package com.example.patrimoine.service;

import com.example.patrimoine.model.Patrimoine;
import com.example.patrimoine.repository.PatrimoineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatrimoineService {
    @Autowired
    private PatrimoineRepository patrimoineRepository;

    public Patrimoine getPatrimoine(String id) {
        return patrimoineRepository.findById(id);
    }

    public void saveOrUpdatePatrimoine(String id, Patrimoine patrimoine) {
        patrimoineRepository.save(id, patrimoine);
    }
}
