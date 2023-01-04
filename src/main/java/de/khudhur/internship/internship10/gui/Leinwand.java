package de.khudhur.internship.internship10.gui;


import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * @version 1.0
 * @author Ayaz Khudhur
 */

public class Leinwand extends JPanel implements Runnable{

    private String autor;
    private int width, height;
    private boolean showSanta, isTannenbaum, isWald, tannenbaumColorGreen = false;

    private int x = 0, y = 0, dx = 1;
    private MoveImage moveImage;
    private Thread thread;

    public Leinwand(int width, int height){
        this.width = width;
        this.height = height;
        setLayout(new FlowLayout());
        setSize(width, height);
        setBackground(Color.GRAY);

        thread = new Thread("Leinwand");
        thread.start();
    }

    private void startSanta(){
        if (isShowSanta()){
            Timer timer = new Timer(10, e -> {
                x += dx;
                repaint();
            });
            timer.start();
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        //setze hintergrund in Schwarz
        setBackground(Color.black);

        //zeichne Sterne
        drawStars(g);

        //tannenbaum
        if (isTannenbaum())
            tannenbaum(g);

        //wald
        if (isWald())
            wald(g);

        //Santa
        if (isShowSanta()) {
            santa(g);
        }

        //Autor
        g.setColor(Color.WHITE);
        g.fillRect(getWidth() - (getAutor().length() * 9) - 30, 30, getAutor().length() + 80, getAutor().length() + 20);
        g.setColor(Color.BLACK);
        g.drawString(getAutor(), getWidth() - (getAutor().length() * 8) - 30 , 50);
    }

    private void santa(Graphics g){
        moveImage = new MoveImage("src/main/java/de/khudhur/internship/internship10/assets/santa.png", 64, 64);
        moveImage.paintComponent(g);
    }

    public void wald(Graphics g){
        tannenbaumColorGreen = false;
        for (int i = 0; i < 40; i++) {
            int x = new Random().nextInt(getWidth() + 1);
            drawTannenbaum(g, x-100, -(getHeight()-100));
        }
    }

    /**
     * Um die Methode außerhalb zugreifen zu können
     */
    public void tannenbaum(Graphics g){
        Random random = new Random();
        int x = random.nextInt(getWidth() + 1);
        tannenbaumColorGreen = true;
        drawTannenbaum(g, x-50, -(getHeight() - 100));
    }

    public void drawStars(Graphics g) {
        g.setColor(Color.WHITE);
        for (int i = 0; i < 100; i++) {
            int x = (int)(Math.random() * getWidth());
            int y = (int)(Math.random() * (getHeight()/2));
            g.fillOval(x, y, 5, 5);
        }
    }

    public void clear(Graphics g){
        g.clearRect(0, 0, getWidth(), getHeight());
    }

    private void drawTannenbaum(Graphics g, int x, int y){

        //Zufalls farben
        int red = (int)(Math.random() * 256);
        int green = (int)(Math.random() * 256);
        int blue = (int)(Math.random() * 256);
        //zufallszahl setzen
        g.setColor(new Color(red, green, blue));

        //um mehr möglichkeiten zubekommen,
        //Konvertieren die Graphics in ein 2D
        Graphics2D g2d = (Graphics2D) g;

        //Dreiecke
        Polygon pol, pol1, pol2;

        //Dreieck 1
        int[] xPoints = {70, 100, 130};
        int[] yPoints = {70, 10, 70};

        //Dreieck 2
        int[] xPoints2 = {70, 100, 130};
        int[] yPoints2 = {100, 30, 100};

        //Dreieck 3
        int[] xPoints3 = {70, 100, 130};
        int[] yPoints3 = {130, 50, 130};

        for (int i = 0; i < xPoints.length; i++) {
            //Dreieck 1
            xPoints[i] += x;
            yPoints[i] -= y;

            //Dreieck 2
            xPoints2[i] += x;
            yPoints2[i] -= y;

            //Dreieck 3
            xPoints3[i] += x;
            yPoints3[i] -= y;
        }

        pol = new Polygon(xPoints, yPoints, xPoints.length);
        pol1 = new Polygon(xPoints2, yPoints2, xPoints2.length);
        pol2 = new Polygon(xPoints3, yPoints3, xPoints3.length);

        if (tannenbaumColorGreen){
            g2d.setColor(Color.GREEN);
        }
        g2d.fillPolygon(pol);
        g2d.fillPolygon(pol1);
        g2d.fillPolygon(pol2);
    }

    @Override
    public void run() {
        moveImage.repaint(this);
        System.out.println("start");
        repaint();
        try {
            Thread.sleep(100);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void setAutor(String autor){
        this.autor = autor;
    }

    public String getAutor(){
        return autor;
    }

    public boolean isTannenbaum() {
        return isTannenbaum;
    }

    public void setTannenbaum(boolean tannenbaum) {
        isTannenbaum = tannenbaum;
    }

    public boolean isWald() {
        return isWald;
    }

    public void setWald(boolean wald) {
        isWald = wald;
    }

    public boolean isShowSanta() {
        return showSanta;
    }

    public void setShowSanta(boolean showSanta) {
        this.showSanta = showSanta;
    }
}
