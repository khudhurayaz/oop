package de.khudhur.projects.games;

import de.khudhur.projects.games.LiliGame.LiliGameApp;

public class Game {
    public static void main(String[] args) {
        LiliGameApp gameApp = new LiliGameApp("title:Mein 2D-Spiel", "icon:icon.png");
        gameApp.initWindow();
    }
}
