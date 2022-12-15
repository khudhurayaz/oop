package de.khudhur.internship.internship8.Shopping;

import java.text.DecimalFormat;

/**
 * @version 1.0
 * @author Ayaz Khudhur
 */
public class Kleidung extends Artikel{

  //Variablen
  private String typ;
  private String farbe;
  private String groesse;
  private final double MEHRWERT = 0.12;

  /**
   * Konstruktor mit erforderlichen Parametern
   * Restlichen werte werden mit null initialisiert.
   *
   * @param artikelNummer artikelNummer wird übergeben
   * @param nettoPreis nettoPreis wird übergeben
   */
  public Kleidung(int artikelNummer, double nettoPreis){
    super(artikelNummer, nettoPreis);
    typ = "";
    farbe = "";
    groesse = "";
  }

  /**
   * Konstruktor mit zusätzlichen Parametern
   * @param artikelNummer artikelNummer wird übergeben
   * @param nettoPreis nettoPreis wird übergeben
   * @param groesse groesse wird übergeben
   * @param typ typ wird übergeben
   * @param farbe farbe wird übergeben
   */
  public Kleidung(int artikelNummer, double nettoPreis, String groesse, String typ, String farbe){
    super(artikelNummer, nettoPreis);
    this.typ = typ;
    this.farbe = farbe;
    this.groesse = groesse;
  }

  /**
   * @return Bruttopreis wird zurückgeliefert
   */
  @Override
  public double getPreis(){
    return (getNettoPreis() * (1+MEHRWERT));
  }

  /**
   * @return informationen der Klasse Kleidung wird
   *         zurückgeliefert. Wie in der Aufgaben-
   *         beschreibung steht.
   */
  @Override
  public String getInfo(){
    return "Kleidung - " + getTyp() + ", " +
      getFarbe() + " ("+getGroesse()+") " + " : " +
      new DecimalFormat("##.00").format(getPreis()) + " Euro";
  }

  /**
   * @return Kleidung typ wird zurückgeliefert
   */
  public String getTyp(){
    return typ;
  }

  /**
   * @param typ Kleidung typ wird übergeben
   */
  public void setTyp(String typ){
    this.typ = typ;
  }

  /**
   *  @return Kleidung Farbe wird zurückgeliefert
   */
  public String getFarbe(){
    return farbe;
  }

  /**
   * @param farbe Kleidung Farbe wird übergeben
   */
  public void setFarbe(String farbe){
    this.farbe = farbe;
  }

  /**
   * @return Kleidung Größe wird zurückgeliefert
   */
  public String getGroesse(){
    return groesse;
  }

  /**
   * @param groesse Kleidung Größe wird übergeben
   */
  public void setGroesse(String groesse){
    this.groesse = groesse;
  }

}