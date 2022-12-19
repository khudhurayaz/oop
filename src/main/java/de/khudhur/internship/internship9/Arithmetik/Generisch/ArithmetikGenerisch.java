package de.khudhur.internship.internship9.Arithmetik.Generisch;

/**
 *
 * Generische Klasse von Arithmetik
 * hier wird der Rechenweg bestimmt und berechnet.
 *
 * @version 1.0
 * @author Ayaz Khudhur
 * @param <T> Vererbt die Klasse Arithmetik {@link Arithmetik}.
 */

public class ArithmetikGenerisch <T extends Arithmetik>{

    //Irgendeine Arithmetik Klasse wird hier gespeichert.
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
