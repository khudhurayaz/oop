package de.khudhur.internship.internship11;

import de.khudhur.internship.internship11.gui.Game;

import javax.swing.*;

/**
 * @author Ayaz Khudhur
 * @version 1.0
 */
public class App {
    //starte das Spiel
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Game());
    }
}
