package de.khudhur.internship.internship2;

public class Quiz {
    public static void main(String[] args) {
        //Objekt erzeugen
        RechenQuiz quiz = new RechenQuiz();
        //Methoden aufruf
        quiz.getExercise();
        //in einer Variable speichern
        int result = quiz.getResult();
        //Ausgabe
        System.out.println("Result: " + result);
    }
}
