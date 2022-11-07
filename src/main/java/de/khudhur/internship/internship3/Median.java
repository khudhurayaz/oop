package de.khudhur.internship.internship3;

import java.util.Arrays;

public class Median {
    public static void main(String[] args) {
        int[] array1 = { 12, 16, 2, 63, 55, 8 }; // Test array 1 n gerade
        int[] array2 = { 42, 7, 543, 77, 87, 876, 143 }; // Test array 2 n ungerade
        System.out.println("Median für Array 1: " + median(array1) + "\n"); // Output array 1
        System.out.println("Median für Array 2: " + median(array2) + "\n"); // Output array 2
    }

    /**
     * @param array erwartet einen int[]
     * @return ein integer Zahl als Rückgabewert
     */
    private static int median(int[] array) { // Anfang

        Arrays.sort(array); // array sortieren
        System.out.println("Array: ");

        // Array output
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();// blank line

        // operation: prüfe ob array.length modul 2 gleich null ist
        if (array.length % 2 == 0) {
            // dann die beiden mittleren Zahlen zusammenaddieren und durch Zwei teilen.
            return (int) ((array[array.length / 2] + array[(array.length / 2) - 1]) / 2);
        } else {
            /**
             * ansonsten teile die array länge durch 2 + 1 {0...n}
             * und das ganze nochmal durch 2 zu teilen, um den mittleren wert zu bekommen
             */
            return array[array.length / 2] + 1 / 2;
        }
    } // Ende

}