package de.khudhur.internship.internship11.gui.objects;

import java.awt.*;

public class Ritter extends GameObjects implements GameFunk{

    private int x, y;
    private int randomGeschwindigkeit, randomIntelligenz;

    /**
     * Default Konstruktor
     */
    public Ritter(){
        x = 0;
        y = 0;

        initRandom();
    }

    /**
     * @param x Koordinate x
     * @param y Koordinate y
     */
    public Ritter(int x, int y) {
        this.x = x;
        this.y = y;

        initRandom();
    }

    /**
     * Random geschwindigkeit und intelligenz
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
     * @return informationen der Klasse Ritter
     */
    @Override
    public String info(){
        return "Spielstärke: " + staerke();
    }

    /**
     * @return Lieferte @see {@link Coordinate}
     */
    @Override
    public Coordinate getCoordinate() {
        return new Coordinate(x, y);
    }

    /**
     * @param x Koordinate x
     * @param y Koordinate y
     */
    @Override
    public void setCoordinate(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * @return geschwindigkeit wird zurückgeliefert
     */
    @Override
    public int geschwindigkeit() {
        return randomGeschwindigkeit;
    }

    /**
     * @return intelligenz wird zurückgeliefert
     */
    @Override
    public int intelligenz() {
        return randomIntelligenz;
    }

    /**
     * @return staerke wird zurückgeliefert
     */
    @Override
    public int staerke() {
        return geschwindigkeit() + intelligenz() * 2;
    }

    /**
     * @param g the <code>Graphics</code> object to protect
     */
    public void paintComponent(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0,0, 50, 50);
        g.setColor(Color.WHITE);
        g.setFont(loadFonts(FontEnum.MONATHA, 43f));
        g.drawString("R", getX() + 10, getY() + 40);
    }

    /**
     * @return liefert x
     */
    @Override
    public int getX() {
        return x;
    }

    /**
     * @param x neue Koordinate x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return liefert y
     */
    @Override
    public int getY() {
        return y;
    }

    /**
     * @param y neue Koordinate y
     */
    public void setY(int y) {
        this.y = y;
    }
}
