package com.example.generaltemplate;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.LinkedHashMap;

public class ScreenController {
    private GameController gameController;
    private Stage stage;
    public ScreenController(Stage stage) {
        this.stage = stage;
        gameController = new GameController();
    }

    protected void activate(String name) throws IOException {
        gameController.setScreenController(this);
        FXMLLoader loader = new FXMLLoader(getClass().getResource(name + "-view.fxml"));
        loader.setController(gameController);
        Parent root = loader.load();
        stage.setScene(new Scene(root));
        stage.show();
    }
}