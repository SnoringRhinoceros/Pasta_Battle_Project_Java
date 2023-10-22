package com.example.generaltemplate;

import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Land {
    ImageView img;
    ArrayList<Enemy> enemies = new ArrayList<>();
    public Land(ImageView img) {
        this.img = img;
    }
}
