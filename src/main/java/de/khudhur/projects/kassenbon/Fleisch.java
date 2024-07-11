package de.khudhur.projects.kassenbon;

public class Fleisch extends Artikel{
    private static final int MEHRWERT = 19;
    private static final int ID = 1;

    public Fleisch(String name) {
        super(name, ID, MEHRWERT);
    }

}
