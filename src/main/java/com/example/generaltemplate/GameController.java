package com.example.generaltemplate;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class GameController {

    @FXML
    public Button idahoBtn, bakeryBtn, riceFieldsBtn, questionMarkBtn, goBackBtn;
    @FXML
    public Button militaryPotatoBtn;
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

        fakeScreenController.activate(mainMap.getName());

        world = new World(new PC("player", CharacterType.SPAGHETTI, 15, 2, 1, 1));
    }

    @FXML
    public void handleIdahoBtnClick(MouseEvent mouseEvent) {
        fakeScreenController.activate("idahoView");
    }

    public void handleBakeryBtnClick(MouseEvent mouseEvent) {
        fakeScreenController.activate("bakeryView");
    }

    public void handleRiceFieldsBtnClick(MouseEvent mouseEvent) {
        fakeScreenController.activate("riceFieldsView");
    }

    public void handleQuestionMarkBtnClick(MouseEvent mouseEvent) {
        fakeScreenController.activate("questionMarkView");
    }

    public void goBack(MouseEvent mouseEvent) {
        fakeScreenController.activate("mainView");
    }

    public void fightMilitaryPotato(MouseEvent mouseEvent) {
        world.createBattle(new Enemy("Joe", 5, 1, 0, 0));
        fakeScreenController.activate("battleView");
    }
}