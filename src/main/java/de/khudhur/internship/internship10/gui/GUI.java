package de.khudhur.internship.internship10.gui;

import javax.swing.*;
import java.awt.*;

/**
 *
 * Die GUI Klasse, hier wird die App verwaltet.
 * ALle notwendigen Parameter für eine JFrame Window sind vorhanden,
 * durch GUI kann man ganz einfach ein Fenster erstellen.
 *
 * @version 1.0
 * @author Ayaz Khudhur
 */

public class GUI {

    private JFrame frame;

    //Fenstertitel und Fenstericon
    private String title, icon;

    //Fensterbreite, Fensterhöhe und Fenster automatisch schlissen
    private int width, height, exit_on_close;

    //Fenster Dehn
    private Boolean resizable;

    //Sichtbarkeit der Fenster
    private Boolean visible;

    //Fenster wird auf die Komponenten angepasst
    private boolean pack;

    //JFrame color
    private Color color;

    //LayoutManager wird eingesetzt
    private LayoutManager manager;

    //ob mittig sein soll
    private Component locationRelativeTo;

    private Fenster fenster;

    //path
    public static final String PATH = "src/main/java/de/khudhur/internship/internship10/assets/";

    /**
     * Leeren GUI Konstruktor
     */
    public GUI(){
        //default value
        defaultValue();
    }


    /**
     * Konstruktor mit Titel
     * @param title Fenstertitel, restlichen Werte sind default
     */
    public GUI(String title){
        setTitle(title);

        defaultValue();
    }

    /**
     * Konstruktor mit ein Breite und eine Höhe.
     * @param width Fensterbreite
     * @param height Fensterhöhe
     */
    public GUI(int width, int height){
        setWidth(width);
        setHeight(height);

        defaultValue();
    }

    /**
     * Konstruktor mit 3 Attributen
     * @param title Fenstertitel setzen
     * @param width Fensterbreite setzen
     * @param height Fensterhöhe setzen
     */
    public GUI(String title, int width, int height){
        //Attributen setzen
        setTitle(title);
        setWidth(width);
        setHeight(height);

        //Restlichen attributen auf Default setzen
        defaultValue();
    }

    public GUI(String title, int width, int height, int exit_on_close, boolean resizable, boolean visible, LayoutManager manager, Component locationRelativeTo){
        setTitle(title);
        setWidth(width);
        setHeight(height);
        setExit_on_close(exit_on_close);
        setResizable(resizable);
        setVisible(visible);
        setManager(manager);
        setLocationRelativeTo(locationRelativeTo);

        defaultValue();
    }

    /**
     * Konstruktor mit Parametern
     * @param title Titel für die Java Swing Window
     * @param icon Icon für die Java Swing Window
     * @param width Breite für die Java Swing Window
     * @param height Höhe für die Java Swing Window
     * @param exit_on_close Automatisch schlissen
     * @param resizable Ob Window dehnbar ist
     * @param visible ob Fenster sichtbar sein soll
     * @param color JFrame Hintergrunds farbe
     * @param manager ein Layout setzen
     * @param locationRelativeTo ob Fenster mittig sein soll
     */
    public GUI(String title, String icon, int width, int height, int exit_on_close, boolean resizable, boolean visible, Color color, LayoutManager manager, Component locationRelativeTo){
        setTitle(title);
        setIcon(icon);
        setWidth(width);
        setHeight(height);
        setExit_on_close(exit_on_close);
        setResizable(resizable);
        setVisible(visible);
        setColor(color);
        setManager(manager);
        setLocationRelativeTo(locationRelativeTo);
    }

    /**
     * createWindow erstellen ein GUI mit dem angegebenes Daten,
     * die Parametern können jederzeit geändert werden.
     */
    public void createJFrame(){

        //Fenster schlissen
        if (getExit_on_close() != 0)
            frame.setDefaultCloseOperation(getExit_on_close());

        //layout setzen
        if (getManager() != null)
            frame.setLayout(getManager());

        //fenster größe setzen
        if (getWidth() != 0 && getHeight() != 0)
            frame.setSize(new Dimension(getWidth(), getHeight()));

        //an die Komponenten passen
        if (isPack())
            frame.pack();

        //set title
        frame.setTitle(getTitle());

        //set icon
        ImageIcon icon = new ImageIcon(getIcon());
        Image image = icon.getImage();
        frame.setIconImage(image);
        //wie der Fenster sein soll
        frame.setLocationRelativeTo(getLocationRelativeTo());

        //Dehnbarkeit festlegen
        frame.setResizable(isResizable());

        //Background color
        frame.setBackground(getColor());

        //sichtbarkeit festlegen
        frame.setVisible(isVisible());
    }

    /**
     * Die methode initialisiert die Werte die noch nicht,
     * initialisiert sind. Somit wird ein funktionsfähiges Window
     * erstellen, um Probleme zu vermeiden.
     *
     * Deswegen werden auch nur die Werte die null oder 0
     * beinhalten.
     */
    public void defaultValue(){
        frame = new JFrame();

        //default value
        if (title == null || title.length() == 0)
            setTitle("Created by Ayaz Khudhur");
        if (icon == null || icon.length() == 0)
            setIcon(PATH + "icon.png");
        if (width == 0)
            setWidth(720);
        if (height == 0)
            setHeight(400);
        if (resizable == null)
            setResizable(Boolean.TRUE);
        if (visible == null)
            setVisible(Boolean.TRUE);
        if (color == null)
            setColor(null);
        if (manager == null)
            setManager(new BorderLayout());
        if (exit_on_close == 0)
            setExit_on_close(JFrame.EXIT_ON_CLOSE);

    }

    public Fenster getFenster(){
        return fenster;
    }

    public void setFenster(Fenster fenster){
        this.fenster = fenster;
    }

    /**
     * @return Fenstertitel wird zurückgeworfen
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title Fenstertitel wird gesetzt
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return Fenstericon wird zurückgeworfen
     */
    public String getIcon() {
        return icon;
    }

    /**
     * @param icon Fenstericon wird gesetzt
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * @return Fensterbreite wird zurückgeworfen
     */
    public int getWidth() {
        return width;
    }

    /**
     * @param width Fensterbreite wird gesetzt
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * @return Fensterhöhe wird zurückgeworfen
     */
    public int getHeight() {
        return height;
    }

    /**
     * @param height Fensterhöhe wird gesetzt
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * @return ob sich automatisch schlissen kann
     */
    public int getExit_on_close(){
        return exit_on_close;
    }

    /**
     * @param exit_on_close soll sich automatisch schliessen oder nicht
     */
    public void setExit_on_close(int exit_on_close){
        this.exit_on_close = exit_on_close;
    }

    /**
     * @return ist Fenster dehnbar?
     */
    public boolean isResizable() {
        return resizable;
    }

    /**
     * @param resizable mach Fenster dehnbar
     */
    public void setResizable(boolean resizable) {
        this.resizable = resizable;
    }

    /**
     * @return ist Window sichtbar
     */
    public boolean isVisible() {
        return visible;
    }

    /**
     * @param visible mach Window sichtbar
     */
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    /**
     * @return Hintergrundfarbe wird zurückgeworfen
     */
    public Color getColor(){
        return color;
    }

    /**
     * @param color Hintergrundfarbe wird festgelegt
     */
    public void setColor(Color color){
        this.color = color;
    }

    /**
     * @return ist an die Komponenten angepasst
     */
    public boolean isPack(){
        return pack;
    }

    /**
     * @param pack an die Komponenten anpassen
     */
    public void setPack(boolean pack) {
        this.pack = pack;
    }

    /**
     * @return Welche LayoutManager verwendet wird
     */
    public LayoutManager getManager() {
        return manager;
    }

    /**
     * @param manager Layout
     */
    public void setManager(LayoutManager manager) {
        this.manager = manager;
    }

    /**
     * @return wie der aktuelle Standort ist
     */
    public Component getLocationRelativeTo(){
        return locationRelativeTo;
    }

    /**
     * @param locationRelativeTo Component für Window,
     *                           hauptsächlich wird für Fenster zentrieren verwendet.
     */
    public void setLocationRelativeTo(Component locationRelativeTo){
        this.locationRelativeTo = locationRelativeTo;
    }

    /**
     * @return JFrame wird zurückgeworfen
     */
    public JFrame getFrame(){
        return frame;
    }

    /**
     * @param frame JFrame wird festgelegt
     */
    public void setFrame(JFrame frame){
        this.frame = frame;
    }

    @Override
    public String toString() {
        return "GUI{" +
                "title='" + title + '\'' +
                ", icon='" + icon + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", exit_on_close=" + exit_on_close +
                ", resizable=" + resizable +
                ", visible=" + visible +
                ", color=" + color +
                ", pack=" + pack +
                ", manager=" + manager +
                ", locationRelativeTo=" + locationRelativeTo +
                ", frame=" + frame +
                '}';
    }
}
