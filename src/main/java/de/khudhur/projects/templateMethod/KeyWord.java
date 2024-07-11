package de.khudhur.projects.templateMethod;

public class KeyWord extends Token{
    @Override
    protected String htmlStart() {
        return "<font color=\"red\"><b>";
    }

    @Override
    protected String htmlEnd() {
        return "</b></font>";
    }
}
