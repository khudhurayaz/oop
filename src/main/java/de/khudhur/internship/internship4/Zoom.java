package de.khudhur.internship.internship4;

public class Zoom {

    private int[][] pixelPicZoom; //originalbild
    private int[][] pixelPicOrg; //skaliertes Bild
    private int f; //faktor

    /**
     * Leeres Konstruktor, ist nicht notwendig
     */
    public Zoom(){}

    /**
     * Konstruktor mit Parameter
     * @param pixelPicOrg Originalbild, welches skalieren soll
     */
    public Zoom(int[][] pixelPicOrg){
        //Initialisierung
        this.pixelPicOrg = pixelPicOrg;
    }

    public int[][] zoom(int f) {
        //Prüfe, ob f kleiner als eins ist
        if (f <= 1){ //true
            return null; //ist der Array null
        }
        //Ansonsten, faktor f initialisieren
        this.f = f;
        //pixelPicZoom initialisieren
        pixelPicZoom = new int[pixelPicOrg.length*f][pixelPicOrg.length*f];
        
        //prüfen
        if (pruefen(pixelPicOrg)){
            //Fehlermeldung
            System.err.println("Es sollen nur Bilder mit Grauwerten im Bereich[0,7] enthalten!");
            return null; //Array ist null
        }

        //skaliertes Bild ersetzen
        setPixelPicZoom(duplicateElement(pixelPicOrg));

        //Ausgabe skaliertes Bild!
        return getPixelPicZoom();
    }

    /**
     * @param pixelPicOrg originalbild wird erwartet
     * @return ob die bedienung für die Grauwerte zu treffen
     */
    private boolean pruefen(int[][] pixelPicOrg) {
        for (int i = 0; i < pixelPicOrg.length; i++) {
            for (int j = 0; j < pixelPicOrg[0].length; j++) {
                //Prüfe, ob nicht die werte größer oder gleich 8 sind
                //sowie, ob die werte nicht negativ sind
                if (pixelPicOrg[i][j] >= 8 || pixelPicOrg[i][j] < 0) return true;
            }
        }
        return false;
    }

    /**
     * @param elements erwartet ein 2D Array
     * @return skaliertes Bild wird zurückgegeben
     */
    public int[][] duplicateElement(int[][] elements){
        int[][] duplicate = getPixelPicZoom();//variable

        for (int i = 0; i < elements.length; i++) {
            for (int j = 0; j < elements[i].length; j++) {
                int temp = elements[i][j];//aktuelle wert Speichern
                //zeile * faktor für die Zeilenbestimmung -
                //spalte * faktor + 1 für die Spaltenbestimmung - wert wird übergeben
                //danach wird der aktuelle wert in die neue
                //zeile und spalte übergeben. Erste!
                duplicate[i*f][j*f+1] = elements[i][j];
                //Abwechselung, jedoch zuständig für die zweite Spalte
                duplicate[i*f+1][j*f] = elements[i][j];

                //erste spalte, wird befüllt
                duplicate[i*f][j*f] = temp;
                //zweite zeile, wird befüllt
                duplicate[i*f+1][j*f+1] = temp;
            }
        }
        //skaliertes array zurückliefern
        return duplicate;
    }


    //Getter für skaliertes Bild
    public int[][] getPixelPicZoom() {
        return pixelPicZoom;
    }
    //Setter für skaliertes Bild
    public void setPixelPicZoom(int[][] pixelPicZoom) {
        this.pixelPicZoom = pixelPicZoom;
    }
    //Getter für Originalbild
    public int[][] getPixelPicOrg() {
        return pixelPicOrg;
    }
    //Setter für Originalbild
    public void setPixelPicOrg(int[][] pixelPicOrg) {
        this.pixelPicOrg = pixelPicOrg;
    }

}
