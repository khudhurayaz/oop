package de.khudhur.internship.internship12.Lilien;

public class DatenverarbeitungApp {
    public static void main(String[] args) {
        //Pfad für die iris data
        String data = "src/main/java/de/khudhur/internship/internship12/Lilien/iris-2.data.txt";

        //Test für Abstand 1
        Abstand1 abstand1 = new Abstand1();
        //Daten laden und speichern
        abstand1.ladenVerarbeitenSpeichern(data);
        //Mittelwert berechnen
        double[] berechneMittelwert = abstand1.berechneMittelwert(abstand1.cluster1);
        double[] berechneMittelwert2 = abstand1.berechneMittelwert(abstand1.cluster2);
        double[] berechneMittelwert3 = abstand1.berechneMittelwert(abstand1.cluster3);
        //Abstand zwischen cluster eins und zwei
        double berechneAbstand = abstand1.berechneAbstand(berechneMittelwert, berechneMittelwert2);
        //Abstand zwischen cluster eins und drei
        double berechneAbstand2 = abstand1.berechneAbstand(berechneMittelwert, berechneMittelwert3);
        //Abstand zwischen cluster zwei und drei
        double berechneAbstand3 = abstand1.berechneAbstand(berechneMittelwert2, berechneMittelwert3);
        //Ausgabe abrufen
        abstand1.ausgabe(berechneAbstand, berechneAbstand2, berechneAbstand3);

        //Leertaste
        System.out.println();

        //Test für Abstand 2
        Abstand2 abstand2 = new Abstand2();
        //Daten laden und speichern
        abstand2.ladenVerarbeitenSpeichern(data);
        //Mittelwert berechnen
        double[] berechneMittelwert4 = abstand2.berechneMittelwert(abstand2.cluster1);
        double[] berechneMittelwert5 = abstand2.berechneMittelwert(abstand2.cluster2);
        double[] berechneMittelwert6 = abstand2.berechneMittelwert(abstand2.cluster3);
        //Abstand zwischen cluster eins und zwei
        double berechneAbstand4 = abstand2.berechneAbstand(berechneMittelwert4, berechneMittelwert5);
        //Abstand zwischen cluster eins und drei
        double berechneAbstand5 = abstand2.berechneAbstand(berechneMittelwert4, berechneMittelwert6);
        //Abstand zwischen cluster zwei und drei
        double berechneAbstand6 = abstand2.berechneAbstand(berechneMittelwert5, berechneMittelwert6);
        //Ausgabe abrufen
        abstand2.ausgabe(berechneAbstand4, berechneAbstand5, berechneAbstand6);
    }
}
