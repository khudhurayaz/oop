package de.khudhur.internship.internship1;

import java.lang.Math;
import java.util.Scanner;

public class Ratespiel {

    public static void main(String[] args) {
        rateZahl();
    }

    private static void rateZahl() {
        int randomNumber = (int) (Math.random() * 101.0); // [0..100]
        int userNumber = 0;
        int anzahlAnVersuchen = 0;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Zahl: ");
            userNumber = scanner.nextInt();

            if (randomNumber < userNumber) {
                System.out.println("Zufallszahl ist kleiner!");
                anzahlAnVersuchen++;
            } else if (randomNumber > userNumber) {
                System.out.println("Zufallszahl ist groesser!");
                anzahlAnVersuchen++;
            } else if (randomNumber == userNumber) {
                System.out.println("Geschafft! Zufallszahl war " + randomNumber);
                System.out.println("Anzahl an Versuchen = " + anzahlAnVersuchen);
                break;
            } else {
                System.out.println("Fehler!");
            }

        } while (randomNumber != userNumber);

        scanner.close();

    }
}