package de.khudhur.projects.passwordGenerator;

public class GeneratorApp {
    public static void main(String[] args) {
        String password = new PasswordGenerator
                                    .PasswordGeneratorBuilder()
                                    .useLower(true)
                                    .useUpper(true)
                                    .useDigits(true)
                                    .usePunctuation(true)
                                    .build()
                                    .generate(12);

        System.out.println("Password: " + password);
    }
}
