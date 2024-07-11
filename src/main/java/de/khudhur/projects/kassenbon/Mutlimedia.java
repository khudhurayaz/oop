package de.khudhur.projects.kassenbon;

public class Mutlimedia extends Artikel{
    private static final int ID = 4;
    private static final int MEHRWERT = 19;

    public Mutlimedia(String name) {
        super(name, ID, MEHRWERT);
    }

    @Override
    public String info() {
        if (getName().length() >= 4){
            return getName() + "\t\t" + getAnzahl() + " x " + String.format("%.2f", getPreis()) + " EUR\n" +
                    "\t\t\t\t\t\t\t" + String.format("%.2f", preis()) + " EUR";
        }else {
            return getName() + "\t\t\t" + getAnzahl() + " x " + String.format("%.2f", getPreis()) + " EUR\n" +
                    "\t\t\t\t\t\t\t" + String.format("%.2f", preis()) + " EUR";
        }
    }
}
