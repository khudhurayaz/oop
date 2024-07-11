package de.khudhur.projects.games.LiliGame;

import de.khudhur.projects.games.LiliGame.constParameter.CONST;

import javax.swing.*;
import java.util.Objects;

// Dies ist die Hauptklasse des Spiels.
public class LiliGameApp {
    // Die Fenstergröße
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    private static final CONST constanten = new CONST();
    private final String[] parameters;

    public LiliGameApp(String...param){
        this.parameters = param;
        initParametern();
    }

    // Die Hauptmethode des Spiels
    public void initWindow() {
        // Erstelle ein neues Fenster
        JFrame frame = new JFrame();
        frame.setTitle(constanten.getTitle());
        frame.setSize(WIDTH, HEIGHT);

        // Erstelle ein neues Spiel-Panel
        JPanel panel = new GamePanel();
        frame.add(panel);

        // Zeige das Fenster an
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource(constanten.getIcon())));
        frame.setIconImage(icon.getImage());
        frame.setVisible(true);
    }

    /*
        Parameter initialisieren
     */
    private void initParametern() {
        for (String param : parameters) {
            if (param.split(":")[0].equalsIgnoreCase("title")) {
                constanten.setTitle(param.split(":")[1]);
            }
            if (param.split(":")[0].equalsIgnoreCase("icon")) {
                constanten.setIcon(param.split(":")[1]);
            }
        }
    }

}

