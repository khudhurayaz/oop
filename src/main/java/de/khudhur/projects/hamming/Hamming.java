package de.khudhur.projects.hamming;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Objects;

/**
 *
 */
public class Hamming extends Application {

    private final static double width = 800, height = 400;

    public static void main(String[] args) {
        launch(args);
    }

    public static enum MENU {
        HOME("HOME"),
        DISTANCE("HAMMING DISTANCE");

        public final String value;
        MENU(String value) {
            this.value = value;
        }
    }

    public static int hammingDistance(String[] s1, String[] s2){
        int count = 0;
        if (s1.length != s2.length){
            return -1;
        }

        for (int i = 0; i < s1.length; i++){
            if (!Objects.equals(s1[i], s2[i])) count++;
        }

        return count;
    }

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane pane = new BorderPane();
        pane.setMinSize(width, height);
        BorderPane.setAlignment(pane, Pos.CENTER);

        HBox hTop = new HBox();
        hTop.setAlignment(Pos.CENTER);
        HBox hDown = new HBox();
        hDown.setAlignment(Pos.CENTER);
        VBox vLeft = new VBox(10);
        vLeft.setMinSize(200, height);
        vLeft.setAlignment(Pos.BASELINE_CENTER);
        VBox vRight = new VBox();
        vRight.setAlignment(Pos.BASELINE_CENTER);

        VBox vCenter = new VBox(10);
        VBox vCenterChilder = new VBox(10);
        vCenterChilder.setMinSize(width/2, height);
        vCenterChilder.setAlignment(Pos.BASELINE_LEFT);
        Label lblVCenterDefault = new Label("Wähle im Menü eine Aufgabe aus!");
        lblVCenterDefault.setStyle("-fx-font-size: 24px;");
        vCenter.getChildren().add(lblVCenterDefault);

        //Überschrift
        Label lblUeberschrift = new Label("Hamming");
        lblUeberschrift.setStyle("-fx-font-size: 64px");
        hTop.getChildren().add(lblUeberschrift);

        //Menu Links
        Button btnHome = getButton(MENU.HOME.value);
        Button btnDistance = getButton(MENU.DISTANCE.value);
        vLeft.getChildren().addAll(btnHome, btnDistance);

        center(vCenter, vCenterChilder, btnHome, btnDistance);


        //Kinder hinzufügen
        pane.setTop(hTop);
        pane.setLeft(vLeft);
        pane.setCenter(vCenter);
        pane.setRight(vRight);
        pane.setBottom(hDown);


        Scene scene = new Scene(pane);
        stage.setMinWidth(width);
        stage.setMinHeight(height);
        stage.setScene(scene);
        stage.setTitle("Hamming");
        stage.setResizable(false);
        stage.show();
    }

    private void center(VBox vCenter, VBox vCenterChilder, Button...btns) {
        for (Button btn : btns){
            if (btn.getText().equalsIgnoreCase(MENU.HOME.value)){
                btn.setOnAction(e -> {
                    vCenterChilder.getChildren().clear();
                    vCenter.getChildren().clear();

                    Label lbl = new Label("Wähle im Menü eine Aufgabe aus!");
                    lbl.setStyle("-fx-font-size: 24px;");

                    vCenterChilder.getChildren().add(lbl);
                    vCenter.getChildren().addAll(vCenterChilder);
                });
                
            } else if (btn.getText().equalsIgnoreCase(MENU.DISTANCE.value)) {
                //Center root
                btn.setOnAction(e -> {
                    //Clear root
                    vCenterChilder.getChildren().clear();
                    vCenter.getChildren().clear();

                    //füge Kinder
                    HBox hChilder = new HBox(10);
                    hChilder.setAlignment(Pos.BASELINE_LEFT);
                    Label lblDistance = new Label("Hamming Distance");
                    lblDistance.setStyle("-fx-font-size: 32px;");


                    TextField tf1 = new TextField();
                    tf1.setPromptText("Erste Codewort");
                    TextField tf2 = new TextField();
                    tf2.setPromptText("Zweite Codewort");
                    Label lbl3 = new Label("Ergebnis: ");

                    hChilder.getChildren().addAll(tf1, tf2, btnDistanceBerechnen(tf1, tf2, lbl3));
                    vCenterChilder.getChildren().addAll(lblDistance, hChilder, lbl3);
                    vCenter.getChildren().addAll(vCenterChilder);
                });
            }
        }
    }

    private static Button btnDistanceBerechnen(TextField tf1, TextField tf2, Label lbl3) {
        Button btnDistanceBerechnen = new Button("Berechnen");
        btnDistanceBerechnen.setOnAction(berechnen -> {
            char[] cA = tf1.getText().toCharArray();
            char[] cB = tf2.getText().toCharArray();
            String[] a = new String[cA.length], b = new String[cB.length];
            for (int i = 0; i < cA.length; i++) {
                a[i] = String.valueOf(cA[i]);
            }
            for (int i = 0; i < cB.length; i++) {
                b[i] = String.valueOf(cB[i]);
            }
            int hamming = hammingDistance(a, b);
            if (hamming == -1){
                lbl3.setText("Fehler! Die länge sind nicht identisch!");
            }else {
                lbl3.setText("Ergebnis: " + hammingDistance(a, b));
            }
        });
        return btnDistanceBerechnen;
    }

    private static Button getButton(String name){
        Button btn = new Button(name);
        btn.setStyle("-fx-font-size: 14px;");
        btn.setMinSize(150, 30);
        return btn;
    }
}
