package de.khudhur.internship.internship10.gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Santa extends JPanel{

    //image
    private BufferedImage image;
    //x, y, dx = geschwindigkeit, breite und höhe
    private int x = 0, y = 50, dx = 3, width, height;
    //timer
    private Timer timer;

    /**
     * Konstruktor
     * @param path image pfad
     * @param width image breite
     * @param height image höhe
     */
    public Santa(String path, int width, int height){
        this.width = width; //setzen
        this.height = height; // setzen
        //laden
        try {
            image = ImageIO.read(new File(path));
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    //game start
    public void game(){
        makeSantaMove();
    }

    //bild bewegen
    private void makeSantaMove(){
        timer = new Timer(500, e -> x += dx);
    }

    //timer starten, um bild bewegen zu sehen
    public void start(){
        timer.start();
    }

    //timer stoppen, um spiel zu pausieren
    public void stop(){
        timer.stop();
    }

    //spielfeld löschen
    public void clear(Graphics g){
        g.clearRect(0, 0, getWidth(), getHeight());
    }

    //bild laden
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(image.getScaledInstance(width,height, Image.SCALE_SMOOTH), x, y, this);
        clear(g);
    }

    //get x
    public int getX() {
        return x;
    }

    //set x
    public void setX(int x) {
        this.x = x;
    }

    //get y
    public int getY() {
        return y;
    }

    //set y
    public void setY(int y) {
        this.y = y;
    }

}
