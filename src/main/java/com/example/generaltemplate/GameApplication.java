package com.example.generaltemplate;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GameApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        ScreenController screenController = new ScreenController(stage);
        screenController.activate("main");
    }

    public static void main(String[] args) {
        launch();
    }
}