package de.khudhur.internship.extra.objects.landscape;

import de.khudhur.internship.extra.objects.Coordinate;

import java.awt.*;

public class Water extends Coordinate {
    public Water(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public Color getBackground(){
        return new Color(0, 0, 254, 255);
    }
}
