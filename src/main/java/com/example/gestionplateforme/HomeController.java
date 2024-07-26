package com.example.gestionplateforme;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class HomeController {

    @FXML
    private Label userCountLabel;

    @FXML
    private Label projectCountLabel;

    @FXML
    private Button utilisateursButton;

    @FXML
    private Button sallesButton;

    @FXML
    private Button projetsButton;

    // Initialise les compteurs avec des valeurs par défaut (vous pouvez les remplacer par des valeurs réelles depuis la base de données)
    private int userCount = 0;
    private int projectCount = 0;

    // Cette méthode est appelée après que le FXML soit chargé
    @FXML
    private void initialize() {
        updateCounts();
    }

    // Met à jour les étiquettes avec les compteurs actuels
    private void updateCounts() {
        userCountLabel.setText("Number of Users: " + userCount);
        projectCountLabel.setText("Number of Projects: " + projectCount);
    }

    // Gère l'action du bouton "Utilisateurs"
    @FXML
    private void handleUtilisateurs() {
        // Ajoutez ici le code pour naviguer vers la page des utilisateurs
        System.out.println("Navigating to Utilisateurs...");
        // Exemple de mise à jour du compteur
        userCount++;
        updateCounts();
    }

    // Gère l'action du bouton "Salles"
    @FXML
    private void handleSalles() {
        // Ajoutez ici le code pour naviguer vers la page des salles
        System.out.println("Navigating to Salles...");
        // Exemple de mise à jour du compteur
        // Aucune mise à jour du compteur pour cette action
    }

    // Gère l'action du bouton "Projets"
    @FXML
    private void handleProjets() {
        // Ajoutez ici le code pour naviguer vers la page des projets
        System.out.println("Navigating to Projets...");
        // Exemple de mise à jour du compteur
        projectCount++;
        updateCounts();
    }
}