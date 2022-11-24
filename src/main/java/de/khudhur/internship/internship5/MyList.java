package de.khudhur.internship.internship5;

public class MyList {

    private int[] array; //neues liste
    private int size; // array size
    private int capacity; //array Kapazität
    private int index; //index wert speichern

    /**
     * Konstruktor mit standard werten
     */
    public MyList(){
        array = new int[1];
        size = 0;
        capacity = 1;
    }

    /**
     * addToList methode, erwartet 2 Integer variablen
     * Aufgabenteil: a) Klasse Liste - Element Hinzufügen
     * @param index array position
     * @param item array item
     */
    public void addToList(int index, int item) {
        this.index = index; //position abspeichern

        //abfrage ob index größer als array länge ist
        if (index > array.length || index < 0) {
            System.err.println("index darf nicht größer/kleiner als array.length sein!");
            return;
        }

        //wenn array größe == array Kapazität ist,
        //wird eine Hilfsmethode um array dynamisch um eins
        // zu vergrößern.
        if (size == capacity){
            increase();
        }

        //wird geprüft ob index == 0 ist,
        //um den ersten index im array zu speichern
        if (index == 0){
            //array[position] = item
            array[index] = item;
            //array größe um eins erweitern
            size++;
        }else {
            //andernfalls, wird der Array verlängert und eins
            //nach rechts verschoben. Außerdem entfernt alle nullen
            setArray(removeAllZeros(extend(array, index, item)));
        }

    }

    /**
     *
     * @param a int[] array, um es zu erweitern und nach rechts verschieben
     * @param index array position
     * @param key array item
     * @return item an der index Stelle positioniert ist und array um eins erhöht
     */
    private int[] extend(int[] a, int index, int key) {
        // befindet sich an index Stelle nullen, somit wird
        // der Methode returniert und liefert null.
        if (index < 0) return null;
        // neues Array, mit der länge der übergebene
        // Array.
        int[] result = new int[a.length + 1];

        //for-schleife
        for (int i = 0, j = 0; i < a.length; i++, j++)
        {
            if (i == index) {
                result[j] = key;
                j++;
                size++;
            }
            result[j] = a[i];
        }
        return result;
    }

    /**
     * Aufgabenteil: b) Klasse Liste - Element Entfernen
     * @param index Welches Element entfernt werden soll
     * @return Als rückgabewert, ist das entfernte Element
     */
    public int removeFromList(int index){
        //falls index > als array länge ist,
        //wirft ein null zurück, um den Vorgang zu beenden
        if (index > array.length) return 0;
        //Welches Element entfernt wurde,
        //wird im Temp gespeichert.
        int temp = array[index];

        //neues array erstellen
        int[] tempArray = new int[array.length];
        //in die neue array, alles speichern außer,
        // index.
        for (int i = 0; i < array.length; i++) {
            if (i != index){
                //im neuen array speichern
                tempArray[i] = array[i];
            }
        }
        //in array überschreiben und alle nullen entfernen
        setArray(removeAllZeros(tempArray));
        //entfernte Element
        return temp;
    }

    /**
     * Aufgabenteil: c) Klasse Liste - Duplikate Entfernen
     * @return Wie viele Duplikate entfernt wurden.
     */
    public int removeDuplicates(){
        //Duplikat Anzahl
        int remove = 0;
        int elements = array.length;

        //Finde Duplikate und lösche es
        for (int i = 0; i < elements-1; i++) {
            for (int j = i+1; j < elements; j++) {
                if ((array[i] == array[j]) && ( i != j)){
                    //um eins erhöhen, Anzahl der entfernten Elemente
                    remove++;
                }
                //löschen und um eins reduzieren
                if (array[i] == array[j]){
                    array[j] = array[elements-1];
                    elements--;
                    j--;
                }
            }
        }


        //changing original array
        size = (size - remove);
        capacity = (capacity - remove);
        //Neuen Elementen überschreiben
        int[] newArray = new int[elements];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = array[i];
        }
        //neues array mit der alten array überschreiben.
        setArray(removeAllZeros(newArray));
        return remove;
    }


    /**
     *Aufgabenteil: d) Klasse Liste - Elementen Sortieren
     */
    public void sortList() {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                //wenn i große als j ist
                if (array[i] > array[j]) {
                    //in ein const variable speichern
                    int temp = array[i];
                    //j in i zuweisen
                    array[i] = array[j];
                    //temp in j zuweisen
                    array[j] = temp;
                }
            }
        }
        setArray(removeAllZeros(array));
    }

    /**
     * Hilfsmethode
     * @param tempArray Ein Array, um nullen zu entfernen
     * @return Neues Array ohne nullen
     */
    private int[] removeAllZeros(int[] tempArray) {
        //länge ohne nullen finden
        int len = 0;
        for (int i = 0; i < tempArray.length; i++) {
            //alles was nicht null ist
            if (tempArray[i] != 0){
                len++;//eins erhöhen
            }
        }

        //neues array, mit richtigem länge
        int[] nArray = new int[len];
        for (int i = 0, j =0; i < tempArray.length; i++){
            if (tempArray[i] != 0){
                //überschreiben
                nArray[j] = tempArray[i];
                //Spalte erhöhen um eins
                j++;
            }
        }
        //neues Array
        return nArray;
    }

    /**
     * Hilfsmethode
     *
     * Array wird dynamisch!
     * Sobald die methode aufgerufen wird, wird der aktuelle Array um eins erhöht.
     */
    private void increase() {
        //neues array
        int[] temp = null;
        //prüfe ob array größe und kapazität
        //gleich sind
        if (size == capacity){
            //neues array mit kapazität + 1,
            //wird initialisiert.
            temp = new int[capacity+1];
            if (capacity > 0) { //kapazität größer als null
                for (int i = 0; i < array.length; i++) {
                    //neues array überschreiben
                    temp[i] = array[i];
                }
            }
        }

        //array überschreiben
        array = temp;
        //kapazität um eins erhöhen
        capacity++;
    }

    /**
     * @return aktuelle Array wird zurückgeliefert
     */
    public int[] getArray(){
        return array;
    }

    /**
     * @param array erwartung eines Array
     */
    public void setArray(int[] array) {
        this.array = array;
    }

}
