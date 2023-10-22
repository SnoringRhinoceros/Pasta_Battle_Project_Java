package com.example.generaltemplate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class GameController {
    @FXML
    public TextArea battleResultTxtArea;
    @FXML
    public ImageView idahoImg, bakeryImg, riceFieldsImg, questionMarkImg;
    @FXML
    public Button idahoBtn, bakeryBtn, riceFieldsBtn, questionMarkBtn;
    private World world;
    private SceneSwitcher sceneSwitcher;
    private int constructed = 0;

    @FXML
    public void initialize() {
        if (constructed == 0) {
            world = new World(idahoImg, bakeryImg, riceFieldsImg, questionMarkImg);
            sceneSwitcher = new SceneSwitcher();
            if (questionMarkBtn != null) {
                questionMarkBtn.setDisable(true);
            }
            if (!(idahoBtn == null) && !(bakeryBtn == null) && !(riceFieldsBtn == null) && !(questionMarkBtn == null)) {
                sceneSwitcher.addSceneSwitch(idahoBtn, "idaho-view.fxml");
                sceneSwitcher.addSceneSwitch(bakeryBtn, "bakery-view.fxml");
                sceneSwitcher.addSceneSwitch(riceFieldsBtn, "riceFields-view.fxml");
                sceneSwitcher.addSceneSwitch(questionMarkBtn, "questionMark-view.fxml");
            }
            constructed++;
        }
    }

    @FXML
    public void handleSceneSwitchBtnClick(MouseEvent event) throws Exception {
        sceneSwitcher.handleSwitch(event);
    }

    @FXML
    public void handleBattleButtonClick(ActionEvent event) {
        battleResultTxtArea.setText(world.handleBattle());
    }

    public void goBack(ActionEvent actionEvent) throws Exception {
        sceneSwitcher.switchToMain();
    }
}