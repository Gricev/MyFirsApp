package com.example.myfirstapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Logger;

public class HelloApplication extends Application {

    private static final Logger logger = Logger.getGlobal();

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/Hellow.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 400);
        stage.setTitle("My GAZuslugi!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        logger.info("оппа-оппа-опапа");
        launch();
       
    }

}