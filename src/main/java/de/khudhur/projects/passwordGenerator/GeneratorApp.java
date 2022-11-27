package de.khudhur.projects.passwordGenerator;

public class GeneratorApp {
    public static void main(String[] args) {
        System.out.println(
                new PasswordGenerator
                        .PasswordGeneratorBuilder()
                        .useDigits(true)
                        .useLower(true)
                        .useUpper(true)
                        .build()
                        .generate(20)
        );

    }
}
