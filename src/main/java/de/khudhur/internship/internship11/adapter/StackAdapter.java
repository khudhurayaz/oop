package de.khudhur.internship.internship11.adapter;

import java.util.ArrayList;

/**
 * StackAdapter Klasse
 * <br>
 * Die StackAdapter Klasse hat intern eine ArrayList,
 * die es intern die Daten speichert.
 * <br>
 * Die Klasse beinhaltet 4 internen Methoden, um ein Stack zu
 * verwalten.
 * <br>
 * @param <T> egal von welchem Typ es sich handelt.
 */
public class StackAdapter<T>{

    //interne ArrayList
    private final ArrayList<T> list;

    /**
     * Konstruktor die es list initialisiert
     */
    public StackAdapter() {
        list = new ArrayList<>();
    }

    /**
     * @return liefert true, wenn die Liste leer ist,
     *         ansonsten ist false.
     */
    public boolean empty() {
        return list.isEmpty();
    }

    /**
     * @param item nimmt das Item in der Liste auf
     * @return Gibt das Item wieder als Typ T zurück.
     */
    public T push(T item) {
        list.add(item);
        return item;
    }

    /**
     * @return Löscht das oberste Item und gibt es zurück,
     *         welches item gelöscht wurde.
     */
    public T pop() {
        if (empty()) {
            throw new RuntimeException("Stack is empty");
        }
        return list.remove(list.size() - 1);
    }

    /**
     * @return Liefert das oberste Item zurück
     */
    public T peek() {
        if (empty()) {
            throw new RuntimeException("Stack is empty");
        }
        return list.get(list.size() - 1);
    }
}
