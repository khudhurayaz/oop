package de.khudhur.projects.modernJava.klassengewinnen.methodeExplizit;

public class D implements A, B{

    @Override
    public String hello() {
        return A.super.hello();
    }
}
