package de.khudhur.projects.kassenbon;

import java.util.ArrayList;

public class Kassenbon {
    public static void main(String[] args) {
        ArrayList<Artikel> warenkorb = new ArrayList<>();

        //Fleisch
        Fleisch wurst = new Fleisch("Wurst");
        wurst.setAnzahl(3);
        wurst.setPreis(4.20);

        //Milchprodukten
        MilchProdukte kaese = new MilchProdukte("Käse");
        kaese.setAnzahl(2);
        kaese.setPreis(2.30);

        //Brot
        Brot brot = new Brot("Brot");
        brot.setAnzahl(10);
        brot.setPreis(2.1);

        //Multimedia
        Mutlimedia dvd = new Mutlimedia("DVD");
        dvd.setAnzahl(2);
        dvd.setPreis(12.00);

        //add
        warenkorb.add(wurst);
        warenkorb.add(kaese);
        warenkorb.add(brot);
        warenkorb.add(dvd);

        //output
        output(warenkorb);
    }

    private static void output(ArrayList<Artikel> warenkorb) {
        //output
        int i = 0;
        double gesamt = 0.0;
        double gegeben = 100;
        double mehrwertsteuer = 0.0;

        //Ausgabe Firma
        System.out.println("-------------------------------------");
        System.out.println("------------ Ayko Market ------------");
        System.out.println("------------- Straße Nr -------------");
        System.out.println("-------------- PLZ Ort --------------");
        System.out.println("-------------------------------------");
        System.out.println("-------------- Mo - Fr --------------");
        System.out.println("----------- 09:00 - 20:00 -----------");
        System.out.println("---------------- Sa ----------------");
        System.out.println("----------- 09:00 - 19:30 -----------");
        System.out.println("-------------------------------------\n");

        for (Artikel artikel : warenkorb) {
            System.out.println(artikel.info());
            gesamt += artikel.preis();
            mehrwertsteuer += artikel.mehrwertsteuer();
            i++;
        }

        if (warenkorb.size() == i && gegeben >= gesamt){
            System.out.println("------------------------------------");
            System.out.println("Gesamt\t\t\t\t\t\t"+String.format("%.2f", gesamt)+" EUR");
            System.out.println("inkl. Mehrwertsteuern von\t"+String.format("%.2f", mehrwertsteuer)+" EUR");
            System.out.println("Gegeben\t\t\t\t\t\t"+String.format("%.2f", gegeben)+" EUR\n");
            System.out.println("Zurück\t\t\t\t\t\t"+String.format("%.2f", gegeben - gesamt)+" EUR");
        }else {
            System.out.println("Überprüfen Sie bitte ihren Einkauf oder Sie haben zu wenig Geld gegeben!!");
        }
    }
}
