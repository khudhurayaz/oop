package de.khudhur.projects.modernJava.klassengewinnen;

import de.khudhur.projects.modernJava.klassengewinnen.subInterface.D;

public class KlassenGewinnen {
    public void defaultTest1(){
        String e = new E().hello();
        System.out.println("in der Ausgabe von KlassenGewinnen steht: " + e);
    }

    public void defaultTest2(){
        String e = new D().hello();
        System.out.println("in der Ausgabe von SubInterface steht: " + e);
    }

    public void defaultTest3(){
        String e = new de.khudhur.projects.modernJava.klassengewinnen.methodeExplizit.D().hello();
        System.out.println("in der Ausgabe von Methode explizit steht: " + e);
    }

    public void quiz(){
        String e = new de.khudhur.projects.modernJava.klassengewinnen.quiz.D().hello();
        System.out.println("in der Ausgabe von Quiz steht: " + e);
    }
}
