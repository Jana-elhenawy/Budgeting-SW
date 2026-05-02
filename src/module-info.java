module com.example.SW {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens com.example.SW to javafx.fxml;
    opens com.example.SW.Controller to javafx.fxml;
    opens com.example.SW.Model to javafx.base;

    exports com.example.SW;
    exports com.example.SW.Controller;
    exports com.example.SW.Model;
    exports com.example.SW.Util;
}