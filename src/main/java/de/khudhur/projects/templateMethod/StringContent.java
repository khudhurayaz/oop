package de.khudhur.projects.templateMethod;

public class StringContent extends Token{
    @Override
    protected String htmlStart() {
        return "<font color=\"green\">";
    }

    @Override
    protected String htmlEnd() {
        return "</font>";
    }
}
