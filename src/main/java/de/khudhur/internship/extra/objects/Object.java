package de.khudhur.internship.extra.objects;

import de.khudhur.internship.extra.objects.icons.ErrorIcons;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Object {

    public static final String PATH = "src/main/java/de/khudhur/internship/extra/assets/";
    private JFrame createdJFrame;
    private static final Load load = new Load();
    private boolean windowClosed = false;
    private ErrorIcons errorIcons;

    /**
     * Um ein Fenster zu erstellen, kann man durch die createJFrame
     * methode ein völlig separates Fenster initialisieren.
     *
     * @param title Fenstertitel
     * @param icon Fenstericon
     * @param ueberschrift Überschrift für die Frames
     * @param description Beschreibung für die Frames
     */
    public void createJFrame(String title, String icon, String ueberschrift, String description, boolean startAnimation){
        int x = 140;
        Dimension frameDimension = new Dimension(650, 350);
        //neues Frame mit Titel erstellen
        JFrame frame = new JFrame(title);

        //Image erstellen und in die JLabel Übergeben
        JLabel lbl1 = new JLabel();
        BufferedImage image = new Load().bufferedImage(icon);
        //Skaliertes icon laden
        ImageIcon scaledIcon = new ImageIcon(image.getScaledInstance(64, 64, Image.SCALE_SMOOTH));
        //aufnahme in die JLabel Klasse
        lbl1.setIcon(scaledIcon);
        //Da, die Layout null ist, kann ich mit dem Methode setBounds neue Koordinaten
        //und Größen angeben.
        lbl1.setBounds(50, 75, 128, 128);
        //Im frame Klasse aufnehmen
        frame.add(lbl1);

        //Überschrift initialisieren
        JLabel lbl2 = new JLabel();
        lbl2.setText("<html>" + ueberschrift + "</html>");
        //Label für überschrift, die Größe setzen
        int laenge = ((ueberschrift.length() * 10) - x) + (lbl1.getX() + lbl1.getWidth());
        if (laenge < frameDimension.getWidth())
            laenge += (int) (frameDimension.getWidth() - laenge);
        lbl2.setPreferredSize(new Dimension(laenge, 100));
        //Neue Schrift übergeben und Schriftgröße
        lbl2.setFont(new Font(Font.MONOSPACED, Font.BOLD, 17));
        //Neue Koordinaten und Größe setzen
        lbl2.setBounds(x, 20, lbl2.getPreferredSize().width, lbl2.getPreferredSize().height);
        //im frame Klasse aufnehmen
        frame.add(lbl2);

        //Beschreibung initialisieren
        JTextArea textArea = new JTextArea();
        //Beschreibung setzen
        textArea.setText(description);
        //position des Text auf null setzen
        textArea.setCaretPosition(0);
        //neue Schriftart und Größe setzen
        textArea.setFont(new Font(Font.MONOSPACED, Font.ITALIC, 15));
        //Der TextArea soll nicht schreibbar sein
        textArea.setEditable(false);
        //An die TextArea größe passen
        textArea.setLineWrap(true);
        //und auch durch sinnvollen Wörter unterbrechen
        textArea.setWrapStyleWord(true);
        //Die Methode macht, ob ein Element durchsichtig oder nicht
        textArea.setOpaque(false);
         /*
          Um den TextArea scrollbar zu machen brauchen wir die Klasse JScrollPane.
          In der JScrollPane Konstruktor, übergebe ich den TextArea und setze

          VERTICAL_SCROLLBAR_AS_NEEDED ist eine Konstante in der Klasse JScrollPane,
          die verwendet wird, um anzugeben, dass die vertikale Scrollbar nur dann angezeigt wird,
          wenn der Inhalt des JScrollPane größer ist als der verfügbare Platz.

          HORIZONTAL_SCROLLBAR_AS_NEEDED ist eine Konstante in der Klasse JScrollPane,
          die verwendet wird, um anzugeben, dass die horizontale Scrollbar nur dann angezeigt wird,
          wenn der Inhalt des JScrollPane größer ist als der verfügbare Platz.
         */
        JScrollPane area = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        /*
          BorderFactory.createEmptyBorder() ist eine Methode in der Klasse BorderFactory,
          die verwendet wird, um einen leeren Border zu erstellen.
          Der leere Border hat keine Linien oder Füllung und gibt den Komponenten,
          auf die er angewendet wird, mehr Platz.
         */
        area.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));

        /*
          um die Scroll-Balken zu verändern bzw. nur
          die Balken Farbe zu ändern, benötige ich die
          JScrollBar Klasse. Dadurch kann ich auf die setUI
          Methode greifen und die Methode configureScrollBarColors und
          paintThumb zugreifen.
         */
        JScrollBar scrollBar = area.getVerticalScrollBar();
        scrollBar.setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = Color.GRAY;
            }
            @Override
            protected void paintThumb(final Graphics g, final JComponent c, final Rectangle thumbBounds) {
                int x = thumbBounds.x +1;
                int y = thumbBounds.y +1;
                int w = thumbBounds.width -2;
                int h = thumbBounds.height -2;

                g.setColor(Color.GRAY);
                g.fillRect(x+1,y+1,w,h);
                g.setColor(Color.GRAY);
                g.drawRect(x,y,w,h);

                incrButton.setBackground(Color.LIGHT_GRAY);
                decrButton.setBackground(Color.LIGHT_GRAY);
                incrButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                decrButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
        });

        if (startAnimation){
            scrollBar.setUnitIncrement(1);
            Timer timer = new Timer(600, e -> scrollBar.setValue(scrollBar.getValue() + scrollBar.getUnitIncrement()));
            timer.start();
        }

        //TextArea die neue Vertikal scrollbar übergeben
        area.setVerticalScrollBar(scrollBar);
        //position und größe initialisieren
        area.setBounds(x, 100, 600 - textArea.getWidth() - 170, 240);
        //in frame aufnehmen
        frame.add(area);

        if (!frame.isActive() || !frame.isVisible()){
            setWindowClosed(true);
        }

        //frame initialisieren und sichtbar machen
        createdJFrame = frame;
        frame.setLayout(null); //Layout ist null
        frame.setIconImage(load.loadIcon(icon)); //setze icon
        frame.setMinimumSize(frameDimension); //größe
        frame.setLocationRelativeTo(null);//Fenster mittig setzen
        frame.setResizable(false); //nicht dehnbar
        frame.setVisible(true); //sichtbar
    }

    /**
     * @return return a new JFrame
     */
    public JFrame getCreatedJFrame() {
        return createdJFrame;
    }

    /**
     * @return ein Boolisches Wert wird zurückgeworfen,
     *         in dem es ausgibt, ob Fenster noch offen oder
     *         geschlossen ist.
     */
    public boolean isWindowClosed() {
        return windowClosed;
    }

    /**
     * @param windowClosed
     */
    public void setWindowClosed(boolean windowClosed) {
        this.windowClosed = windowClosed;
    }

    public ErrorIcons getErrorIcons() {
        return errorIcons;
    }
}
