package de.khudhur.internship.internship11.gui.landscape;

import de.khudhur.internship.internship11.gui.objects.Coordinate;

import java.awt.*;

public class Water extends Coordinate {
    public Water(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public Color getBackground(){
        return new Color(0, 0, 254, 255);
    }
}
