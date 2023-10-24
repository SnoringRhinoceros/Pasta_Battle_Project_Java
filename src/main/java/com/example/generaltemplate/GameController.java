package com.example.generaltemplate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.io.IOException;

public class GameController {
    @FXML
    public Button idahoBtn, bakeryBtn, riceFieldsBtn, questionMarkBtn;
    @FXML
    public Label battleOutcomeLbl;
    @FXML
    public TextArea playerStatsTextArea, enemyStatsTextArea;
    private World world;
    private ScreenController screenController;

    public void setScreenController(ScreenController screenController) {
        this.screenController = screenController;
    }

    public void myOwnInit() {
        world = new World();
        questionMarkBtn.setDisable(true);
        playerStatsTextArea.setDisable(true);
        enemyStatsTextArea.setDisable(true);
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

    private void initBattle(Enemy enemy) throws IOException {
        screenController.activate("battle");
        world.createBattle(enemy);
        // start working
    }

    @FXML
    public void fightMilitaryPotato(MouseEvent mouseEvent) throws IOException {
        Enemy enemy = new Enemy("Joe", 5, 1,1,0);
        initBattle(enemy);
    }

    @FXML
    public void doActionBtn(MouseEvent mouseEvent) throws IOException {
        // TODO
    }
}