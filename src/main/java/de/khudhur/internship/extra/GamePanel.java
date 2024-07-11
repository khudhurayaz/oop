package de.khudhur.internship.extra;

import de.khudhur.internship.extra.objects.Load;
import de.khudhur.internship.extra.objects.Object;
import de.khudhur.internship.extra.objects.enumClasses.FontEnum;
import javax.swing.*;
import java.awt.*;

/**
 * GamePanel() - Konstruktor
 * init() -
 * gameObjectsInitialisieren() -
 *
 * @author AG
 * @version 1.0
 */
public class GamePanel extends JFrame {

    //Attributen
    private String gameName, gameIcon;
    private Dimension gameDimension;
    private static Object object;

    /**
     * Konstruktor
     */
    public GamePanel(){
        init();
    }

    /**
     * Initialisierung:
     * → Default Window wird initialisiert
     * → GameObjects wird initialisiert
     * → Object Klasse wird initialisiert
     */
    private void init(){
        setLayout(new BorderLayout());

        //objects initialisieren
        gameObjectsInitialisieren();
        object = new Object();

        //default eingaben
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(gameDimension);
        setIconImage(new Load().loadIcon(gameIcon));
        setTitle(gameName);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Alle notwendigen Einstellungen für die GameView,
     * werden hier deklariert.
     */
    private void gameObjectsInitialisieren(){
        gameName = "Ritter vs Drache";
        gameIcon = Object.PATH + "RitterGegenDrache2.png";
        gameDimension = new Dimension(1080,600);
        Load load = new Load();
        JLabel label = new JLabel("Test");
        label.setFont(load.loadFonts(FontEnum.PROF_BENS, 32));
        add(label, BorderLayout.CENTER);
    }

}
