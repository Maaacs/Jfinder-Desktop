module com.example.jfinder {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;
    requires java.sql;


    opens com.example.jfinder to javafx.fxml;
    exports com.example.jfinder;
}