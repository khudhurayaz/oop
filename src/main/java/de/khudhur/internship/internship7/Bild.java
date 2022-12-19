package de.khudhur.internship.internship7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Bild {

    //Später Entfernen!!!
    private static final String PATH = "src/main/java/de/khudhur/internship/internship7/";

    private int brightness;
    private String format;
    private String comment;
    private String fileName;
    private int[][] daten;


    /**
     * Aufgabe 7. Teil b) Verdrehte Bilder
     *      → try-catch block
     *          → Pfad für die eingegebenen dateinamen
     *              → abfrage ob, File lesbar ist
     *              → Ja, läuft das Program weiter
     *              → nein, gibt ein entsprechendes Exception aus
     *          → neue Scanner objekt erstellen
     *          → PGM-Format in format (von Typ String) speichern
     *              → abfrage ob, format P2 enthält
     *              → falls nicht, scanner schliessen und
     *                  geeignetes Exception auswerfen
     *                 → Exception: Programm unterstützt nur P2 Format
     *          → Restlichen Parametern von PGM Datei ablesen und abspeichern.
     *          → 2D Array ablesen und abspeichern in daten - von typ int
     *          → scanner schliessen
     *      → Falls, probleme auftauchen
     *          geeignetes Exception auswerfen
     *
     * @param dateiName um eine Datei zu lesen, benötigt das Programm der Dateiname
     * @throws Exception Exception abfangen, falls die .pgm Datei nicht lesbar ist oder
     *                   nicht existiert.
     */
    public void leseBild(String dateiName) throws Exception {
        //try-catch block
        try{
            //Pfad für dateiName
            Path path = Paths.get(PATH + dateiName);

            //abfrage ob, File lesbar ist
            if (!Files.isReadable(path))
                throw new Exception("ERROR: die Datei " + dateiName +
                                    ", kann nicht gelesen werden!");

            //Scanner um die Inhalte auszulesen
            Scanner in = new Scanner(path);

            //Format ablesen
            format = in.nextLine();

            //abfrage ob, format von typ P2 ist
            if (!format.equals("P2")) {
                in.close();
                throw new Exception("ERROR: Unterstützt nur P2 Dateien! Dateiname: "
                                    + dateiName);
            }

            //Restlichen parametern in Klasse Bild abspeichern
            comment = in.nextLine();
            /**
             * Variablen
             */
            int width = in.nextInt();
            int height = in.nextInt();
            brightness = in.nextInt();

            //Bild 2D Array von typ int ablesen und abspeichern
            //in daten variable
            daten = new int[height][width];
            for (int row = 0; row < height; row++) {
                for (int col = 0; col < width; col++) {
                    daten[row][col] = in.nextInt();
                }
            }

            //Scanner schliessen
            in.close();

        }catch (IOException e){
            throw new Exception("ERROR: kann die .pgm File " + dateiName
                                + " nicht lesen!" +
                                "\nMessage: " + e.getMessage() + "\nLocalizedMessage: "
                                + e.getLocalizedMessage() +
                                "\nCause: " + e.getCause());
        }
    }

    /**
     * Aufgabe 7. Teil c)
     * Die Klasse Bild wird um 2 Methoden erweitert.
     * Erste Methode ist schreibeBild(verzeichnis: String): void
     *  → daten - Überprüfung - 2D Array von Typ int
     *  → fileName / verzeichnis - String Variable
     *  → Pfad für verzeichnis
     *  → try-catch block und Exception geeignet abfangen
     *      → Pfad für fileName
     *      → abfrage ob, verzeichnis lesbar/vorhanden ist
     *          →ist vorhanden, wird die file datei entweder überschrieben
     *            (falls vorhanden)
     *              → oder wird eine neue Datei erstellt.
     *          → falls nicht erstelle ein neues Verzeichnis
     *      → abfrage ob, verzeichnis erstellt und Datei gelesen werden kann
     *      → erstelle ein StringBuilder
     *          → Alle parameter an StringBuilder übergeben
     *      → Files.write aufrufen
     *          → Ein Path pfad Angeben und ein parameter array von typ byte
     *              übergeben
     *  → Falls, probleme auftauchen
     *     geeignetes Exception auswerfen
     *
     * @param verzeichnis Verzeichnisname von Typ String
     * @throws Exception Exception abfangen, falls das Verzeichnis oder
     *                   .pgm Datei nicht lesbar oder schreibbar ist.
     */
    public void schreibeBild(String verzeichnis) throws Exception{
        //überprüfung
        if (daten == null)
            throw new Exception("Die Matrix-Daten müssen " +
                                "noch initialisiert werden!"); //error output

        this.fileName = new SimpleDateFormat("yyyy-MM-dd")
                            .format(Calendar.getInstance()
                                        .getTime())
                            + ".pgm";

        //path für verzeichnis
        Path dir = Paths.get(PATH + verzeichnis);

        try{
            //path für fileName
            Path path = Paths.get(PATH + dir.getFileName() + "\\" + fileName);

            //create directory
            if (!Files.isReadable(path))
                Files.createDirectories(dir);

            //Abfrage ob, File erstellt wurde und kann gelesen werden
            if (!Files.isReadable(dir))
                if (!Files.isWritable(path))
                    throw new Exception("ERROR: die Datei " + dir.getFileName()
                                        + "\\" + path.getFileName()
                                        + ", konnte entweder nicht " +
                                        "erstellt oder gelesen werden!");

            //Stringbuilder erstellen und alle .pgm parameter
            //übergeben
            StringBuilder builder = new StringBuilder();
            builder.append(getFormat());
            builder.append("\n");
            builder.append("#Created by Ayaz Khudhur");
            builder.append("\n");
            builder.append(getWidth() + " " + getHeight());
            builder.append("\n");
            builder.append(getBrightness());
            builder.append("\n");
            for (int i = 0; i < daten.length; i++) {
                for (int j = 0; j < daten[0].length; j++) {
                    builder.append(daten[i][j] + " ");
                    if(j < daten.length -1)
                        builder.append(" ");
                }
                builder.append("\n");
            }
            //Datei Überschreiben
            Files.write(path, builder.toString().getBytes());
        }catch (IOException e){
            throw new Exception("ERROR: kann die .pgm File {" + verzeichnis + "\\"
                                + getFileName() + "} nicht lesen!" +
                                "\nMessage: " + e.getMessage() + "\nLocalizedMessage: "
                                + e.getLocalizedMessage() +
                                "\nCause: " + e.getCause());
        }
    }

    /**
     * Aufgabe 7. Teil c)
     * Die Klasse Bild wird um 2 Methoden erweitert.
     * Zweite Methode ist rotiereBild(): void
     *      → Variablen
     *          → 2D Array von typ int - matrix
     *          → tRow von typ int
     *          → tCol von typ int
     *          → Temporäres 2D Array von typ int - rotatedMatrix
     *              -> mit der tRow, tCol größe
     *      → Rotieren - Schleife
     *          width um 1 reduzieren und subtrahieren mit aktuelle spalte,
     *          ergibt eine neue Zeile (id)
     *
     *          die Schleife wiederholt sich bis zeile und spalte die
     *          länge von matrix
     *          erreicht haben.
     *      → rotiertes 2D Array übergeben an daten
     */
    public void rotiereBild(){
        int[][] matrix = daten;
        //neue row, width von matrix wird übernommen
        int tRow = matrix[0].length;
        //neue col, height von matrix wird übernommen
        int tCol = matrix.length;
        //neues 2D Array
        int[][] rotatedMatrix = new int[tRow][tCol];

        //Rotieren
        for (int row = 0; row < matrix.length; row++)
            for (int col = 0; col < matrix[0].length; col++)
                rotatedMatrix[(tRow-1) - col][row] = matrix[row][col];

        //rotiertes matrix an daten [von typ int 2D Array] übergeben
        daten = rotatedMatrix;
    }

    /**
     * Ausgabe:
     * daten von Typ int - ein 2D Array
     * wird ausgegeben.
     */
    public void getDaten(){
        for (int[] ints : daten) {
            for (int j = 0; j < daten[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }

    //getFormat - Bild Format
    public String getFormat(){
        return format;
    }

    // getHeight - Bild Höhe
    public int getHeight() {
        return daten.length;
    }

    // getWidth - Bild Breite
    public int getWidth() {
        return daten[0].length;
    }

    // getBrightness - Bildhelligkeit
    public int getBrightness() {
        return brightness;
    }

    //.pgm Datei kommentare
    public String getComment(){
        return comment;
    }

    //Erstelltes .pgm Datei (nur Dateiname wird zurückgeliefert)
    public String getFileName(){
        return fileName;
    }

}