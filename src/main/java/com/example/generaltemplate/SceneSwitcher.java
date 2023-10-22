package com.example.generaltemplate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.LinkedHashMap;
import java.util.Map;

public class SceneSwitcher {
    Map<Button, String> buttonFXMLNameHashMap = new LinkedHashMap<>();

    @FXML
    public void handleSwitch (MouseEvent event) throws Exception {
        for (Map.Entry<Button, String> set: buttonFXMLNameHashMap.entrySet()) {
            if (set.getKey() == event.getSource()) {
                Stage stage = (Stage) set.getKey().getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource(set.getValue()));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                return;
            }
        }
    }

    public void switchToMain() throws Exception {
        System.out.println(buttonFXMLNameHashMap.entrySet().iterator());
        if (buttonFXMLNameHashMap.entrySet().iterator().hasNext()) {
            Stage stage = (Stage) buttonFXMLNameHashMap.entrySet().iterator().next().getKey().getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("main-view.fxml"));

            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.show();
        }
    }

    public void addSceneSwitch(Button button, String documentName) {
        buttonFXMLNameHashMap.put(button, documentName);
    }
}
