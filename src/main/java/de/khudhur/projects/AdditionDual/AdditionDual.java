package de.khudhur.projects.AdditionDual;

import java.util.Scanner;

public class AdditionDual {
    public static void main(String[] args) {
        String add1;
        String add2;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Addition Binär 1: ");
        add1 = scanner.nextLine();
        System.out.println("Addition Binär 2: ");
        add2 = scanner.nextLine();

        StringBuilder sum = new StringBuilder();
        char[] array1 = new char[add1.length()];
        char[] array2 = new char[add2.length()];
        for (int i = 0; i < add1.length(); i++) {
            array1[i] = add1.charAt(i);
        }
        for (int i = 0; i < add2.length(); i++) {
            array2[i] = add2.charAt(i);
        }

        //prüfung
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] == '0' && array2[i] == '0' || array2[i] == '0' && array1[i] == '0'){
                sum.append(0);
            }
            if (array1[i] == '0' && array2[i] == '1' || array2[i] == '0' && array1[i] == '1'){
                sum.append(1);
            }
            if (array1[i] == '1' && array2[i] == '1' || array2[i] == '1' && array1[i] == '1'){
                sum.append(0);
            }
        }

        //ausgabe
        System.out.println(sum);
    }
}
