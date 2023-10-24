package com.example.generaltemplate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class GameController {
    @FXML
    public TextArea battleResultTxtArea;
    @FXML
    public ImageView idahoImg, bakeryImg, riceFieldsImg, questionMarkImg;
    @FXML
    public Button idahoBtn, bakeryBtn, riceFieldsBtn, questionMarkBtn;
    private World world;
    private ScreenController screenController;

    public void setScreenController(ScreenController screenController) {
        this.screenController = screenController;
    }

    public GameController() {

    }

    public GameController(GameController another) {
        this.battleResultTxtArea = another.battleResultTxtArea;
        this.world = another.world;
        this.screenController = another.screenController;
    }

    public void myOwnInit() {
        world = new World(idahoImg, bakeryImg, riceFieldsImg, questionMarkImg);
        questionMarkBtn.setDisable(true);
    }

    @FXML
    public void handleBattleButtonClick(ActionEvent event) {
        battleResultTxtArea.setText(world.handleBattle());
    }

    private void handleSceneSwitchBtnClick(String name) throws IOException {
        screenController.activate(name);
    }

    @FXML
    public void handleIdahoBtnClick(MouseEvent mouseEvent) throws IOException {
        handleSceneSwitchBtnClick("idaho");
    }

    @FXML
    public void handleBakeryBtnClick(MouseEvent mouseEvent) throws IOException {
        handleSceneSwitchBtnClick("bakery");
    }

    @FXML
    public void handleRiceFieldsBtnClick(MouseEvent mouseEvent) throws IOException {
        handleSceneSwitchBtnClick("riceFields");
    }

    @FXML
    public void handleQuestionMarkBtnClick(MouseEvent mouseEvent) throws IOException {
        handleSceneSwitchBtnClick("questionMark");
    }

    @FXML
    public void goBack(MouseEvent mouseEvent) throws IOException {
        handleSceneSwitchBtnClick("main");
    }
}