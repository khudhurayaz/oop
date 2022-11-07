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
     * @param a erwartung eines int array
     * @param b erwartung eines int array
     * @return boolean ob array gleich sind oder nicht
     */
    static boolean isEqual(int[] a, int[] b) {
        // Zuerst werden die Array's sortiert
        int[] tempA = sort(a);
        int[] tempB = sort(b);

        // Erster abfrage ob array die gleiche länge haben
        if (tempA.length != tempB.length)
            return false;

        /**
         * solange tempA[i] nicht gleich tempB[i] ist,
         * ist die rückgabewert false.
         */
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
     * @return sortiertes array wird zurückgeliefert
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
     * Hilfmethode für output
     * @param a erwartung ein int[] array
     * @param b erwartung ein weiteres int[] array
     */
    static void output(int[] a, int[] b) {
        System.out.println("a=" + Arrays.toString(a) +
                ", b=" + Arrays.toString(b) +
                " -> Output:" + isEqual(a,b));
    }

}