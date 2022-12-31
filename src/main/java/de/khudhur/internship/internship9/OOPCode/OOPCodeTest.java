package de.khudhur.internship.internship9.OOPCode;

public class OOPCodeTest {

    private static final String PATH = "src/main/java/de/khudhur/internship/internship9/OOPCode/";
    public static void main(String[] args) throws Exception {

        //Für Zahlen, wenn Bild nicht vorhanden ist 3x3
        OOPCode codeFuer3 = new OOPCode(3);
        Codes<Boolean> codesFuer3 = new Codes<Boolean>(codeFuer3.getBool());
        //schwarze pixel setzen
        codesFuer3.setCode(1,1,true);
        //zweite schwarze pixel setzen
        codesFuer3.setCode(2,2,true);
        //hilfsboolean um es herauszufinden welches pixel schwarz ist
        codeFuer3.setBool(codesFuer3.getCode());
        System.out.println("OOPCode für Zahl 3: ");
        System.out.println("print Code: ");
        new Codes<Integer>().print(codeFuer3.getCode());
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>");
        //wenn es true ist, gibt es ein schwarzes punkt.
        System.out.println("print Boolean (Wo schwarze Pixel sind): ");
        new Codes<Boolean>().print(codeFuer3.getBool());
        System.out.println("OOPCode wäre: " + codeFuer3.encode());
        System.out.println("----------------------------------------------");


        //Für Zahlen, wenn Bild nicht vorhanden ist 4x4
        OOPCode codeFuer4 = new OOPCode(4);
        Codes<Boolean> codesFuer4 = new Codes<Boolean>(codeFuer4.getBool());
        codesFuer4.setCode(1,1,true);
        codesFuer4.setCode(2,2,true);
        codeFuer4.setBool(codesFuer4.getCode());
        System.out.println("\nOOPCode für Zahl 4: ");
        System.out.println("print Code: ");
        new Codes<Integer>().print(codeFuer4.getCode());
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>");
        //wenn es true ist, gibt es ein schwarzes punkt.
        System.out.println("print Boolean (Wo schwarze Pixel sind): ");
        new Codes<Boolean>().print(codeFuer4.getBool());
        System.out.println("OOPCode wäre: " + codeFuer4.encode());
        System.out.println("----------------------------------------------");

        //Falls, ein Bild übergeben wurde
        System.out.println("\nOOPCode für ein Bild: ");
        OOPCode codeFuerBild =  new OOPCode(PATH + "5x5.jpeg");
        codeFuerBild.getImage();
        //print code
        System.out.println("print Code: ");
        new Codes<Integer>().print(codeFuerBild.getData());
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("print Boolean (Wo schwarze Pixel sind): ");
        new Codes<Boolean>().print(codeFuerBild.getBool());
        System.out.println("OOPCode wäre: " + codeFuerBild.encode());
        System.out.println("Größte OOPCode wäre: " + codeFuerBild.bigEncode());
        System.out.println("Anzahl der Rotationen: " + codeFuerBild.getAnzahlRotationen());
    }

}
