package de.khudhur.internship.internship9.OOPCode;

/**
 * Codes - eine generische Klasse
 * in der codes Klasse wird hauptsächlich,
 * für mehrdimensionale Arrays angewendet.
 * <br>
 * → Ausgabe eines 2D Array
 * → Eingabe eines 2D Array
 *
 * @version 1.0
 * @author Ayaz Khudhur
 * @param <T> akzeptiert jedes Typ's
 */
public class Codes<T> {

    /**
     * Ein Mehrdimensional Array von typ T
     */
    T[][] typ;

    /**
     * Leeres Konstruktor
     */
    Codes(){

    }

    /**
     * Konstruktor erwartung mit 2D von irgendein Typ T
     * @param typ 2D Typ von T
     */
    Codes(T[][] typ) {
        this.typ = typ;
    }

    /**
     * Methode setCode
     * um ein Wert zu ändern kann man
     * mit dieser Methode machen.
     * <br>
     * Die Methode erwartet, einen zustandswert,
     * um es bei der Konstruktor angegebenes 2D
     * Array zu Speichern.
     *
     * @param t zustandswert verändert (falls die Daten vorhanden sind)
     *          oder fügt an der i, j stelle die daten, über
     *          Typ t ein.
     */
    public void setCode(T t){
        //for-schleife aussen
        for (int i = 0; i < typ.length; i++) {
            //for-schleife innen
            for (int j = 0; j < typ[0].length; j++) {
                //wert an der Position i, j speichern
                typ[i][j] = t;
            }
        }
    }

    /**
     * Methode setCode - Überlagern der setCode Methode
     * <br>
     * die Methode überlagert der setCode Methode, falls
     * man mit x, y, Wert arbeiten möchte und selbst tragen
     * will.
     *
     * @param x position an der x stelle
     * @param y position an der y stelle
     * @param b zustandswert an der x, y position
     */
    public void setCode(int x, int y, T b){
        typ[x][y] = b;
    }

    /**
     * @return 2D Array von typ T
     */
    public T[][] getCode(){
        return typ;
    }

    /**
     * Die Methode gibt die Ausgabe eins
     * 2D Array aus.
     *
     * @param code 2D Array von Typ T
     */
    public void print(T[][] code){
        for (T[] ts : code) {
            for (int j = 0; j < code[0].length; j++) {
                System.out.print(ts[j] + " ");
            }
            System.out.println();
        }
    }

}
