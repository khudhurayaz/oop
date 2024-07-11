package de.khudhur.internship.internship11.gui;

import de.khudhur.internship.internship11.gui.objects.Background;
import de.khudhur.internship.internship11.gui.objects.GameObjects;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class GamePanel extends JPanel{

    //background image
    private ImageIcon backgroundImage;
    //Backgrounds
    private final String[] backgroundsImage = {"1.png",
                                               "2.png",
                                               "3.png"};

    //gameOver
    private boolean gameOver = false;
    private boolean start = false;
    private boolean continueButton = false;

    //Timer
    private boolean pause = false;
    private Timer timer;
    //Layout
    private BorderLayout borderLayout;
    //GameObjects
    private GameObjects objects;

    //preferecsize
    private Dimension prefSize;

    //Main Panel für rechte Seite
    private JPanel panelRight, panelGame;


    final boolean[] chkPlayerIfUserInit = {false};


    /**
     * Panel Konstruktor
     * setzt die größe ein und Focus.
     *
     * initGame wird aufgerufen
     * startGame wird aufgerufen
     */
    public GamePanel(){
        prefSize = new Dimension(906, 552);
        setPreferredSize(prefSize);
        setFocusable(true);

        initGame();
        startGame();
    }

    /**
     * Panel Konstruktor mit Parametern
     *
     * @param gameWidth gamePanel breite
     * @param gameHeight gamePanel höhe
     */
    public GamePanel(int gameWidth, int gameHeight) {
        prefSize = new Dimension(gameWidth, gameHeight);
        setPreferredSize(prefSize);
        setFocusable(true);

        initGame();
        startGame();
    }

    /**
     * Objekte werden initialisiert für
     * GamePanel.
     */
    private void initGame(){
        //GameObjects wird initialisiert
        objects = new GameObjects();
        objects.setOpaque(false);
        objects.initObjects();
        //BorderLayout wird initialisiert
        borderLayout = new BorderLayout();
        //Layout wird auf BorderLayout gesetzt
        setLayout(borderLayout);

        //Background image setzen
        setBackground(2);
        //GameLoop timer erstellen
        timer = new Timer(10, e -> {
            loop();
        });

        //zusätzlichen parametern und JComponenten
        //initialisieren
        init();
    }

    /**
     * Die zusätzlichen Methoden werden
     * im init methode initialisiert
     */
    private void init(){
        createTitledBorder();

        //Game Panel
        createGamePanel();
    }

    private void createGamePanel(){
        panelGame = new JPanel();
        panelGame.setLayout(new BorderLayout());
        panelGame.setMinimumSize(new Dimension(prefSize.width-400, prefSize.height));
        panelGame.setOpaque(false);
        panelGame.add(objects, BorderLayout.CENTER);
        //add panel
        add(panelGame, BorderLayout.CENTER);
        panelGame.setEnabled(false);
    }

    /**
     * Das rechte Panel wird initialisiert,
     * und die größen manuel angepasst.
     * <br> --------------------------- <br>
     * Es wird für jedes abschnitt ein JPanel
     * verwendet und wird mit GridBagLayout visualisiert.
     */
    private void createTitledBorder(){
        //Panel initialisieren
        panelRight = new JPanel();

        //setze Größe
        panelRight.setPreferredSize(new Dimension(400, prefSize.height));

        //Neues Dimension Objekt für die Kinder erstellen
        Dimension panelChildDimension = new Dimension(panelRight.getPreferredSize().width - 10, 90);

        //Kinder und geeignete Größe setzen
        JPanel panelRitter = new JPanel();
        panelRitter.setPreferredSize(panelChildDimension);
        panelRitter.setMinimumSize(panelChildDimension);
        JPanel panelDrache = new JPanel();
        panelDrache.setPreferredSize(panelChildDimension);
        panelDrache.setMinimumSize(panelChildDimension);
        JPanel panelInformationen = new JPanel();
        panelInformationen.setMinimumSize(new Dimension(panelChildDimension.width, panelChildDimension.height + 100));
        panelInformationen.setPreferredSize(new Dimension(panelChildDimension.width, panelChildDimension.height + 100));
        JPanel panelAktion = new JPanel();
        panelAktion.setPreferredSize(new Dimension(panelChildDimension.width, panelChildDimension.height + 40));
        panelAktion.setMinimumSize(new Dimension(panelChildDimension.width, panelChildDimension.height + 40));

        /*
            Ritter informationen ausgeben und Schriftart auf MONOSPACED setzen,
            die Schriftgröße wird dabei auf 14 pixel gesetzt.
         */

        JLabel lblRitter = new JLabel();
        lblRitter.setText(objects.getRitter().info());
        lblRitter.setFont(new Font("MONOSPACED", Font.ITALIC, 14));

        /*
            Drachen informationen ausgeben und Schriftart auf MONOSPACED setzen,
            die Schriftgröße wird dabei auf 14 pixel gesetzt.
            Von der Objektritter wird die Schriftart übernomen,
            falls es verändert werden soll, kann man bei lblRitter die setFont,
            Methode aufrufen und dabei eine neue Schriftart übergeben.
         */
        JLabel lblDrache = new JLabel();
        lblDrache.setText(objects.getDrache().info());
        lblDrache.setFont(lblRitter.getFont());

        //Information Panel
        JLabel lblInformationen = new JLabel("Würfele, um das Spiel zu starten!");
        lblInformationen.setFont(lblRitter.getFont());

        //Aktion Panel
        String ergb = "Ergebnis:";
        JLabel lblAktion = new JLabel(ergb + "-");
        JButton jButton = new JButton("Würfeln");

        jButton.addActionListener(e -> {
            Timer textFirst = new Timer(10, first -> {
                if (objects.getPlayerText() == null){
                    objects.setFirst();
                    lblInformationen.setText(objects.getPlayerText());
                }
            });
            textFirst.start();


            if (objects.getPlayerText() != null){
                Random random1 = new Random();
                objects.setRandom(random1.nextInt(3) + 1);
                lblAktion.setText(ergb + objects.getRandom());
            }
            objects.setPlayerText();
            chkPlayerIfUserInit[0] = true;

            Timer timer1 = new Timer(10, s -> {
                lblRitter.setText(objects.getRitter().info());
                lblDrache.setText(objects.getDrache().info());
                lblInformationen.setText(objects.getPlayerText());
            });
            timer1.start();
        });
        lblAktion.setText(ergb + objects.getRandom());
        jButton.setPreferredSize(new Dimension(panelChildDimension.width - 30, 35));
        jButton.setMinimumSize(new Dimension(panelChildDimension.width - 30, 35));
        lblAktion.setFont(lblRitter.getFont());

        /*
            Die Klasse GridBagLayout ist eine Layoutmanager-Klasse in Java Swing, die es ermöglicht,
            Komponenten in einem Gitter von Zeilen und Spalten anzuordnen.
            Die Komponenten können unterschiedliche Größen haben und sich über mehrere Zellen erstrecken.
         */
        panelRight.setLayout(new GridBagLayout());

        //addGridBagConstraints for Ritter
        addGridBagConstraints("Ritter", 1, false, true, panelRitter, panelRight, lblRitter);
        addGridBagConstraints("Drache", 1, false, true, panelDrache, panelRight, lblDrache);
        addGridBagConstraints("Informationen", 1, false, true, panelInformationen, panelRight, lblInformationen);
        addGridBagConstraints("Aktion", 2, false, true, panelAktion, panelRight, jButton, lblAktion);

        //main panel zum HAUPTPANEL übergeben
        panelRight.setBackground(null);
        panelRight.setOpaque(false);
        add(panelRight, BorderLayout.EAST);

    }

    /**
     * @param borderTitle Titel für die Border
     * @param anzahlAnChild Anzahl an Kinder die hinzugefügt werden soll
     * @param gridx Der boolean x soll aktiviert werden oder nicht
     * @param gridy Der boolean y soll aktiviert werden oder nicht
     * @param childPanel Kinder JPanel
     * @param mainPanel Haupt Panel übergeben
     * @param kinder Kinder übergeben
     */
    private void addGridBagConstraints(String borderTitle, int anzahlAnChild, boolean gridx, boolean gridy, JPanel childPanel, JPanel mainPanel, JComponent...kinder){
        /*
            GridBagConstraints ist eine Klasse in der Java Swing-Bibliothek,
            die verwendet wird, um bestimmte Eigenschaften von Komponenten in einem GridBagLayout festzulegen.
         */
        GridBagConstraints gbc = new GridBagConstraints();

        /*
            Die gridwidth-Eigenschaft der GridBagConstraints legt fest,
            wie viele Spalten eine Komponente im GridBagLayout einnimmt.
            Der Wert GridBagConstraints.REMAINDER besagt,
            dass die Komponente die letzte Spalte im Grid einnimmt und somit bis zum Rand des Panels reicht.
         */
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        //Horizontal setzen
        gbc.fill = gbc.HORIZONTAL;
        childPanel.add(kinder[0], gbc);
        /*
            In diesem Beispiel wird eine CompoundBorder erstellt,
            die aus einer TitledBorder und einer EmptyBorder besteht.
            Die TitledBorder hat den Titel die im `str` ist, wird linksbündig angezeigt und linksbündig ausgerichtet.
            Die EmptyBorder hat einen Abstand von 10 Pixeln zu allen Seiten.
         */
        TitledBorder titledBorder = new TitledBorder(null, borderTitle, TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION);
        titledBorder.setTitleColor(new Color(255, 255, 255, 221));
        Border border = new CompoundBorder(
                titledBorder,
                new EmptyBorder(10, 10, 15, 10)
        );

        //Border setzen
        childPanel.setBorder(border);
        //übergeben an Main Panel
        mainPanel.add(childPanel, gbc);

        //Kinder Panel dem Layout GridBagLayout fügen
        childPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbcChild = new GridBagConstraints();
        /*
            Die Eigenschaft anchor der Klasse GridBagConstraints gibt an,
            wie das Komponenten-Objekt im Zelle angeordnet werden soll.
         */
        gbcChild.anchor = GridBagConstraints.WEST;
        /*
            Ein Wert zwischen 0 und 1 gibt an,
            dass die Komponente nur einen Teil des verfügbaren Platzes
            ausfüllen soll und entsprechend weniger Ressourcen erhält.
         */
        gbcChild.weightx = 0.5;
        gbcChild.weighty = 0.5;

        for (int i = 0; i < anzahlAnChild; i++){
            if (gridx){
                gbcChild.gridx = i; //x Koordinate
            }else {
                gbcChild.gridx = 0;
            }

            if (gridy){
                gbcChild.gridy = i; //y Koordinate
            }else {
                gbcChild.gridy = 0;
            }
            kinder[i].setForeground(new Color(255, 255, 255, 221));
            childPanel.add(kinder[i], gbcChild);
        }
        childPanel.setOpaque(false);
    }

    /**
     * In der Methode createPause
     * erstelle ich ein Rechteck, in der ein Hintergrund ist, um später
     * zusätzlichen informationen anzuzeigen.
     * @param g @see {@link java.awt.Graphics}
     */
    private void createPause(Graphics g){
        g.clearRect(0,0, prefSize.width, prefSize.height);
        //Hintergrund
        Rectangle rectangle = new Rectangle();
        rectangle.setRect(0, 0, prefSize.width, prefSize.height);
        g.setColor(new Color(115, 115, 115, 168));
        g.fillRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
        panelRight.setVisible(false);
        panelGame.setVisible(false);

        //Menü
        g.setColor(Color.BLACK);
        g.setFont(new Font(Font.SERIF, Font.BOLD, 30));
        g.drawString("Pause", 50, 50);
        g.fillRect(50, 70, 300, 15);

        //Continue das Game
        g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 14));
        g.setColor(new Color(255, 255, 255, 255));
        g.setColor(new Color(24, 64, 87, 168));
        g.drawString("Umschalt + C - Startet das Spiel", 50, 130);
        g.drawString("Umschalt + R - Startet das Spiel Neu", 50, 150);
        g.drawString("STRG + Q - Beendet das Spiel", 50, 170);
        g.drawString("STRG + A - Öffnet die Autor Seite", 50, 190);
        g.drawString("STRG + G - Öffnet die Game Beschreibung Seite", 50, 210);
        repaint();
    }

    /**
     * Clear methode
     * um die Klasse zu restarten können
     */
    private void clear(){
        setGameOver(false);
        panelGame.removeAll();
        panelRight.removeAll();
        objects.removeAll();
        setPause(true);
        setStart(true);
        setContinueButton(true);
        createPause(getGraphics());
        repaint();
    }

    /**
     * Die Methode startet das Spiel
     */
    public void startGame(){
        timer.start();
        setStart(false);
        setPause(false);
        setContinueButton(true);
        objects.initObjects();
        createGamePanel();
        createTitledBorder();
        repaint();
    }

    /**
     * Falls der Fenster nicht im Vordergrund oder durch
     * Tastenkombination P wird das Spiel pausiert.
     */
    public void pause(){
        timer.stop();
        setPause(true);
        setStart(false);
        setContinueButton(false);
        panelGame.setVisible(false);
        panelRight.setVisible(false);
        objects.setVisible(false);
        createPause(getGraphics());
        repaint();
    }

    /**
     * setzt das Spielfort.
     */
    public void continueGame(){
        if (!isGameOver()) timer.start();
        setPause(false);
        setContinueButton(false);
        panelRight.setVisible(true);
        panelGame.setVisible(true);
        objects.setVisible(true);
        repaint();
    }

    /**
     * Setzt das Spiel auf Anfang
     * und ruft die methode startGame auf, um
     * das Spiel zu Starten
     */
    public void restart(){
        objects.restart();
        clear();
        repaint();
    }

    /**
     * In der methode setBackground
     * setzen wir ein neues Hintergrundbild.
     * @param i integer variable um den Hintergrund ändern zu können
     */
    public void setBackground(int i){
        BufferedImage image = objects.load(Game.PATH + backgroundsImage[i]);
        backgroundImage = new ImageIcon(image);
    }

    /**
     * Überschreibt die Methode setBackground um das Enum
     * Background, wird noch einfacher für User werden,
     * da es nur eins von Background gewählt werden können.
     * @param background
     */
    public void setBackground(Background background){
        switch (background){
            case BACKGROUND_GREEN -> setBackground(0);
            case BACKGROUND_ORANGE -> setBackground(1);
            case BACKGROUND_BLUE -> setBackground(2);
        }
    }

    /**
     * Background als ImageIcon zurückliefern
     * @param i integer Zahl für ein Hintergrundsbild
     * @return Ein Objekt von der Klasse ImageIcon
     */
    public ImageIcon getBackgroundImage(int i){
        return backgroundImage = new ImageIcon(objects.load(Game.PATH + backgroundsImage[i]));
    }

    /**
     * Background als ImageIcon zurückliefern
     * @param background das Enum Klasse Background kann als Helfe für
     *                   ein Hintergrundbild genutzt werden.
     * @return Ein Objekt von der Klasse ImageIcon
     */
    public ImageIcon getBackgroundImage(Background background){
        //ImageIcon objekt
        ImageIcon icon = null;
        //abfrage ob, Grün gewählt wurde
        if (background == Background.BACKGROUND_GREEN){
            icon = getBackgroundImage(0);
        }
        //oder ist es Orang
        if (background == Background.BACKGROUND_ORANGE){
            icon = getBackgroundImage(1);
        }
        //oder ist es doch Blau
        if (background == Background.BACKGROUND_BLUE){
            icon = getBackgroundImage(2);
        }
        //gib das Objekt zurück
        return icon;
    }

    /**
     * Loop methode Herzstück jedes Spieles
     */
    private void loop(){
        //Beispiel
        repaint();
    }

    /**
     *
     * @return true, wenn Pause vorhanden ist.
     */
    public boolean isPause() {
        return pause;
    }

    public void setPause(boolean pause) {
        this.pause = pause;
    }

    /**
     * @return ob das Spiel beendet ist oder noch läuft.
     */
    public boolean isGameOver() {
        return gameOver;
    }

    /**
     * @param gameOver gameOver zustandswert verändern
     */
    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public boolean isStart() {
        return start;
    }

    public void setStart(boolean start) {
        this.start = start;
    }

    public boolean isContinueButton() {
        return continueButton;
    }

    public void setContinueButton(boolean continueButton) {
        this.continueButton = continueButton;
    }

    /**
     * Zeichen methode alles im Spiel verfügbaren Objekten werden
     * hier gezeichnet oder aufgerufen
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        backgroundImage.paintIcon(null, g, 0,0);

        if (isGameOver()){
            g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 100));
            g.setColor(Color.RED);
            g.drawString("GAME OVER!", prefSize.width/2 - 275, prefSize.height/2);
        }

        if (isPause()){
            createPause(g);
        }

        //GameObjekts die paintComponent methode aufrufen
        objects.paintComponent(g);
    }
}
