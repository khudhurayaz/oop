package de.khudhur.projects.modernJava.klassengewinnen.quiz;

public interface B extends A{
    @Override
    default String hello() {
        return "B";
    }
}
