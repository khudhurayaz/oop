package de.khudhur.internship.internship3;

import java.util.Arrays;

public class Median {

    /**
     * @param array erwartet einen Integer Array
     * @return ein Integer Zahl als Rückgabewert
     */
    public int median(int[] array) { // Anfang

        Arrays.sort(array); // array sortieren
        System.out.println("Array: ");

        // Array output
        for (int j : array) {
            System.out.print(j + " ");
        }
        System.out.println();// blank line

        // operation: prüfe ob modul 2 gleich null ist
        if (array.length % 2 == 0) {
            // dann die beiden mittleren Zahlen zusammenaddieren und durch Zweiteilen.
            return (int) ((array[array.length / 2] + array[(array.length / 2) - 1]) / 2);
        } else {
            /**
             * ansonsten teile die array länge durch 2 + 1 {0.n}
             * und das ganze durch nochmal durch 2 teilen, um den mittleren wert zu bekommen
             */
            return array[array.length / 2] + 1 / 2;
        }
    } // Ende

}