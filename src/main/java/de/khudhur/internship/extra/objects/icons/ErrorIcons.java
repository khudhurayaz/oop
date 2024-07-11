package de.khudhur.internship.extra.objects.icons;


import de.khudhur.internship.extra.objects.enumClasses.ErrorEnum;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ErrorIcons {

    public static final String WARNING = "src/main/java/de/khudhur/internship/extra/assets/error/warning.png";
    public static final String ERROR = "src/main/java/de/khudhur/internship/extra/assets/error/error.png";
    public static final String INFORMATION = "src/main/java/de/khudhur/internship/extra/assets/error/information.png";
    public static BufferedImage warning, information, error;

    public ErrorIcons(){
        loadIcons();
    }

    private void loadIcons(){
        try {
            information = ImageIO.read(new File("src/main/java/de/khudhur/internship/extra/assets/" + "error/" + "information.png"));
            error = ImageIO.read(new File("src/main/java/de/khudhur/internship/extra/assets/" + "error/" + "error.png"));
            warning = ImageIO.read(new File("src/main/java/de/khudhur/internship/extra/assets/" + "error/" + "warning.png"));
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public String getIcon(ErrorEnum errorEnum){
        String get = "";
        switch (errorEnum){
            case ERROR -> get = ERROR;
            case WARNING -> get = WARNING;
            case INFORMATION -> get = INFORMATION;
        }
        return get;
    }
}
