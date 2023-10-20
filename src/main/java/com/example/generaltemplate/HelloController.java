package com.example.generaltemplate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField txtInput;
    @FXML
    private Button button;
    @FXML
    private Label label;
    @FXML
    public void handleClick(ActionEvent event) {
        label.setText(txtInput.getText());
    }

}