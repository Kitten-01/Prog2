
package com.example.test;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDate;

public class Main extends Application {

    private Inventaire inv = new Inventaire();
    private ListView<String> listView = new ListView<>();

    @Override
    public void start(Stage stage) {

        TextField txtSearch = new TextField();
        txtSearch.setPromptText("Rechercher...");

        // Inputs
        TextField txtNom = new TextField();
        txtNom.setPromptText("Nom");

        TextField txtPrix = new TextField();
        txtPrix.setPromptText("Prix");

        // Buttons
        Button btnSearch = new Button("Rechercher");
        Button btnAjouter = new Button("Ajouter Livre");
        Button btnGame = new Button("Ajouter Jeu");
        Button btnTool = new Button("Ajouter Outil");
        Button btnSupprimer = new Button("Supprimer");
        Button btnSave = new Button("Sauvegarder");
        Button btnLoad = new Button("Charger");

        // Actions
        btnAjouter.setOnAction(e -> {
            try {
                String nom = txtNom.getText();
                double prix = Double.parseDouble(txtPrix.getText());

                inv.ajouter(new Book(nom, prix, LocalDate.now(), "Moi", Etat.EN_POSSESSION, "Auteur", "Editeur"));
                rafraichirListe();

                txtNom.clear();
                txtPrix.clear();

            } catch (Exception ex) {
                System.out.println("Erreur de saisie");
            }
        });

        btnSearch.setOnAction(e -> {
            listView.getItems().clear();

            Item resultat = inv.rechercher(txtSearch.getText());

            if (resultat != null) {
                listView.getItems().add(resultat.toString());
            } else {
                listView.getItems().add("Aucun résultat");
            }
        });

        btnGame.setOnAction(e -> {
            inv.ajouter(new Game("Zelda", 60, LocalDate.now(), "Moi", Etat.EN_POSSESSION, 12, 1));
            rafraichirListe();
        });

        btnTool.setOnAction(e -> {
            inv.ajouter(new Tool("Tournevis", 10, LocalDate.now(), "Moi", Etat.EN_POSSESSION, "Stanley", "T100"));
            rafraichirListe();
        });

        btnSupprimer.setOnAction(e -> {
            int index = listView.getSelectionModel().getSelectedIndex();
            if (index >= 0) {
                inv.supprimer(index);
                rafraichirListe();
            }
        });

        btnSave.setOnAction(e -> {
            inv.sauvegarder("inventaire.dat");
        });

        btnLoad.setOnAction(e -> {
            inv.charger("inventaire.dat");
            rafraichirListe();
        });

        // Layout
        VBox root = new VBox(10,
                txtNom,
                txtPrix,
                txtSearch,
                btnSearch,
                btnAjouter,
                btnGame,
                btnTool,
                btnSupprimer,
                btnSave,
                btnLoad,
                listView
        );

        Scene scene = new Scene(root, 400, 400);

        stage.setTitle("Inventaire");
        stage.setScene(scene);
        stage.show();
    }

    private void rafraichirListe() {
        listView.getItems().clear();

        for (Item item : inv.getItems()) {
            listView.getItems().add(item.toString());
        }
    }

    public static void main(String[] args) {
        launch();
    }
}