package de.khudhur.projects.exmatrikulation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Exmatrikulation extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(Exmatrikulation.class.getResource("/de/khudhur/projects/exmatrikulation/fxml/exmatrikulation.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/de/khudhur/projects/exmatrikulation/style/master.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("ExmatrikulationController");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
