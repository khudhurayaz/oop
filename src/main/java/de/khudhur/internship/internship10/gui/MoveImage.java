package de.khudhur.internship.internship10.gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MoveImage {
    private BufferedImage image;
    private int x = 0, y = 0, dx = 1, width, height;

    public MoveImage(String path, int width, int height){
        this.width = width;
        this.height = height;
        try {
            image = ImageIO.read(new File(path));
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    public void repaint(JPanel panel){
        Timer timer = new Timer(10, e -> {
            x += dx;
            panel.repaint();
        });
        timer.start();
    }
    public void paintComponent(Graphics g){
        g.drawImage(image.getScaledInstance(width,height, Image.SCALE_SMOOTH), x, y, null);
    }
}
