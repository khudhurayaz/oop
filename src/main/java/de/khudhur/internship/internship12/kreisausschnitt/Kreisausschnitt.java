package de.khudhur.internship.internship12.kreisausschnitt;

import javax.swing.*;
import java.awt.*;
import java.util.Hashtable;

/**
 * Aufgabe 12, GUI für NxN Kreise.
 * Je nach ausgewähltem anzahl an Kreisen bzw.
 * bis zum vollständigem Kreis, wird auf der Leinwand,
 * die nötigen schritte gezeichnet.
 * @author Ayaz Khudhur
 * @version 1.0
 */
public class Kreisausschnitt extends JFrame{
    //Panel größe
    private final Dimension dimension = new Dimension(800, 700);

    /**
     * GUI für Kreisauschnitt
     * @param title Fenstertitel wird als String erwartet
     */
    public Kreisausschnitt(String title){
        //panel initialisieren
        panel();

        //Fenster initialisieren
        pack();
        //Fenstergröße wird festgelegt
        setMaximumSize(dimension);
        setPreferredSize(dimension);
        setSize(dimension);
        setMinimumSize(dimension);
        //Fenstertitel wird festgelegt
        setTitle(title);
        //Fenster mittig Zentrieren
        setLocationRelativeTo(null);
        //Normal schlissen, minimieren und maximieren
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //nicht vergrößbar
        setResizable(true);
        //BorderLayout wird verwendet
        setLayout(new BorderLayout());
    }

    /**
     * Das Panel wird initialisiert
     */
    private void panel(){
        //Zeichen Panel
        Leinwand zeichenPanel = new Leinwand(dimension.width - 100, dimension.height);

        //Control panel
        JPanel controlPanel = new JPanel(new BorderLayout());
        controlPanel.setPreferredSize(new Dimension(100, getHeight()));
        controlPanel.setMaximumSize(new Dimension(100, getHeight()));
        controlPanel.setMinimumSize(new Dimension(100, getHeight()));
        controlPanel.setSize(new Dimension(100, getHeight()));
        controlPanel.setBackground(Color.GRAY);

        //Kinder

        //Slider
        JSlider slider = new JSlider(JSlider.VERTICAL, 1, 10, 3);

        //Teilmarkierungen werden festgelegt
        slider.setMinorTickSpacing(1);
        slider.setMajorTickSpacing(10);

        //Zeichnen der Labels wird aktiviert
        slider.setPaintLabels(true);
        //Zeichnen der markierungen wird aktiviert
        slider.setPaintTicks(true);

        //Hinzufügen das eigene Label.
        Hashtable<Integer, JLabel> label = new Hashtable<>();
        label.put(1, new JLabel("1x1"));
        label.put(5, new JLabel("5x5"));
        label.put(10, new JLabel("10x10"));
        //Label setzen
        slider.setLabelTable(label);

        //Größe setzen
        slider.setPreferredSize(new Dimension(controlPanel.getWidth(), controlPanel.getHeight() - 65));
        slider.setMaximumSize(new Dimension(controlPanel.getWidth(), controlPanel.getHeight() - 65));
        slider.setMinimumSize(new Dimension(controlPanel.getWidth(), controlPanel.getHeight() - 65));

        //Button initialisieren
        JButton btnStart = new JButton("Start");
        btnStart.setPreferredSize(new Dimension(100, 35));
        btnStart.setMinimumSize(new Dimension(100, 35));
        btnStart.addActionListener(e ->{
            zeichenPanel.setShouldDraw(true);
            zeichenPanel.setSliderValue(slider.getValue());
            zeichenPanel.repaint();
        });

        //add
        controlPanel.add(slider, BorderLayout.CENTER);
        controlPanel.add(btnStart, BorderLayout.SOUTH);

        //hinzufügen
        add(zeichenPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.EAST);
    }

    public static void main(String[] args) {
        Kreisausschnitt kreisausschnitt = new Kreisausschnitt("Kreisauschnitt");
        kreisausschnitt.setVisible(true);
    }
}
