package de.khudhur.internship.internship12.Lilien;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 *
 * <h1>Datenverarbeitung</h1>
 * <p>Ist eine abstrakte Klasse, Verwaltet <code>Iris-flower-Datensatz</code> Daten.</p>
 * <br>
 * <p>
 *     <h2>Der Iris-flower-Datensatz</h2>
 *     Der Iris-Flower-Datensatz ist ein bekannter Datensatz in der maschinellen Lernforschung,
 *     der für Klassifikationsaufgaben verwendet wird. Der Datensatz enthält 150 Beobachtungen von Irisblüten,
 *     die in drei Arten unterteilt sind: Iris setosa, Iris versicolor und Iris virginica. Für jede Beobachtung
 *     sind vier Merkmale aufgezeichnet: die Länge und die Breite des Kelchblatts und der Länge und die Breite der Blütenblätter.
 *      <br>
 *     Der Iris-Flower-Datensatz wurde im Jahr 1936 von dem Biologen Ronald Fisher veröffentlicht und
 *     seitdem wird er häufig als Testdatensatz für Klassifikationsalgorithmen verwendet.
 *     Er ist ein guter Einstiegspunkt für die Arbeit mit maschinellem Lernen,
 *     da er eine begrenzte Anzahl von Merkmalen und eine begrenzte Anzahl von Klassen enthält.
 *      <br>
 *     Der Datensatz ist in vielen maschinellen Lernbibliotheken wie scikit-learn in Python und
 *     Weka in Java enthalten und ist auch auf Online-Ressourcen wie UCI Machine Learning Repository und Kaggle verfügbar.
 * </p>
 * <br>
 * <br>
 * <h3>
 *     Code - Beispiel
 * </h3>
 * <code>
 *  &nbsp;public class Abstand extends Datenverarbeitung {<br>
 *  &nbsp;&nbsp;&nbsp;&nbsp;@Override<br>
 *  &nbsp;&nbsp;&nbsp;&nbsp;public double berechneAbstand(double[] data1, double[] data2) { <br>
 *  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;double sum = 0.0;
 *  <br>
 *  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;//Data 1 <br>
 *  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;for (int i = 0; i < data1.length; i++) { <br>
 *  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;sum += Math.pow(data1[i] - data2[i], 2);<br>
 *  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}<br>
 *  <br>
 *  &nbsp;&nbsp;&nbsp;&nbsp;return Math.sqrt(sum); <br>
 *  &nbsp;&nbsp;&nbsp;&nbsp;} <br>
 *  &nbsp;}
 * </code>
 * <br><br>
 * <h3>Aufrufe der Methode 'ausgabe'</h3>
 * <code>
 *  &nbsp;&nbsp;Abstand abstand = new Abstand();<br>
 *  &nbsp;&nbsp;//Ausgabe<br>
 *  &nbsp;&nbsp;abstand.ausgabe(mittelwert1: double, mittelwert2: double, mittelwert3: double);<br>
 * </code>
 * @author Ayaz Khudhur
 * @version 1.0
 */
public abstract class Datenverarbeitung {
    //Datensatz 1 - Iris-setosa
    protected double[][] cluster1 = new double[50][];
    //Datensatz 2 - Iris-versicolor
    protected double[][] cluster2 = new double[50][];
    //Datensatz 3 - Iris-virginica
    protected double[][] cluster3 = new double[50][];
    //für die einzeln Cluster
    private int zaehler = -1;

    /**
     * Ladet, verwaltet Iris Daten und am Ende wird
     * es im Variablen gespeichert.
     * @param laden Pfad zum iris-flower-Datensatz
     */
    public final void ladenVerarbeitenSpeichern(String laden){
        //try-catch
        try {
            //Pfad zu Datei
            Path path = Paths.get(laden);

            //Abfrage, ob die Datei lesbar ist.
            if (!Files.isReadable(path))
                throw new Exception("ERROR: die Datei " + laden +
                        ", kann nicht gelesen werden!");

            //Scanner objekt erstellen
            Scanner scanner = new Scanner(path);
            //while-schleife, um alle Daten zu laden
            while (scanner.hasNext()){
                //Rufe ladDaten Methode
                ladeDaten(scanner.nextLine());
            }
        }catch (Exception e){
            try {
                throw new Exception("Die Daten können nicht geladen werden");
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    /**
     * Abstraktes methode, bei jeder Vererbung muss die Methode
     * berechneAbstand implementiert werden.
     * <br>
     * Dabei werden die notwendigen Abstände für die jeweiligen,
     * Klassen berechnet.
     *
     * @param data1 Clustern werden für die Berechnungen benötigt. Data 1
     * @param data2 Clustern werden für die Berechnungen benötigt. Data 2
     * @return Ergebnis von dem jeweiligen Abstand zurückgeliefert.
     */
    public abstract double berechneAbstand(double[] data1, double[] data2);

    /**
     * In der Methode berechneMittelwert, wird der mittelwert errechnet.
     * Beginn der Methode, erstelle ich ein dimensional Array von Typ double.
     * In der ersten For-Schleife, bevor die Zweite beginnt, erstelle ich die Variable
     * sum, für die Summe der einzeln Werte, die ich zusammen addiere und wenn der Zeile
     * durch ist, füge ich dem matrix[i = position] die neuen Werte hinzu. Die gesamt sum,
     * welches wert im Variable sum befindet, teile ich durch die mittelwert länge, bzw. mehrdimensional Array.
     * @param mittelwert erwartet mehrdimensional Array
     * @return Zurückgeliefert wird der errechnete Wert.
     */
    public double[] berechneMittelwert(double[][] mittelwert){
        //errechnete mittelwerte
        double[] matrix = new double[mittelwert[0].length];
        //for-schleife
        for (int i = 0; i < mittelwert[0].length; i++) {
            //die summe für einzeln Zeile
            double sum = 0;
            //for-schleife innen
            for (double[] doubles : mittelwert) {
                //addieren
                sum += doubles[i];
            }
            //an i position speichern und den Mittelwert
            //von mittelwert.length rechnen
            matrix[i] = sum / mittelwert.length;
        }
        return matrix;
    }

    /**
     * Lade Daten, die geladenen Daten werden hier im jeweiligen
     * Cluster abgespeichert.
     * @param daten daten von File
     */

    public void ladeDaten(String daten){
        //ersetzt ',' durch leerzeichen ersetzen
        String replaceData = daten.replace("[',']*", " ");
        //Erstes abfrage
        if (replaceData.endsWith("Iris-setosa")){
            zaehler++;
            cluster1 = initialisieren(daten, "cluster1");
            resetZaehler();

        }
        //zweite abfrage
        if (replaceData.endsWith("Iris-versicolor")){
            zaehler++;
            cluster2 = initialisieren(replaceData, "cluster2");
            resetZaehler();
        }
        //dritte abfrage
        if (replaceData.endsWith("Iris-virginica")){
            zaehler++;
            cluster3 = initialisieren(replaceData, "cluster3");
            resetZaehler();
        }
    }

    /**
     * Die Daten werden im jeweiligen Cluster abgespeichert
     * @param replaceData eingabe der neuen Daten.
     * @param strCluster in welchen Cluster sollen die Daten abgerufen werden.
     * @return Mehrdimensionalen Array wird zurückgeliefert, in diesem Fall
     *         wird der neue Cluster geliefert.
     */
    private double[][] initialisieren(String replaceData, String strCluster){
        //Trennen durch komma
        String[] splitData = replaceData.split(",");
        //Variablen
        double d1 = 0.0;
        double d2 = 0.0;
        double d3 = 0.0;
        double d4 = 0.0;
        //neue cluster
        double[][] cluster = null;

        //Cluster abfrage, welche cluster daten sollen abgerufen werden
        if (strCluster.equalsIgnoreCase("cluster1"))
            cluster = cluster1;
        if (strCluster.equalsIgnoreCase("cluster2"))
            cluster = cluster2;
        if (strCluster.equalsIgnoreCase("cluster3"))
            cluster = cluster3;

        //Einzeln daten filtern
        for (int i = 0; i < splitData.length; i++) {
            if (i == 0) {
                d1 = Double.parseDouble(splitData[i]);
            }
            if (i == 1) {
                d2 = Double.parseDouble(splitData[i]);
            }
            if (i == 2) {
                d3 = Double.parseDouble(splitData[i]);
            }
            if (i == 3) {
                d4 = Double.parseDouble(splitData[i]);
            }
            if (i >= 4) {
                break;
            }
        }
        //daten in ein Array übergeben
        double[] zsm = {d1, d2, d3, d4};
        //cluster soll nicht null sein
        assert cluster != null;
        //an der zaehler position kommen
        //die neuen Daten.
        cluster[zaehler] = zsm;
        //cluster zurückliefern
        return cluster;
    }

    /**
     * Der Zähler wird auf -1 ersetzt
     */
    private void resetZaehler(){
        if (zaehler >= 49){
            zaehler = -1;
        }
    }

    /**
     * Ausgabe
     * @param a Abstand von Block 1 und 2
     * @param a2 Abstand von Block 1 und 3
     * @param a3 Abstand von Block 2 und 3
     */
    public void ausgabe(double a, double a2, double a3){
        System.out.printf("d(cluster1, cluster2) = %.2f \n", a);
        System.out.printf("d(cluster1, cluster3) = %.2f \n", a2);
        System.out.printf("d(cluster2, cluster3) = %.2f \n", a3);
    }
}
