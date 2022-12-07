package de.khudhur.internship.internship7;

public class PasswortGeneratorApp {

    public static void main(String[] args) throws Exception {

        //PasswortGenerator ein objekt erstellen
        PasswortGenerator pg = new PasswortGenerator();

        //methode erstellePasswort aufrufen für ersten Satz
        pg.erstellePasswort("java ist eine objekt-orientierte sprache?");
        //Ausgabe
        pg.output();

        //methode erstellePasswort aufrufen für zweiten Satz
        pg.erstellePasswort("Java ist auch eine Insel (von Christian Ullenboom)");
        //Ausgabe
        pg.output();
    }

}

