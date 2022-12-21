package de.khudhur.internship.internship9.TicTacToe;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TicTacToe {

  // feld 3x3
  private final int[] feld;

  // wer gewonnen hat
  private String gewonnen;

  // wenn feld besetzt ist
  private boolean feldBesetzt;

  // wer am Zug ist
  private boolean zug;

  /**
  * Leeres Konstruktor
  * feld wird initialisiert mit 3x3 Feldern
  */
  public TicTacToe(){
    feld = new int[3*3];
    reset();
  }

  /**
   * Methode reset() setzt
   * der Spielstand, sowie
   * wer gewonnen und welches feld besetzt wurde
   * zurück.
   */
  public void reset() {
    // Spielstand zurücksetzen
    for (int i = 0; i < feld.length; i++) {
      feld[i] = 0;
    }
    // Wer gewonnen hat, zurücksetzen
    gewonnen = "Spieler: ";
    // wenn der feld besetzt ist, wird zurückgesetzt
    feldBesetzt = false;
    zug = true;
  }

  /**
   * Methode macheZug(x, y): int
   * in dieser Methode macht der Spieler
   * sein Zug, mit x und y wird der index an
   * der feld[position] errechnet.
   * 
   * @param x position für die Index
   * @param y position für die Index
   */
  public void macheZug(int x, int y) {
    // index errechnen
    int index = (3 * y) + x;

    // mach Zug
    System.out.println("macheZug(" + x + ", " + y + ")");
    // prüfe ob, X am Zug ist
    if (zug) {
      // prüfe ob, an der position noch freies Feld ist
      if (feld[index] == 0) {
        // setzte an der index stelle eine 1 für X
        feld[index] = 1;
      } else {
        // andernfalls ist die Stelle besetzt
        feldBesetzt = true;
      }
    }

    // prüfe ob, O am Zug ist
    if (!zug) {
      // prüfe ob, an der position noch freies Feld ist
      if (feld[index] == 0) {
        // setzte an der index stelle eine 2 für O
        feld[index] = 2;
      } else {
        // andernfalls ist die Stelle besetzt
        feldBesetzt = true;
      }
    }
    // Zug umdrehen
    zug = !zug;
  }

  /**
   * Hier wird der Spielstand ausgegeben
   */
  public void zeigeSpielfeld() {
    // prüfe ob, feld besetzt ist.
    // falls ja, wird ein ERROR ausgegeben und returniert
    if (feldBesetzt) {
      System.out.println("Feld ist besetzt! Bitte anderes Feld nehmen!");
      return;
    }

    // in dieser abschnitt, dient um zu überprüfen,
    // ob die felder noch 0 sind,
    // um leeres output mit 'initial'
    int sum = 0;
    for (int i = 0; i < feld.length; i++) {
      if (feld[i] == 0) {
        sum += 1;
      }
    }
    if (sum == feld.length) {
      System.out.println("Initial");
    }

    /*
      gibt aus wo x, o oder " "
      felder sind.
     */
    for (int i = 0; i < feld.length; i++) {
      if (feld[i] == 0) {
        print(i, " ");
      } else if (feld[i] == 1) {
        print(i, "X");
      } else if (feld[i] == 2) {
        print(i, "O");
      }
    }

    // nach der Ausgabe wird überprüft ob,
    // ein Spieler gewonnen hat
    if (pruefe()) {
      printGewonnen();
    }
    if (isFeldFull()){
      System.out.println("Unentschieden!");
      System.out.println("Um ein neues Spiel zu starten, " +
              "schreib 'reset' in der Konsole!");
    }
  }

  /**
   * Die Methode zeigt,
   * wer gerade am Zug ist.
   */
  public String amZug() {
    // gib es aus wer am Zug ist
    if (zug) {
      return "Spieler X ist am Zug";
    } else {
      return "Spieler O ist am Zug";
    }
  }

  /**
   * Gibt gewinner Benachrichtigung aus
   */
  private void printGewonnen() {
    System.out.println(gewonnen + " hat gewonnen!!!");
    System.out.println("Um ein neues Spiel zu starten, " +
            "schreib 'reset' in der Konsole!");
  }

  /**
   * Hier wird der Spielinhalt
   * initialisiert.
   */
  private void print(int i, String str) {
    // Erste Zeile
    if (i < 2) {
      System.out.print(str + "|");
    }
    if (i == 2) {
      System.out.print(str);
      System.out.println();
      System.out.print("-+");
      System.out.print("-+-");
      System.out.println();
    }

    // zweite Zeile
    if (i >= 3 && i < 5) {
      System.out.print(str + "|");
    }
    if (i == 5) {
      System.out.print(str);
      System.out.println();
      System.out.print("-+");
      System.out.print("-+-");
      System.out.println();
    }

    // Dritte Zeile
    if (i >= 6 && i < 8) {
      System.out.print(str + "|");
    }
    if (i == 8) {
      System.out.print(str + "\n");
      System.out.println();
    }

  }

  /**
   * Die Methode überprüft, ob
   * eins der Zeile alle 3 werte gleicheinhalte haben.
   */
  private boolean pruefe() {
    // prüfe ob, Spieler "X" gewonnen hat
    if (feld[0] == 1 && feld[1] == 1 && feld[2] == 1 || // erste Zeile
        feld[3] == 1 && feld[4] == 1 && feld[5] == 1 || // zweite Zeile
        feld[6] == 1 && feld[7] == 1 && feld[8] == 1 || // dritte Zeile
        feld[0] == 1 && feld[4] == 1 && feld[8] == 1 || // Diagonal seite 1
        feld[2] == 1 && feld[4] == 1 && feld[6] == 1) { // Diagonal seite 2
      gewonnen += "X";
      return true;
    }
    // andernfalls prüfe ob, Spieler "O" gewonnen hat
    else if (feld[0] == 2 && feld[1] == 2 && feld[2] == 2 || // erste Zeile
        feld[3] == 2 && feld[4] == 2 && feld[5] == 2 || // zweite Zeile
        feld[6] == 2 && feld[7] == 2 && feld[8] == 2 || // Dritte Zeile
        feld[0] == 2 && feld[4] == 2 && feld[8] == 2 || // Diagonal seite 1
        feld[2] == 2 && feld[4] == 2 && feld[6] == 2) { // Diagonal seite 2
      gewonnen += "O";
      return true;
    }else {
      return false;
    }
  }

  private boolean isFeldFull(){
    int sum = 0;
    for (int i = 0; i < feld.length; i++) {
      if (feld[i] != 0){
        sum += 1;
      }
    }

    if (sum == feld.length){
      return true;
    }
    return false;
  }

  public void userInput() {
    boolean weiter = true;
    Scanner user = new Scanner(System.in);
    int sum = 0;

    while(weiter){

      // prüft ob, der feld komplett leer ist
      for (int j : feld) {
        if (j == 0) {
          //jedes feld, wenn es 0 beinhaltet
          //wird um eins erhöht
          sum += 1;
        }
      }
      //hat es die gleiche länge wie
      //das feld, wird Spiel feld mit leerem Zügen initialisiert
      if (feld.length == sum){
        zeigeSpielfeld();
      }

      //User Angabe.
      //Wer ist amZug?
      //gibt Zug format aus
      System.out.print(amZug() + " (Format: x, y): ");

      //speichere die nächste Zeile
      String nextLine = user.nextLine();
      //regex falls, Buchstaben gefunden werden
      String regex = "[a-zA-Z]";
      Pattern pattern = Pattern.compile(regex);
      Matcher matcher = pattern.matcher(nextLine);

      //abfrage, wenn eins davon trifft wird sich die
      //while-Schleife wiederholen
      if (nextLine.equalsIgnoreCase("") || nextLine.isBlank() || nextLine.isEmpty() || matcher.find()){
        continue;
      }

      //Position abspeichern
      int x = Integer.parseInt(nextLine.split(",")[0]);
      int y = Integer.parseInt(nextLine.split(",")[1]);

      //Spieler Zug spielen
      macheZug(x, y);
      //feld anzeigen
      zeigeSpielfeld();

      //prüfen falls, dass das Spiel beendet wurde.
      //Wenn spieler reset eingeben, soll sich das Spiel Neustarten.
      //Falls nicht, wird das Spiel automatisch beendet.
      if (pruefe() || isFeldFull()){
        //user eingabe
        String input = user.nextLine();
        if (input.equalsIgnoreCase("reset") || input.equalsIgnoreCase("reset()")){
          System.out.println("\n\n\n\n\n\n\n\n\n");
          reset();
        }else{
          System.out.println("Das Spiel wird sich nun Beenden!");
          System.out.println("Keine eingabe wurde erkannt!");
          reset();
        }

      }

      //prüft ob, der user das Spielbeenden möchte
      if (nextLine.equalsIgnoreCase("exit") || nextLine.equalsIgnoreCase("e") ||
              nextLine.equalsIgnoreCase("quit") || nextLine.equalsIgnoreCase("q")) {
        System.out.println("Das Spiel wird sich nun Beenden!");
        reset();
      }
    }
  }
}