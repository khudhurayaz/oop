package de.khudhur.internship.internship9.TicTacToe;

public class TicTacToeTest {
  public static void main(String[] args) {
    TicTacToe ticTacToe = new TicTacToe();

    // initial
    ticTacToe.zeigeSpielfeld();
    // Spieler X
    ticTacToe.amZug();
    ticTacToe.macheZug(2, 2);
    ticTacToe.zeigeSpielfeld();

    // Spieler O
    ticTacToe.amZug();
    ticTacToe.macheZug(2, 0);
    ticTacToe.zeigeSpielfeld();

    // Spieler X
    ticTacToe.amZug();
    ticTacToe.macheZug(1, 0);
    ticTacToe.zeigeSpielfeld();

    // Spieler O
    ticTacToe.amZug();
    ticTacToe.macheZug(1, 1);
    ticTacToe.zeigeSpielfeld();

    // Spieler X
    ticTacToe.amZug();
    ticTacToe.macheZug(0, 1);
    ticTacToe.zeigeSpielfeld();

    // Spieler O
    ticTacToe.amZug();
    ticTacToe.macheZug(0, 2);
    ticTacToe.zeigeSpielfeld();

    //Sie können dieser Zeile auskommentieren
    //und man kann mit 2 Spieler TicTacToe spielen
    //davor löschen Sie bitte die restlichen Methoden.
    //ticTacToe.userInput();
  }
}