package de.khudhur.internship.internship7;

public class PasswortGenerator {

    //Variable
    private String passwort;

    /**
     * Aufgabe 7. Teil a) Passwort
     *  -> Exception, wenn passwort null oder leer ist.
     *  -> regex um Zahlen und Sonderzeichen auszuschliessen.
     *  -> arrayPasswort, aus passwort string zurückbekommen.
     *  -> Variable satz -> type String -> für Kompletes Satz
     *      ohne Zahlen und Sonderzeichen -> for-each schleife ist in verwendung.
     *  -> Satz durch Leerzeichen trennen, um wörter zuerhalten.
     *      -> for-schleife, nur die ersten Buchstaben Speichern
     *  -> weitere schleife in verwendung, um in einer if-abfrage zu Fragen,
     *      ob i durch 2 teilbar und gleich 0 ist.
     *          -> erstes fall, trifft zu, wird Buchstabe kleingeschrieben
     *          -> zweites fall, Buchstabe wird großgeschrieben.
     *  -> Übergabe das erstellten Passwort
     * @param passwort
     */
    public void erstellePasswort(String passwort) {

        //Exception, wenn string null oder die länge 0 ist.
        if (passwort == null || passwort.length() == 0){
            try {
                throw new Exception("Passwort darf nicht leer sein!");
            }catch (Exception e){
                e.printStackTrace();
                System.exit(2);
            }
        }

        //Ignorieren 0-9, (), ',', !, ?, -, .
        String regex = "[0-9.().,.!.?.\\-.\\.]*";
        //Neues Array für gesplitteten arrays
        String[] arrayPasswort = passwort.split(regex);

        //zusammenfügen in einem Satz
        StringBuilder satz = new StringBuilder();
        for (String str : arrayPasswort) {
            satz.append(str);
        }

        //trennen durch leerzeichen
        String[] woerter = satz.toString().split(" ");
        //nur die ersten Buchstaben speichern
        String[] erstenBuchstaben = new String[woerter.length];
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < woerter.length; i++) {
            erstenBuchstaben[i] = woerter[i].substring(0,1);
        }

        // jeder zweiter Buchstabe wird großgeschrieben.
        for (int i = 0; i < erstenBuchstaben.length; i++){
            //prüft ob, i gerade ist oder nicht
            if (i % 2 == 0){
                str.append(erstenBuchstaben[i].toLowerCase());
            }else {
                str.append(erstenBuchstaben[i].toUpperCase());
            }
        }

        //neues passwort übergeben
        this.passwort = str.toString();

    }

    /**
     * Output
     */
    public void output(){
        System.out.println(passwort);
    }

}
