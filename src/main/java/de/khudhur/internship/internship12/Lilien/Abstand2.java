package de.khudhur.internship.internship12.Lilien;

/**
 * Klasse Abstand2
 * @author Ayaz Khudhur
 * @version 1.0
 */
public class Abstand2 extends Datenverarbeitung{

    /**
     * Berechnet den Abstand zwischen Zwei cluster
     * @param data1 Clustern werden für die Berechnungen benötigt. Data 1
     * @param data2 Clustern werden für die Berechnungen benötigt. Data 2
     * @return errechnete Abstand wird zurückgeliefert
     */
    @Override
    public double berechneAbstand(double[] data1, double[] data2) {
        double sum = 0.0;

        //Data
        for (int i = 0; i < data1.length; i++) {
            //Die beiden werte mit Math.pow abziehen und
            //hoch 2 rechnen
            sum += Math.abs(data1[i] - data2[i]);
        }

        return sum;
    }

    /**
     * Zusätzlich printe Ergebnis für Abstand2
     * @param a Abstand von Block 1 und 2
     * @param a2 Abstand von Block 1 und 3
     * @param a3 Abstand von Block 2 und 3
     */
    @Override
    public void ausgabe(double a, double a2, double a3) {
        System.out.println("Ergebnis für Abstand2:");
        super.ausgabe(a, a2, a3);
    }
}
