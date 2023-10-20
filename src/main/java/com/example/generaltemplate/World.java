package com.example.generaltemplate;

public class World {
    private final PlayableCharacter player;

    World() {
        player = new PlayableCharacter(CharacterType.SPAGHETTI, 10, 2, 1, 1);
        Enemy basic1 = new Enemy("slime", 5, 1, 0, 0);
        System.out.println(player.getStats());
        System.out.println(basic1.getStats());
    }
}
