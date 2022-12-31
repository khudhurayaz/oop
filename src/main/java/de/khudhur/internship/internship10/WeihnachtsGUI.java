package de.khudhur.internship.internship10;

import de.khudhur.internship.internship10.gui.GUI;
import de.khudhur.internship.internship10.gui.Leinwand;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class WeihnachtsGUI {

    private static BorderLayout borderLayout = new BorderLayout();
    private static Leinwand leinwand;

    private static GUI createGUI;

    public static void createJFrame(String title){
        //Frame erstellen und initialisieren
        createGUI = new GUI(title, 890, 800, JFrame.EXIT_ON_CLOSE, true, true, borderLayout, null);
        System.out.println(createGUI.toString());
        createGUI.setIcon(GUI.PATH + "santa.png");
        createGUI.setColor(Color.gray);
        createGUI.createJFrame();

        //Leinwand
        leinwand = new Leinwand();
        leinwand.setBackground(Color.black);
        leinwand.setSize(new Dimension(800, 600));
        createGUI.getFrame().add(leinwand, BorderLayout.WEST);

        //Parameter
        JRadioButton jrbTannenbaum = new JRadioButton("Tannenbaum");
        JRadioButton jrbWald = new JRadioButton("Wald");
        JCheckBox jcbSanta = new JCheckBox("Snata");

        //RadioButton in einer Group tun
        ButtonGroup groupParameter = new ButtonGroup();
        groupParameter.add(jrbTannenbaum);
        groupParameter.add(jrbWald);

        JPanel panelParameter = new JPanel(new GridLayout(3,1));
        panelParameter.setBorder(BorderFactory.createTitledBorder("Parameter:"));
        panelParameter.add(jrbTannenbaum);
        panelParameter.add(jrbWald);
        panelParameter.add(jcbSanta);
        createGUI.getFrame().add(panelParameter, BorderLayout.WEST);

        JLabel jlblStatus = new JLabel("Status");
        jlblStatus.setForeground(Color.white);
        jlblStatus.setSize(new Dimension(createGUI.getWidth(), 25));
        createGUI.getFrame().add(jlblStatus, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createJFrame("WeihnachtsGUI"));
    }
}
