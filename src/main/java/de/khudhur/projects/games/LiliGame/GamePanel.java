package de.khudhur.projects.games.LiliGame;

import javax.swing.*;
import java.awt.*;

// Dies ist das Spiel-Panel, auf dem das Spiel gezeichnet wird.
public class GamePanel extends JPanel {
    // Diese Methode wird vom Java-Framework aufgerufen,
    // wenn das Panel neu gezeichnet werden muss.
    @Override
    protected void paintComponent(Graphics g) {
        // Zeichne etwas auf das Panel...
        g.drawString("Hallo, Welt!", 100, 100);
    }
}