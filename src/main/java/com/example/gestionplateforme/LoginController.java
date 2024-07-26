package com.example.gestionplateforme;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class LoginController {

    @FXML
    private TextField cinField;

    @FXML
    private TextField passwordField;

    private boolean authenticate(String cin, String password) {
        String url = "jdbc:mysql://localhost:3306/GestionPlateforme";
        String user = "root";
        String pass = "root";

        try (Connection connection = DriverManager.getConnection(url, user, pass)) {
            String sql = "SELECT * FROM admin WHERE cin = ? AND password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cin);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
//            System.out.println("requete sql :"+sql);
//            System.out.println("requete sql :"+resultSet);

            return resultSet.next(); // Authentication successful if a record is found
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void handleLoginButtonAction(ActionEvent event) {
        String cin = cinField.getText();
        String password = passwordField.getText();

        if (authenticate(cin, password)) {
            try {
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("home.fxml")));
                Stage stage = (Stage) cinField.getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Incorrect CIN or Password");
            alert.show();
        }
    }
}
