package de.khudhur.internship.internship4;

public class EinkaufswagenTest {

    public static void main(String[] args) {
        Einkaufswagen cart = new Einkaufswagen();
        System.out.println("Beispiel mit <= fünf Artikeln!");
        cart.addToCart("Birne");
        cart.addToCart("Salat");
        cart.addToCart("Paprika");
        cart.showContent();
        System.out.println("----------------");
        System.out.println("Entferne Salat!");
        cart.removeFromCart("Salat");
        cart.showContent();
        cart.size();

        System.out.println("\nMehr als fünf Artikeln:");
        cart.addToCart("Mandarine");
        cart.addToCart("Apfel");
        cart.addToCart("Traube");
        cart.addToCart("Orange");
        cart.addToCart("Honigmelone");
        cart.addToCart("Wassermelone");
        cart.showContent();
        cart.size();
    }

}
