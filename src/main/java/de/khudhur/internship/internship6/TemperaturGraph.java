package de.khudhur.internship.internship6;

public class TemperaturGraph {

    private int jahr;
    private final int[] list = new int[12];


    /**
     * Empty constructor is not supported.
     */
    public TemperaturGraph(){
        System.err.println("Empty constructor is not supported.");
    }

    /**
     * Konstruktor
     * @param jahr set the jahr parameter
     */
    public TemperaturGraph(int jahr){
        this.jahr = jahr;
    }

    /**
     * Temperatur hinzufügen
     *
     * @param monat Monat eingabe
     * @param temperatur temperatur des jeweiligen Monat
     */
    public void addTemperatur(int monat, int temperatur){
        if (list[monat-1] == 0){
            if (temperatur >= 0){
                list[monat-1] = temperatur;
            }
        }
    }

    /**
     * Temperatur Ausgabe
     * Jahr - Überprüfung
     * Minimum und Maximum - Herausfinden
     *
     */
    public void plotGraph(){

        //Überprüfung
        if (jahr <= 0){
            System.err.println("Bitte ein Jahr übergeben!");
            return;
        }

        //Ausgabe
        System.out.println("Jahr: " + jahr);

        //max and min temperatur
        int maxTemp = -1; // -1
        int minTemp = list[0]; //an der Position 0 ist der Wert 5

        //for -schleife für min und max
        for (int k : list) {
            if (k >= maxTemp) {
                maxTemp = k;
            }
            if (k < minTemp) {
                minTemp = k;
            }
        }

        //Plot graph

        //y-axis - 28 (wenn die größte Temperatur sich ändert, ändert auch sich der y_axis wert.)
        int y_axis = maxTemp;
        //for schleife i <= (maxTemp - minTemp) - 26 mal durchlaufen (wird sich ebenfalls ändern,
        // sobald sich die max oder min temperatur ändern)
        for (int i = 0; i <= (maxTemp - minTemp); i++) {
            //y-axis ausgabe
            System.out.print(y_axis + "\t");
            y_axis--; //um eins reduzieren

            //for schleife für Rautezeichen
            for (int k : list) {
                //abfrage, ob list[j] größer als y_axis ist
                if (k < y_axis) {
                    //ja, printe ein Tabulatur
                    System.out.print("\t");
                } else {
                    //nein, printe ein Rautezeichen und ein Tabulatur
                    System.out.print("#\t");
                }
            }
            //jedes durchlauf, neues Zeile hinzufügen
            System.out.println();
        }


        //x_axis
        System.out.print("\t");
        for (int j = 0; j < list.length; j++) {
            System.out.print((j+1) + "\t");
        }
    }
}
