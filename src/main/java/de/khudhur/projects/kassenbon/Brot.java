package de.khudhur.projects.kassenbon;

public class Brot extends Artikel{
    private static final int MEHRWERT = 7;
    private static final int ID = 3;

    public Brot(String name){
        super(name, ID, MEHRWERT);
    }
}
