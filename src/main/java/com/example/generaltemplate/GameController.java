package com.example.generaltemplate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class GameController {
    @FXML
    public TextArea battleResultTxtArea;
    @FXML
    public ImageView idahoImg, bakeryImg, riceFieldsImg, questionMarkImg;
    private World world;

    public void initialize() {
        world = new World(idahoImg, bakeryImg, riceFieldsImg, questionMarkImg);
    }
    @FXML
    public void handleClick(ActionEvent event) {
        battleResultTxtArea.setText(world.handleBattle());
    }

}