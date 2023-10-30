package com.example.generaltemplate;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

public class GameController {

    @FXML
    public Button idahoBtn, bakeryBtn, riceFieldsBtn, questionMarkBtn, goBackBtn;
    @FXML
    public Button MILITARY_POTATOBtn1, MILITARY_POTATOBtnA1, MILITARY_POTATOBtnB1, MILITARY_POTATOBtnA3,
            MILITARY_POTATOBtnA4, MILITARY_POTATOBtn2, MILITARY_POTATOBtnA5, MILITARY_POTATOBtnA2;
    ArrayList<Button> idahoViewBattleBtns;
    @FXML
    public Label battleOutcomeLbl;
    @FXML
    public TextArea enemyStatsTextArea, playerStatsTxtArea;
    @FXML
    public ListView actionGroupingsListView, specificActionListView;
    private ActionGroupings selectedActionGrouping;
    private PossibleActions selectedSpecificAction;
    @FXML
    public AnchorPane characterSelectPane, idahoViewPane;
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

        FakeScreen characterSelectView = new FakeScreen("characterSelectView");
        characterSelectView.addFXMLElement(characterSelectPane);
        fakeScreenController.add(characterSelectView);

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
        idahoView.addFXMLElement(idahoViewPane);
        idahoView.addFXMLElement(playerImg);
        idahoView.addFXMLElement(playerStatsTxtArea);
        fakeScreenController.add(idahoView);
        idahoViewBattleBtns = new ArrayList<>(Arrays.asList(MILITARY_POTATOBtn1, MILITARY_POTATOBtnA1, MILITARY_POTATOBtnB1, MILITARY_POTATOBtnA3,
                MILITARY_POTATOBtnA4, MILITARY_POTATOBtn2, MILITARY_POTATOBtnA5, MILITARY_POTATOBtnA2));
        for (Button button: idahoViewBattleBtns) {
            displayImage((ImageView) button.getGraphic(), "/Idaho/" + getEnemyType(button.getId()) + "/" + getEnemyDifficulty(button.getId()) + "/" + getEnemyType(button.getId()) + ".png");
        }

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

        fakeScreenController.activate(characterSelectView.getName());
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
        playerStatsTxtArea.setText(world.getPlayer().getStatsText());
        enemyStatsTextArea.setText(world.getCurBattle().getEnemy().getStatsText());
        displayImage(enemyBattleImg, world.getCurBattle().getEnemy().getImgPath());
        battleOutcomeLbl.setText(world.getCurBattle().getEnemy().getEntryText());
        updateEnemyBattleHealthBar();
        doActionBtn.setText("Do");
        doActionBtn.setDisable(true);
    }

    private void updateEnemyBattleHealthBar() {
        Enemy curEnemy =  world.getCurBattle().getEnemy();
        enemyBattleHealthBar.setProgress((double) curEnemy.getStats().getCurHealth() / (double) curEnemy.getStats().getMaxHealth());
        enemyBattleHPLbl.setText("HP: " + curEnemy.getStats().getCurHealth() + "/" + curEnemy.getStats().getMaxHealth());
    }

    private void updateBattleView(String result) {
        battleOutcomeLbl.setText(result);
        updateBattleView();
    }

    private void updateBattleView() {
        playerStatsTxtArea.setText(world.getPlayer().getStatsText());
        playerStatsTxtArea.appendText("\n" + world.getPlayer().getStatModifiersOwned().getAllStatModifierText());
        enemyStatsTextArea.setText(world.getCurBattle().getEnemy().getStatsText());
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
        playerStatsTxtArea.setText(world.getPlayer().getStatsText());
        playerStatsTxtArea.appendText("\n" + world.getPlayer().getStatModifiersOwned().getAllStatModifierText());
    }

    private static String getIdOfButton(Event event) {
        return ((Control) event.getSource()).getId();
    }

    private String getEnemyType(String idOfBtn) {
        return idOfBtn.substring(0, idOfBtn.indexOf("Btn"));
    }

    private int getEnemyDifficulty(String idOfEnemy) {
        for (int i = idOfEnemy.length()-1; i >= 0; i--) {
            if (!Character.isDigit(idOfEnemy.charAt(i))) {
                return Integer.parseInt(idOfEnemy.substring(i+1));
            }
        }
        throw new RuntimeException("Enemy Difficulty not properly specified in id. " +
                "Should be in the format of type+Btn+uniqueIdentifier+difficultyNum (ex. MILITARY_POTATOBtnA1");
    }

    @FXML
    public void fightEnemy(MouseEvent mouseEvent) {
        fakeScreenController.activate("battleView");
        String idOfBtn = getIdOfButton(mouseEvent);
        world.createBattle(world.createNewEnemy(EnemyType.getEnemyType(getEnemyType(idOfBtn)), getEnemyDifficulty(idOfBtn)));
        initBattleScreen();
    }

    @FXML
    public void doActionBtn(MouseEvent mouseEvent) {
        BattleState battleState = world.getCurBattle().getState();
        if (battleState.equals(BattleState.PLAYER_TURN)) {
            String result = world.getCurBattle().runTurn(selectedSpecificAction);
            updateBattleView(result);
        } else if (battleState.equals(BattleState.ENEMY_TURN)) {
            updateBattleView(world.getCurBattle().runTurn());
        } else if (battleState.equals(BattleState.BATTLE_OVER)) {
            if (world.getPlayer().isDead()) {
                // handle that
            }
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

    public void chooseCharacterBtnClick(ActionEvent actionEvent) {
        for (PastaType pastaType: PastaType.values()) {
            if (getIdOfButton(actionEvent).equals(pastaType.getName())) {
                world = new World(new PC("player", pastaType));
                playerStatsTxtArea.setText(world.getPlayer().getStatsText());
                displayImage(playerImg, "Player/" + pastaType.getName() + ".png");
                fakeScreenController.activate("mainView");
            }
        }
    }
}