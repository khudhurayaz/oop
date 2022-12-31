package de.khudhur.internship.internship10.gui;

import javax.swing.*;
import java.awt.*;

public class Fenster extends JPanel {
    private Color color;
    private int width, height;
    private LayoutManager manager;

    public Fenster(){
        if (color == null)
            setColor(Color.black);
        if (manager == null)
            setManager(new BorderLayout());
        if (width == 0)
            setWidth(1000);
        if (height == 0)
            setHeight(700);
    }

    public Fenster(int width, int height){
        setWidth(width);
        setHeight(height);
    }

    public Fenster(int width, int height, Color color){
        setWidth(width);
        setHeight(height);
        setColor(color);
    }

    public Fenster(LayoutManager manager, int width, int height, Color color){
        setManager(manager);
        setWidth(width);
        setHeight(height);
        setColor(color);
    }

    public void createWindow(){
        setBackground(getColor());
        setLayout(getManager());
        setPreferredSize(new Dimension(getWidth(), getHeight()));
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public LayoutManager getManager() {
        return manager;
    }

    public void setManager(LayoutManager manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "Fenster{" +
                "color=" + color +
                ", width=" + width +
                ", height=" + height +
                ", manager=" + manager +
                '}';
    }
}
