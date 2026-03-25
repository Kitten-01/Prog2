package com.example.test;

import java.io.*;

public class Inventaire {
    private Item[] items;
    private int taille;

    public Inventaire() {
        items = new Item[10];
        taille = 0;
    }

    public void ajouter(Item item) {
        if (taille == items.length) {
            agrandir();
        }
        items[taille] = item;
        taille++;
    }

    private void agrandir() {
        Item[] nouveau = new Item[items.length + 10];
        for (int i = 0; i < items.length; i++) {
            nouveau[i] = items[i];
        }
        items = nouveau;
    }

    public void supprimer(int index) {
        if (index < 0 || index >= taille) return;

        for (int i = index; i < taille - 1; i++) {
            items[i] = items[i + 1];
        }

        items[taille - 1] = null;
        taille--;
    }

    public Item rechercher(String motCle) {
        for (int i = 0; i < taille; i++) {
            if (items[i].toString().toLowerCase().contains(motCle.toLowerCase())) {
                return items[i];
            }
        }
        return null;
    }

    public Item[] getItems() {
        Item[] resultat = new Item[taille];
        for (int i = 0; i < taille; i++) {
            resultat[i] = items[i];
        }
        return resultat;
    }

    // =========================
    //  SAUVEGARDE
    // =========================
    public void sauvegarder(String fichier) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichier))) {
            oos.writeObject(items);
            oos.writeInt(taille); // save actual size too
            System.out.println("Sauvegarde réussie !");
        } catch (IOException e) {
            System.out.println("Erreur sauvegarde : " + e.getMessage());
        }
    }

    // =========================
    // CHARGEMENT
    // =========================
    public void charger(String fichier) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichier))) {
            items = (Item[]) ois.readObject();
            taille = ois.readInt(); // restore correct size
            System.out.println("Chargement réussi !");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erreur chargement : " + e.getMessage());
        }
    }
}