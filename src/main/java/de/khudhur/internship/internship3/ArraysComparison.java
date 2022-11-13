package de.khudhur.internship.internship3;

import java.util.Arrays;

public class ArraysComparison {

    /**
     * @param a Erwartet ein Array
     * @param b Erwartet ein Array
     * @return boolean, ob Array gleich sind oder nicht
     */
     private boolean isEqual(int[] a, int[] b) {
        // Zuerst werden die Arrays sortiert,
        // keine veränderung! Wird nur temporär gespeichert und sortiert.
        int[] tempA = sort(a);
        int[] tempB = sort(b);

        // Erstes abfrage, ob Array die gleiche länge haben
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
     * Hilfsmethode - Sortierung ist temporär
     * 
     * @param array Erwartung um ein Array zu sortieren
     * @return sortiertes array wird zurückgeliefert
     */
     private int[] sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                //wenn i große als j ist
                if (array[i] > array[j]) {
                    //in ein const variable speichern
                    int temp = array[i];
                    //j in i zuweisen
                    array[i] = array[j];
                    //temp in j zuweisen
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    /**
     * Ausgabe
     * @param a Erwartet, um ein Array zu überprüfen - erste Array
     * @param b Erwartet, um ein Array zu überprüfen - zweite Array
     */
     public void output(int[] a, int[] b) {
        System.out.println("Input: a=" + Arrays.toString(a) + ", " +
                           "b=" + Arrays.toString(b) +
                           " -> Output:" + isEqual(a,b));
    }

}
