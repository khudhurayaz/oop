package de.khudhur.internship.internship9.Arithmetik.Generisch;

/**
 *
 * Generische Klasse von ArithmetikGen
 * hier wird der Rechenweg bestimmt und berechnet.
 *
 * @version 1.0
 * @author Ayaz Khudhur
 * @param <T> Vererbt die Klasse ArithmetikGen {@link ArithmetikGen}.
 */

public class ArithmetikGenerisch <T extends ArithmetikGen>{

    //Irgendein Arithmetikgen Klasse wird hier gespeichert.
    T typ;

    //Typ setzen
    public void setTyp(T typ1){
        this.typ = typ1;
    }

    //berechnungsmethode aufrufen
    public double berechne(double x, double y){
        return typ.berechne(x, y);
    }

}
