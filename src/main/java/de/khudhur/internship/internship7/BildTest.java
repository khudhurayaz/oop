package de.khudhur.internship.internship7;

public class BildTest {

    public static void main(String[] args) throws Exception {

     //Objekt von Bild erstellen
     Bild bild = new Bild();

     //Bild Format PGM-Format auslesen von java.pgm datei
     System.out.println("Lesen: ");
     //bild lesen
     bild.leseBild("java.pgm");
     //Attributen ausgeben
     System.out.println("Format: " + bild.getFormat());
     System.out.println("Kommentare: " + bild.getComment());
     System.out.println("Höhe: " + bild.getHeight());
     System.out.println("Breite: " + bild.getWidth());
     System.out.println("Helligkeit: " + bild.getBrightness());
     //Daten ausgeben
     bild.getDaten();

     //Bild schreiben und rotieren um 90°
     System.out.println("\nDatei ausgeben: ");
     //zuerst rotieren, um speichern zu können
     //man könnte auch rotieren und auslesen die Daten werden im Horizontal
     //mehr sein als vertikal
     bild.rotiereBild();
     bild.rotiereBild();
     bild.rotiereBild();
     //Bild im verzeichnis speichern
     bild.schreibeBild("verzeichnis");

     //Neues Bild auslesen
     bild.leseBild("verzeichnis/"+bild.getFileName());
     //Attributen von neuer PGM-Datei ausgegeben.
     System.out.println("Format: " + bild.getFormat());
     System.out.println("Kommentare: " + bild.getComment());
     System.out.println("Höhe: " + bild.getHeight());
     System.out.println("Breite: " + bild.getWidth());
     System.out.println("Helligkeit: " + bild.getBrightness());
     //Daten ausgeben
     bild.getDaten();

    }


}
