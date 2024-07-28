package de.khudhur.projects.modernJava;

import de.khudhur.projects.modernJava.klassengewinnen.KlassenGewinnen;
import java.util.*;

public class App {

  public record Studiengang(String name, List<Studi> studis) {}

  public record Fachbereich(String name, List<Studiengang> studiengaenge) {}

  private static long getCountFB(Fachbereich fb) {
    long count = 0;
    for (Studiengang sg : fb.studiengaenge) {
      for (Studi s : sg.studis()) {
        if (s.getCredits() > 100) count += 1;
      }
    }
    return count;
  }

  private static long getCountSG(Studiengang sg) {
    return sg.studis.stream().map(Studi::getCredits).filter(c -> c > 100).count();
  }

  private static void dummy(Studiengang sg) {
    sg.studis().stream()
        .peek(s -> System.out.println("Looking at: " + s.getName()))
        .map(Studi::getCredits)
        .peek(c -> System.out.println("This one has: " + c + " ETCS"))
        .filter(c -> c > 5)
        .peek(c -> System.out.println("Filtered: " + c))
        .sorted()
        .forEach(System.out::println);
  }

  public static void main(String[] args) {
    Outer k = new Outer("Aussern", "Innen");
    System.out.println(k);

    Studi o1 = new Studi("Khudhur", 150);
    Studi o2 = new Studi("Ayaz", 90);

    UComparator<Studi> c1 =
        (s1, s2) -> (s1.getCredits() - s2.getCredits() > 0 ? s1 : s2).getCredits();

    System.out.println(o1);
    System.out.println(o2);
    System.out.println(c1.compare(o1, o2));

    List<Studi> l1 = new ArrayList<>();
    l1.add(o1);
    l1.add(o2);

    l1.sort(Studi::cmpCpsClass);
    System.out.println(l1);

    Thread t1 = new Thread(ThreadStarter::start);
    t1.start();

    List<String> words = Arrays.asList("Test 2", "Test 3", "Test 4");
    System.out.println(words);

    List<Studiengang> studiengangs = new ArrayList<>();

    Studiengang informatik = new Studiengang("Informatik", l1);
    studiengangs.add(informatik);
    Fachbereich fachbereich = new Fachbereich("Informatik", studiengangs);
    System.out.println(
        "Anzahl an Student die mehr als 100 CP haben(mit for schleife Realisiert): "
            + getCountFB(fachbereich)
            + "/"
            + l1.size());
    System.out.println(
        "Anzahl an Student die mehr als 100 CP haben(mit stream Realisiert): "
            + getCountSG(informatik)
            + "/"
            + l1.size());
    dummy(informatik);

    Record.StudiR s = new Record.StudiR("Ayaz Khudhur", -5);
    System.out.println(s);

    Klausur kPM = new ProgrammierMethoden();
    Studi ayazKhudhur = new Studi("Ayaz Khudhur", 20);
    kPM.anmelden(ayazKhudhur);
    kPM.abmelden(ayazKhudhur);

    // Ausgabe in der Klasse "KlassenGewinnen"
    new KlassenGewinnen().defaultTest1();

    // Ausgabe in der Klasse "SubInterface"
    new KlassenGewinnen().defaultTest2();

    // Ausgabe in der Klasse "methode explizit"
    new KlassenGewinnen().defaultTest3();

    // Ausgabe in der Klasse "Quiz"
    new KlassenGewinnen().quiz();
  }
}
