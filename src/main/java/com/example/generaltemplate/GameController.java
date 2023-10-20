package com.example.generaltemplate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class GameController {
    @FXML
    private TextField txtInput;
    @FXML
    private Label label;
    private World world;

    public void initialize() {
        world = new World();
    }
    @FXML
    public void handleClick(ActionEvent event) {
        label.setText(txtInput.getText());
    }

}