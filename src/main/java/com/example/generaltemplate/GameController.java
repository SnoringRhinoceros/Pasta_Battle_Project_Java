package com.example.generaltemplate;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

public class GameController {

    @FXML
    public Button idahoBtn, bakeryBtn, riceFieldsBtn, questionMarkBtn, goBackBtn;
    @FXML
    public Button militaryPotatoBtn;
    @FXML
    public Label battleOutcomeLbl;
    @FXML
    public TextArea enemyStatsTextArea, playerStatsTxtArea;
    @FXML
    public ListView actionGroupingsListView, specificActionListView;
    @FXML
    public TextArea itemDescriptionTextArea;
    @FXML
    public Button doActionBtn;
    FakeScreenController fakeScreenController;
    World world;

    @FXML
    public void initialize() {
        fakeScreenController = new FakeScreenController();
        FakeScreen mainMap = new FakeScreen("mainView");
        mainMap.addFXMLElement(idahoBtn);
        mainMap.addFXMLElement(bakeryBtn);
        mainMap.addFXMLElement(riceFieldsBtn);
        mainMap.addFXMLElement(questionMarkBtn);
        questionMarkBtn.setDisable(true);
        fakeScreenController.add(mainMap);

        FakeScreen idahoView = new FakeScreen("idahoView");
        idahoView.addFXMLElement(goBackBtn);
        idahoView.addFXMLElement(militaryPotatoBtn);
        fakeScreenController.add(idahoView);

        FakeScreen bakeryView = new FakeScreen("bakeryView");
        bakeryView.addFXMLElement(goBackBtn);
        fakeScreenController.add(bakeryView);

        FakeScreen riceFieldsView = new FakeScreen("riceFieldsView");
        riceFieldsView.addFXMLElement(goBackBtn);
        fakeScreenController.add(riceFieldsView);

        FakeScreen questionMarkView = new FakeScreen("questionMarkView");
        fakeScreenController.add(questionMarkView);

        FakeScreen battleView = new FakeScreen("battleView");
        battleView.addFXMLElement(battleOutcomeLbl);
        battleView.addFXMLElement(playerStatsTxtArea);
        playerStatsTxtArea.setEditable(false);
        battleView.addFXMLElement(enemyStatsTextArea);
        enemyStatsTextArea.setEditable(false);
        battleView.addFXMLElement(actionGroupingsListView);
        battleView.addFXMLElement(specificActionListView);
        battleView.addFXMLElement(itemDescriptionTextArea);
        battleView.addFXMLElement(doActionBtn);
        fakeScreenController.add(battleView);

        fakeScreenController.activate(mainMap.getName());

        world = new World(new PC("player", CharacterType.SPAGHETTI, 15, 2, 1, 1));
    }

    @FXML
    public void handleIdahoBtnClick(MouseEvent mouseEvent) {
        fakeScreenController.activate("idahoView");
    }

    @FXML
    public void handleBakeryBtnClick(MouseEvent mouseEvent) {
        fakeScreenController.activate("bakeryView");
    }

    @FXML
    public void handleRiceFieldsBtnClick(MouseEvent mouseEvent) {
        fakeScreenController.activate("riceFieldsView");
    }

    @FXML
    public void handleQuestionMarkBtnClick(MouseEvent mouseEvent) {
        fakeScreenController.activate("questionMarkView");
    }

    @FXML
    public void goBack(MouseEvent mouseEvent) {
        fakeScreenController.activate("mainView");
    }

    @FXML
    public void fightMilitaryPotato(MouseEvent mouseEvent) {
        fakeScreenController.activate("battleView");
        world.createBattle(new Enemy("Joe", 5, 1, 0, 0));
    }

    @FXML
    public void doActionBtn(MouseEvent mouseEvent) {
    }
}