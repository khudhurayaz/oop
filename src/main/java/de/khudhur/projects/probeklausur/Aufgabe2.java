package de.khudhur.projects.probeklausur;

import java.util.Arrays;

public class Aufgabe2 {
    public static void main(String[] args) {
       SelectionList<Double> list = new SelectionList<>();
       list.addLeft(42.0);
       list.addLeft(12.0);
       list.moveRight(23.0);
       System.out.println(Arrays.toString(list.left.toArray()));
    }
}
