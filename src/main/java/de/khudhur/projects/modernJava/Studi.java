package de.khudhur.projects.modernJava;

public class Studi {
    private String name;
    private int credits;

    public Studi(){

    }

    public Studi(String name, int credits) {
        this.name = name;
        this.credits = credits;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public static int cmpCpsClass(Studi s1, Studi s2){
        return s1.getCredits() - s2.getCredits();
    }

    @Override
    public String toString() {
        return "Studi{" +
                "name='" + name + '\'' +
                ", credits=" + credits +
                '}';
    }
}
