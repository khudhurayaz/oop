module OOP.internships {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    exports de.khudhur;
    exports de.khudhur.projects.hamming;
    exports de.khudhur.projects.exmatrikulation;
    exports de.khudhur.projects.exmatrikulation.controller;

    opens de.khudhur to javafx.fxml;
    opens de.khudhur.projects.hamming to javafx.fxml;
    opens de.khudhur.projects.exmatrikulation.controller to javafx.fxml;

}