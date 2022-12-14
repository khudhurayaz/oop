package de.khudhur;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(new Pane(), 400, 400));
        primaryStage.setTitle("Ayaz Khudhur");
        primaryStage.show();
    }

}
