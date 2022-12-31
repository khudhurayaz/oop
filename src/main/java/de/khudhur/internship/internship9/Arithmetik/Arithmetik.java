package de.khudhur.internship.internship9.Arithmetik;

/**
 * Arithemtik Klasse
 *
 * Die ArithmetikGen Klasse, beherbergt eine Methode,
 * berechne(double, double), in dieser Methode werden die berechnungen
 * durchgeführt.
 *
 * @version 1.0
 * @author Ayaz Khudhur
 */
public class Arithmetik {

    //Objekt Rechenweg
    private Rechenweg rechenweg;

    /**
     * Rechenweg bestimmen
     * @param rechenweg Rechenweg Klasse wird erwartet
     */
    public void bestimmeRechenweg(Rechenweg rechenweg){
        this.rechenweg = rechenweg;
    }

    /**
     * Methode berechne
     * @param x der x wert für eins beliebiges double wert.
     * @param y der y wert für eins beliebiges double wert.
     * @return der ergebnis von berechneten Aufgabe
     */
    public double berechne(double x, double y){
        return rechenweg.berechneErgebnis(x,y);
    }

}
