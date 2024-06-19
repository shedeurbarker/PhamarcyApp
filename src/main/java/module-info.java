module com.codeclique.dsa2.pharmacyapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens com.codeclique.dsa2.pharmacyapp to javafx.fxml;
    exports com.codeclique.dsa2.pharmacyapp;
}