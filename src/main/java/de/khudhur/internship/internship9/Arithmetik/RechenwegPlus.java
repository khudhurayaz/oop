package de.khudhur.internship.internship9.Arithmetik;

/**
 * @version 1.0
 * @author Ayaz Khudhur
 */
public class RechenwegPlus implements Rechenweg{
    /**
     * Methode für + Berechnung
     * @param x der x wert für eins beliebiges double wert.
     * @param y der y wert für eins beliebiges double wert.
     * @return der ergebnis von + rechnung wird zurückgeliefert.
     */
    @Override
    public double berechneErgebnis(double x, double y) {
        return x + y;
    }
}
