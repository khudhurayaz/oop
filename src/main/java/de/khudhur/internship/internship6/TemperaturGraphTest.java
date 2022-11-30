package de.khudhur.internship.internship6;

public class TemperaturGraphTest {

    public static void main(String[] args) {
        //Objekt anlegen
        TemperaturGraph temperaturGraph = new TemperaturGraph(2004);

        //Daten hinzufügen
        temperaturGraph.addTemperatur(1, 5);
        temperaturGraph.addTemperatur(2, 8);
        temperaturGraph.addTemperatur(3, 10);
        temperaturGraph.addTemperatur(4, 14);
        temperaturGraph.addTemperatur(5, 16);
        temperaturGraph.addTemperatur(6, 19);
        temperaturGraph.addTemperatur(7, 24);
        temperaturGraph.addTemperatur(8, 28);
        temperaturGraph.addTemperatur(9, 15);
        temperaturGraph.addTemperatur(10, 11);
        temperaturGraph.addTemperatur(11, 8);
        temperaturGraph.addTemperatur(12, 2);

        //Ausgabe
        temperaturGraph.plotGraph();
    }
}
