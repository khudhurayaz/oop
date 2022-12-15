package de.khudhur.internship.internship8.Shopping;

/**
* @author Ayaz Khudhur
*/

public class ShoppingTest {


  public static void main(String[] args) {

    /**
    * Warenkorb
    * hier können wir unseren gekauften Artikeln speichern oder entfernen lassen.
    * warenkorb wird mit null initialisiert, ein produkt wird von jedem Artikel,
    * initialisiert und im warenkorb hinzugefügt.
    */
    Warenkorb warenkorb = new Warenkorb();
    Buch buch = new Buch(1, 32.71, 2011, "Max Mustermann", "Java das Buch");
    Buch buch2 = new Buch(2, 32.71, 2021, "Max Mustermann", "Java noch ein Buch");
    DVD dvd = new DVD(3, 14.95, "Java: Der Film", "Classic Collection", 2.21);
    Kleidung kleidung = new Kleidung(4, 8.93, "M", "T-Shirt", "blau");

    //Produkt hinzufügen und anzeigen
    warenkorb.addArtikel(buch);
    warenkorb.addArtikel(buch2);
    warenkorb.addArtikel(dvd);
    warenkorb.addArtikel(kleidung);
    System.out.println("Artikeln im Warenkorb hinzufügen: ");
    warenkorb.zeigeWarenkorb();
    System.out.println();

    //Entferne dvd Artikel aus dem Warenkorb und zeige Warenkorb
    warenkorb.removeArtikel(dvd);
    System.out.println("Artikel ("+dvd.getFilmtitel()+") im Warenkorb entfernen: ");
    warenkorb.zeigeWarenkorb();
  }

}