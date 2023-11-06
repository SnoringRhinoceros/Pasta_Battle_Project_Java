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
    public Button Spaghetti, Ravioli, Rotini, idahoBtn, bakeryBtn, questionMarkBtn, goBackBtn, inventoryCraftBtn, inventoryEquipBtn, inventoryBtn, doActionBtn;
    @FXML
    public Button MILITARY_POTATOBtn1, MILITARY_POTATOBtnA1, MILITARY_POTATOBtn3, MILITARY_POTATOBtn2, MILITARY_POTATOBtnA2;
    @FXML
    public Button KUNG_FU_BREADBtn1, KUNG_FU_BREADBtnA1, KUNG_FU_BREADBtn3, KUNG_FU_BREADBtn2, KUNG_FU_BREADBtnA2;
    ArrayList<Button> idahoViewBattleBtns;
    ArrayList<Button> bakeryViewBattleBtns;
    @FXML
    public TextArea battleOutcomeTextArea, actionDescriptionTextArea, inventoryCraftableItemTextArea, enemyStatsTextArea, playerStatsTxtArea, itemDescriptionTextArea;
    @FXML
    public ListView equippedActionsListView, equippedActionGroupingsListView, allActionsListView, actionGroupingsListView, specificActionListView;
    @FXML
    public AnchorPane inventoryPane, characterSelectPane, idahoViewPane, bakeryViewPane;
    private ActionGroupings selectedActionGrouping;
    private Action selectedSpecificAction;
    private Item selectedItem;
    @FXML
    public ImageView playerImg, enemyBattleImg;
    @FXML
    public ProgressBar enemyBattleHealthBar;
    @FXML
    public Label enemyBattleHPLbl, battleTurnNumLbl, timePassedLbl;
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
        mainView.addFXMLElement(questionMarkBtn);
        mainView.addFXMLElement(playerImg);
        mainView.addFXMLElement(playerStatsTxtArea);
        mainView.addFXMLElement(inventoryBtn);
        mainView.addFXMLElement(timePassedLbl);
        questionMarkBtn.setDisable(true);
        fakeScreenController.add(mainView);

        FakeScreen idahoView = new FakeScreen("idahoView");
        idahoView.addFXMLElement(goBackBtn);
        idahoView.addFXMLElement(idahoViewPane);
        idahoView.addFXMLElement(playerImg);
        idahoView.addFXMLElement(playerStatsTxtArea);
        idahoView.addFXMLElement(inventoryBtn);
        idahoView.addFXMLElement(timePassedLbl);
        fakeScreenController.add(idahoView);
        idahoViewBattleBtns = new ArrayList<>(Arrays.asList(MILITARY_POTATOBtn1, MILITARY_POTATOBtnA1,
                MILITARY_POTATOBtn2, MILITARY_POTATOBtnA2, MILITARY_POTATOBtn3));
        for (Button button: idahoViewBattleBtns) {
            displayImage((ImageView) button.getGraphic(), "/Idaho/" + getEnemyType(button.getId()) + "/" + getEnemyDifficulty(button.getId()) + "/" + getEnemyType(button.getId()) + ".png");
        }

        FakeScreen bakeryView = new FakeScreen("bakeryView");
        bakeryView.addFXMLElement(goBackBtn);
        bakeryView.addFXMLElement(playerImg);
        bakeryView.addFXMLElement(playerStatsTxtArea);
        bakeryView.addFXMLElement(inventoryBtn);
        bakeryView.addFXMLElement(bakeryViewPane);
        bakeryView.addFXMLElement(timePassedLbl);
        fakeScreenController.add(bakeryView);
        bakeryViewBattleBtns = new ArrayList<>(Arrays.asList(KUNG_FU_BREADBtn1, KUNG_FU_BREADBtnA1,
                KUNG_FU_BREADBtn3, KUNG_FU_BREADBtn2, KUNG_FU_BREADBtnA2));
        for (Button button: bakeryViewBattleBtns) {
            displayImage((ImageView) button.getGraphic(), "/Bakery/" + getEnemyType(button.getId()) + "/" + getEnemyDifficulty(button.getId()) + "/" + getEnemyType(button.getId()) + ".png");
        }


        FakeScreen questionMarkView = new FakeScreen("questionMarkView");
        questionMarkView.addFXMLElement(playerImg);
        questionMarkView.addFXMLElement(playerStatsTxtArea);
        questionMarkView.addFXMLElement(inventoryBtn);
        questionMarkView.addFXMLElement(timePassedLbl);
        fakeScreenController.add(questionMarkView);

        FakeScreen battleView = new FakeScreen("battleView");
        battleView.addFXMLElement(battleOutcomeTextArea);
        battleOutcomeTextArea.setEditable(false);
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
        battleView.addFXMLElement(battleTurnNumLbl);
        battleView.addFXMLElement(timePassedLbl);
        fakeScreenController.add(battleView);


        FakeScreen inventoryView = new FakeScreen("inventoryView");
        inventoryView.addFXMLElement(inventoryPane);
        equippedActionGroupingsListView.getItems().add("Weapons");
        equippedActionGroupingsListView.getItems().add("Items");
        equippedActionGroupingsListView.getItems().add("Spells");
        equippedActionGroupingsListView.getItems().add("Misc");
        actionDescriptionTextArea.setEditable(false);
        inventoryCraftableItemTextArea.setEditable(false);
        inventoryView.addFXMLElement(playerImg);
        inventoryView.addFXMLElement(playerStatsTxtArea);
        inventoryView.addFXMLElement(goBackBtn);
        fakeScreenController.add(inventoryView);

        fakeScreenController.activate(characterSelectView.getName());
    }

    public static int generateRandNum(int min, int max) {
        return min + (int) (Math.random()*((max - min) + 1));
    }

    private void playerTravelTo(String place) {
        world.tickTime();
        timePassedLbl.setText("Time: " + world.getTime());
        world.getPlayer().travelTo(place);
        fakeScreenController.activate(place);
        displayImage(playerImg, "Player/" + world.getPlayer().getPastaType().getName() + ".png");
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
        battleOutcomeTextArea.setText(world.getCurBattle().getEnemy().getEntryText());
        updateEnemyBattleHealthBar();
        doActionBtn.setText("Do");
        doActionBtn.setDisable(true);
        updateBattleView();
    }

    private void updateEnemyBattleHealthBar() {
        Enemy curEnemy =  world.getCurBattle().getEnemy();
        enemyBattleHealthBar.setProgress((double) curEnemy.getStats().getCurHealth() / (double) curEnemy.getStats().getMaxHealth());
        enemyBattleHPLbl.setText("HP: " + curEnemy.getStats().getCurHealth() + "/" + curEnemy.getStats().getMaxHealth());
    }

    private void updateBattleView(String result) {
        battleOutcomeTextArea.setText(result);
        updateBattleView();
    }

    private void updateBattleView() {
        battleTurnNumLbl.setText("Turn Num: " + world.getCurBattle().getTurnNum());
        timePassedLbl.setText("Time: " + world.getTime());
        playerStatsTxtArea.setText(world.getPlayer().getStatsText());
        playerStatsTxtArea.appendText("\n" + world.getPlayer().getStatModifiersOwned().getAllStatModifierText());
        enemyStatsTextArea.setText(world.getCurBattle().getEnemy().getStatsText());
        updateEnemyBattleHealthBar();
        BattleState battleState = world.getCurBattle().getState();
        specificActionListView.getItems().clear();
        itemDescriptionTextArea.clear();
        if (battleState.equals(BattleState.PLAYER_TURN)) {
            updateActionsAndDescriptionsListViewAndTextArea(specificActionListView, itemDescriptionTextArea);
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
        world.createBattle(world.createNewEnemy(EnemyType.getEnemyType(getNormalName(idOfBtn)), getEnemyDifficulty(idOfBtn)));
        world.tickTime();
        initBattleScreen();
    }

    private String getNormalName(String name) {
        String[] nameArray = name.split("_");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < nameArray.length; i++) {
            if (i == nameArray.length-1) {
                result.append(nameArray[i].toLowerCase(), 0, nameArray[i].indexOf("Btn"));
            } else {
                if (i == 0) {
                    result.append(nameArray[i].substring(0, 1).toUpperCase()).append(nameArray[i].toLowerCase().substring(1));
                } else {
                    result.append(nameArray[i].toLowerCase());
                }
                result.append(" ");
            }
        }
        return result.toString();
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
            selectedSpecificAction = world.getPlayer().getAction(selectedSpecificActionTxt);
            updateBattleView();
        }
    }

    @FXML
    public void chooseCharacterBtnClick(ActionEvent actionEvent) {
        for (PastaType pastaType: PastaType.values()) {
            if (getIdOfButton(actionEvent).equals(pastaType.getName())) {
                world = new World(new PC("player", pastaType));
                playerTravelTo("mainView");
                timePassedLbl.setText("Time: " + world.getTime());
                playerStatsTxtArea.setText(world.getPlayer().getStatsText());
                break;
            }
        }
    }

    @FXML
    public void updateInventoryView() {
        String selectedActionGroupingTxt = getSelectedItemFromListView(equippedActionGroupingsListView);
        if (selectedActionGroupingTxt != null) {
            selectedActionGrouping = ActionGroupings.getActionGrouping(selectedActionGroupingTxt);
        }

        updateActionsAndDescriptionsListViewAndTextArea(equippedActionsListView, actionDescriptionTextArea);

        allActionsListView.getItems().clear();
        for (Item item : world.getPlayer().getItems()) {
            if (item.getAction().getGrouping().equals(selectedActionGrouping)) {
                allActionsListView.getItems().add(item.getAction().getName() + " - " + item.getAmount() + "x");
            }
        }


        inventoryCraftBtn.setDisable(true);
        inventoryCraftableItemTextArea.clear();
        inventoryEquipBtn.setDisable(true);
        if (selectedItem != null) {
            if (!world.getPlayer().hasItem(selectedItem)) {
                selectedItem = null;
                return;
            }
            inventoryEquipBtn.setDisable(false);
            if (world.getCrafter().getItemCraftable(selectedItem)) {
                inventoryCraftBtn.setDisable(false);
            }
            inventoryCraftableItemTextArea.setText(world.getCrafter().getNextItemCraftableDescription(selectedItem));
        }
    }

    private void updateActionsAndDescriptionsListViewAndTextArea(ListView actionGroupingsListView, TextArea actionDescriptionTextArea) {
        if (selectedActionGrouping != null) {
            actionGroupingsListView.getItems().clear();
            actionDescriptionTextArea.clear();
            for (Action action: world.getPlayer().getActions()) {
                if (action.getGrouping().getName().equals(selectedActionGrouping.getName())) {
                    actionGroupingsListView.getItems().add(action.getName());
                }
            }
            if (selectedSpecificAction != null ) {
                actionDescriptionTextArea.setText(selectedSpecificAction.getDescription());
            }
        }
    }

    private void initInventoryView() {
        selectedActionGrouping = null;
        selectedSpecificAction = null;
    }

    @FXML
    public void inventoryBtnClick(ActionEvent actionEvent) {
        fakeScreenController.activate("inventoryView");
        world.tickTime();
        timePassedLbl.setText("Time: " + world.getTime());
        initInventoryView();
        updateInventoryView();
    }

    @FXML
    public void equippedActionsListViewClick(MouseEvent mouseEvent) {
        if (getSelectedItemFromListView(equippedActionsListView) != null) {
            String selectedSpecificActionTxt = getSelectedItemFromListView(equippedActionsListView);
            selectedSpecificAction = world.getPlayer().getAction(selectedSpecificActionTxt);
        }
        updateInventoryView();
    }

    @FXML
    public void allActionsListViewClick(MouseEvent mouseEvent) {
        if (getSelectedItemFromListView(allActionsListView) != null) {
            String selectedSpecificActionTxt = getSelectedItemFromListView(allActionsListView);
            selectedSpecificAction = world.getPlayer().getAction(selectedSpecificActionTxt.substring(0, selectedSpecificActionTxt.indexOf(" - ")));
            for (Item item: world.getPlayer().getItems()) {
                if (item.getAction().equals(selectedSpecificAction)) {
                    selectedItem = item;
                }
            }
        }
        updateInventoryView();
    }

    @FXML
    public void equippedActionGroupingsListViewClick(MouseEvent mouseEvent) {
        selectedSpecificAction = null;
        selectedItem = null;
        updateInventoryView();
    }

    @FXML
    public void onInventoryCraftBtnClick(ActionEvent actionEvent) {
        world.getPlayer().addItem(world.getCrafter().craft(selectedItem, world.getPlayer()));
        updateInventoryView();
    }
    @FXML
    public void inventoryEquipBtnClick(ActionEvent actionEvent) {
        world.getPlayer().equipItem(selectedItem);
        updateInventoryView();
    }
}