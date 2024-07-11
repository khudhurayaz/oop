package de.khudhur.projects.kassenbon;

public class MilchProdukte extends Artikel{

    private static final int MEHRWERT = 7;
    private static final int ID = 2;
    public MilchProdukte(String name) {
        super(name, ID, MEHRWERT);
    }
}
