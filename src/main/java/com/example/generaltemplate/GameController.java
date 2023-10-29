package com.example.generaltemplate;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Objects;

import static com.example.generaltemplate.PossibleActions.getPossibleAction;

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
    private ActionGroupings selectedActionGrouping;
    private PossibleActions selectedSpecificAction;
    @FXML
    public TextArea itemDescriptionTextArea;
    @FXML
    public Button doActionBtn;
    @FXML
    public ImageView playerImg, enemyBattleImg;
    @FXML
    public ProgressBar enemyBattleHealthBar;
    @FXML
    public Label enemyBattleHPLbl;
    FakeScreenController fakeScreenController;
    World world;

    @FXML
    public void initialize() {
        fakeScreenController = new FakeScreenController();
        FakeScreen mainView = new FakeScreen("mainView");
        mainView.addFXMLElement(idahoBtn);
        mainView.addFXMLElement(bakeryBtn);
        mainView.addFXMLElement(riceFieldsBtn);
        mainView.addFXMLElement(questionMarkBtn);
        mainView.addFXMLElement(playerImg);
        mainView.addFXMLElement(playerStatsTxtArea);
        questionMarkBtn.setDisable(true);
        fakeScreenController.add(mainView);

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
        actionGroupingsListView.getItems().add("Misc");
        battleView.addFXMLElement(specificActionListView);
        battleView.addFXMLElement(itemDescriptionTextArea);
        itemDescriptionTextArea.setEditable(false);
        battleView.addFXMLElement(doActionBtn);
        battleView.addFXMLElement(enemyBattleImg);
        battleView.addFXMLElement(enemyBattleHealthBar);
        battleView.addFXMLElement(enemyBattleHPLbl);
        fakeScreenController.add(battleView);

        fakeScreenController.activate(mainView.getName());

        world = new World(new PC("player", "mainMap", CharacterType.SPAGHETTI, 15, 2, 1, 1));
        playerStatsTxtArea.setText(world.getPlayer().getStats());
    }

    private void playerTravelTo(String place) {
        world.getPlayer().travelTo(place);
        fakeScreenController.activate(place);
    }

    @FXML
    public void handleIdahoBtnClick(MouseEvent mouseEvent) {
        playerTravelTo("idahoView");
    }

    @FXML
    public void handleBakeryBtnClick(MouseEvent mouseEvent) {
        playerTravelTo("bakeryView");
    }

    @FXML
    public void handleRiceFieldsBtnClick(MouseEvent mouseEvent) {
        playerTravelTo("riceFieldsView");
    }

    @FXML
    public void handleQuestionMarkBtnClick(MouseEvent mouseEvent) {
        playerTravelTo("questionMarkView");
    }

    @FXML
    public void goBack(MouseEvent mouseEvent) {
        playerTravelTo("mainView");
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
        updateEnemyBattleHealthBar();
        doActionBtn.setText("Do");
        doActionBtn.setDisable(true);
    }

    private void updateEnemyBattleHealthBar() {
        Enemy curEnemy =  world.getCurBattle().getEnemy();
        enemyBattleHealthBar.setProgress((double) curEnemy.getCurHealth() / (double) curEnemy.getMaxHealth());
        enemyBattleHPLbl.setText("HP: " + curEnemy.getCurHealth() + "/" + curEnemy.getMaxHealth());
    }

    private void updateBattleView(String result) {
        updateBattleView();
        battleOutcomeLbl.setText(result);
    }

    private void updateBattleView() {
        playerStatsTxtArea.setText(world.getPlayer().getStats());
        enemyStatsTextArea.setText(world.getCurBattle().getEnemy().getStats());
        updateEnemyBattleHealthBar();
        BattleState battleState = world.getCurBattle().getState();
        specificActionListView.getItems().clear();
        itemDescriptionTextArea.clear();
        if (battleState.equals(BattleState.PLAYER_TURN)) {
            if (selectedActionGrouping != null) {
                for (Action action: world.getPlayer().getActions()) {
                    if (action.getGrouping().getName().equals(selectedActionGrouping.getName())) {
                        specificActionListView.getItems().add(action.getName());
                    }
                }
                if (selectedSpecificAction != null ) {
                    itemDescriptionTextArea.setText(selectedSpecificAction.getDescription());
                }
            }
            doActionBtn.setDisable(selectedActionGrouping == null || selectedSpecificAction == null);
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
            fakeScreenController.activate(world.getPlayer().getLoc());
        }
    }

    private static String getSelectedItemFromListView(ListView listView) {
        Object selectedItem = listView.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            return selectedItem.toString();
        }
        return null;
    }

    @FXML
    public void handleActionGroupingsListViewClick(MouseEvent mouseEvent) {
        String selectedActionGroupingTxt = getSelectedItemFromListView(actionGroupingsListView);
        if (selectedActionGroupingTxt != null) {
            selectedActionGrouping = ActionGroupings.getActionGrouping(selectedActionGroupingTxt);
            updateBattleView();
        }

    }

    @FXML
    public void handleSpecificActionListViewClick(MouseEvent mouseEvent) {
        String selectedSpecificActionTxt = getSelectedItemFromListView(specificActionListView);
        if (selectedSpecificActionTxt != null) {
            selectedSpecificAction = PossibleActions.getPossibleAction(selectedSpecificActionTxt);
            updateBattleView();
        }
    }
}