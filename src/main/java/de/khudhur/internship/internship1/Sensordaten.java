public class Sensordaten {
    public static void main(String[] args){
        filterMesswerte(1);
        filterMesswerte(4);
        filterMesswerte(7);
        filterMesswerte(6);
        filterMesswerte(-2);
        filterMesswerte(-3);
        filterMesswerte(0);
        filterMesswerte(-4);
        filterMesswerte(-1);
        filterMesswerte(1);
        filterMesswerte(1);
        filterMesswerte(1);
    }


    static int nullen = 0;
    static int einsen = 0;
    static boolean isRun = true;

    private static void filterMesswerte(int wert) {
        do {

            if(wert <= 0) // kleiner oder gleich 0
                System.out.println(wert); //gib wert aus

            if(wert == 1) { // einsen ueberpruefung
                einsen += 1;
            }
            if(wert == 0) { // nullen ueberpruefung
                nullen += wert;
            }

            if(einsen >= 3) {
                isRun = false;
            }
        }while(isRun);

        System.out.println("nullen: " + nullen);
        System.out.println("einsen: " + einsen);

                    
    }
} 