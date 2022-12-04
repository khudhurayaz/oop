module OOP.internships {
    requires javafx.controls;
    requires javafx.fxml;

    exports de.khudhur;
    exports de.khudhur.projects.exmatrikulation;
    exports de.khudhur.projects.exmatrikulation.controller;

    opens de.khudhur to javafx.fxml;
    opens de.khudhur.projects.exmatrikulation.controller to javafx.fxml;
}