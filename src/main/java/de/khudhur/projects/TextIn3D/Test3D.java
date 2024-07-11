package de.khudhur.projects.TextIn3D;

public class Test3D {
    private static String[] buchstaben;
    public static void main(String[] args) {
        String name = "Ayaz";
        buchstaben = new String[name.length()];
        print(name);
    }

    private static void print(String wort){
        char[] chars = wort.toCharArray();
        for (char aChar : chars) {
            if (aChar == 'a' || aChar == 'A') {
                printArray(1);
            }
            if (aChar == 'b' || aChar == 'B') {
                printArray(2);
            }
            if (aChar == 'c' || aChar == 'C') {
                printArray(3);
            }
            if (aChar == 'd' || aChar == 'D') {
                printArray(4);
            }
            if (aChar == 'e' || aChar == 'E') {
                printArray(5);
            }
            if (aChar == 'f' || aChar == 'F') {
                printArray(6);
            }
            if (aChar == 'g' || aChar == 'G') {
                printArray(7);
            }
            if (aChar == 'h' || aChar == 'H') {
                printArray(8);
            }
            if (aChar == 'i' || aChar == 'I') {
                printArray(9);
            }
            if (aChar == 'j' || aChar == 'J') {
                printArray(10);
            }
            if (aChar == 'k' || aChar == 'K') {
                printArray(11);
            }
            if (aChar == 'l' || aChar == 'L') {
                printArray(12);
            }
            if (aChar == 'm' || aChar == 'M') {
                printArray(13);
            }
            if (aChar == 'n' || aChar == 'N') {
                printArray(14);
            }
            if (aChar == 'o' || aChar == 'O') {
                printArray(15);
            }
            if (aChar == 'p' || aChar == 'P') {
                printArray(16);
            }
            if (aChar == 'q' || aChar == 'Q') {
                printArray(17);
            }
            if (aChar == 'r' || aChar == 'R') {
                printArray(18);
            }
            if (aChar == 's' || aChar == 'S') {
                printArray(19);
            }
            if (aChar == 't' || aChar == 'T') {
                printArray(20);
            }
            if (aChar == 'u' || aChar == 'U') {
                printArray(21);
            }
            if (aChar == 'v' || aChar == 'V') {
                printArray(22);
            }
            if (aChar == 'w' || aChar == 'W') {
                printArray(23);
            }
            if (aChar == 'x' || aChar == 'X') {
                printArray(24);
            }
            if (aChar == 'y' || aChar == 'Y') {
                printArray(25);
            }
            if (aChar == 'z' || aChar == 'Z') {
                printArray(26);
            }
        }

    }

    private static int numberOfChar = 0;

    private static void printArray(int x) {
        String temp = "";
        for (int i = x-1; i < x; i++) {
            for (int j = 0; j < DDDText.letters[0].length-1; j++) {
                temp += DDDText.letters[i][j];
                temp += "\n";
            }
            StringBuilder buffer = new StringBuilder(temp);
            buffer.deleteCharAt(buffer.length()-1);
            buchstaben[numberOfChar] = buffer.toString();
            numberOfChar++;
            System.out.print(temp);
        }
    }
}
