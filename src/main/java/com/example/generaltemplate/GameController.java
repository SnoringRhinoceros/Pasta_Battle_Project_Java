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

        fakeScreenController.activate(mainMap.getName());
    }

    @FXML
    public void handleIdahoBtnClick(MouseEvent mouseEvent) {
        fakeScreenController.activate("idahoView");
    }

    public void handleBakeryBtnClick(MouseEvent mouseEvent) {
    }

    public void handleRiceFieldsBtnClick(MouseEvent mouseEvent) {
    }

    public void handleQuestionMarkBtnClick(MouseEvent mouseEvent) {
    }

    public void goBack(MouseEvent mouseEvent) {
        fakeScreenController.activate("mainView");
    }

    public void fightMilitaryPotato(MouseEvent mouseEvent) {
    }
}