package de.khudhur.internship.extra;

import javax.swing.*;

/**
 * Game startet hier
 * @author AG
 * @version 1.0
 */
public class Game {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GamePanel::new);
    }

}
