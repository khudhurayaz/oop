package de.khudhur.test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FXApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScee(new Scene(new Panel(), 800, 600));
        stage.show();
    } 

    public static void main(String[] args) {
        launch(args);
    }
}