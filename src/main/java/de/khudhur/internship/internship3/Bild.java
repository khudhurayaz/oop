package de.khudhur.internship.internship3;

public class Bild {

    private int[][] bild; //Zweidimensionales Array

    /**
     * @return neues Array wird zurückgeliefert
     */
    private int[][] flipAndInvert(){
        int row = bild.length; //Zeile
        int column = bild[0].length; //Spalte
        int[][] copyArray = copy(bild); //temporer

        // Umwandeln von Weiß auf Schwarz
        // Weiß = 1, Schwarz = 0
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (bild[i][j] == 1){ //wenn es Weiß ist umwandeln in Schwarz
                    copyArray[i][j] = 0; //BLACK
                }else { //Ansonsten, wenn es Schwarz ist, umwandeln in Weiß
                    copyArray[i][j] = 1; //WHITE
                }
            }
        }

        for (int i = 0; i < copyArray.length; i++) {
            for (int j = 0; j < copyArray[i].length; j++) {
                int[] temp = copyArray[i];
                copyArray[i] = copyArray[copyArray.length-i-1];
                copyArray[copyArray.length-i-1] = temp;
            }
        }

        return copyArray;
    }

    public void ausgabe(){
        //Überprüfe, ob ein binäres Bild enthält
        if (bild == null) {
            System.err.println("Bitte übergebe ein binäres Bild!");
            return;
        }

        //Ausgabe Original
        System.out.println("Originalbild");
        arrayAusgabe(getBild());

        //Ausgabe nach flipAndInvert
        System.out.println("\nBild nach flipAndInvert()");
        setBild(flipAndInvert());
        //arrayAusgabe(getBild());
        //Flip, plätze tauschen, nur Zeilen
        for (int i = 0; i < getBild().length; i++) {
            for (int j = 0; j < getBild()[i].length; j++) {
                System.out.print(getBild()[getBild().length - i - 1][j] + " ");
            }
            System.out.println();
        }
    }



    /**
     * @param array erwartung eines array um es zu Kopieren
     * @return neues array wird zurückgeliefert
     */
    private int[][] copy(int[][] array){
        int row = array.length; //Zeile
        int column = array[0].length; //Spalte
        int[][] tempArray = new int[row][column]; //temporer

        //array kopieren
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                tempArray[i][j] = array[i][j];
            }
        }
        //Rückgabe des kopierten array
        return tempArray;
    }

    /**
     * Array Ausgabe
     * @param tmpArray erwartung eines Array um es auszugeben
     */
    private void arrayAusgabe(int[][] tmpArray){
        for (int i = 0; i < tmpArray.length; i++) {
            for (int j = 0; j < tmpArray[i].length; j++) {
                System.out.print(tmpArray[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * @return binäres Bild wird zurückgeliefert
     */
    public int[][] getBild() {
        return bild;
    }

    /**
     * @param bild erwartung eines binäres Bild
     */
    public void setBild(int[][] bild) {
        this.bild = bild;
    }
}
