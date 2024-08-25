module com.codeclique.dsa.pharmacyapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.sql;
    requires mysql.connector.j;

    opens com.codeclique.dsa2.pharmacyapp to javafx.fxml;
    exports com.codeclique.dsa2.pharmacyapp;
    exports com.codeclique.dsa2.pharmacyapp.managers;
    opens com.codeclique.dsa2.pharmacyapp.managers to javafx.fxml;
    exports com.codeclique.dsa2.pharmacyapp.models;
    opens com.codeclique.dsa2.pharmacyapp.models to javafx.fxml;
}