package com.example.generaltemplate;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

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
    @FXML
    public ImageView playerImg, enemyBattleImg;
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
        mainMap.addFXMLElement(playerImg);
        mainMap.addFXMLElement(playerStatsTxtArea);
        questionMarkBtn.setDisable(true);
        fakeScreenController.add(mainMap);

        FakeScreen idahoView = new FakeScreen("idahoView");
        idahoView.addFXMLElement(goBackBtn);
        idahoView.addFXMLElement(militaryPotatoBtn);
        idahoView.addFXMLElement(playerImg);
        idahoView.addFXMLElement(playerStatsTxtArea);
        fakeScreenController.add(idahoView);

        FakeScreen bakeryView = new FakeScreen("bakeryView");
        bakeryView.addFXMLElement(goBackBtn);
        bakeryView.addFXMLElement(playerImg);
        bakeryView.addFXMLElement(playerStatsTxtArea);
        fakeScreenController.add(bakeryView);

        FakeScreen riceFieldsView = new FakeScreen("riceFieldsView");
        riceFieldsView.addFXMLElement(goBackBtn);
        riceFieldsView.addFXMLElement(playerImg);
        riceFieldsView.addFXMLElement(playerStatsTxtArea);
        fakeScreenController.add(riceFieldsView);

        FakeScreen questionMarkView = new FakeScreen("questionMarkView");
        questionMarkView.addFXMLElement(playerImg);
        questionMarkView.addFXMLElement(playerStatsTxtArea);
        fakeScreenController.add(questionMarkView);

        FakeScreen battleView = new FakeScreen("battleView");
        battleView.addFXMLElement(battleOutcomeLbl);
        battleView.addFXMLElement(playerImg);
        battleView.addFXMLElement(playerStatsTxtArea);
        playerStatsTxtArea.setEditable(false);
        battleView.addFXMLElement(enemyStatsTextArea);
        enemyStatsTextArea.setEditable(false);
        battleView.addFXMLElement(actionGroupingsListView);
        actionGroupingsListView.getItems().add("Weapons");
        actionGroupingsListView.getItems().add("Items");
        actionGroupingsListView.getItems().add("Spells");
        actionGroupingsListView.getItems().add("Misc.");
        battleView.addFXMLElement(specificActionListView);
        battleView.addFXMLElement(itemDescriptionTextArea);
        battleView.addFXMLElement(doActionBtn);
        battleView.addFXMLElement(enemyBattleImg);
        fakeScreenController.add(battleView);

        fakeScreenController.activate(mainMap.getName());

        world = new World(new PC("player", CharacterType.SPAGHETTI, 15, 2, 1, 1));
        playerStatsTxtArea.setText(world.getPlayer().getStats());
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

    private static void displayImage(ImageView imageView, String imgPath) {
//        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        try {
            FileInputStream input = new FileInputStream("src/main/resources/com/example/generaltemplate/img/" + imgPath);
            imageView.setImage(new Image(input));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void initBattleScreen() {
        playerStatsTxtArea.setText(world.getPlayer().getStats());
        enemyStatsTextArea.setText(world.getCurBattle().getEnemy().getStats());
        displayImage(enemyBattleImg, world.getCurBattle().getEnemy().getImgPath());
        battleOutcomeLbl.setText(world.getCurBattle().getEnemy().getEntryText());
    }

    private void updateBattleView(String result) {
        playerStatsTxtArea.setText(world.getPlayer().getStats());
        enemyStatsTextArea.setText(world.getCurBattle().getEnemy().getStats());
        battleOutcomeLbl.setText(result);
        BattleState battleState = world.getCurBattle().getState();
        if (battleState.equals(BattleState.PLAYER_TURN)) {
            doActionBtn.setText("Do");
        } else if (battleState.equals(BattleState.ENEMY_TURN)) {
            doActionBtn.setText("Enemy attacks");
        } else if (battleState.equals(BattleState.BATTLE_OVER)) {
            doActionBtn.setText("Leave battle");
        }
    }


    @FXML
    public void fightMilitaryPotato(MouseEvent mouseEvent) {
        fakeScreenController.activate("battleView");
        world.createBattle(world.createNewEnemy(EnemyType.MILITARY_POTATO));
        initBattleScreen();
    }

    @FXML
    public void doActionBtn(MouseEvent mouseEvent) {
        BattleState battleState = world.getCurBattle().getState();
        if (battleState.equals(BattleState.PLAYER_TURN)) {
            updateBattleView(world.getCurBattle().runTurn("nonsense"));
        } else if (battleState.equals(BattleState.ENEMY_TURN)) {
            updateBattleView(world.getCurBattle().runTurn());
        } else if (battleState.equals(BattleState.BATTLE_OVER)) {
            // change scene back to original location
        }
    }
}