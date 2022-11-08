package de.khudhur.internship.internship3;

public class Bild {

    private int[][] bild; //Zweidimensionales Array


    /**
     * @return neues Array wird zurückgeliefert
     */
    private Bild flipAndInvert(){
        int row = bild.length; //Zeile
        int column = bild[0].length; //Spalte
        int[][] copyArray = copy(bild); //temporär
        Bild tempBild = new Bild(); //Neues Bild objekt erstellen

        // Umwandeln von Weiß auf Schwarz
        // Weiß = 1, Schwarz = 0
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                //wenn es Weiß ist umwandeln in Schwarz
                if (bild[i][j] == 1){
                    copyArray[i][j] = 0; //BLACK
                }
                //Ansonsten, wenn es Schwarz ist, umwandeln in Weiß
                else {
                    copyArray[i][j] = 1; //WHITE
                }
            }
        }

        int[][] newArray = new int[row][column];
        //reverse copyArray
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                int[] temp = copyArray[i];
                newArray[i][j] = copyArray[copyArray.length-i-1][j];
                newArray[copyArray.length-1-i] = temp;
            }
        }

        //binäres und flipAndInvert bild übergeben
        tempBild.setBild(newArray);
        return tempBild;
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
        Bild tempBild = flipAndInvert();
        setBild(tempBild.getBild());
        arrayAusgabe(getBild());
    }

    /**
     * @param array erwartung eines array um es zu Kopieren
     * @return neues array wird zurückgeliefert
     */
    private int[][] copy(int[][] array){
        int row = array.length; //Zeile
        int column = array[0].length; //Spalte
        int[][] tempArray = new int[row][column]; //temporär

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
