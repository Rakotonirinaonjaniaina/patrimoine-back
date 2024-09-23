package com.example.patrimoine.model;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Patrimoine {
    private String possesseur;
    private LocalDateTime derniereModification;

    public void setPossesseur(String possesseur) {
        this.possesseur = possesseur;
        this.derniereModification = LocalDateTime.now();
    }
}

