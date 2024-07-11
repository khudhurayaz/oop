package de.khudhur.projects.templateMethod;

public class TM {
    public static void main(String[] args) {
        Token token = new StringContent();
        token.content = "This is a test!";
        System.out.println(token.getHtml());
    }
}
