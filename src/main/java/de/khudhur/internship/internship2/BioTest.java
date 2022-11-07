package de.khudhur.internship.internship2;

public class BioTest {
    public static void main(String[] args) {
        //Tier Objekten
        Tier loewe = new Tier(); //Löwe
        loewe.setName("Löwen");
        loewe.setFleisch("Zebra");
        Tier zebra = new Tier(); //Zebra
        zebra.setName("Zebras");
        zebra.setPflanzen("Gras");
        Tier baer = new Tier(); //Bär
        baer.setName("Bären");
        baer.setFleisch("Fische");
        baer.setPflanzen("Beeren");
        Tier fische = new Tier(); //Fische
        fische.setName("Fische");
        fische.setPflanzen("Algen");

        //Pflanze Objekten
        Pflanze gras = new Pflanze(); //Gras
        gras.setName("Gras");
        gras.setFarbe("Grün");
        Pflanze beeren = new Pflanze(); //Beeren
        beeren.setName("Beeren");
        beeren.setFarbe("rot");
        Pflanze algen = new Pflanze(); //Algen
        algen.setName("Algen");
        algen.setFarbe("Silber");

        //Szenario 1
        System.out.println("Szenario 1: ");
        System.out.println(gras.getName() + " ist " + gras.getFarbe());
        System.out.println(beeren.getName() + " sind " + beeren.getFarbe());
        System.out.println(algen.getName() + " sind " + algen.getFarbe());
        System.out.println(fische.getName() + " fressen " + fische.getPflanzen());
        System.out.println(zebra.getName() + " fressen " + zebra.getPflanzen());
        System.out.println(loewe.getName() + " fressen " + loewe.getFleisch());
        System.out.println(baer.getName() + " fressen " + baer.getPflanzen());
        System.out.println(baer.getName() + " fressen " + baer.getFleisch());


        System.out.println("------------------------------");

        //Szenario 2
        zebra.setName("Zebra"); //ändern von Zebras zu Zebra
        loewe.setName("Löwe"); //ändern von Löwen zu Löwe
        baer.setName("Bär"); //ändern von Bären zu Bär
        System.out.println("Szenario 2: ");
        System.out.println(zebra.getName() + " ist ein " + zebra.identifizieren());
        System.out.println(loewe.getName() + " ist ein " + loewe.identifizieren());
        System.out.println(baer.getName() + " ist ein " + baer.identifizieren());
    }

}
