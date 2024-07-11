package de.khudhur.internship.extra.objects.landscape;

import de.khudhur.internship.extra.objects.Coordinate;
import java.awt.*;

public class Lava extends Coordinate {

    public Lava(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public Color getBackground(){
        return new Color(253, 0, 1, 255);
    }
}
