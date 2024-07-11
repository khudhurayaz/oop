package de.khudhur.projects.games.LiliGame.constParameter;
public class CONST{
    private String title = "";
    private static final String PATH = "/de/khudhur/projects/";
    private String icon = "";

    public void setTitle(String newTitle){
        this.title = newTitle;
    }

    public String getTitle(){
        return title;
    }

    public void setIcon(String newIcon){
        this.icon = PATH + "image/" + newIcon;
    }

    public String getIcon(){
        return icon;
    }
}