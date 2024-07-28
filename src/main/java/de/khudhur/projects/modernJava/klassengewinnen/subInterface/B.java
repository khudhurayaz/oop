package de.khudhur.projects.modernJava.klassengewinnen.subInterface;

public interface B extends A{
    @Override default String hello() { return "B"; }
}
