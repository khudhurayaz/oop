package de.khudhur.internship.internship4;

import java.util.Scanner;

public class Memory {

    /**
     * @param n um ein n Einträge als mehrdimensionales Array erzeugen kann.
     * @return Rückgabewert ist ein mehrdimensionales Array (Generiertes Spielfeld)
     */
    public int[][] generateField(int n) {
        int nf; // Falls n ungerade ist
        //Scanner initialisieren
        Scanner scanner = new Scanner(System.in);

        //beginn der While-Schleife
        while (true){
            //prüfe, ob nur gerade Zahlen eingegeben wurden.
            if (n % 2 != 0){
                //Fehlermeldung
                System.out.println("Bitte nur gerade Zahlen eingeben!");
                System.out.print("Eingabe: "); //Eingabe
                nf = scanner.nextInt(); //Zahl in nf speichern
                n = nf; //n neue Zahl übergeben
                continue; // wiederhole
            }

            //ist es gerade, wird ein 2D Array initialisiert
            int[][] generate = new int[n][n];
            //beginn der Initialisierung von Paare Zahlen
            for (int i = 0; i < generate.length; i++) {
                //Zähler um Paare zu identifizieren
                int zaehler = 0;
                // Random Zahl als double
                // um eine Zahl zwischen 5 - n x 100 zu generieren
                double gZ = 5 + (Math.random() * n * 100);
                // double wert in int umwandeln
                int generateZahl = (int) gZ;
                //zweite schleife - Zeilen und spalten generieren
                for (int j = 0; j < generate[0].length; j++) {
                    // Zufallszahl
                    generate[i][j] = generateZahl;
                    // Prüfe, wie viel gleiche Zahlen vorkommt.
                    if (generate[i][j] == generateZahl){
                        zaehler++; //Erhöhe um eins
                    }
                    //prüfe, ob Zähler gleich 2 ist
                    if (zaehler == 2){ //ja
                        //Zahl generieren
                        gZ = 5 + (Math.random() * n * 100);
                        //Zahl zuweisen
                        generateZahl = (int) gZ;
                        //Zähler zurücksetzen
                        zaehler = 0;
                    }
                }

            }
            //Zahlen mischen
            shuffle(generate);
            //2D Array zurückgeben
            return generate;
        }
    }

    /**
     * @param shuffle 2D Array, um zu mischen.
     * @return gemischtes Array wird zurückgeliefert.
     */
    private int[][] shuffle(int[][] shuffle){
        for (int i = 0; i < shuffle.length; i++) {
            for (int j = 0; j < shuffle[0].length; j++) {
                //Random Zeile
                int k = (int)(Math.random() * shuffle.length);
                //Random Spalte
                int n = (int)(Math.random() * shuffle.length);
                //shuffle[zeile][spalte] in temp speichern
                int temp = shuffle[i][j];
                //im aktuellen zeile und spalte random
                //inhalte einfügen
                shuffle[i][j] = shuffle[k][n];
                //random zeile und spalte
                //den inhalt temp übernehmen
                shuffle[k][n] = temp;
            }
        }
        return shuffle;
    }

    /**
     * @param arr um ein 2D Array auszugeben können.
     */
    public void ausgabe(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}
