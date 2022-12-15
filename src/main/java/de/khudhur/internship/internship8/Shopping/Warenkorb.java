package de.khudhur.internship.internship8.Shopping;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * @version 1.0
 * @author Ayaz Khudhur
 */
public class Warenkorb {

  //Variable ArrayList - artikelListe
  private ArrayList<Artikel> artikelListe = new ArrayList<Artikel>();

  /**
   * @param artikel Artikeln hinzufügen
   */
  public void addArtikel(Artikel artikel){
    artikelListe.add(artikel);
  }

  /**
   * @param artikel Artikeln aus der Liste entfernen
   */
  public void removeArtikel(Artikel artikel){
    artikelListe.remove(artikel);
  }

  /**
   * ZeigeWarenkorb
   *
   * double variable für gesamtPreis
   * for schleife
   *  -> artikel preise summieren
   *
   * for schleife
   *  -> Artikel getInfo methode aufrufen
   *
   * Gesamtpreis ausgeben und zweistellen nach komma
   * ausgeben
   */
  public void zeigeWarenkorb(){
    //variable für gesamte Preis
    double gesamtPreis = 0.0;
    //Preise in der double variable addieren
    for (Artikel artikel : artikelListe) {
      gesamtPreis += artikel.getPreis();
    }

    //getInfo methode aufrufen
    for(Artikel artikel : artikelListe){
      System.out.println(artikel.getInfo());
    }

    //ausgabe der Gesamt einkaufen
    System.out.println("Gesamtpreis: " +
                       new DecimalFormat("##.00").format(gesamtPreis) 
                      + " Euro");
  }

}