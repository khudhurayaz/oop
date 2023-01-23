package de.khudhur.internship.internship4;

public class ZoomTest {

    public static void main(String[] args) {
        //Testbild 1
        int[][] testbild1 = {{1,7,0}, {1,0,3}, {0,2,1}};
        //Testbild 2
        int[][] testbild2 = {{1,0,2}, {4,2,4}, {2,0,1}};
        //Erste Zoom objekt für test 1
        Zoom zoom = new Zoom(testbild1);
        //output testbild 1
        ausgabe(4, zoom, "Testbild 1");
        //Erste Zoom objekt für test 1
        Zoom zoom1 = new Zoom(testbild2);
        //output testbild 2
        ausgabe(4, zoom1, "Testbild 2");

    }

    private static void ausgabe(int f, Zoom zoom, String test){
        //faktor übergabe
        zoom.zoom(f);

        //output originalbild
        System.out.println("\nOriginalbild ("+test+"): ");
        arrayAusgabe(zoom.getPixelPicOrg());

        //output skaliertes Bild
        System.out.println("\nVergrößerungsfaktor f= " + f);
        arrayAusgabe(zoom.getPixelPicZoom());
    }

    /**
     * Hilfsmethode für die 2D Array Ausgabe
     * @param arr erwartet ein Array
     */
    private static void arrayAusgabe(int[][] arr){
        //Fehlermeldung
        if (arr == null) { System.err.println("Array länge ist zu klein!"); return;}

        //outputs schleife
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }


}
