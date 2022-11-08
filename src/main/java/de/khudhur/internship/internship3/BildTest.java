package de.khudhur.internship.internship3;

public class BildTest {

    public static void main(String[] args) {
        //input 1
        int[][] testBild1 = {
                                {1,1,0,1},
                                {0,1,0,1},
                                {0,1,1,1},
                                {1,0,1,0}
                            };
        //input 2
        int[][] testBild2 = {
                                {0,0,1,1,0},
                                {0,1,0,1,1},
                                {1,0,0,1,1},
                                {0,1,0,1,0}
                            };
        Bild bild = new Bild();

        //Testbild 1
        bild.setBild(testBild1);
        System.out.println("Testbild 1:");
        bild.ausgabe();

        //Testbild 2
        bild.setBild(testBild2);
        System.out.println("\nTestbild 2:");
        bild.ausgabe();
    }

}
