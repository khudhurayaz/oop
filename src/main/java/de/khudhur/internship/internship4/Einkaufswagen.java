package de.khudhur.internship.internship4;

import java.util.ArrayList;
import java.util.List;

public class Einkaufswagen {

    //private liste für einkaufswagen
    private List<String> cart = new ArrayList<>();

    /**
     * Wenn es mehr als 5 Artikel sind,
     * wird ein entsprechendes ErrorIcons ausgegeben.
     * @param item Artikel im Einkaufswagen hinzufügen
     */
    public void addToCart(String item) {
        if (cart.size() >= 5) {
            System.err.println("Es haben leider nicht alle einen Platz! {" + item + "}"); //error
        }else {
            if (!item.equalsIgnoreCase(" ") && item.length() != 0){
                cart.add(item); //Add to cart
            }
        }
    }

    /**
     * Die Methode removeFromCart,
     * löscht eins ungewünschtes Artikel aus dem Einkaufswagen.
     * @param item Artikel aus dem Einkaufswagen löschen
     */
    public void removeFromCart(String item){
        cart.remove(item);//remove from cart
    }

    /**
     * Zeigt, welchen Artikel im Einkaufswagen sind
     */
    public void showContent(){
        for (String item : cart) { // alle items in cart
            System.out.println(item); // ausgabe einzeln Item
        }
    }

    /**
     * Die Einkaufsgröße übermitteln.
     */
    public void size(){
        System.out.println("Einkaufsgröße: " + cart.size());
    }

}
