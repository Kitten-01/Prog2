package com.example.test;

import java.time.LocalDate;

public class Tool extends Item {
    private String marque;
    private String modele;

    public Tool(String nom, double prix, LocalDate dateAchat, String emplacement, Etat etat, String marque, String modele) {
        super(nom, prix, dateAchat, emplacement, etat);
        this.marque = marque;
        this.modele = modele;
    }

    @Override
    public String toString() {
        return nom + " - " + marque + " " + modele;
    }
}