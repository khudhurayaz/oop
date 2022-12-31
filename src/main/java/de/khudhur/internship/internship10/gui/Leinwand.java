package de.khudhur.internship.internship10.gui;

import javax.swing.*;
import java.awt.*;

/**
 * @version 1.0
 * @author Ayaz Khudhur
 */

public class Leinwand extends JPanel{

    public Leinwand(){
        Fenster fenster = new Fenster();
        fenster.setManager(new FlowLayout());
        fenster.setWidth(700);
        fenster.setHeight(670);
        fenster.setColor(Color.black);
        fenster.createWindow();
    }

}
