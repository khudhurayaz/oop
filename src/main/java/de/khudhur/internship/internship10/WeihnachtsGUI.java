package de.khudhur.internship.internship10;

import de.khudhur.internship.internship10.gui.Leinwand;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WeihnachtsGUI implements Runnable{
    private JFrame frame;
    private JPanel panel;
    private JRadioButton jrbTannenbaum, jrbWald;
    private JCheckBox jcbSanta;
    private JButton start = new JButton();
    private JTextField tfAutor = new JTextField();
    private String strStatus = "-";
    private JLabel status = new JLabel(strStatus);

    private Thread thread;

    public WeihnachtsGUI(){
        createFrame("Weihnachts GUI");
        thread = new Thread("WeihnachtsGUI");
        thread.start();
        System.out.println("Thread Name: " + thread.getName());
    }


    private void createFrame(String title){
        frame = new JFrame(title);
        BorderLayout borderLayout = new BorderLayout();
        panel = new JPanel();
        panel.setLayout(borderLayout);

        //---------------------------------------------------
        //Rechte Panel
        JPanel panel1 = new JPanel();
        panel1.setBorder(new EmptyBorder(10,10,10,10));
        panel1.setSize(new Dimension(200, 650));
        panel1.setLayout(new BorderLayout());
        panel1.setToolTipText("Using BorderLayout");

        //Autor
        JLabel autor = new JLabel("Autor");
        tfAutor = new JTextField("Enter a name");
        tfAutor.setPreferredSize(new Dimension(100, 30));
        JPanel autorPanel = new JPanel();
        autorPanel.add(autor);
        autorPanel.add(tfAutor);
        autorPanel.setToolTipText("Using nothing");
        panel1.add(autorPanel, BorderLayout.NORTH);

        //radiobutton
        jrbTannenbaum = new JRadioButton("Tannenbaum");
        jrbWald = new JRadioButton("Wald");
        jcbSanta = new JCheckBox("Santa");

        //Gruppieren
        ButtonGroup group = new ButtonGroup();
        group.add(jrbTannenbaum);
        group.add(jrbWald);

        //ein Rahmen über die RadioButton
        JPanel parameter = new JPanel(new GridLayout(3,1));
        parameter.setPreferredSize(new Dimension(200, 100));
        parameter.setToolTipText("Using GridLayout");
        parameter.setBorder(BorderFactory.createTitledBorder("Parameter:"));
        parameter.add(jrbTannenbaum);
        parameter.add(jrbWald);
        parameter.add(jcbSanta);
        panel1.add(parameter);

        panel1.revalidate();
        //ButtonStart
        start = new JButton("Start");
        panel1.add(start, BorderLayout.SOUTH);

        //add to main panel
        panel.add(panel1, BorderLayout.EAST);
        panel.revalidate();

        //---------------------------------------------------
        //Leinwand
        Leinwand leinwand = new Leinwand(700, 650);
        leinwand.setAutor(tfAutor.getText());
        //panel.add(leinwand, BorderLayout.CENTER);
        start.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        if (jrbTannenbaum.isSelected() || jrbWald.isSelected()){
                            leinwand.setAutor(tfAutor.getText());
                            leinwand.setBackground(Color.black);

                            if (jrbTannenbaum.isSelected()) {
                                leinwand.clear(panel.getGraphics());
                                leinwand.setWald(false);
                                leinwand.setTannenbaum(true);
                                leinwand.tannenbaum(panel.getGraphics());
                            }

                            if (jrbWald.isSelected()) {
                                leinwand.clear(panel.getGraphics());
                                leinwand.setTannenbaum(false);
                                leinwand.setWald(true);
                                leinwand.wald(panel.getGraphics());
                            }

                            panel.add(leinwand, BorderLayout.CENTER);
                            panel.revalidate();
                            panel.repaint();
                        }else {
                            status.setText("Wähle ein Parameter!");
                        }
                    }
                });
            }
        });

        //ActionListener
        jrbTannenbaum.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jrbTannenbaum.isSelected()){
                    if (!jcbSanta.isSelected()) {
                        status.setText("Tannenbaum");
                    }
                    if (jcbSanta.isSelected() && jrbTannenbaum.isSelected()){
                        status.setText("Tannenbaum + Santa");
                    }
                }
            }
        });
        jrbWald.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jrbWald.isSelected()) {
                    if (!jcbSanta.isSelected()) {
                        status.setText("Wald");
                    }
                    if (jcbSanta.isSelected() && jrbWald.isSelected()){
                        status.setText("Wald + Santa");
                    }
                }
            }
        });
        jcbSanta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jrbTannenbaum.isSelected()) {
                    if (jcbSanta.isSelected()) {
                        status.setText("Tannenbaum + Santa");
                        leinwand.setShowSanta(true);
                        panel.revalidate();
                        panel.repaint();
                    }else {
                        status.setText("Tannenbaum");
                        leinwand.setShowSanta(false);
                    }
                }
                if (jrbWald.isSelected()) {
                    if (jcbSanta.isSelected()) {
                        status.setText("Wald + Santa");
                        leinwand.setShowSanta(true);
                        panel.revalidate();
                        panel.repaint();
                    }else {
                        status.setText("Wald");
                        leinwand.setShowSanta(false);
                    }
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

        frame.add(panel);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(900, 700));
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WeihnachtsGUI();
            }
        });
    }

    @Override
    public void run() {
        panel.revalidate();
        panel.repaint();
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
