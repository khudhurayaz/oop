package de.khudhur.internship.internship6;

public class BruchTest {

    public static void main(String[] args) {
        //Objekt 1, 8/7
        Bruch bruch1 = new Bruch(8, 7);
        //Objekt 2, -2/6
        Bruch bruch2 = new Bruch(-2, 6);
        //Objekt addieren
        Bruch add = bruch1.add(bruch2);
        //Objekt Multiplizieren
        Bruch multiply = bruch1.multiply(bruch2);

        //Ausgabe
        System.out.println("Addieren: " + add.toString());
        System.out.println("Multiplizieren: " + multiply.toString());
    }

}
