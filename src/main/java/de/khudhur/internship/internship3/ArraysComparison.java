package de.khudhur.internship.internship3;

import java.util.Arrays;

public class ArraysComparison {
    public static void main(String[] args) {

        int[] a = { 1, 2, 3, 4 }; // Input a
        int[] b = { 3, 1, 6, 2 }; // Input b
        int[] c = { 3, 5, 1, 3 }; // Input c
        int[] d = { 1, 5, 3, 3 }; // Input d

        // Outputs
        output(a, b);
        output(c, d);
    }

    /**
     * @param a erwartung eines array
     * @param b erwartung eines array
     * @return boolean ob array gleich sind oder nicht
     */
    static boolean isEqual(int[] a, int[] b) {
        // Zuerst werden die Arrays sortiert,
        // keine veränderung! Wird nur temporer gespeichert und sortiert.
        int[] tempA = sort(a);
        int[] tempB = sort(b);

        // Erstes abfrage ob array die gleiche länge haben
        if (tempA.length != tempB.length)
            return false;


         //solange tempA[i] nicht gleich tempB[i] ist,
         //ist die rückgabewert false.
        for (int i = 0; i < tempA.length; i++) {
            if (tempA[i] != tempB[i]) {
                return false;
            }
        }

        // Ansonsten ist es true
        return true;
    }

    /**
     * Hilfsmethode
     * 
     * @param array erwartung um ein array zu sortieren
     * @return sortiertes array wird es zurückgeliefert
     */
    static int[] sort(int[] array) {
        //
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    /**
     * Ausgabe
     * @param a Erwartung eines Arrays zu überprüfen - erste Array
     * @param b Erwartung eines Arrays zu überprüfen - zweite Array
     */
    static void output(int[] a, int[] b) {
        System.out.println("Input: a=" + Arrays.toString(a) + ", " +
                           "b=" + Arrays.toString(b) +
                           " -> Output:" + isEqual(a,b));
    }

}
