package de.khudhur.internship.internship11.gui;

import de.khudhur.internship.internship11.gui.objects.Background;
import de.khudhur.internship.internship11.gui.objects.GameObjects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * ###########Game Klasse###########
 * ---------------------
 * Verwaltet, initialisiert GameObject und zeichnet
 * das Spiel.

 *  - Game beschreibung:
 * Das Spiel ist Ritter gegen Drache in einer 7x7 Feld,
 * durch unterschiedlichen Landschaften, erkämpfen sich nach
 * Spielstärke, der stärkere gewinnt. Sobald sich die Spieler
 * aufeinander treffen entscheidet der Stärke alles.

 * - Feature
 *  -> Auf Spielkachel sind random stärke.
 *  -> Spieler können per Maus auf eine Kachel tippen.
 *  -> Spieler informationen können auf rechte Panel abgelesen werden.
 *  -> Aktionen können mit ein Button zugegriffen werden.
 *  -> Über das Menü, kann das Spiel folgendes:
 *      -> Spiel pausieren
 *      -> Spiel kann wieder fortgesetzt werden
 *      -> Spiel kann beendet werden
 *      -> Neues Spiel kann erstellt werden.
 *      -> Background kann gesetzt werden
 *      -> Spielinformationen können gezeigt werden
 *      -> Entwickler wird gezeigt

 * ---------------------
 * @author Ayaz Khudhur
 * @version 1.0
 */
public class Game extends JFrame {

    //Attributen
    private String gameTitle, gameBeschreibung, gameIcon;
    private final long ID = 1L; //Klass version
    //autorName, autorBeschreibung und ein Bild
    private String autor, autorBeschreibung, autorImagePath;
    //game Breite und game Höhe
    private int gameWidth, gameHeight;
    //game panel
    private GamePanel gamePanel;
    private GameObjects objects;

    //individual Attributen
    public static final String PATH = "src/main/java/de/khudhur/internship/internship11/assets/";

    /**
     * #### Game Konstruktor ####
     * Lade game inhalte
     */
    public Game(){
        //Windows Listener
        registerGameListener();
        //Erstelle das Menü
        createMenu();

        //initialisiere JFrame und Parametern
        init();
        initFrame();
    }

    /**
     * Initialisiere Frame Eigenschaften.
     */
    private void initFrame(){
        //add
        add(gamePanel);

        //Frame config
        //an komponenten anpassen
        pack();

        //Bedienung von minimieren, maximieren und schlissen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Fenster zentrieren
        //setLocationRelativeTo(null);

        setIconImage(objects.loadIcon(getGameIcon()));

        //Fenstertitel
        setTitle(getGameTitle());
        //Fenstergröße
        setSize(new Dimension(getGameWidth(), getGameHeight()));
        setMinimumSize(new Dimension(getGameWidth(), getGameHeight()));
        setMaximumSize(new Dimension(getGameWidth(), getGameHeight()));

        setLocationRelativeTo(null);

        //nicht resizable
        setResizable(false);
        //Fenstersichtbarkeit
        setVisible(true);
    }

    /**
     * initialisiere GameObjects
     */
    private void init(){
        gameTitle = "Ritter gegen Drache";
        gameBeschreibung = """
                In dem Spiel "Ritter gegen Drache" geht es um den tapferen Ritter Sir William, der sich aufmacht, 
                das Königreich vor dem bösen Drachenkönig zu retten. Sir William wurde von König Harold ausgesandt, 
                um den mächtigen Drachenkönig zu bezwingen, der das Land mit seiner Armee von Unterdrachen terrorisiert.

                Sir William zieht durch das Land und bekämpft eine Reihe von mächtigen Drachen, die ihm in den Weg kommen. 
                Auf seiner Reise trifft er auf verschiedene Charaktere, die ihm bei seiner Quest helfen, 
                darunter eine weise alte Hexe, die ihm magische Tränke verkauft, und einen mutigen Knappen, 
                der Sir William als Schildträger begleitet.

                Schließlich gelangt Sir William zum Versteck des Drachenkönigs, einer gewaltigen Burg, 
                die von tausenden von Unterdrachen bewacht wird. Der Ritter kämpft sich durch die Armee 
                und trifft schließlich auf den mächtigen Drachenkönig selbst. In einem epischen Kampf 
                setzt Sir William alles auf eine Karte und schafft es schließlich, den Drachenkönig zu 
                bezwingen. Das Königreich ist gerettet und Sir William wird als Held gefeiert.""";
        gameIcon = PATH + "RitterGegenDrache2.png";
        autor = "Ayaz Khudhur";
        autorBeschreibung = "Ich heiße Ayaz Khudhur und bin 24 Jahre alt. " +
                            "Programmieren ist eines meiner Hobbys und ich höre sehr gerne Musik. " +
                            "In meiner Freizeit nehme ich mir auch immer wieder Zeit, " +
                            "um mich um meine Gesundheit zu kümmern und mich sportlich zu betätigen." +
                            "Ich studiere derzeit Informatik und hoffe, in Zukunft in diesem Bereich zu arbeiten. " +
                            "Ich bin sehr interessiert an neuen Technologien und versuche immer, " +
                            "mich weiterzubilden und meine Fähigkeiten zu verbessern. " +
                            "Auch in meiner Freizeit lese ich gerne Fachliteratur und " +
                            "halte mich über aktuelle Entwicklungen auf dem Laufenden. " +
                            "Ich bin auch sehr sozial und treffe mich gerne mit Freunden und Familie. " +
                            "Insgesamt genieße ich es, meine Zeit sinnvoll und abwechslungsreich zu gestalten.";
        //Autor Profilbild
        autorImagePath = PATH + autor + ".png";
        //Breite
        gameWidth = 906;
        //Höhe
        gameHeight = 552;

        //GamePanel initialisieren
        gamePanel = new GamePanel(gameWidth, gameHeight);
        objects = new GameObjects();
    }

    /**
     * Window Listener
     * Fenster aktivitäten, wenn Fenster minimiert, unsichtbar oder
     * geschlossen wird.
     */
    private void registerGameListener(){
        addWindowListener(new WindowAdapter() {

            //Wenn Fenster geschlossen wird
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }

            //Wenn Fenster wieder im sichtbaren bereich ist,
            //soll das Spiel wieder starten
            @Override
            public void windowActivated(WindowEvent e) {
                gamePanel.continueGame();
                if (objects.isClose()){
                    gamePanel.setPause(true);
                }
            }

            //Wenn Fenster im Hintergrund ist, soll
            //das Spiel pausiert werden.
            @Override
            public void windowDeactivated(WindowEvent e) {
                gamePanel.pause();
            }
        });
    }

    /**
     * createMenu
     * hier erstelle ich die Menüs für das Spiel.
     */
    private void createMenu(){

        //Menüleiste
        JMenuBar bar = new JMenuBar();
        setJMenuBar(bar);

        //Menu's erstellen
        JMenu fileMenu = new JMenu("File");
        JMenu gameMenu = new JMenu("Game");
        JMenu prefMenu = new JMenu("Preferences");
        JMenu aboutMenu = new JMenu("About");

        /*
            addMenuItems
            durch einen Timer wird die Items nach eine Sekunde
            geladen, um sicherzustellen, dass alle elementen
            initialisiert werden können.
        */
        Timer timer = new Timer(1, e -> {
            //aufruf der Items
            addFileMenuItem(fileMenu);
            addGameMenuItem(gameMenu);
            addPreferencesItem(prefMenu);
            addAboutItem(aboutMenu);

            //Timer danach beenden
            ((Timer) e.getSource()).stop();
        });
        //Timer starten
        timer.start();

        //Menü in die Menüleiste aufnehmen
        bar.add(fileMenu);
        bar.add(gameMenu);
        bar.add(prefMenu);
        bar.add(aboutMenu);
    }

    /**
     * Menüitems von File Menü werden eingefügt und
     * initialisiert.
     * @param fileMenu erwartet das File Menü
     */
    private void addFileMenuItem(JMenu fileMenu){
        //Menüitem quit
        JMenuItem quitItem = addIconToMenuItems("Custom.quitIcon", "Quit", PATH +  "logout.png", fileMenu);
        //Tastenkürzel STRG + Q
        quitItem.setAccelerator(keyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_MASK));
        //in FileMenu aufnehmen
        fileMenu.add(quitItem);
        //Beenden das Spiel initialisieren
        quitItem.addActionListener(e -> System.exit(1));
    }

    /**
     * Menüitems von Game Menü werden eingefügt und
     * initialisiert.
     * @param gameMenu erwartet das Game Menü
     */
    private void addGameMenuItem(JMenu gameMenu){
        //Menüitem pause
        JMenuItem start = addIconToMenuItems("Custom.startIcon", "Start", PATH + "start.png", gameMenu);
        start.setAccelerator(keyStroke(KeyEvent.VK_S, KeyEvent.SHIFT_MASK));
        //in GameMenu aufnehmen
        gameMenu.add(start);

        Timer timer = new Timer(10, e ->{
            if (gamePanel.isStart()){
                start.setEnabled(true);
                repaint();
            }
            if (!gamePanel.isStart()){
                start.setEnabled(false);
                repaint();
            }
        });
        timer.start();

        //Action Listener initialisieren, und pause methode
        //in der GamePanel aufrufen.
        start.addActionListener(e -> {
            gamePanel.startGame();
            System.out.println("start");
            repaint();
        });

        //Menüitem pause
        JMenuItem pause = addIconToMenuItems("Custom.pauseIcon", "Pause", PATH + "pause.png", gameMenu);
        pause.setAccelerator(keyStroke(KeyEvent.VK_P, KeyEvent.SHIFT_MASK));
        //in GameMenu aufnehmen
        gameMenu.add(pause);

        Timer timer1 = new Timer(10, e -> {
            if (gamePanel.isPause()){
                pause.setEnabled(false);
            }
            if (!gamePanel.isPause()){
                pause.setEnabled(true);
            }
        });
        timer1.start();

        //Action Listener initialisieren, und pause methode
        //in der GamePanel aufrufen.
        pause.addActionListener(e -> {
            gamePanel.pause();
            System.out.println("Pause");
            repaint();
        });

        //Menüitem Continue
        JMenuItem continueGame = addIconToMenuItems("Custom.continueIcon", "Continue", PATH + "continue.png", gameMenu);
        continueGame.setAccelerator(keyStroke(KeyEvent.VK_C, KeyEvent.SHIFT_MASK));
        //Aufnahme in der GameMenu
        gameMenu.add(continueGame);

        Timer timer2 = new Timer(10, e -> {
            if (gamePanel.isContinueButton()){
                continueGame.setEnabled(false);
            }
            if (!gamePanel.isContinueButton()){
                continueGame.setEnabled(true);
            }
        });
        timer2.start();

        //Aufruf der Methode Continue von der GamePanel
        continueGame.addActionListener(e -> {
            gamePanel.continueGame();
            System.out.println("Continue");
            repaint();
        });

        //Menüitem Neustart des Spieles
        JMenuItem restart = addIconToMenuItems("Custom.restartIcon", "Restart", PATH + "restart.png", gameMenu);
        restart.setAccelerator(keyStroke(KeyEvent.VK_R, KeyEvent.SHIFT_MASK));
        //Ein Separator Einfügen
        gameMenu.addSeparator();
        //Aufnahme in der GameMenu
        gameMenu.add(restart);
        //Aufruf der Methode restart von der GamePanel
        restart.addActionListener(e -> {
            gamePanel.restart();
            System.out.println("Restart");
            repaint();
        });
    }

    /**
     * Menüitems von Preferences Menü werden eingefügt und
     * initialisiert.
     * @param prefMenu erwartet die Preferences Menü
     */
    private void addPreferencesItem(JMenu prefMenu){
        //Hintergrunds Bilder
        JMenu subMenu = addIconToMenu("Custom.background", "Background", PATH + "background.png");
        //Background 1
        JMenuItem choose1 = addIconToMenuItems("Custom.chooseIcon1", "GRÜN", gamePanel.getBackgroundImage(Background.BACKGROUND_GREEN), prefMenu);
        //Background 2
        JMenuItem choose2 = addIconToMenuItems("Custom.chooseIcon2", "ORANG", gamePanel.getBackgroundImage(Background.BACKGROUND_ORANGE), prefMenu);
        //Background 3
        JMenuItem choose3 = addIconToMenuItems("Custom.chooseIcon3", "BLAU", gamePanel.getBackgroundImage(Background.BACKGROUND_BLUE), prefMenu);

        //Hinzufügen in der subMenu
        subMenu.add(choose1);
        subMenu.add(choose2);
        subMenu.add(choose3);

        //ActionListener
        choose1.addActionListener(e -> {
            gamePanel.setBackground(Background.BACKGROUND_GREEN); //background 1
            repaint();
        });
        choose2.addActionListener(e -> {
            gamePanel.setBackground(Background.BACKGROUND_ORANGE); //background 2
            repaint();
        });
        choose3.addActionListener(e -> {
            gamePanel.setBackground(Background.BACKGROUND_BLUE); //background 3
            repaint();
        });

        //Hinzufügen im preferences Menu
        prefMenu.add(subMenu);
    }

    /**
     * addAboutItem
     * ist für die Menüleiste About zuständig,
     * um die Menüleiste About mit items zu füllen,
     * werden hier die notwendigen JMenuItems kreiert.
     * ------
     * Hier können auch weitere Items erstellt und dem
     * Menü About hinzugefügt werden.
     * @param about Die JMenu Leiste wird erwartet
     */
    private void addAboutItem(JMenu about){

        //autor item
        JMenuItem autorItem = addIconToMenuItems("Custom.autorIcon", "About Autor", getAutorImagePath(), about);
        //Tastenkürzel (Strg + A)
        autorItem.setAccelerator(keyStroke(KeyEvent.VK_A, KeyEvent.CTRL_MASK));

        /*
            Item actionListener, sobald gedrückt oder mit dem
            Tastenkürzel Strg + A, wird sich der Fenster Autor
            aufgerufen bzw. Initialisiert.
         */
        autorItem.addActionListener(e -> {
            //neues JFrame für Autor Page erstellen
            objects.createJFrame("Autor: " + getAutor(), getAutorImagePath(), getAutor(), getAutorBeschreibung(), true);
            gamePanel.setPause(true);
        });

        //aufnahme in die about menu
        about.add(autorItem);

        //Linie hinzufügen
        about.addSeparator();

        //Ein JFrame über das Spiel
        JMenuItem aboutGame = addIconToMenuItems("Custom.gameIcon", "About Game", getGameIcon(), about);
        //Tastenkürzel für über das Spiel (Strg + G)
        KeyStroke s2 = KeyStroke.getKeyStroke(KeyEvent.VK_G, KeyEvent.CTRL_MASK);
        aboutGame.setAccelerator(s2);
        about.add(aboutGame);

        /*
            Item actionListener, sobald gedrückt oder mit dem
            Tastenkürzel Strg + G, wird sich der Fenster Game Beschreibung
            aufgerufen bzw. Initialisiert.
         */
        aboutGame.addActionListener(e ->{
            objects.createJFrame(
                    "Game beschreibung für: " + getGameTitle(),
                    PATH  + "RitterGegenDrache2.png", getGameTitle(),
                    getGameBeschreibung(),
                    true);
            gamePanel.setPause(true);
        });
    }

    /**
     * addIconToMenuItems, hinzufügt ein icon im angegebenes
     * JMenuItem hinzu.
     * @param customText UIManger ein customText zuweisen
     * @param name JMenuItem einen Text hinzufügen
     * @param path für JMenuItem das Bild Pfad
     * @param menu Übergeordnetes JMenu übergeben
     * @return zurückgeworfen wird ein JMenuItem
     */
    private JMenuItem addIconToMenuItems(String customText, String name, String path, JMenu menu){
        //imageicon laden durch angegebenes Pfad
        ImageIcon icon = objects.loadImageIcon(path);
        //neues Image Objekt erstellen
        Image image = icon.getImage();
        //weiteres Objekt für die Skalierung erstellen
        Image scaledImage = image.getScaledInstance(16, 16, Image.SCALE_SMOOTH);
        //Ein weiteres ImageIcon objekt für die skaliertes Bild erstellen
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        //icon im UIManger unter dem schlüssel customText speichern
        UIManager.put(customText, scaledIcon);
        //neues JMenuItem erstellen und bei Konstruktor die name und icon übergeben
        JMenuItem jMenuItem = new JMenuItem(name, (Icon) UIManager.get(customText));
        //im JMenu aufnehmen
        menu.add(jMenuItem);
        //neues item zurückliefern
        return jMenuItem;
    }

    /**
     * addIconToMenuItems, hinzufügt ein icon im angegebenes
     * JMenuItem hinzu.
     * @param customText UIManger ein customText zuweisen
     * @param name JMenuItem einen Text hinzufügen
     * @param path für JMenuItem das Bild Pfad als ImageIcon
     * @param menu Übergeordnetes JMenu übergeben
     * @return zurückgeworfen wird ein JMenuItem
     */
    private JMenuItem addIconToMenuItems(String customText, String name, ImageIcon path, JMenu menu){
        //imageicon konvertieren in image
        Image image = path.getImage();
        //neues image für Skalieren initialisieren
        Image scaledImage = image.getScaledInstance(16, 16, Image.SCALE_SMOOTH);
        //neues ImageIcon für die Image skalierung
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        //icon im UIManger unter dem schlüssel customText speichern
        UIManager.put(customText, scaledIcon);
        //neues JMenuItem erstellen und bei Konstruktor die name und icon übergeben
        JMenuItem jMenuItem = new JMenuItem(name, (Icon) UIManager.get(customText));
        //im JMenu aufnehmen
        menu.add(jMenuItem);
        //neues item zurückliefern
        return jMenuItem;
    }

    /**
     * addIconToMenu, hinzufügt ein icon im angegebenes
     * JMenu hinzu.
     * @param customText UIManger customText
     * @param name JMenu ein Titel
     * @param path für JMenu das Bild Pfad
     * @return zurückgeworfen wird ein JMenu
     */
    private JMenu addIconToMenu(String customText, String name, String path){
        //imageIcon mit dem angegebene path initialisieren
        ImageIcon icon = new ImageIcon(path);
        //neues image objekt erstellen
        Image image = icon.getImage();
        //weiteres image objekt für die skalierung erstellen
        Image scaledImage = image.getScaledInstance(16, 16, Image.SCALE_SMOOTH);
        //neues imageicon objekt für die skaliertes Bild initialisieren
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        //icon im UIManger unter dem schlüssel customText speichern
        UIManager.put(customText, scaledIcon);
        //Neues menu erstellen und name übergeben
        JMenu jMenu = new JMenu(name);
        //menu ein icon übergeben
        jMenu.setIcon((Icon) UIManager.get(customText));
        //erstelltes Menu zurückliefern
        return jMenu;
    }

    /**
     * JMenuItem um ein Tastenkürzel zuweisen
     * Beispiel: KeyEvent.VK_A, öffnet die register Autor
     *           KeyEvent.VK_G, öffnet die register Game
     * @param event1 ein Integer oder eine Konstante
     *               von der Klasse KeyEvent
     * @return neues KeyStroke wird zurückgeworfen
     */
    private KeyStroke keyStroke(int event1){
        return KeyStroke.getKeyStroke(event1, 0);
    }

    /**
     * JMenuItem um ein Tastenkürzel zuweisen
     * Beispiel Strg + A, öffnet die register Autor
     *          Strg + G, öffnet die register Game
     * @param event1 ein Integer variable wird erwartet,
     *               oder eine Konstante von der Klasse KeyEvent
     * @param event2 zweite Integer oder eine Konstante
     *               von der Klasse KeyEvent
     * @return neues KeyStroke wird zurückgeworfen
     */
    private KeyStroke keyStroke(int event1, int event2){
        return KeyStroke.getKeyStroke(event1, event2);
    }

    /**
     * @return The game version number
     */
    public long getID() {
        return ID;
    }

    /**
     * @return Zugriff auf Game Titel
     */
    public String getGameTitle() {
        return gameTitle;
    }

    /**
     * @param gameTitle setze ein Game Titel
     */
    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }

    /**
     * @return Zugriff auf Game Beschreibung
     */
    public String getGameBeschreibung() {
        return gameBeschreibung;
    }

    /**
     * @param gameBeschreibung Setze eine Beschreibung für ein Spiel
     */
    public void setGameBeschreibung(String gameBeschreibung) {
        this.gameBeschreibung = gameBeschreibung;
    }

    /**
     * @return Zugriff auf GameIcon (Fensterbild)
     */
    public String getGameIcon() {
        return gameIcon;
    }

    /**
     * @param gameIcon Setze ein GameIcon
     */
    public void setGameIcon(String gameIcon) {
        this.gameIcon = gameIcon;
    }

    /**
     * @return Zugriff auf Autor Name
     */
    public String getAutor() {
        return autor;
    }

    /**
     * @param autor Autor Name können mit helfe dieser Parameter
     *              verändert werden.
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * @return Zugriff auf ein Autor Beschreibung, Beispiel Biografie
     */
    public String getAutorBeschreibung() {
        return autorBeschreibung;
    }

    /**
     * @param autorBeschreibung Hier kann der Biografie verändert oder leer gelassen
     *                          werden.
     */
    public void setAutorBeschreibung(String autorBeschreibung) {
        this.autorBeschreibung = autorBeschreibung;
    }

    /**
     * @return Zugriff auf Autor Image
     */
    public String getAutorImagePath() {
        return autorImagePath;
    }

    /**
     * @param autorImagePath Setze ein Image Pfad für Autor ein
     */
    public void setAutorImagePath(String autorImagePath) {
        this.autorImagePath = autorImagePath;
    }

    /**
     * @return Zugriff auf Game Fenster Breite
     */
    public int getGameWidth() {
        return gameWidth;
    }

    /**
     * @param gameWidth Setze ein neues Game Fenster Bereite ein
     */
    public void setGameWidth(int gameWidth) {
        this.gameWidth = gameWidth;
    }

    /**
     * @return Zugriff auf Game Fensterhöhe
     */
    public int getGameHeight() {
        return gameHeight;
    }

    /**
     * @param gameHeight Setze eine Fensterhöhe ein
     */
    public void setGameHeight(int gameHeight) {
        this.gameHeight = gameHeight;
    }

    /**
     * @return Zugriff auf Spiel Control Panel
     */
    public GamePanel getGamePanel() {
        return gamePanel;
    }

    /**
     * @param gamePanel Setze ein Spiel Control Panel ein
     */
    public void setGamePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

}