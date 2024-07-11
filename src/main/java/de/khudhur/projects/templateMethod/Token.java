package de.khudhur.projects.templateMethod;

public abstract class Token {
    protected String content;

    public final String getHtml(){
        return htmlStart() + content + htmlEnd();
    }

    protected abstract String htmlStart();
    protected abstract String htmlEnd();
}
