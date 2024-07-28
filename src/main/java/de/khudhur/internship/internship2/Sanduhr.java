package de.khudhur.internship.internship2;

public class Sanduhr {

    public static void main(String[] args) {
        printSanduhr(7);
    }

    //leerzeichen für die erste durchlauf
    static int firstBlanks = 0;

    //leerzeichen für die zweite durchlauf
    static int secondBlanks  = 0;

    public static void printSanduhr (int width){//anfang
        //Leerzeichen
        for (int i = 0; i < firstBlanks; i++) {
            System.out.print(" ");
        }

         //Erste for-schleife, wiederholt
         //sich wie viel width übergeben würde!

        for (int i = 0; i < width; i++) {
            //gib sterne aus: i=0, i=1, i=2 sind 3 sterne
            System.out.print("*");
        }


        //bedienung, prüfe ob width 0 oder 1 ist,
        //abbruch des vorgang.
        //ansonsten wiederhole dich selbst und
        //gib die int von printSanduhr (width -2)

        if (width == 2) {
            System.out.println();
            return;
        }
        if (width == 0 || width == 1){
            if (width != 1){
                System.out.println("*");
                //trifft zu wird es übersprungen
                return;
            }
        }
        else {
            System.out.println();
            firstBlanks++;
            //rufe die methode printSanduhr auf
            printSanduhr(width - 2);
        }


        //Nach der Rekursion wiederhole die schritte

        //für die zweite leerzeichen durchlauf
        secondBlanks = firstBlanks;
        //Leerzeichen
        for (int i = 0; i < secondBlanks; i++) {
            System.out.print(" ");
        }
        for (int i = 0; i < width; i++) {
            if (width != 1){
                System.out.print("*");
            }
        }
        firstBlanks--;
        System.out.println(); //Leerzeile
    }//ende

}
