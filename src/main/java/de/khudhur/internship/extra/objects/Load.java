package de.khudhur.internship.extra.objects;

import de.khudhur.internship.extra.objects.enumClasses.ErrorEnum;
import de.khudhur.internship.extra.objects.enumClasses.FontEnum;
import de.khudhur.internship.extra.objects.icons.ErrorIcons;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * loadIcon() - lädt ein Icon
 * loadImageIcon() - lädt ein Bild
 * bufferedImage() - lädt ein BufferedImage
 * loadFonts() - ladet die Fonts
 *
 * @author AG
 * @version 1.0
 */
public class Load {
    private static Object objects = new Object();

    /**
     * Die Methode loadIcon, lädt aus dem angegebenes
     * Pfad ein Bild
     * @param path Bildpfad als String variable
     * @return see {@link Image}, wird geladen
     */
    public Image loadIcon(String path){
        return new ImageIcon(path).getImage();
    }

    /**
     * Die Methode loadImageIcon, ladet aus dem angegebenes
     * Pfad ein Bild.
     * @param path Bildpfad als String variable
     * @return see {@link ImageIcon}, wird geladen
     */
    public ImageIcon loadImageIcon(String path){
        return new ImageIcon(path);
    }

    /**
     * @param path Der Pfad zum Laden eines Bildes
     * @return geladenes Bild wird zurückgeliefert, falls vorhanden ist,
     *          ansonsten wird ein entsprechendes Exception ausgegeben.
     */
    public BufferedImage bufferedImage(String path){
        //temp BufferedImage
        BufferedImage image = null;
        //versuche ... Image zu laden
        try {
            //image laden
            image = ImageIO.read(new File(path));
        } catch (IOException e) {
            new Object().createJFrame(
                    "Load a bufferedImage",
                    new Object().getErrorIcons().getIcon(ErrorEnum.ERROR),
                    "Can not load the image",
                    e.getMessage(),
                    false
            );
        }
        return image;
    }

    /**
     * Die Methode ladet von der Enum Klasse die erforderlichen Schriftarten.
     * Dadurch kann ich besser ein auswahl zutreffen kann.
     * @param fontEnum @see{@link FontEnum}
     * @param size Schriftgröße eingeben
     * @return Neues Font objekt
     */
    public Font loadFonts(FontEnum fontEnum, float size){
        //Font pfad
        String f = Object.PATH + "fonts/";

        //switch case
        switch (fontEnum){
            //Schriftart Monatha
            case MONATHA -> f += "Monatha.ttf";
            //Schriftart Prof Bens
            case PROF_BENS -> f += "pb.ttf";
            //Standard Schriftart wäre MONOSPACED
            default -> new Font(Font.MONOSPACED, Font.ITALIC, 18);
        }
        //Font objekt
        Font font = null;
        //versuche die Fonts durch angegebenes Datei zu laden
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File(f));
            font = font.deriveFont(size);
        } catch (IOException | FontFormatException e) {
            String str = "Wo: LoadClass (loadFonst method)\n";
            str += "Nachricht: " + e.getMessage();
            str += "\nNachricht lokalisiert: " + e.getLocalizedMessage();
            if (objects.getCreatedJFrame() == null)
                objects.createJFrame(
                        "FontEnum Error",
                        ErrorIcons.ERROR,
                        "Der Schriftart '" + fontEnum + "'\n kann nicht geladen werden",
                        str,
                        true
                );
        }
        return  font;
    }
}
