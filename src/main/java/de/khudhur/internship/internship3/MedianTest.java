package de.khudhur.internship.internship3;

public class MedianTest {

    public static void main(String[] args) {
        Median med = new Median();
        // Test array 1 gerade Zahl
        int[] array1 = { 12, 16, 2, 63, 55, 8 };
        // Test array 2 ungerade Zahl
        int[] array2 = { 42, 7, 543, 77, 87, 876, 143 };
        System.out.println("Median für Array 1: " +
                med.median(array1) + "\n"); // Output array 1
        System.out.println("Median für Array 2: " +
                med.median(array2) + "\n"); // Output array 2
    }

}
