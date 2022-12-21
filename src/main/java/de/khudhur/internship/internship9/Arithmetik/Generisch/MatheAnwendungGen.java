package de.khudhur.internship.internship9.Arithmetik.Generisch;

/**
 * MatheAnwendungGen main Klasse
 *
 * Ein Beispiel, wie die generische Arithmetik
 * funktioniert.
 *
 * @version 1.0
 * @author Ayaz Khudhur
 */
public class MatheAnwendungGen {
    public static void main(String[] args){
        //Kleines Test Beispiel
        ArithmetikGenerisch<Arithmetik> gen = new ArithmetikGenerisch<Arithmetik>();
        gen.setTyp(new RechenwegPlus());
        System.out.println(gen.berechne(2.0, 2.0)); //4
        gen.setTyp(new RechenwegMinus());
        System.out.println(gen.berechne(12.0, 4.0));//8
        gen.setTyp(new RechenwegMal());
        System.out.println(gen.berechne(4.0, 4.0)); //16
    }
}
