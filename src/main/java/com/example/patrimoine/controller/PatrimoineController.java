package com.example.patrimoine.controller;

import com.example.patrimoine.model.Patrimoine;
import com.example.patrimoine.service.PatrimoineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patrimoines")
public class PatrimoineController {
    @Autowired
    private PatrimoineService patrimoineService;

    @PutMapping("/{id}")
    public ResponseEntity<Void> createOrUpdatePatrimoine(@PathVariable String id, @RequestBody Patrimoine patrimoine) {
        patrimoineService.saveOrUpdatePatrimoine(id, patrimoine);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patrimoine> getPatrimoine(@PathVariable String id) {
        Patrimoine patrimoine = patrimoineService.getPatrimoine(id);
        return patrimoine != null ? ResponseEntity.ok(patrimoine) : ResponseEntity.notFound().build();
    }
}
