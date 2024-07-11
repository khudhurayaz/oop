package de.khudhur.internship.internship9.Arithmetik.Generisch;

/**
 * MatheAnwendungGen main Klasse
 * Beispiel: wie das generische Arithmetikgen
 * funktioniert.
 *
 * @version 1.0
 * @author Ayaz Khudhur
 */
public class MatheAnwendungGen {
    public static void main(String[] args){
        //Kleines StackTest Beispiel
        ArithmetikGenerisch<ArithmetikGen> gen = new ArithmetikGenerisch<>();
        gen.setTyp(new RechenwegPlusGen());
        System.out.println(gen.berechne(2.0, 2.0)); //4
        gen.setTyp(new RechenwegMinusGen());
        System.out.println(gen.berechne(12.0, 4.0));//8
        gen.setTyp(new RechenwegMalGen());
        System.out.println(gen.berechne(4.0, 4.0)); //16
    }
}
