package de.khudhur.projects.probeklausur;

import java.util.ArrayList;

public class SelectionList <T>{
    ArrayList<T> left = new ArrayList<>();
    ArrayList<T> right = new ArrayList<>();

    public void addLeft(T leftT){
        left.add(leftT);
    }

    public void moveRight(T left){
        right.add(left);
    }

    public int goTotalCount(){
        return left.size() + right.size();
    }
}
