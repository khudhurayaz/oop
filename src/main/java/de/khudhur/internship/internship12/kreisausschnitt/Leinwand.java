package de.khudhur.internship.internship12.kreisausschnitt;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Arc2D;
import java.util.Random;

/**
 * @author Ayaz Khudhur
 * @version 1.0
 */
public class Leinwand extends JPanel {
    //Slider value
    private int sliderValue;
    //Ob es Zeichnen soll oder nicht
    private boolean shouldDraw = false;

    /**
     * Konstruktor mit Parametern
     * @param w Leinwand breite
     * @param h Leinwand höhe
     */
    public Leinwand(int w, int h){
        setMinimumSize(new Dimension(w, h));
        setPreferredSize(new Dimension(w, h));
        setSize(new Dimension(w, h));
        setBackground(Color.WHITE);
        setName("Leinwand");
        sliderValue = 3;
    }

    /**
     * @param graphics the <code>Graphics</code> object to protect
     */
    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        //wenn die variable true ist,
        //wird erst dann gezeichnet
        if (isShouldDraw()){
            Graphics2D g2 = (Graphics2D) graphics;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            //Clear Zeichenfläche
            g2.clearRect(0,0, getPreferredSize().width, getPreferredSize().height);
            g2.setColor(Color.WHITE);
            g2.fillRect(0, 0, getPreferredSize().width, getPreferredSize().height);

            //kreise Zeichnen
            initKreise(g2);
        }
    }

    /**
     * <h2>Kreise Zeichnen</h2>
     * von oben Recht wird die Schritte ausgeführt bis unten Links zum
     * vollständigen Kreis.
     * @param g2 Graphics2D hat mehr Kontrolle für Geometrische
     *           Funktionen
     */
    private void initKreise(Graphics2D g2){
        int NxN = getSliderValue() * getSliderValue();
        //Winkel
        int angle = 360 / getSliderValue();
        //Winkel befüllen
        int fill = 360 / (NxN) + 40;


        //Wenn anzahl 1 ist, zeichne einen großen Kreis
        if (NxN == 1){
            initFarbe(g2);
            g2.fill(new Arc2D.Double((getWidth() / 40) + 10, (getHeight() / 40) + 10, getWidth() - 40, getHeight() - 40, 0, 380, Arc2D.PIE));
        }

        //für NxN > 1 gilt
        if (NxN > 2){
            //Aussen-schleife
            for (int i = 0; i < NxN; i++) {
                //innen-schleife
                for (int j = 0; j < NxN; j++) {
                    //x - position
                    int x = i * (getWidth() / getSliderValue());
                    //y - position
                    int y = j * (getHeight() / getSliderValue());
                    //Kreis breite
                    int width = getWidth() / getSliderValue();
                    //Kreis höhe
                    int height = getHeight() / getSliderValue();
                    //Zufällige farbe
                    initFarbe(g2);
                    //Zeichne Kreis
                    g2.fillArc(x + 10, y + 10, width - 20, height - 20, 360 - fill * j,  angle);

                    //Winkel erhöhen
                    angle += 360 / getSliderValue();
                    //Füllung erhöhen
                    fill += 360 / (NxN) + 40;

                    //wenn füllung größer als 360 ist
                    if (fill >= 360) {
                        //wird fill auf 0 gesetzt
                        fill = 0;
                    }

                    //wenn winkel größer als 390 ist
                    if (angle >= 390){
                        //wird Winkel auf ausgang position gesetzt
                        angle = 360 / NxN + 40;
                    }
                }
            }
        }
    }

    /**
     * <h2>Zufälliges farbe</h2>
     * Die Methode sorgt für ein zufällige farbe, nach jedem Aufruf
     * wird ein zufällige farbe gewählt.
     * @param g Graphics2D hat mehr Kontrolle für Geometrische
     *          Funktionen
     */
    private void initFarbe(Graphics2D g){
        //Zufällige Farbe
        Random random = new Random();
        int r = random.nextInt(255) + 1;
        int gr = random.nextInt(255) + 1;
        int b = random.nextInt(255) + 1;
        g.setColor(new Color(r,gr,b));
    }

    /**
     * @param value wichtig für slider Kontrolle,
     *              die es User gewählt hat.
     */
    public void setSliderValue(int value){
        this.sliderValue = value;
    }

    /**
     * @return Anzahl an feldern, die User von der Slider Kontrolle
     *         ausgewählt hat
     */
    public int getSliderValue(){
        return this.sliderValue;
    }

    /**
     * @return Soll es zeichnen dann ist der Wert <code>true</code>, ansonsten
     *          <code>false</code>.
     */
    public boolean isShouldDraw() {
        return shouldDraw;
    }

    /**
     * @param shouldDraw stellt fest, ob es Zeichnen soll oder nicht
     */
    public void setShouldDraw(boolean shouldDraw) {
        this.shouldDraw = shouldDraw;
    }
}
