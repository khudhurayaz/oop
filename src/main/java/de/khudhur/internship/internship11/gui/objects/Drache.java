package de.khudhur.internship.internship11.gui.objects;

import java.awt.*;

public class Drache extends GameObjects implements GameFunk{

    //Variablen
    private int x, y;
    private int randomGeschwindigkeit, randomIntelligenz;

    /**
     * Standard Konstruktor
     */
    public Drache(){
        this.x = 0;
        this.y = 0;

        initRandom();
    }

    /**
     * Konstruktor mit Parametern
     * @param x die Koordinate von x
     * @param y die Koordinate von y
     */
    public Drache(int x, int y){
        this.x = x;
        this.y = y;

        //random initialisieren
        initRandom();
    }

    /**
     * Geschwindigkeit und intelligenz
     * werden initialisiert
     */
    private void initRandom(){
        randomGeschwindigkeit = random();
        randomIntelligenz = random();
        while (true){
            if (randomGeschwindigkeit == randomIntelligenz){
                randomIntelligenz = random();
            }else {
                break;
            }
        }
    }

    /**
     * @return getCoordinate von Drache
     */
    @Override
    public Coordinate getCoordinate() {
        return new Coordinate(x, y);
    }

    /**
     * @param x Die Koordinate x
     * @param y Die Koordinate y
     */
    @Override
    public void setCoordinate(int x, int y) {
        setX(x);
        setY(y);
    }

    /**
     * @return geschwindigkeit zurückliefern
     */
    @Override
    public int geschwindigkeit() {
        return randomGeschwindigkeit;
    }

    /**
     * @return intelligenz zurückliefern
     */
    @Override
    public int intelligenz() {
        return randomIntelligenz;
    }

    /**
     * @return staerke errechnen und zurückliefern
     */
    @Override
    public int staerke() {
        return 2 * geschwindigkeit() + intelligenz();
    }

    /**
     * @return informationen für Drachen
     */
    @Override
    public String info() {
        return "Drachenstärke: " + staerke();
    }

    /**
     * @return liefere x
     */
    @Override
    public int getX() {
        return x;
    }

    /**
     * @param x setze x neu ein
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return liefere x
     */
    @Override
    public int getY() {
        return y;
    }

    /**
     * @param y setze y neu ein
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @param g the <code>Graphics</code> object to protect
     */
    public void paintComponent(Graphics g) {
       g.setColor(Color.BLACK);
    }
}
