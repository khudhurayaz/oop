package de.khudhur.internship.internship6;

import java.io.StringReader;
import java.util.ArrayList;

public class TemperaturGraph {

    private int jahr;
    private int[] list = new int[12];


    /**
     * Empty constructor is not supported.
     */
    public TemperaturGraph(){
        throw new UnsupportedOperationException("Empty constructor is not supported.");
    }

    /**
     * Konstruktor
     * @param jahr
     */
    public TemperaturGraph(int jahr){
        this.jahr = jahr;
    }

    /**
     * Temperatur hinzufügen
     *
     * @param monat monat eingabe
     * @param temperatur temperatur des jeweiligen Monat
     */
    public void addTemperatur(int monat, int temperatur){
        list[monat-1] = temperatur;
    }

    /**
     * Temperatur Ausgabe
     */
    public void plotGraph(){

        //Überprüfung
        if (jahr <= 0){
            System.out.println("Bitte ein Jahr übergeben!");
            return;
        }

        //Ausgabe
        System.out.println("Jahr: " + jahr);

        //add to arrayList
        ArrayList<String[]> arrayListTemperatur = new ArrayList<String[]>();
        for (int i = 0; i < list.length; i++) {
            arrayListTemperatur.add(getHash(list[i]));
        }

        //Temporär, später wird es in der Liste durch 'max' ersetzt
        int maxTemp = 28;

        //Ausgabe der Rauten
        for (int i = 0; i < list.length; i++) {
            System.out.print(maxTemp + "\t"); //max temperatur
            for (int j = 0; j < list[i]; j++) { //durch liste gehen
                if (i >= j){
                    System.out.printf(arrayListTemperatur.get(i)[j] + "\t" ); //ausgaben, jedoch printet es vertikal
                }
            }
            System.out.println();
            maxTemp--; //um eins reduzieren
        }

    }

    /**
     * @param temp temperatur
     * @return String-Array von Rauten
     */
    private String[] getHash(int temp){
        //Zwischenspeicher
        String[] newString =new String[temp];

        //Rautenschreiben
        for (int i = 0; i < temp; i++) {
            newString[i] = "#";
        }

        //Zurückliefern
        return newString;
    }


}
