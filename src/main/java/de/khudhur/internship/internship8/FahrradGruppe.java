package de.khudhur.internship.internship8;

/**
 * @version 1.0
 * @author Ayaz Khudhur
 */
public class FahrradGruppe {

    //Aktuelle Fahrrad
    private Fahrrad startFahrrad;

    /**
     * Konstruktor <br>
     * Fahrrad wird mit null initialisiert.
     */
    public FahrradGruppe() {
        this.startFahrrad = null;
    }

    /**
     * Methode addFahrrad(Fahrrad f)
     * Neues Fahrrad wird hinzugefügt.
     * @param f Fahrrad wird hinzugefügt
     * @see Fahrrad
     */
    public void addFahrrad(Fahrrad f) {
        //fahrrad hinzufügen
        f.setNext(startFahrrad);
        //start Fahrrad ersetzen durch neues Fahrrad
        startFahrrad = f;
    }

    /**
     * reisegeschwindigkeit
     *  int fahrrad = 0
     *      → anzahl an fahrräder
     *  int langsamste = Maximale Integer Value
     *      → langsamste Fahrrad zu finden
     *  Fahrrad aktive = startFahrrad
     *      -> Fahrräder durchsuchen
     *  while schleife
     *      → prüft ob, noch fahrrädern gibt
     *      int aktivSpeed = aktiv.speed()
     *          -> Aktuelle Fahrrad speed
     *      if abfrage
     *          →prüft ob, aktuelle Speed kleiner als langsamste
     *          speed ist.
     *          ja: langsamste speed speichern, fahrrad um eins erhöhen
     *     if abfrage
     *          →prüft ob, aktivSpeed gleich null oder
     *                      aktivSpeed im Negativen Bereich ist
     *          → ja, gibt ein entsprechendes Exception aus
     *    neues aktiv setzen
     *    langsamste fahrrad ausgeben
     *
     * @return die Reisegeschwindigkeit für die Fahrradgruppe
     * @throws Exception Ein Exception wird ausgeworfen, wenn <br>
     *                   fahrrad speed 0 oder -1 ist.
     */
    public int reisegeschwindigkeit() throws Exception {
        //Temp variablen
        int langsamste = Integer.MAX_VALUE;
        Fahrrad aktiv = startFahrrad;

        //while schleife
        while (aktiv != null) {
            //aktuelle speed
            int aktivSpeed = aktiv.speed();

            //abfrage ob aktuelle speed
            //kleiner als langsamste speed ist
            if (aktivSpeed < langsamste) {
                //ja, tauschen
                langsamste = aktivSpeed;
            }

            //Exception geeignet abfangen
            //prüfe ob, speed null oder -1 ist
            if (aktivSpeed == 0 || aktivSpeed < -1)
                //exception Auswerfen
                throw new Exception("Die Ladung("+aktiv.getLadung()+") ist groesser als eigenes MaxSpeed(" +
                        aktiv.getMaxSpeed() + ") oder ist im Negativen Bereich!");
            //ende, aktuelle Fahrrad gegen next Fahrrad austauschen
            aktiv = aktiv.getNext();
        }

        //langsamste ausgeben
        return langsamste;
    }

    /**
     * addLadung methode
     * temporär variablen
     * while schleife
     *  → fahrräder zählen
     * aktuelle Fahrrad wieder einsetzen
     * while schleife
     *  → integer variable für Ladung,
     *     wie viel ein einzel Fahrrad transportieren kann.
     *  -> ladung für aktuelle Fahrrad setzen
     *  → aktuelle Fahrrad durch next ersetzen
     * @param anzahl anzahl an ladungen für die gesamte Fahrradgruppe
     */
    public void addLadung(int anzahl) {
        //temp variablen
        int fahrraeder = 0;
        Fahrrad aktuelle = startFahrrad;

        //erste schleife für anzahl an fahrrädern
        while (aktuelle != null) {
            //aktuell ist nicht null
            //fahrraeder variable um eins erhöhen
            fahrraeder++;
            //nächste Fahrrad übergeben
            aktuelle = aktuelle.getNext();
        }

        //wieder aktuelle Fahrrad setzen
        aktuelle = startFahrrad;
        //Zweite schleife für die einzeln Ladungen
        while (aktuelle != null) {
            //Ladung pro Fahrrad
            int ladungPerFahrrad = anzahl / fahrraeder;
            //set ladung für Fahrrad
            aktuelle.setLadung(aktuelle.getLadung() + ladungPerFahrrad);
            //next Fahrrad übergeben
            aktuelle = aktuelle.getNext();
        }
    }

    /**
     * @return Start Fahrrad wird zurückgeliefert
     */
    public Fahrrad getStartFahrrad() {
        return startFahrrad;
    }

    /**
     * @param startFahrrad Start Fahrrad ersetzen
     */
    public void setStartFahrrad(Fahrrad startFahrrad) {
        this.startFahrrad = startFahrrad;
    }

}
