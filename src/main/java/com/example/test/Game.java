package com.example.test;

import java.time.LocalDate;

public class Game extends Item {
    private int age;
    private int joueurs;

    public Game(String nom, double prix, LocalDate dateAchat, String emplacement, Etat etat, int age, int joueurs) {
        super(nom, prix, dateAchat, emplacement, etat);
        this.age = age;
        this.joueurs = joueurs;
    }

    @Override
    public String toString() {
        return nom + " - " + joueurs + " joueurs";
    }
}