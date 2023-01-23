package de.khudhur.internship.internship11.gui.landscape;

import de.khudhur.internship.internship11.gui.objects.Coordinate;

import java.awt.*;

public class Lava extends Coordinate {

    public Lava(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public Color getBackground(){
        return new Color(253, 0, 1, 255);
    }
}
