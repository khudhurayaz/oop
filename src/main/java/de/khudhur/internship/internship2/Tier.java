package de.khudhur.internship.internship2;

/**
 * Klasse Tier
 *
 * @version 1.0
 * @author Ayaz Khudhur
 */
public class Tier {

    //Attributen für die Klasse Tier
    private String name, fleisch = "-", pflanzen = "-";

    /**
     * @return ausgabe der aktuelle Tiername
     */
    public String getName() {
        return name;
    }

    /**
     * @param name ändere,- oder gib ein Tiername
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return ausgabe, ob das Tier fleisch isst
     */
    public String getFleisch() {
        return fleisch;
    }

    /**
     * @param fleisch ändere,- oder füge, ob es fleisch isst
     */
    public void setFleisch(String fleisch) {
        this.fleisch = fleisch;
    }

    /**
     * @return ausgabe, ob das Tier pflanzen isst
     */
    public String getPflanzen() {
        return pflanzen;
    }

    /**
     * @param pflanzen ändere,- oder füge, ob es pflanzen isst
     */
    public void setPflanzen(String pflanzen) {
        this.pflanzen = pflanzen;
    }

    /**
     * Die methode erkennt, was das Tier ist und gibt aus, was es fressen kann.
     * @return wird, was das Tier ist, Bspl. Allesfresser
     */
    public String identifizieren(){
        //Überprüfung, ob es Fleischfresser ist
        if (!fleisch.equalsIgnoreCase("-") && pflanzen.equalsIgnoreCase("-") || pflanzen.equalsIgnoreCase("") || pflanzen.equalsIgnoreCase(" ")){
            return "Fleischfresser";
        }
        //Überprüfung, ob es Pflanzenfresser ist
        else if (!pflanzen.equalsIgnoreCase("-") && fleisch.equalsIgnoreCase("-") || fleisch.equalsIgnoreCase("") || fleisch.equalsIgnoreCase(" ")) {
            return "Pflanzenfresser";
        }
        //Überprüfung, ob es Allesfresser ist
        else if (!pflanzen.equalsIgnoreCase("-") && !fleisch.equalsIgnoreCase("-")) {
            return "Allesfresser";
        }
        //Falls nichts gefunden wurde
        else {
            return "Not found!";
        }
    }

}
