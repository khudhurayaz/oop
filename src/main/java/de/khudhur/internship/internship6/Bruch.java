package de.khudhur.internship.internship6;

public class Bruch {
    //Attributen
    private int zaehler;
    private int nenner;

    /**
     * Konstruktor mit parametern
     * @param zaehler ein int Zahl
     * @param nenner ein int Zahl
     */
    public Bruch(int zaehler, int nenner) {
        this.zaehler = zaehler;
        this.nenner = nenner;
    }

    /**
     * Methode add(Bruche f)
     * @param f Bruch objekt
     * @return rückgabe wird ein Bruch Objekt sein
     */
    public Bruch add(Bruch f) {

        if (getZaehler() == 0 || getNenner() == 0) {
            System.err.println("Darf nullen nicht enthalten!");
        }

        //Temporär
        Bruch auswertung = new Bruch(getZaehler(), getNenner());

        //Sind nenner gleicher
        if (f.getNenner() == getNenner()){
            //addiere nur Zaehler
            auswertung.setZaehler(getZaehler() + f.getZaehler());
            //gib irgendein nenner, in dem Bsp von übergebenes Bruch f.getNenner()
            auswertung.setNenner(f.getNenner());
        }else{//anders falls
            //Prüfe ob, aktuelle nenner (getNenner()) mal übergebenes nenner (f.getNenner())
            //gleich übergebenes nenner (f.getNenner()) mal aktuelle nenner (getNenner()) sind.
           if ((getNenner() * f.getNenner()) == (f.getNenner() * getNenner())){
               //in neues Bruch (Temporär) setzen
               auswertung.setZaehler(
                           (getZaehler() * f.getNenner()) +
                           (f.getZaehler() * getNenner())
                       );
               auswertung.setNenner(
                       (getNenner() * f.getNenner())
               );

           }
        }
        //Ausgabe neues Objekt
        return auswertung;
    }

    /**
     * Methode multiply(Bruch f)
     * @param f
     * @return
     */
    public Bruch multiply(Bruch f){
        //Neues Objekt erstellen
        Bruch auswertung = new Bruch(getZaehler(), getNenner());

        //aktuelle zaehler (getZaehler()) mal übergebens zaehler (f.getZaehler())
        //sowie aktuelle nenner (getNenner()) mal übergebens nenner (f.getNenner())
        auswertung.setZaehler(getZaehler() * f.getZaehler());
        auswertung.setNenner(getNenner() * f.getNenner());

        //Neues Objekt
        return auswertung;
    }

    /**
     * @return get the integer number (zaehler)
     */
    public int getZaehler() {
        return zaehler;
    }

    /**
     * @param zaehler set the integer number
     */
    public void setZaehler(int zaehler) {
        this.zaehler = zaehler;
    }

    /**
     * @return get the integer number (nenner)
     */
    public int getNenner() {
        return nenner;
    }

    /**
     * @param nenner set the integer number
     */
    public void setNenner(int nenner) {
        this.nenner = nenner;
    }

    /**
     * @return String Zeichenkette
     */
    @Override
    public String toString() {
        return "" + getZaehler() + "/" + getNenner();
    }
}
