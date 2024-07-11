package de.khudhur.internship.internship8;

/**
 * @version 1.0
 * @author Ayaz Khudhur
 */
public class Fahrrad {

    //Next Fahrrad wird mit null initialisiert
    private Fahrrad next = null;

    //Fahrrad ladung
    private int ladung;

    //Fahrrad maximale Speed
    private int maxSpeed;

    /**
     * Der Konstruktor wird mit zwei (int) Variablen initialisiert,
     * die zwei parametern sind sehr wichtig für ein Fahrrad.
     * Erste Parameter, um ein Fahrrad zu beladen und um daraus
     * die Geschwindigkeit zu errechnen können.
     *
     */
    public Fahrrad(int maxSpeed, int ladung) {
        this.ladung = ladung;
        this.maxSpeed = maxSpeed;
    }

    /**
     * Speed Methode
     * --------------------------------------------------
     * Es wird errechnet wie schnell ein Fahrrad sein kann,
     * ohne Beladung sehe {@link Fahrrad#getMaxSpeed()} die
     * maximale Geschwindigkeit. Mit Ladung wird mit maxSpeed
     * subtrahiert, dadurch wird der Fahrrad speed errechnet.
     *
     * @return die Fahrradgeschwindigkeit wird zurückgeliefert.
     * @throws Exception Ein Exception wird ausgeworfen, wenn
     *                   speed kleiner als -1 oder Ladung
     *                   grosser als maximale Geschwindigkeit ist.
     */
    public int speed() throws Exception {
        if ((maxSpeed - ladung) <= -1)
            throw new Exception("Ladung ist im negativen Bereich!");
        else if (ladung >= maxSpeed)
            throw new Exception("Ladung ist groesser als maxSpeed");
        else
            return maxSpeed - ladung;
    }

    /**
     * Next Fahrrad wird zurückgeliefert, falls noch eins gibt.
     * @return nachfolger Fahrrad wird zurückgeliefert.
     */
    public Fahrrad getNext() {
        return next;
    }

    /**
     * Next Fahrrad übergeben <br>
     * wenn noch ein Fahrrad als nachfolger gibt <br>
     * wird der nexte Fahrrad dadurch ersetzt.
     * @param next nachfolger Fahrrad wird übergeben
     */
    public void setNext(Fahrrad next) {
        this.next = next;
    }

    /**
     * Ladung <br>
     * Fahrradladung wird zurückgeworfen, <br>
     * wie viel ein Fahrrad derzeit trägt.
     * @return Fahrradladung wird zurückgeliefert
     */
    public int getLadung() {
        return ladung;
    }

    /**
     * Fahrrad beladen <br>
     * Fahrrad wird in dieser Methode beladen, <br>
     * wenn neue säcke verteilt worden sind.
     * @param ladung fahrrad beladen
     */
    public void setLadung(int ladung) {
        this.ladung = ladung;
    }

    /**
     * @return gibt die maximale Fahrradgeschwindigkeit aus
     */
    public int getMaxSpeed() {
        return maxSpeed;
    }

    /**
     * @param maxSpeed Fahrrad speed festlegen
     */
    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

}
