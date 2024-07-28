package de.khudhur.projects.modernJava;

public class ProgrammierMethoden implements Klausur{
    @Override
    public void anmelden(Studi s) {
        System.out.println("Für die Klausur hat sich '" + s.getName() + "' erfolgreich angemeldet!");
    }

    @Override
    public void abmelden(Studi s) {
        System.out.println("Für die Klausur hat sich '" + s.getName() + "' erfolgreich abgemeldet!");
    }
}
