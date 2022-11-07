package de.khudhur.internship.internship2;

public class RechenQuiz {

    //Attributen
    private int operand1 = 0;
    private int operand2 = 0;
    private int result;
    private char operator = ' ';


    public void getExercise() {
        //Zufallszahl für operand 1
        operand1 = (int) (Math.random() * 21.0);
        //Zufallszahl für operand 2
        operand2 = (int) (Math.random() * 21.0);
        //Zufallszahl für Operator
        int iOperator = (int) (Math.random() * 3.0);
        operator = operator(iOperator); //Operator zuweisung


         //Wenn operand 1 und 2 positive sind,
         //werden die Rechnungen im Weiteren bedienungen
         //geführt.

        if (operand1 >= 0 && operand2 >= 0) {
            if (this.operator == '+') { //Addition
                this.result = operand1 + operand2;
            } else if (operator == '-') { //Subtraktion
                this.result = operand1 - operand2;
            } else if (operator == '*') { //Multiplikation
                this.result = operand1 * operand2;
            } else {//Ansonsten spuckt ein fehler aus
                System.out.println("Fehler!");
            }
            if (result >= 0) {//Ergebnis grosser als 0
                //Ergebnis ausgeben
                System.out.print(operand1 + " " + operator + " " + operand2 + " = ?\n");
            }else { //Ansonsten wiederhole dich
                getExercise();
            }
        }
        //Wenn Operand 1 und 2 nicht positive sind.
        //Wird sich die Methode wiederholen
        else {
            getExercise();
        }
    }

    /**
     * @param i Zufallszahl für +, - oder *
     * @return ein char Zeichen +, - oder *
     */
    private char operator(int i) {
        if (i == 0) // für +
            return '+';
        if (i == 1) // für -
            return '-';
        if (i == 2) //für *
            return '*';
        // nichts, bedeutet der Zufallszahl hat es nicht geklappt.
        return ' ';
    }

    public int getResult() { //Ergebnis
        return this.result;
    }

    /**
     * @return inhalt der Variablen/Attributen der Klasse RechenQuiz
     */
    @Override
    public String toString() {
        return "RechenQuiz{" +
                "operand1=" + operand1 +
                ", operand2=" + operand2 +
                ", result=" + result +
                ", operator=" + operator +
                '}';
    }

}
