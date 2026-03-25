package com.example.test;

import java.time.LocalDate;

public class Book extends Item {
    private String auteur;
    private String editeur;

    public Book(String nom, double prix, LocalDate dateAchat, String emplacement, Etat etat, String auteur, String editeur) {
        super(nom, prix, dateAchat, emplacement, etat);
        this.auteur = auteur;
        this.editeur = editeur;
    }

    @Override
    public String toString() {
        return nom + " - " + auteur + " (" + editeur + ")";
    }
}