package com.example.test;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Item implements Serializable {
    protected String nom;
    protected double prix;
    protected LocalDate dateAchat;
    protected String emplacement;
    protected Etat etat;

    public Item(String nom, double prix, LocalDate dateAchat, String emplacement, Etat etat) {
        this.nom = nom;
        this.prix = prix;
        this.dateAchat = dateAchat;
        this.emplacement = emplacement;
        this.etat = etat;
    }

    public abstract String toString();
}