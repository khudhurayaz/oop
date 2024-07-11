package de.khudhur.projects.ggT;

import javax.swing.*;

/**
 *<h1>Algorithmus von Euklid (ggT)</h1>
 * <p>
 *     Der Algorithmus von Euklid ist ein Verfahren zur Bestimmung
 *     des größten gemeinsamen Teilers (ggT) zweier oder mehrerer natürlicher Zahlen.
 *     <br>
 *     Der Algorithmus ist nach dem Mathematiker Euklid benannt,
 *     der ihn bereits im 3.Jahrhundert v.Chr. beschrieben hat.
 * </p>
 * @author Ayaz Khudhur
 * @version 1.0
 */
public class GGT {
    public static void main(String[] args) {
        //Zeichenkette für a und b
        String strA = "", strB = "";
        //Ganzzahlen für a, b und r
        int a = 0, b = 0, r = 0;
        //boolischeswert für weiter
        boolean weiter = true;
        //User eingabe
        while (weiter){
            //Eingabe für a
            strA = JOptionPane.showInputDialog("Gib ein Zahl für Zahl 1 ein: ");
            //Eingabe für b
            strB = JOptionPane.showInputDialog("Gib ein Zahl für Zahl 2 ein: ");
            //in Ganzzahlen umwandeln
            a = Integer.parseInt(strA);
            b = Integer.parseInt(strB);

            //abfrage ob, in a und b nur positiven werten sind
            if (!pruefe(a, b))
                weiter = false;
        }

        //ggT errechnen
        do {
            r = a % b;
            a = b;
            b = r;

        }while (r != 0);

        //ausgabe
        JOptionPane.showMessageDialog(
                null,
                "---->ggT von a = " + strA + " und b = " + strB + ", ist: " + a,
                "ggT von Euklid",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static boolean pruefe(int...zahl){
        boolean weiter = false;
        for (int i : zahl) {
            if (i == 0 || i <= -1){
                int option = JOptionPane.showConfirmDialog(
                        null,
                        "Dürfen nullen oder negativen Zahlen nicht enthalten!",
                        "ggT von Euklid",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
                if (option == JOptionPane.OK_OPTION) {
                    weiter = true;
                }else {
                    JOptionPane.showMessageDialog(
                            null,
                            "Programm wird beendet!",
                            "ggT von Euklid",
                            JOptionPane.INFORMATION_MESSAGE);
                    System.exit(-1);
                    weiter = false;
                }
            }
        }
        return weiter;
    }
}
