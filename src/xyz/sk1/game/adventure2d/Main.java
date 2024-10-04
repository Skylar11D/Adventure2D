package xyz.sk1.game.adventure2d;

import xyz.sk1.game.adventure2d.panels.GamePanel;
import xyz.sk1.game.adventure2d.player.Player;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        GamePanel game = setFrameProperties();

        //game runtime behavior starts here
        game.runGameLoop();

    }

    private static GamePanel setFrameProperties() {
        JFrame window = new JFrame();

        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        window.setResizable(true);

        Player player = new Player();

        GamePanel game = new GamePanel(player);

        window.add(game);

        window.pack();

        window.setTitle("Adventure2D");

        window.setLocationRelativeTo(null);

        window.setVisible(true);
        return game;
    }

}
