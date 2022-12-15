package de.khudhur.internship.internship8.Shopping;

/**
 * @version 1.0
 * @author Ayaz Khudhur
 */

public class Artikel{

  //Variablen
  private int artikelNummer;
  private double nettoPreis;

    /**
     * Der Konstruktor ist mit zwei
     * Parametern verfügbar. Die Parameter
     * werden gespeichert, um von unterklassen verarbeitet
     * werden.
     *
     * @param artikelNummer artikelnummer von einem Produkt, dies kann
     *                      random oder selbst angegeben werden.
     * @param nettoPreis nettoPreis von einem Produkt, ohne Steuern
     */
  public Artikel(int artikelNummer, double nettoPreis){
    this.artikelNummer = artikelNummer;
    this.nettoPreis = nettoPreis;
  }

  /**
  * Gilt für alle Unterklassen:
  * um Bruttowert zu rechnen, wird in einer int final Variable die
  * MEHRWERT gespeichert. Die nettopreis wird mit
  * 1 + MEHRWERT - multipliziert, dadurch wird der gewünschte Bruttopreis errechnet.
  */
  public double getPreis(){
    return nettoPreis;
  }

  /**
   * Für die unterklassen wird die Methode
   * getInfo() zu verfügung gestellt. Um
   * die informationen aus den jeweiligen Klassen
   * zu bekommen.
   * @return ein string wird zurückgeliefert
   *         hier wird die infos der Klassen
   *         ausgegeben.
   */
  public String getInfo(){
    return "";
  }

  /**
   * @return artikelnummer wird zurückgeliefert
   */
  public int getArtikelNummer() {
  return artikelNummer;
  }

  /**
   * @param artikelNummer artikelnummer wird festgelegt
   */
  public void setArtikelNummer(int artikelNummer) {
  this.artikelNummer = artikelNummer;
  }

  /**
   * @return Netto Preis wird zurückgeliefert
   */
  public double getNettoPreis() {
  return nettoPreis;
  }

  /**
   * @param nettoPreis nettoPreis wird festgelegt
   */
  public void setNettoPreis(double nettoPreis) {
  this.nettoPreis = nettoPreis;
  }

}