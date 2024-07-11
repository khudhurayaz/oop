package de.khudhur.projects.Beispiele;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) {
        System.out.println( "Text eingeben und mit Return abschliessen:" );
        while (true){
            try {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader( System.in ) );
                String s = in.readLine();
                if (s.equalsIgnoreCase("abbruch") || s.equalsIgnoreCase("exit") || s.equalsIgnoreCase("beenden")){
                    System.out.println( "Programm wird beendet!");
                    return;
                }
                System.out.println( "Der eingelesene Text lautet: " + s );
            } catch( IOException ex ) {
                System.out.println( ex.getMessage() );
            }
        }
    }
}
