package de.khudhur.internship.internship11.adapter;

/**
 *  Die Klasse StackTest, testet die
 *  Adapter-Klasse und liefert bzw. testet ein paar
 *  Beispielen. Durch die Methode push(), hinzufüge ich
 *  3 Strings und gebe als erstes, ob der Adapter leer ist.
 *  Zweite Ausgabe, löscht den obersten Stack in diesem Fall
 *  'Stack (3)' und gibt, aus welche Stack gelöscht wurde.
 *  Die Dritte Ausgabe gibt das oberste Stack aus.
 * @author Ayaz Khudhur
 * @version 1
 */
public class StackTest {
    public static void main(String[] args) {
        //StackAdapter für String Klasse
        StackAdapter<String> stringStackAdapter = new StackAdapter<>();
        //Hinzufüge 3 Strings
        stringStackAdapter.push("Stack (1)");
        stringStackAdapter.push("Stack (2)");
        stringStackAdapter.push("Stack (3)");

        //Ausgabe
        System.out.println("Ist die Liste leer? " + stringStackAdapter.empty());
        System.out.println("Lösche das oberste Item: " + stringStackAdapter.pop());
        System.out.println("Liefere mir das oberste Item: " + stringStackAdapter.peek());
    }
}
