package de.khudhur.internship.internship3;

public class ArraysComparisonTest {

    public static void main(String[] args) {
        ArraysComparison comparison = new ArraysComparison();
        int[] a = { 1, 2, 3, 4 }; // Input a
        int[] b = { 3, 1, 6, 2 }; // Input b
        int[] c = { 3, 5, 1, 3 }; // Input c
        int[] d = { 1, 5, 3, 3 }; // Input d

        // Outputs
        comparison.output(a, b);
        comparison.output(c, d);
    }

}
