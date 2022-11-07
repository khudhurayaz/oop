package de.khudhur.internship.internship3;

public class BildTest {
    public static void main(String[] args) {
        int[][] testBild1 = {{1,1,0,1},{0,1,0,1},{0,1,1,1},{1,0,1,0}};
        int[][] testBild2 = {{0,0,1,1,0},{0,1,0,1,1},{1,0,0,1,1},{0,1,0,1,0}};
        int[][] test = new int[][]{{1,0,0}, {0,1,0}, {0,0,1}, {0,1,0}};
        Bild bild = new Bild();

        //Test
        bild.setBild(test);
        bild.ausgabe();

        //Testbild 1
        bild.setBild(testBild1);
        System.out.println();
        bild.ausgabe();

        //Testbild 2
        bild.setBild(testBild2);
        System.out.println();
        bild.ausgabe();

    }
}
