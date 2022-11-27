package de.khudhur.internship.internship6;

public class TemperaturGraphTest {
    public static void main(String[] args) {
        TemperaturGraph temperaturGraph = new TemperaturGraph(2004);
        temperaturGraph.addTemperatur(1, 8);
        temperaturGraph.addTemperatur(2, 9);
        temperaturGraph.addTemperatur(3, 12);
        temperaturGraph.addTemperatur(4, 15);
        temperaturGraph.addTemperatur(5, 22);
        temperaturGraph.addTemperatur(6, 24);
        temperaturGraph.addTemperatur(7, 26);
        temperaturGraph.addTemperatur(8, 28);
        temperaturGraph.addTemperatur(9, 24);
        temperaturGraph.addTemperatur(10, 18);
        temperaturGraph.addTemperatur(11, 10);
        temperaturGraph.addTemperatur(12, 5);
        temperaturGraph.plotGraph();
    }
}
