package de.khudhur.projects.kassenbon;

abstract class Artikel {
    private int id;
    private int anzahl;
    private double preis;
    private String name;
    private final double mehrwert;
    public double preis() {
        return getAnzahl() * (getPreis());
    }

    public double mehrwertsteuer(){
        return ((getAnzahl() * getPreis()) * mehrwert) / 100;
    }

    public String info(){
        return getName() + "\t\t" + getAnzahl() + " x " + String.format("%.2f", getPreis()) + " EUR\n" +
                "\t\t\t\t\t\t\t" + String.format("%.2f", preis()) + " EUR";
    }

    public Artikel(String name, int id, int mehrwert){
        this.name = name;
        this.id = id;
        this.mehrwert = mehrwert;
    }

    public int getAnzahl() {
        return anzahl;
    }

    public void setAnzahl(int anzahl) {
        this.anzahl = anzahl;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
