package de.khudhur.internship.internship11.gui.objects;

import de.khudhur.internship.internship11.gui.Game;
import de.khudhur.internship.internship11.gui.landscape.Gras;
import de.khudhur.internship.internship11.gui.landscape.Lava;
import de.khudhur.internship.internship11.gui.landscape.Water;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class GameObjects extends JPanel{

    private Ritter ritter;
    private Drache drache;
    private boolean close;
    private boolean turn;
    private int gewuerfelt;
    private String playerText;
    private JPanel panelKachel;
    private JButton[][] kacheln;
    private boolean[][] booleansKacheln;
    private JFrame createdJFrame = null;

    public void initObjects() {
        ritter = new Ritter();
        drache = new Drache();

        //initialisiere Object Panel
        setLayout(new BorderLayout());

        //init kacheln
        initKacheln();
    }

    /**
     * Kacheln initialisieren
     * <br>
     * Die Kacheln werden mit einem Feld von 7 x 7 feldern
     * initialisiert und dem JPanel panelKachel übergeben.
     */
    private void initKacheln(){
        //JPanel initialisieren
        panelKachel = new JPanel();
        panelKachel.setOpaque(false); //hintergrundentfernen
        panelKachel.setLayout(null); //layout auf null

        //kacheln initialisieren
        kacheln = new JButton[7][7];

        //kacheln eine feste größe und Koordinaten geben
        Dimension dimension = new Dimension(70, 70);
        for (int i = 0; i < kacheln.length; i++) {
            for (int j = 0; j < kacheln.length; j++) {
                kacheln[i][j] = new JButton();
                kacheln[i][j].setBounds(i * 70, j * 70, dimension.width, dimension.height);
                panelKachel.add(kacheln[i][j]);
            }
        }

        //random map
        int[][] kachelInt = new int[7][7];
        booleansKacheln = new boolean[7][7];
        for (int i = 0; i < kachelInt.length; i++) {
            for (int j = 0; j < kachelInt.length; j++) {
                Random random = new Random();
                kachelInt[i][j] = random.nextInt(3);
                booleansKacheln[i][j] = false;
            }
        }

        //kacheln action listener und map zeichnen
        for (int i = 0; i < kacheln.length; i++) {
            for (int j = 0; j < kacheln[0].length; j++) {
                //map zeichnen
                //wasser
                if (kachelInt[i][j] == 0){
                    kacheln[i][j].setBackground(new Water(kacheln[i][j].getX(), kacheln[i][j].getY(), kacheln[i][j].getWidth(), kacheln[i][j].getHeight()).getBackground());
                }
                //grass
                if (kachelInt[i][j] == 1){
                    kacheln[i][j].setBackground(new Gras(kacheln[i][j].getX(), kacheln[i][j].getY(), kacheln[i][j].getWidth(), kacheln[i][j].getHeight()).getBackground());
                }
                //Vulkan
                if (kachelInt[i][j] == 2){
                    kacheln[i][j].setBackground(new Lava(kacheln[i][j].getX(), kacheln[i][j].getY(), kacheln[i][j].getWidth(), kacheln[i][j].getHeight()).getBackground());
                }
            }
        }

        //Ritter und Drachen Zeichnen
        ritterPaint(0, 0);
        drachePaint(6, 6);
        booleansKacheln[0][0] = true;
        booleansKacheln[6][6] = true;

        for (int i = 0; i < kacheln.length; i++) {
            for (int j = 0; j < kacheln.length; j++) {
                int finalI = i;
                int finalJ = j;
                kacheln[i][j].addActionListener(e -> {
                    if (isTurn()){
                        if (!booleansKacheln[finalI][finalJ]){
                            ritterPaint(finalI, finalJ);
                            setTurn(false);
                            booleansKacheln[finalI][finalJ] = true;
                        }
                        if (booleansKacheln[finalI][finalJ]){
                            System.out.println("Feld ist besetzt");
                        }
                    }
                    if (!isTurn()){
                        if (!booleansKacheln[finalI][finalJ]){
                            drachePaint(finalI, finalJ);
                            setTurn(true);
                            booleansKacheln[finalI][finalJ] = true;
                        }
                        if (booleansKacheln[finalI][finalJ]){
                            System.out.println("Feld ist besetzt");
                        }
                    }
                });
            }
        }

        //kacheln hinzufügen
        add(panelKachel, BorderLayout.CENTER);

    }

    /**
     * Um ein Fenster zu erstellen, kann man durch die createJFrame
     * methode ein völlig separates Fenster initialisieren.
     *
     * @param title Fenstertitel
     * @param icon Fenstericon
     * @param ueberschrift Überschrift für die Frames
     * @param description Beschreibung für die Frames
     */
    public void createJFrame(String title, String icon, String ueberschrift, String description, boolean startAnimation){
        //neues Frame mit Titel erstellen
        JFrame frame = new JFrame(title);

        //Image erstellen und in die JLabel Übergeben
        JLabel lbl1 = new JLabel();
        BufferedImage image = load(icon);
        //Skaliertes icon laden
        ImageIcon scaledIcon = new ImageIcon(image.getScaledInstance(128, 128, Image.SCALE_SMOOTH));
        //aufnahme in die JLabel Klasse
        lbl1.setIcon(scaledIcon);
        //Da, die Layout null ist, kann ich mit dem Methode setBounds neue Koordinaten
        //und Größen angeben.
        lbl1.setBounds(50, 75, 128, 128);
        //Im frame Klasse aufnehmen
        frame.add(lbl1);

        //Überschrift initialisieren
        JLabel lbl2 = new JLabel();
        lbl2.setText(ueberschrift);
        //Label für überschrift, die Größe setzen
        lbl2.setPreferredSize(new Dimension(ueberschrift.length() * 5 + 150, 100));
        //Neue Schrift übergeben und Schriftgröße
        lbl2.setFont(new Font(Font.MONOSPACED, Font.BOLD, 18));
        //Neue Koordinaten und Größe setzen
        lbl2.setBounds(200, 20, lbl2.getPreferredSize().width, lbl2.getPreferredSize().height);
        //im frame Klasse aufnehmen
        frame.add(lbl2);

        //Beschreibung initialisieren
        JTextArea textArea = new JTextArea();
        //Beschreibung setzen
        textArea.setText(description);
        //position des Text auf null setzen
        textArea.setCaretPosition(0);
        //neue Schriftart und Größe setzen
        textArea.setFont(new Font(Font.MONOSPACED, Font.ITALIC, 15));
        //Der TextArea soll nicht schreibbar sein
        textArea.setEditable(false);
        //An die TextArea größe passen
        textArea.setLineWrap(true);
        //und auch durch sinnvollen Wörter unterbrechen
        textArea.setWrapStyleWord(true);
        //Die Methode macht, ob ein Element durchsichtig oder nicht
        textArea.setOpaque(false);
         /*
          Um den TextArea scrollbar zu machen brauchen wir die Klasse JScrollPane.
          In der JScrollPane Konstruktor, übergebe ich den TextArea und setze

          VERTICAL_SCROLLBAR_AS_NEEDED ist eine Konstante in der Klasse JScrollPane,
          die verwendet wird, um anzugeben, dass die vertikale Scrollbar nur dann angezeigt wird,
          wenn der Inhalt des JScrollPane größer ist als der verfügbare Platz.

          HORIZONTAL_SCROLLBAR_AS_NEEDED ist eine Konstante in der Klasse JScrollPane,
          die verwendet wird, um anzugeben, dass die horizontale Scrollbar nur dann angezeigt wird,
          wenn der Inhalt des JScrollPane größer ist als der verfügbare Platz.
         */
        JScrollPane area = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        /*
          BorderFactory.createEmptyBorder() ist eine Methode in der Klasse BorderFactory,
          die verwendet wird, um einen leeren Border zu erstellen.
          Der leere Border hat keine Linien oder Füllung und gibt den Komponenten,
          auf die er angewendet wird, mehr Platz.
         */
        area.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));

        /*
          um die Scroll-Balken zu verändern bzw. nur
          die Balken Farbe zu ändern, benötige ich die
          JScrollBar Klasse. Dadurch kann ich auf die setUI
          Methode greifen und die Methode configureScrollBarColors und
          paintThumb zugreifen.
         */
        JScrollBar scrollBar = area.getVerticalScrollBar();
        scrollBar.setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = Color.GRAY;
            }
            @Override
            protected void paintThumb(final Graphics g, final JComponent c, final Rectangle thumbBounds) {
                int x = thumbBounds.x +1;
                int y = thumbBounds.y +1;
                int w = thumbBounds.width -2;
                int h = thumbBounds.height -2;

                g.setColor(Color.GRAY);
                g.fillRect(x+1,y+1,w,h);
                g.setColor(Color.GRAY);
                g.drawRect(x,y,w,h);

                incrButton.setBackground(Color.LIGHT_GRAY);
                decrButton.setBackground(Color.LIGHT_GRAY);
                incrButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                decrButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
        });

        if (startAnimation){
            scrollBar.setUnitIncrement(1);
            Timer timer = new Timer(600, e -> scrollBar.setValue(scrollBar.getValue() + scrollBar.getUnitIncrement()));
            timer.start();
        }

        //TextArea die neue Vertikal scrollbar übergeben
        area.setVerticalScrollBar(scrollBar);
        //position und größe initialisieren
        area.setBounds(200, 100, 600 - textArea.getWidth() - 170, 240);
        //in frame aufnehmen
        frame.add(area);

        if (!frame.isActive() || !frame.isVisible()){
            setClose(true);
        }

        //frame initialisieren und sichtbar machen
        createdJFrame = frame;
        frame.setLayout(null); //Layout ist null
        frame.setIconImage(loadIcon(icon)); //setze icon
        frame.setMinimumSize(new Dimension(650, 350)); //größe
        frame.setLocationRelativeTo(null);//Fenster mittig setzen
        frame.setResizable(false); //nicht dehnbar
        frame.setVisible(true); //sichtbar
    }

    /**
     * Die Methode loadIcon, ladet aus dem angegebenes
     * Pfad ein Bild
     * @param path Bildpfad als String variable
     * @return neues und geladenes Image zurückwerfen
     */
    public Image loadIcon(String path){
        return new ImageIcon(path).getImage();
    }

    /**
     * Die Methode loadImageIcon, ladet aus dem angegebenes
     * Pfad ein Bild.
     * @param path Bildpfad als String variable
     * @return neues und geladenes ImageIcon wird zurückgeworfen
     */
    public ImageIcon loadImageIcon(String path){
        return new ImageIcon(path);
    }

    /**
     * Die Methode ladet von der Enum Klasse die erforderlichen Schriftarten.
     * Dadurch kann ich besser ein auswahl zutreffen kann.
     * @param fontEnum @see{@link FontEnum}
     * @param size Schriftgröße eingeben
     * @return Neues Font objekt
     */
    public Font loadFonts(FontEnum fontEnum, float size){
        //Font pfad
        String f = Game.PATH + "fonts/";

        //switch case
        switch (fontEnum){
            //Schriftart Monatha
            case MONATHA -> f += "Monatha.ttf";
            //Schriftart Prof Bens
            case PROF_BENS -> f += "pb.ttf";
            //Standard Schriftart wäre MONOSPACED
            default -> new Font(Font.MONOSPACED, Font.ITALIC, 18);
        }
        //Font objekt
        Font font = null;
        //versuche die Fonts durch angegebenes Datei zu laden
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File(f));
            font = font.deriveFont(size);
        } catch (IOException | FontFormatException e) {
            String str = "Nachricht: " + e.getMessage();
            str += "\nNachricht lokalisiert: " + e.getLocalizedMessage();
            if (getCreatedJFrame() == null)
                createJFrame(
                        "FontEnum Error",
                             ErrorIcons.ERROR,
                        "Der Schriftart '" + fontEnum + "'\n kann nicht laden",
                             str,
                        true
                        );
        }
        return  font;
    }

    /**
     * @param path Der Pfad zum Laden eines Bildes
     * @return geladenes Bild wird zurückgeliefert, falls vorhanden ist,
     *          ansonsten wird ein entsprechendes Exception ausgegeben.
     */
    public BufferedImage load(String path){
        BufferedImage image;
        try {
            image = ImageIO.read(new File(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return image;
    }

    /**
     * @return Text wer dran ist
     */
    public String getPlayerText(){
        return playerText;
    }

    /**
     * Wer dran ist
     */
    public void setPlayerText(){
        if (isTurn()){
            playerText = "Der Ritter ist dran";
        }
        if(!isTurn()){
            playerText = "Der Drache ist dran";
        }
    }

    /**
     * Wer darf Anfangen
     */
    public void setFirst(){
        int ritter, drache;
        ritter = new Random().nextInt(3) + 1;
        drache = new Random().nextInt(3) + 1;

        if (ritter == drache){
            ritter = new Random().nextInt(3) + 1;
            drache = new Random().nextInt(3) + 1;
        }

        setTurn(ritter > drache);
        setPlayerText();
        repaint();
    }

    public JFrame getCreatedJFrame(){
        return createdJFrame;
    }

    protected int random(){
        return new Random().nextInt(3) + 6;
    }

    public boolean isTurn(){
        return turn;
    }

    public void setTurn(boolean pl){
        this.turn = pl;
    }

    public void setRandom(int random){
        this.gewuerfelt = random;
    }

    public int getRandom(){
        return gewuerfelt;
    }

    public boolean isClose() {
        return close;
    }

    public void setClose(boolean close) {
        this.close = close;
    }

    public Ritter getRitter(){
        return ritter;
    }

    public Drache getDrache() {
        return drache;
    }

    public void clear(){
        clearDrachenRitter();
        kacheln = null;
        panelKachel = null;
        ritter = null;
        drache = null;
    }

    public void restart(){
        clear();
        initObjects();
        initKacheln();
        repaint();
    }

    @Override
    public void paintComponent(Graphics gr) {
        super.paintComponent(gr);
    }

    private void ritterPaint(int x, int y){
        kacheln[x][y].setBackground(Color.BLACK);
        kacheln[x][y].setForeground(Color.WHITE);
        kacheln[x][y].setFont(loadFonts(FontEnum.MONATHA, 43f));
        kacheln[x][y].setText("R");
        repaint();
    }

    private void drachePaint(int x, int y){
        kacheln[x][y].setBackground(Color.BLACK);
        kacheln[x][y].setForeground(Color.WHITE);
        kacheln[x][y].setFont(loadFonts(FontEnum.MONATHA, 26f));
        kacheln[x][y].setText("D");
        repaint();
    }

    private void clearDrachenRitter(){
        for (int i = 0; i < kacheln.length; i++) {
            for (int j = 0; j < kacheln.length; j++) {
                kacheln[i][j].setBackground(null);
                kacheln[i][j].setText("");
            }
        }
    }

}
