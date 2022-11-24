package de.khudhur.internship.internship6;

public class TemperaturGraphTest {
    public static void main(String[] args) {
        TemperaturGraph temperaturGraph = new TemperaturGraph(2004);
        temperaturGraph.addTemperatur(1, 7);
        temperaturGraph.addTemperatur(2, 9);
        temperaturGraph.plotGraph();
    }
}
