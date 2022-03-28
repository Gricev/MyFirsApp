package com.example.myfirstapp;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class RegistrationController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField countryField;

    @FXML
    private CheckBox femaleField;

    @FXML
    private Button registrateButton;

    @FXML
    private TextField registrationLastnameField;

    @FXML
    private TextField registrationLoginField;

    @FXML
    private TextField registrationNameField;

    @FXML
    private PasswordField registrationPasswordField;

    @FXML
    void initialize() {

        registrateButton.setOnAction(event -> {

            signUpNewUser();
            openNewScene("/Hellow.fxml");

        });
    }

    private void signUpNewUser() {
        DataBaseHandler dbHandler = new DataBaseHandler();

        String firstName = registrationNameField.getText();
        String lastName = registrationLastnameField.getText();
        String userName = registrationLoginField.getText();
        String password = registrationPasswordField.getText();
        String location = countryField.getText();
        String sex = "";
        if(femaleField.isSelected()) {
            sex = "Мужской";
        } else {
            sex = "Женский";
        }
        User user = new User(firstName, lastName, userName, password, location, sex);

        dbHandler.signUpUser(user);
    }

    public void openNewScene(String window) {
        registrateButton.getScene().getWindow().hide();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(window));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }
}
