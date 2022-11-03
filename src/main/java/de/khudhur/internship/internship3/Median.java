package de.khudhur.internship.internship3;

import java.util.Arrays;

public class Median {
    public static void main(String[] args) {
        int[] array1 = { 12, 16, 2, 63, 55, 8 };
        int[] array2 = { 42, 7, 543, 77, 87, 876, 143 };
        System.out.println("Median für Array 1: " + median(array1));
        System.out.println("Median für Array 2: " + median(array2));
    }

    private static int median(int[] array) {

        Arrays.sort(array); // array sortieren
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        if (array.length % 2 == 0) {
            return (int) ((array[array.length / 2] + array[(array.length / 2) - 1]) / 2);
        } else {
            return array[array.length / 2] + 1 / 2;
        }

    }
}