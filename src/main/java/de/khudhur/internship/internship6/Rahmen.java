package de.khudhur.internship.internship6;

public class Rahmen {

    /**
     * Rahmen um einen Text generieren.
     * @param text String array
     */
    public void rahmen(String...text){
        //Temporär String array
        String[] texts = new String[text.length];
        //in temp: texts überschreiben
        System.arraycopy(text, 0, texts, 0, text.length);

        //Längste Zeile finden
        //variable length, für oben und unten sternen.
        int len = 0;
        //for-schleife
        for (String s : texts) {
            for (int j = 0; j < texts.length - 1; j++) {
                //erste prüfung, wenn texts[i].length() 'Rahmen' > texts[j].length() 'sind' ist.
                //wird beim zweiten prüfung nochmal überprüft ob
                //texts[i].length() 'Rahmen' //ändert sich nach jedem i durchlauf
                //größer als gespeichertes length - 'len' ist.
                if (s.length() > texts[j + 1].length()) {
                    if (s.length() > len) {
                        //dann erst abspeichern
                        len = s.length();
                    }
                }
            }
        }

        //initialisieren, mit der übergebenes len
        char[] stern = new char[len];
        //Sterne für oben und unten
        stern = starForTopAndBottom(stern.length);

        //sterne verketten
        StringBuilder sterne = new StringBuilder();
        for (char c : stern) {
            sterne.append(c);
        }

        for (int i = 0; i < texts.length; i++) {

            //Sterne für Anfang
            if (i == 0){
                System.out.println(sterne);
            }

            //Am Anfang wird ein stern + texts[an der stelle i] übergeben
            // und am Ende + stern.
            //mit jedem durchgelaufene i, wird sich Sys wiederholen.
            System.out.println("* " + texts[i] + addSpace(stern.length, texts[i].length()) + "*");

            //Sterne für Ende
            if (texts.length-1 == i){
                System.out.println(sterne);
            }
        }

    }

    /**
     * Methode starForTopAndBottom()
     * @param firstLine wie viele Sterne sollen erstellt werden
     * @return Char Array mit Anzahl an übergebenes int
     */
    private char[] starForTopAndBottom(int firstLine){
        //firstLine ist 10 + 4 = 14
        //char array wird mit länge 14 erstellt, in dem Bsp.
        char[] topBottom = new char[firstLine+4];
        for (int i = 0; i < topBottom.length; i++) {
            //14 Sterne, in char array speichern
            topBottom[i] += '*';
        }
        return topBottom;//char array zurückliefern
    }

    /**
     * Methode addSpace
     * @param j - länge der Sterne, um Leerzeichen richtig dazustellen
     * @param textLength - länge der Text zeilen
     * @return - Ein String in dem space gespeichert sind
     */
    private String addSpace(int j, int textLength){
        //size abfrage, ob textLength < Sterne (char) sind
        // ziehe die Länge der Sterne von textLength ab, zusätzlich - 3
        // ansonsten ist textLength
        int size = (textLength < j) ? (j - textLength)-3 : textLength;
        //Leerzeichen
        String space = "";
        //Leerzeichen hinzufügen
        for (int i = 0; i < size; i++) {
            space += " ";
        }

        //Leerzeichen zurückliefern
        return space;
    }

}
