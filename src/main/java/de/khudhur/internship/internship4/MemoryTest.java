package de.khudhur.internship.internship4;

public class MemoryTest {

    public static void main(String[] args) {
        //Objekt von Memory erstellen
        Memory memory = new Memory();
        // die Methode generateField in ein 2D Array weisen
        int[][] list = memory.generateField(3);
        // Hilfsmethode für eine generierte Ausgabe
        memory.ausgabe(list);
    }

}
