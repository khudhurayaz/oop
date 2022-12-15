package de.khudhur.internship.internship8;

public class FahrradTest {

    public static void main(String[] args) throws Exception {

        //FahrradGruppe 1
        FahrradGruppe gruppe1 = new FahrradGruppe();

        //Fahrräder
        Fahrrad fahrrad1 = new Fahrrad(17, 3);
        Fahrrad fahrrad2 = new Fahrrad(19, 7);
        Fahrrad fahrrad3 = new Fahrrad(26, 9);

        //Fahrräder zu Gruppe hinzufügen
        gruppe1.addFahrrad(fahrrad1);
        gruppe1.addFahrrad(fahrrad2);
        gruppe1.addFahrrad(fahrrad3);
        gruppe1.addLadung(20);

        //Ausgabe erste Gruppe
        System.out.println("Info für FahrradGruppe 1 ");
        System.out.println("Reisegeschwindigkeit: " + gruppe1.reisegeschwindigkeit());
        System.out.println("Ladung für Fahrrad 1: " + fahrrad1.getLadung());
        System.out.println("Ladung für Fahrrad 2: " + fahrrad2.getLadung());
        System.out.println("Ladung für Fahrrad 3: " + fahrrad3.getLadung());

        System.out.println("MaxSpeed für Fahrrad 1: " + fahrrad1.getMaxSpeed());
        System.out.println("MaxSpeed für Fahrrad 2: " + fahrrad2.getMaxSpeed());
        System.out.println("MaxSpeed für Fahrrad 3: " + fahrrad3.getMaxSpeed());
        System.out.println("\n");


        //FahrradGruppe 2
        FahrradGruppe gruppe2 = new FahrradGruppe();

        //Fahrräder
        Fahrrad fahrrad4 = new Fahrrad(25, 7);
        Fahrrad fahrrad5 = new Fahrrad(35, 12);
        Fahrrad fahrrad6 = new Fahrrad(40, 15);

        //Fahrräder zu Gruppe hinzufügen
        gruppe2.addFahrrad(fahrrad4);
        gruppe2.addFahrrad(fahrrad5);
        gruppe2.addFahrrad(fahrrad6);
        gruppe2.addLadung(14);

        //Ausgabe zweite Gruppe
        System.out.println("Info für FahrradGruppe 2 ");
        System.out.println("Reisegeschwindigkeit: " + gruppe2.reisegeschwindigkeit());
        System.out.println("Ladung für Fahrrad 4: " + fahrrad4.getLadung());
        System.out.println("Ladung für Fahrrad 5: " + fahrrad5.getLadung());
        System.out.println("Ladung für Fahrrad 6: " + fahrrad6.getLadung());

        System.out.println("MaxSpeed für Fahrrad 4: " + fahrrad4.getMaxSpeed());
        System.out.println("MaxSpeed für Fahrrad 5: " + fahrrad5.getMaxSpeed());
        System.out.println("MaxSpeed für Fahrrad 6: " + fahrrad6.getMaxSpeed());
        System.out.println("\n");
    }

}
