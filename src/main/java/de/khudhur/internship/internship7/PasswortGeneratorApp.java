package de.khudhur.internship.internship7;

public class PasswortGeneratorApp {
    public static void main(String[] args) throws Exception {
        PasswortGenerator pg = new PasswortGenerator();
        pg.erstellePasswort("java ist eine objekt-orientierte sprache?");
        pg.output();
        pg.erstellePasswort("Java ist auch eine Insel (von Christian Ullenboom)");
        pg.output();

    }
}
