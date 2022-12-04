package de.khudhur.projects.passwordGenerator;

public class GeneratorApp {
    public static void main(String[] args) {
        String password = new PasswordGenerator.PasswordGeneratorBuilder().useLower(true).useUpper(true).useDigits(true).build().generate(20);

        System.out.println("Password: " + password);

    }
}
