package de.khudhur.internship.internship10.gui;


import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * @version 1.0
 * @author Ayaz Khudhur
 */

public class Leinwand extends JPanel{

    //autor
    private String autor;
    //fenster breite und höhe
    private int width, height;
    //boolean für santa, tannenbaum, wald, tannenbaumcolorgreen
    private boolean showSanta, isTannenbaum, isWald, tannenbaumColorGreen = false;
    //objekt santa
    private Santa santa;
    //timer objekt
    private Timer timer;

    /**
     * Konstruktor
     * @param width fenster breite
     * @param height fenster höhe
     */
    public Leinwand(int width, int height){
        this.width = width;//setzen
        this.height = height;//setzen
        setLayout(new FlowLayout()); //layout
        setSize(width, height);//größe
        setBackground(Color.GRAY); //panel farbe
        setFocusable(true);//focus

        //spiel initialisieren
        initGame();
    }

    /**
     * Game initialisieren
     * objekte laden
     * timer initialisieren
     *  santa game starten und neu laden
     */
    private void initGame(){
        createGameObjects();
        timer = new Timer(1000, e -> {
            santa.game();
            santa.start();
            repaint();
        });
    }

    /**
     * game objekten erstellen
     */
    private void createGameObjects(){
        //santa objekt erstellen
        santa = new Santa("src/main/java/de/khudhur/internship/internship10/assets/santa.png", 64, 64);
    }

    /**
     * game starten bzw. Timer
     */
    private void startGame(){
        timer.start();
    }

    /**
     * game pausieren, bzw Timer stoppen
     */
    private void endGame(){
        timer.stop();
        santa.setX(0);
        if (santa != null){
            santa.clear(getGraphics());
        }
    }

    //override methode fürs zeichnen
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //setze hintergrund in Schwarz
        setBackground(Color.black);

        //zeichne Sterne
        boolean bStar = drawStars(g);

        boolean bTannen = false, bWald = false;
        //tannenbaum
        if (isTannenbaum()) {
            tannenbaum(g);
            bTannen = true;
        }

        //wald
        if (isWald()) {
            wald(g);
            bWald = true;
        }

        //Santa angekreuzt
        if (isShowSanta()) {
            //ist schon wald oder Tannenbaum gezeichnet?
            if (bTannen || bWald){
                //nicht noch mal Zeichnen
                setIgnoreRepaint(false);
            }
            if (bStar){
                //sterne nicht noch mal Zeichnen
                setIgnoreRepaint(true);
            }

            //Santa game starten
            startGame();
            //santa zeichnen
            santa.paintComponent(g);
        }else {
            //falls nicht angekreuzt wurde, game beenden
            endGame();
        }

        //Autor
        g.setColor(Color.WHITE);
        g.fillRect(getWidth() - (getAutor().length() * 9) - 30, 30, getAutor().length() + 80, getAutor().length() + 20);
        g.setColor(Color.BLACK);
        g.drawString(getAutor(), getWidth() - (getAutor().length() * 8) - 30 , 50);
    }

    /**
     * wald zeichnen
     * @param g Graphics
     */
    public void wald(Graphics g){
        //Alle bäume, sind nicht grün
        tannenbaumColorGreen = false;
        //zeichne 40 Bäume
        for (int i = 0; i < 40; i++) {
            //baum position random
            int x = new Random().nextInt(getWidth() + 1);
            //baum zeichnen
            drawTannenbaum(g, x-100, -(getHeight()-100));
        }
    }

    /**
     * Um die Methode außerhalb zugreifen zu können
     */
    public void tannenbaum(Graphics g){
        //baum ist grün
        tannenbaumColorGreen = true;
        //baum zeichnen
        drawTannenbaum(g, 130, -(getHeight() - 100));
    }

    /**
     * Sterne zeichnen
     * @param g Graphics
     * @return true die sterne sind gezeichnet, falls
     *              die methode aufgerufen wird.
     */
    public boolean drawStars(Graphics g) {
        //Farbe weis
        g.setColor(Color.WHITE);
        //100 mal aufrufen
        for (int i = 0; i < 100; i++) {
            //zufalls position
            int x = (int)(Math.random() * getWidth());
            int y = (int)(Math.random() * (getHeight()/2));
            //zeichnen
            g.fillOval(x, y, 5, 5);
        }
        return true;
    }

    //lösche Leinwand
    public void clear(Graphics g){
        g.clearRect(0, 0, getWidth(), getHeight());
    }

    /**
     * Zeichne ein tannenbaum
     * @param g Graphics
     * @param x position
     * @param y position
     */
    private void drawTannenbaum(Graphics g, int x, int y){

        //Zufalls farben
        int red = (int)(Math.random() * 256);
        int green = (int)(Math.random() * 256);
        int blue = (int)(Math.random() * 256);
        //zufallszahl setzen
        g.setColor(new Color(red, green, blue));

        //um mehr möglichkeiten zubekommen,
        //Konvertieren die Graphics in ein 2D
        Graphics2D g2d = (Graphics2D) g;

        //Dreiecke
        Polygon pol, pol1, pol2;

        //Dreieck 1
        int[] xPoints = {70, 100, 130};
        int[] yPoints = {70, 10, 70};

        //Dreieck 2
        int[] xPoints2 = {70, 100, 130};
        int[] yPoints2 = {100, 30, 100};

        //Dreieck 3
        int[] xPoints3 = {70, 100, 130};
        int[] yPoints3 = {130, 50, 130};

        for (int i = 0; i < xPoints.length; i++) {
            //Dreieck 1
            xPoints[i] += x;
            yPoints[i] -= y;

            //Dreieck 2
            xPoints2[i] += x;
            yPoints2[i] -= y;

            //Dreieck 3
            xPoints3[i] += x;
            yPoints3[i] -= y;
        }

        //polygon initialisieren
        pol = new Polygon(xPoints, yPoints, xPoints.length);
        pol1 = new Polygon(xPoints2, yPoints2, xPoints2.length);
        pol2 = new Polygon(xPoints3, yPoints3, xPoints3.length);

        //ist Tannenbaum grün?
        if (tannenbaumColorGreen){
            g2d.setColor(Color.GREEN);
        }

        //zeichnen
        g2d.fillPolygon(pol);
        g2d.fillPolygon(pol1);
        g2d.fillPolygon(pol2);
    }

    //setAutor
    public void setAutor(String autor){
        this.autor = autor;
    }

    //getAutor
    public String getAutor(){
        return autor;
    }

    //isTannenbaum - ob Tannenbaum aktiviert wurde
    public boolean isTannenbaum() {
        return isTannenbaum;
    }

    //Tannenbaum - zustand
    public void setTannenbaum(boolean tannenbaum) {
        isTannenbaum = tannenbaum;
    }

    //isWald - ob wald aktiviert wurde
    public boolean isWald() {
        return isWald;
    }

    //wald - zustand
    public void setWald(boolean wald) {
        isWald = wald;
    }

    //santa ist sichtbar?
    public boolean isShowSanta() {
        return showSanta;
    }

    //santa - zustand
    public void setShowSanta(boolean showSanta) {
        this.showSanta = showSanta;
    }
}
