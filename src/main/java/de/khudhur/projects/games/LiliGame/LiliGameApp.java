package de.khudhur.projects.games.LiliGame;

import javax.swing.JPanel;
import javax.swing.JFrame;

// Dies ist die Hauptklasse des Spiels.
public class LiliGameApp {
    // Die Fenstergröße
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    // Die Hauptmethode des Spiels
    public void setWindow() {
        // Erstelle ein neues Fenster
        JFrame frame = new JFrame("Mein 2D-Spiel");
        frame.setSize(WIDTH, HEIGHT);

        // Erstelle ein neues Spiel-Panel
        JPanel panel = new GamePanel();
        frame.add(panel);

        // Zeige das Fenster an
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

