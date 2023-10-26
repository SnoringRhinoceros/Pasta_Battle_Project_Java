package com.example.generaltemplate;

import javafx.scene.Node;

import java.util.ArrayList;

public class FakeScreenController {
    ArrayList<FakeScreen> fakeScreens = new ArrayList<>();
    FakeScreen currentScreen;

    public void add(FakeScreen fakeScreen) {
        fakeScreens.add(fakeScreen);
    }

    public void activate(String name) {
        for (FakeScreen fakeScreen: fakeScreens) {
            if (fakeScreen.getName().equals(name)) {
                clearAll();
                ArrayList<Node> nodes = fakeScreen.getFXMLElements();
                for (Node node: nodes) {
                    node.setVisible(true);
                }
                currentScreen = fakeScreen;
            }
        }
    }

    private void clearAll() {
        for (FakeScreen fakeScreen: fakeScreens) {
            ArrayList<Node> nodes = fakeScreen.getFXMLElements();
            for (Node node: nodes) {
                node.setVisible(false);
            }
        }
    }
}
