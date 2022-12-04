package de.khudhur.internship.internship7;

public class PasswortGenerator {

    private String passwort;

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
        String satz = "";
        for (String str:
             arrayPasswort) {
            satz += str;
        }

        //trennen durch leerzeichen
        String[] woerter = satz.split(" ");
        //nur die ersten Buchstaben speichern
        String[] erstenBuchstaben = new String[woerter.length];
        String str = "";
        for (int i = 0; i < woerter.length; i++) {
            erstenBuchstaben[i] = woerter[i].substring(0,1);
        }

        // jeder zweiter Buchstabe wird großgeschrieben.
        for (int i = 0; i < erstenBuchstaben.length; i++){
            //prüft ob, i gerade ist oder nicht
            if (i % 2 == 0){
                str += erstenBuchstaben[i].toLowerCase();
            }else {
                str += erstenBuchstaben[i].toUpperCase();
            }
        }

        this.passwort = str;

    }

    /**
     * Output
     */
    public void output(){
        System.out.println(passwort);
    }
}
