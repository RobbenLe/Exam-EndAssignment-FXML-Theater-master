module nl.inholland.nl.endassignment {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.management;
    requires java.desktop;

    opens nl.inholland.nl.endassignment to javafx.fxml;
    exports nl.inholland.nl.endassignment;
    exports Database;
    opens Database to javafx.fxml;
    //exports Controller;
    //opens Controller to javafx.fxml;
    //exports nl.inholland.nl.endassignment;
}