package de.khudhur.internship.internship9.OOPCode;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * OOPCode
 *
 * @version 1.0
 * @author Ayaz Khudhur
 */
public class OOPCode {

    //NxN feldern
    private int size;
    private int anzahlRotationen;

    /**
     * Wrapper Klasse von Typ Integer
     * in diesem Wrapper 2D Array speichere
     * ich die errechneten feldern ab.
     */
    private Integer[][] data;

    /**
     * Wrapper Klasse von Typ Boolean
     * in diesem 2D Array speichere ich,
     * wenn ein pixel Schwarz ist, wird mit
     * true belegt. Für die spätere Programmierung kann man
     * sehen welches feld schon belegt ist. Dies ist
     * wichtig um zu wissen an welche stelle ein Black
     * Pixel ist, für die berechnung ist sehr hilfreich.
     */
    private Boolean[][] bool;

    /**
     * Image wird in der Klasse BufferedImage gespeichert,
     * es gibt in dieser Klasse eine Methode wie man rgb bekommt.
     * RGB sind wichtig um es herauszufinden können, ob ein Pixel
     * Schwarz ist oder nicht.
     */
    private BufferedImage image;
    private String endung;

    /**
     * Konstruktor für einen BufferedImage
     * @param path erwartet ein pfad zum einen Bild
     */
    public OOPCode(String path) throws Exception {
        //in path die endung mit punkt zu finden
        int lastDotIndex = path.lastIndexOf(".");
        //prüfen ob, endung nicht -1 beinhaltet
        if (lastDotIndex != -1)
            //ist nicht der fall, speichere die Endung
            endung = path.substring(lastDotIndex + 1);

        //Abfrage ob, endung ein dieser Formate nicht enthält.
        assert endung != null;
        if (!endung.equalsIgnoreCase("png")
                && !endung.equalsIgnoreCase("jpg")
                && !endung.equalsIgnoreCase("jpeg"))
            //ist dies der Fall, gib ein entsprechendes fehler aus
            throw new Exception("Programm Unterstützt " +
                                "folgendes Formate [.png, jpg, jpeg]!");

        //Image lesen
        try {
            this.image = ImageIO.read(new File(path));
        } catch (IOException e) {
            throw new Exception("Bild konnte nicht gelesen werden!" +
                    "\nNachricht: " + e.getMessage() +
                    "\nLokalisiertes Nachricht: " + e.getLocalizedMessage() +
                    "\nUrsache" + e.getCause());
        }

        //data & bool mit image.getWidth und image.getHeight initialisieren
        data = new Integer[image.getWidth()][image.getHeight()];
        bool = new Boolean[image.getWidth()][image.getHeight()];
        anzahlRotationen = 0;
        //alle boolean werte mit false initialisieren
        new Codes<>(bool).setCode(false);

    }

    /**
     * Konstruktor für Zahlen
     * @param size erwartet ein N, um daraus ein NxN feldern zu
     *             erstellen.
     */
    public OOPCode(int size){
        //size abspeichern
        this.size = size;
        //data & bool initialisieren
        data = new Integer[size][size];
        bool = new Boolean[size][size];
        //alle booleschen werten mit false initialisieren
        new Codes<>(bool).setCode(false);
    }

    /**
     * durch den angegebenes Image errechnen wir
     * einzelne Werte. Für die ARGB (Alpha, Rot, Grün und Blau)
     * wird ein Farbwert zu einem 32-Bit-Wert bestehen aus 8 Bit
     * pro Farbkanal.
     *                    3        2         1        0
     * bit position    10987654 32109876 54321098 76543210
     * ------------   +--------+--------+--------+--------+
     * bits           |........|RRRRRRRR|GGGGGGGG|BBBBBBBB|
     *
     * @param p erwartet einen Pixel int, um daraus die
     *          argb zu errechnen.
     * @return ob schwarz vorhanden ist oder nicht
     */
    private boolean argb(int p){
        //für alpha, dies wird nicht benutzt, jedoch kann
        //man auch mitspeichern, falls man später
        //mit dem Programm die transparent eines Bildes
        //erhalten und verändern möchte.

        int a = (p >> 24) & 0xff;
        //für rot
        int r = (p >> 16) & 0xff;
        //für grün
        int g = (p >> 8) & 0xff;
        //für blau
        int b = (p) & 0xff;
        //abfrage ob, r, g und b 0 beinhalten,
        //ja? gib true zurück
        return r == 0 && g == 0 && b == 0;
    }

    /**
     * In der getImage() methode
     * errechnen bzw. erhalten wir sowie in
     * der getCode() methode die errechnete werte
     * für schwarzen Pixel, jedoch wird separat
     * in eine 2D Array gespeichert, welches
     * pixel schwarz ist, wird mit true belegt.
     */
    public void getImage(){
        //image width
        int w = image.getWidth();
        //image height
        int h = image.getHeight();
        //ausgabe
        System.out.printf("width: %s height: %s", w, h + "\n");

        //Werte für Schwarzen feldern
        int k = (int)Math.pow(2, ((w * h) - 1));
        //for-schleife
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                //pixel von jeweiligen bild erhalten
                int pixel = image.getRGB(j, i);
                //abfrage ob, true geliefert ist,
                //wenn schwarze pixel gefunden wurde.
                if(argb(pixel))
                    //setze an der pos[i][j] true ein
                    getBool()[i][j] = true;
                //für data die errechnete Zahl ein
                getData()[i][j] = k;
                //k um 2 dividieren
                k /= 2;
            }
        }
    }

    /**
     * rotiereBild(): void
     *      → Variablen
     *          → 2D Array von typ Integer - matrix
     *          → tRow von typ int
     *          → tCol von typ int
     *          → Temporäres 2D Array von typ Integer - rotatedMatrix
     *              -> mit der tRow, tCol größe
     *      → Rotieren - Schleife
     *          width um 1 reduzieren und subtrahieren mit aktuelle spalte,
     *          ergibt eine neue Zeile (id)
     *          die Schleife wiederholt sich bis zeile und spalte die
     *          länge von matrix
     *          erreicht haben.
     *      → rotiertes 2D Array übergeben an daten
     *      (Weil ich die Methode schon geschrieben habe,
     *      habe ich einfach kopiert! (Praktikum 7 - Bild .pgm files))
     */
    public void rotiereBild(){

        //neue row, width von matrix wird übernommen
        int tRow = data[0].length;
        //neue col, height von matrix wird übernommen
        int tCol = data.length;
        //neues 2D Array
        Boolean[][] b = new Boolean[tRow][tCol];

        //Rotieren
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[0].length; col++) {
                b[col][(tCol - 1) - row] = getBool()[row][col];
            }
        }

        //setBool
        setBool(b);
    }

    /**
     * Methode encode um daraus ein
     * OOPCode zu bekommen.
     * @return die OOPCode wird zurückgeliefert
     */
    public int encode(){
        //summe für OOPCode
        int sum = 0;
        //for-schleife aussen
        for (int i = 0; i < getData().length; i++) {
            //fo-schleife innen
            for (int j = 0; j < getData()[0].length; j++) {
                //abfrage welches Boolean an i, j stelle
                //true liefert, (true für schwarz)
                if (bool[i][j]){
                    //daten auslesen und aufsummen
                    sum += getData()[i][j];
                }
            }
        }
        //Rückgabe der OOPCode
        return sum;
    }

    /**
     * in der Methode bigEncode
     * kann ich die größte OOPCode herausfinden
     * und anzahl an notwendigen Rotationen
     * @return die Größte OOPCode eines Objekt von typ
     *         OOPCode.
     */
    public int bigEncode(){
        //summe
        int sum = 0;
        //anzahl an Rotationen
        int az = 0;
        //erstes encode
        int first = encode();

        //while schleife
        while(true){
            //aktuelle encode
            int current;
            //erstmal rotieren
            rotiereBild();
            //encode abrufen
            current = encode();
            //prüfen ob, aktuelle encode
            //größer als die summe für endcode ist
            if (current > sum){
                //ja, speichern
                sum = current;
                //anzahl an Rotationen erhöhen
                az++;
            }

            //abgleich ob, erste endocde
            //mit der aktuelle endcode übereinstimmt
            if (first == current){
                //ja, unterbreche es
                break;
            }
        }
        //anzahl an Rotationen setzen
        setAnzahlRotationen(az);
        //größte endcode zurückliefern
        return sum;
    }

    /**
     * Falls, man mit Zahlen anstatt Bildern arbeiten
     * möchte. Jedoch muss die Größe (size) angegeben sein.
     *
     * @return 2D Array die Daten für NxN feldern
     */
    public Integer[][] getCode(){
        //wenn ein feld 2^(size x size -1) ist
        int k = (int)Math.pow(2, ((getSize() * getSize()) - 1));
        //for-schleife aussen
        for (int i = 0; i < data.length; i++) {
            //for-schleife innen
            for (int j = 0; j < data[0].length; j++) {
                //berechnung anstelle x(i), y(j) setzen
                data[i][j] = k;
                //dividieren mit 2
                k /= 2;
            }
        }
        //daten zurückliefern
        return data;
    }

    // Größe für NxN feldern
    public Integer getSize(){
        return size;
    }

    //getData
    public Integer[][] getData(){
        return data;
    }

    /**
     * @param data OOPCode data überschreiben oder
     */
    public void setData(Integer[][] data) {
        this.data = data;
    }

    /**
     * @return boolean an welche stelle ein Schwarzes Eintrag gibt
     */
    public Boolean[][] getBool(){
        return bool;
    }

    /**
     * @param b 2D Array von Typ Boolean Ersetzen
     */
    public void setBool(Boolean[][] b){
        this.bool = b;
    }

    /**
     * @return wie viel mal rotiert wurde, um den Größten OOPCode
     *         zu finden.
     */
    public int getAnzahlRotationen() {
        return anzahlRotationen;
    }

    /**
     * @param anzahlRotationen wie viel mal rotiert wurde
     */
    public void setAnzahlRotationen(int anzahlRotationen) {
        this.anzahlRotationen = anzahlRotationen;
    }

}