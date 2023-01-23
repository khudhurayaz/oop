package de.khudhur.internship.internship10;

import de.khudhur.internship.internship10.gui.Leinwand;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class WeihnachtsGUI {

    private JPanel panel; //main panel
    private JRadioButton jrbTannenbaum, jrbWald; //auswahl
    private JCheckBox jcbSanta; // zusatzbox
    private JTextField tfAutor = new JTextField(); //Autor feld
    private String strStatus = "-"; //statusleiste
    private JLabel status = new JLabel(strStatus); //Status Ausgabe

    /**
     * Konstruktor ruft createFrame mit title auf
     */
    public WeihnachtsGUI(){
        //neues frame erstellen
        createFrame("Weihnachts GUI");
    }

    /**
     * CreateFrame
     * hier erstelle ich mein WeihnachtsGUI
     * @param title Fenster Titel wird erwartet
     */
    private void createFrame(String title){
        //frame
        JFrame frame = new JFrame(title);
        //main panel initialisieren
        panel = new JPanel();
        //main panel layout zuweisen
        panel.setLayout(new BorderLayout());
        //toolTipText zeigt an, welches layout in benutzung ist.
        panel.setToolTipText("using BorderLayout");

        //---------------------------------------------------
        //Rechtes Panel
        JPanel panel1 = new JPanel();
        //Margin von jeder Seite 10px Abstand nehmen
        panel1.setBorder(new EmptyBorder(10,10,10,10));
        //panel größe festlegen
        panel1.setSize(new Dimension(200, 650));
        //layout zuweisen
        panel1.setLayout(new BorderLayout());
        //toolTipText zuweisen
        panel1.setToolTipText("Using BorderLayout");

        //Autor
        JLabel autor = new JLabel("Autor");
        //textfield für autor, um irgendein Text auf Leinwand auszugeben.
        tfAutor = new JTextField("Ayaz Khudhur");
        //größe setzen
        tfAutor.setPreferredSize(new Dimension(100, 30));
        //Panel für autor erstellen
        JPanel autorPanel = new JPanel();
        //parametern hinzufügen
        autorPanel.add(autor);
        autorPanel.add(tfAutor);
        //toolTipText zuweisen
        autorPanel.setToolTipText("Using nothing");
        //im rechten Panel hinzufügen
        panel1.add(autorPanel, BorderLayout.NORTH);

        //radiobutton
        jrbTannenbaum = new JRadioButton("Tannenbaum");
        jrbWald = new JRadioButton("Wald");
        //checkbox
        jcbSanta = new JCheckBox("Santa");
        //anfang ist nicht benutzbar
        jcbSanta.setEnabled(false);

        //Gruppieren
        ButtonGroup group = new ButtonGroup();
        group.add(jrbTannenbaum);
        group.add(jrbWald);

        //ein Rahmen über die RadioButton
        JPanel parameter = new JPanel();
        parameter.setLayout(new BoxLayout(parameter, BoxLayout.PAGE_AXIS));
        parameter.setToolTipText("Using GridLayout");
        parameter.setBorder(BorderFactory.createTitledBorder("Parameter:"));
        parameter.add(jrbTannenbaum);
        parameter.add(jrbWald);
        parameter.add(jcbSanta);
        panel1.add(parameter, BorderLayout.CENTER);


        //ButtonStart
        //start button
        JButton start = new JButton("Start");
        panel1.add(start, BorderLayout.SOUTH);

        //add to main panel
        panel.add(panel1, BorderLayout.EAST);
        panel.revalidate();

        //---------------------------------------------------
        //Leinwand
        Leinwand leinwand = new Leinwand(700, 650);
        leinwand.setAutor(tfAutor.getText());

        //ActionListener, wenn start gedrückt wurde
        start.addActionListener(e -> SwingUtilities.invokeLater(() -> {

            //wenn eins ausgewählt wurde
            if (jrbTannenbaum.isSelected() || jrbWald.isSelected()){
                jcbSanta.setEnabled(true); //checkbox aktivieren
                leinwand.setAutor(tfAutor.getText()); //autor übergeben
                leinwand.setBackground(Color.black);//background auf Schwarz setzen

                //wurde es Tannenbaum gewählt
                if (jrbTannenbaum.isSelected()) {
                    //clear den leinwand
                    leinwand.clear(panel.getGraphics());
                    //wald ist unsichtbar
                    leinwand.setWald(false);
                    //tannenbaum ist sichtbar
                    leinwand.setTannenbaum(true);
                    //tannenbaum Zeichnen
                    leinwand.tannenbaum(panel.getGraphics());
                }

                //wurde es wald gewählt
                if (jrbWald.isSelected()) {
                    //clear den leinwand
                    leinwand.clear(panel.getGraphics());
                    //tannenbaum ist unsichtbar
                    leinwand.setTannenbaum(false);
                    //wald ist sichtbar
                    leinwand.setWald(true);
                    //wald Zeichnen
                    leinwand.wald(panel.getGraphics());
                }

                //alles dem main panel übergeben
                //borderlayout mittig setzen
                panel.add(leinwand, BorderLayout.CENTER);
                //neu Zeichnen
                panel.repaint();
            }else {
                //wenn kein option gewählt wird,
                //gib ein entsprechendes ErrorIcons in statusleiste
                //aus.
                status.setText("Wähle ein Parameter!");
            }
        }));

        //ActionListener für Tannenbaum
        jrbTannenbaum.addActionListener(e -> {
            //wurde der Tannenbaum gewählt
            if (jrbTannenbaum.isSelected()){
                //santa ist nicht ausgewählt,
                //wird nur Tannenbaum in der Statusleiste sichtbar
                if (!jcbSanta.isSelected()) {
                    status.setText("Tannenbaum");
                }
                //sind beides ausgewählt,
                //wird in der Statusleiste diesen code sichtbar
                if (jcbSanta.isSelected() && jrbTannenbaum.isSelected()){
                    status.setText("Tannenbaum + Santa");
                }
            }
        });

        //ActionListener für Wald
        jrbWald.addActionListener(e -> {
            //wurde der Wald gewählt
            if (jrbWald.isSelected()) {
                //santa ist nicht ausgewählt,
                //wird nur Wald in der Statusleiste sichtbar
                if (!jcbSanta.isSelected()) {
                    status.setText("Wald");
                }
                //sind beides ausgewählt,
                //wird in der Statusleiste diesen code sichtbar
                if (jcbSanta.isSelected() && jrbWald.isSelected()){
                    status.setText("Wald + Santa");
                }
            }
        });

        //ActionListener für Wald
        jcbSanta.addActionListener(e -> {
            //wurde Tannenbaum gewählt
            if (jrbTannenbaum.isSelected()) {
                //ist santa box angekreuzt
                if (jcbSanta.isSelected()) {
                    //gib aus
                    status.setText("Tannenbaum + Santa");
                    //setze showSanta auf true
                    leinwand.setShowSanta(true);
                    //neu Zeichnen
                    panel.repaint();
                }else {
                    //Ansonsten ist nur der Tannenbaum
                    //sichtbar
                    status.setText("Tannenbaum");
                    //showSanta auf nicht sichtbar setzen
                    leinwand.setShowSanta(false);
                    //neu Zeichnen
                    panel.repaint();
                }
            }
            //wurde wald gewählt
            if (jrbWald.isSelected()) {
                //ist santa box angekreuzt
                if (jcbSanta.isSelected()) {
                    //gib aus
                    status.setText("Wald + Santa");
                    //setze showSanta auf true
                    leinwand.setShowSanta(true);
                    //neu Zeichnen
                    panel.repaint();
                }else {
                    //Ansonsten ist nur der Wald
                    //sichtbar
                    status.setText("Wald");
                    //showSanta auf nicht sichtbar setzen
                    leinwand.setShowSanta(false);
                    //neu Zeichnen
                    panel.repaint();
                }
            }
        });

        //statusleiste
        JPanel statusPanel = new JPanel(new FlowLayout());
        statusPanel.setSize(new Dimension(700, 50));
        status.setText(strStatus);
        status.setLayout(statusPanel.getLayout());
        statusPanel.add(status, FlowLayout.LEFT);
        panel.add(statusPanel, BorderLayout.SOUTH);

        //set icon
        ImageIcon icon = new ImageIcon("src/main/java/de/khudhur/internship/internship10/assets/santa.png");
        Image image = icon.getImage();
        frame.setIconImage(image);

        //frame konfiguration
        frame.add(panel); //main panel
        frame.pack(); // komponenten an Layout anpassen
        frame.setResizable(true); //dehnbar
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //code 3, sauberes schlissen
        frame.setSize(new Dimension(900, 700)); // größe
        frame.setVisible(true); //anzeigen
    }

    public static void main(String[] args) {
        //GUI aufrufen
        SwingUtilities.invokeLater(WeihnachtsGUI::new);
    }

}
