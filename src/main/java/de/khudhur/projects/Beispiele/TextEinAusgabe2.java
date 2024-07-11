package de.khudhur.projects.Beispiele;


import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TextEinAusgabe2 extends Frame {
    TextField eingabe;
    Label     ausgabe;

    public static void main( String[] args )
    {
        TextEinAusgabe2 meinFenster = new TextEinAusgabe2( "Text-Ein-/Ausgabe" );
        meinFenster.setSize( 400, 200 );
        meinFenster.setVisible( true );
    }

    public TextEinAusgabe2( String fensterTitel )
    {
        super( fensterTitel );
        Label hinweis = new Label( "Text eingeben und mit Return abschliessen" );
        eingabe = new TextField();
        ausgabe = new Label();
        add( BorderLayout.NORTH,  eingabe );
        add( BorderLayout.CENTER, hinweis );
        add( BorderLayout.SOUTH,  ausgabe );
        eingabe.addActionListener(ev -> meineMethode());
        addWindowListener(
                new WindowAdapter() {
                    public void windowClosing( WindowEvent ev ) {
                        dispose();
                        System.exit( 0 ); } } );
    }

    void meineMethode()
    {
        ausgabe.setText( "Der eingelesene Text lautet: " + eingabe.getText() );
    }
}