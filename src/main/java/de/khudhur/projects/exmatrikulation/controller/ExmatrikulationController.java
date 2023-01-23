package de.khudhur.projects.exmatrikulation.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class ExmatrikulationController implements Initializable {

    @FXML
    private Text txtStatus;
    @FXML
    private VBox content;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Button ja = new Button("Ja");
        ja.setPrefSize(60, 20);
        ja.setOnMouseEntered(e -> {
            Stage main;
            main = (Stage) ((Node) e.getSource()).getScene().getWindow();
            Random random = new Random();
            double w = main.getMinWidth() + ja.getPrefWidth() - content.getMaxWidth();
            double h = main.getMinHeight() + ja.getPrefHeight() - content.getMaxHeight();
            double width = random.nextDouble() * w;
            double height = random.nextDouble() * h;
            boolean weiter = true;

            do {
                if (width > content.getWidth() || height > content.getHeight() || width > main.getWidth() || height > main.getHeight()) {
                    width = random.nextDouble() * w;
                    height = random.nextDouble() * h;
                }else {
                    weiter = false;
                }
                ja.setTranslateY(width - ja.getWidth());
                ja.setTranslateX(height - ja.getHeight());
            }while (weiter);

            System.out.println("width: " + (width - ja.getWidth()) + "\nheight: " + (height - ja.getHeight()));
            ja.setOnAction(actionEvent -> txtStatus.setText("Glückwunsch du hast Geschafft!"));
        });

        Button nein = new Button("Nein");
        nein.setPrefSize(60, 20);
        nein.setOnAction(e -> {
            System.out.println("Programm schließt sich..");
            Platform.exit();
            System.exit(1);
        });
        ja.getStyleClass().add("btnJa");
        content.getChildren().addAll(ja, nein);
    }
}
