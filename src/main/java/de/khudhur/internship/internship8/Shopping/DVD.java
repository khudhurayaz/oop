package de.khudhur.internship.internship8.Shopping;

import java.text.DecimalFormat;

/**
* Die Klasse DVD erbt von Artikel {@link Artikel}
* -------------------------------------------------
* Hier sind die Zusätzlichen Attributen und Methoden (Getter &amp; Setter)
* definiert. Außerdem sind die Überschreibbaren Methoden überschrieben.
* 
* @author Ayaz Khudhur
* @version 1.0
*/
public class DVD extends Artikel{

  //Variablen
  private String filmtitel;
  private String kategorie;
  private double dauer;
  private final double MEHRWERT = 0.19;

  /**
  *
  * Konstruktor mit erforderlichen Parametern
  * ----------------------------------------
  * nur die erforderlichen Parametern {@link de.khudhur.internship.internship8.Shopping.Artikel}
  * werden benötigt. Rest wird mit null initialisiert.
  */
  public DVD(int artikelNummer, double nettoPreis){
    super(artikelNummer, nettoPreis);
    this.filmtitel = "";
    this.kategorie = "";
    this.dauer = 0.0;
  }

  /**
  *
  * Konstruktor mit zusätzlichen Parametern
  * --------------------------------------
  * die erforderlichen Parametern wird, an die super klasse übergeben.
  * restlichen Parametern werden in einzel Attributen gespeichert.
  */
  public DVD(int artikelNummer, double nettoPreis, String filmtitel, String kategorie, double dauer){
    super(artikelNummer, nettoPreis);
    this.filmtitel = filmtitel;
    this.kategorie = kategorie;
    this.dauer = dauer;
  }

  /**
   * Preismethode von Eltern Klasse {@link de.khudhur.internship.internship8.Shopping.Artikel},
   * wird überschrieben
   * und preis in Brutto zurückgeliefert, weil von Eltern Klasse nur
   * {@link Artikel#getNettoPreis()} geliefert wird.
   * @see {@link Artikel#getPreis()}
  */
  @Override
  public double getPreis(){
    // @see {@link Artikel#getPreis()} 
    return (getNettoPreis() * (1+MEHRWERT));
  }

  /**
  * Informationsmethode von Eltern Klasse {@link Artikel}, wird überschrieben
  * und als String wieder zurückgeliefert.
  * @return info - alle informationen, die es in DVD Klasse gibt
  *                werden ausgegeben.
  * @see {@link Artikel#getInfo()}
  */
  @Override
  public String getInfo(){
    return "DVD - " + getFilmtitel() + ", " + getKategorie() + " ("
      +Double.toString(getDauer()).replace(".", ":")+") "
      + " : " + new DecimalFormat("##.00").format(getPreis()) + " Euro";
  }

  /**
  * Film Title wird ausgegeben
  * @return filmtitle - der Film Title wird zurückgeliefert
  */
  public String getFilmtitel(){
    return filmtitel;
  }

  /**
  * Film Title wird ersetzt oder neu hinzugefügt.
  * 
  * @param filmtitel der Film Title wird eingegeben
  */
  public void setFilmtitle(String filmtitel){
    this.filmtitel = filmtitel;
  }

  /**
  * Film kategorie wird ausgegeben
  * @return kategorie - Film Kategorie wird zurückgeliefert
  */
  public String getKategorie(){
    return kategorie;
  }

  /**
  * Film Kategorie wird übergeben und im Variable 
  * Kategorie gespeichert.
  */
  public void setKategorie(String kategorie){
    this.kategorie = kategorie;
  }

  /**
  * Dauer der Film wird ausgegeben
  * @return dauer - Dauer eines Films wird zurückgeliefert
  */
  public double getDauer(){
    return dauer;
  }

  /**
  * Film Dauer wird übergeben und im Variable 
  * dauer gespeichert.
  */
  public void setDauer(double dauer){
    this.dauer = dauer;
  }
  
}