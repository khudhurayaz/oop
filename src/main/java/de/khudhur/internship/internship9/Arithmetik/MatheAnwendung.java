package de.khudhur.internship.internship9.Arithmetik;

/**
 * MatheAnwendung
 *
 * @version 1.0
 * @author Ayaz Khudhur
 */
public class MatheAnwendung {
    public static void main(String[] args){
        RechenwegPlus plus = new RechenwegPlus();
        RechenwegMinus minus = new RechenwegMinus();
        RechenwegMal mal = new RechenwegMal();

        Arithmetik arithmetik = new Arithmetik();
        arithmetik.bestimmeRechenweg(plus);
        System.out.println(arithmetik.berechne(2, 2)); // 4
        arithmetik.bestimmeRechenweg(minus);
        System.out.println(arithmetik.berechne(12, 4)); // 8
        arithmetik.bestimmeRechenweg(mal);
        System.out.println(arithmetik.berechne(4, 4)); //16
    }
}
