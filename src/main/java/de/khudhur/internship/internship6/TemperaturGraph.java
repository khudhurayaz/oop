package de.khudhur.internship.internship6;

import java.util.ArrayList;

public class TemperaturGraph {

    private int jahr;
    private int zaehler = 0;
    private int[] list = new int[12];

    public TemperaturGraph(int jahr){
        this.jahr = jahr;
    }

    public void addTemperatur(int monat, int temperatur){
        list[monat-1] = temperatur;
    }

    public void plotGraph(){
        if (jahr <= 0){
            System.out.println("Bitte ein Jahr übergeben!");
            return;
        }

        for (int i = 0; i < list.length; i++) {
            System.out.println("Monat: " + (i+1) + ", Temperatur: " + list[i]);
        }
    }

}
