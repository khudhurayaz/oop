package de.khudhur.internship.internship11.gui.objects;

import java.awt.*;

public interface GameFunk {

    /**
     * @return @see {@link Coordinate}
     */
    Coordinate getCoordinate();

    /**
     * @param x Koordinate x
     * @param y Koordinate y
     */
    void setCoordinate(int x, int y);

    /**
     * @return geschwindigkeit wird zurückgeliefert
     */
    int geschwindigkeit();

    /**
     * @return intelligenz wird zurückgeliefert
     */
    int intelligenz();

    /**
     * @return starke wird zurückgeliefert
     */
    int staerke();

    /**
     * @return info zu jeweiligen Klassen
     */
    String info();

    void paintComponent(Graphics g);
}
