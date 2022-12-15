package de.khudhur.internship.internship8.Shopping;

import java.text.DecimalFormat;

/**
 * @version 1.0
 * @author Ayaz Khudhur
 */
public class Buch extends Artikel{

  //Variablen
  private String autor;
  private String buchtitel;
  private int erscheinungsjahr;
  //Mehrwertsteuersatz
  private final double MEHRWERT = 0.07;

  /**
   * Konstruktor
   * die erforderlichen Variablen werden an die Super
   * Klasse weitergeleitet.
   * Restlichen Variablen werden mit null initialisiert.
   *
   * @param artikelNummer artikelNummer wird übergeben
   * @param nettoPreis nettoPreis wird übergeben
   */
  public Buch(int artikelNummer, double nettoPreis){
    super(artikelNummer, nettoPreis);
    autor = "";
    buchtitel = "";
    erscheinungsjahr = 0;
  }

  /**
   * Konstruktor mit zusätzlichen Parametern.
   * Alle Variablen werden beim Konstruktor aufruf
   * initialisiert.
   *
   * @param artikelNummer artikelNummer wird übergeben
   * @param nettoPreis nettoPreis wird übergeben
   * @param erscheinungsjahr erscheinungsjahr wird übergeben
   * @param autor autor wird übergeben
   * @param buchtitel buchtitel wird übergeben
   */
  public Buch(int artikelNummer, double nettoPreis, int erscheinungsjahr, String autor, String buchtitel){
    super(artikelNummer, nettoPreis);
    this.autor = autor;
    this.buchtitel = buchtitel;
    this.erscheinungsjahr = erscheinungsjahr;
  }

  /**
   * @return Bruttopreis wird zurückgeliefert
   */
  @Override
  public double getPreis(){
    return (getNettoPreis() * (1+MEHRWERT));
  }

  /**
   * @return informationen der Klasse Buch wird
   *         zurückgeliefert. Wie in der Aufgaben-
   *         beschreibung steht.
   */
  @Override
  public String getInfo(){
    return "Buch - " + getAutor() + ", " 
      + getBuchtitel() + " ("+getErscheinungsjahr()+") "
      + " : " + new DecimalFormat("##.00").format(getPreis()) + " Euro";
  }

  /**
   * @return getAutor name
   */
  public String getAutor() {
  return autor;
  }

  /**
   * @param autor autor wird festgelegt
   */
  public void setAutor(String autor) {
  this.autor = autor;
  }

  /**
   * @return getBuchtitel wird zurückgeliefert
   */
  public String getBuchtitel() {
  return buchtitel;
  }

  /**
   * @param buchtitel buchtitel wird festgelegt
   */
  public void setBuchtitel(String buchtitel) {
  this.buchtitel = buchtitel;
  }

  /**
   * @return getErscheinungsjahr wird zurückgeliefert
   */
  public int getErscheinungsjahr() {
  return erscheinungsjahr;
  }

  /**
   * @param erscheinungsjahr erscheinungsjahr wird festgelegt
   */
  public void setErscheinungsjahr(int erscheinungsjahr) {
  this.erscheinungsjahr = erscheinungsjahr;
  }

  /**
   * @return Mehrwertsteuersatz wird zurückgeliefert.
   *         Kann nicht verändert werden, weil ein finale
   *         variable ist.
   */
  public double getMEHRWERT() {
  return MEHRWERT;
  }
  
}