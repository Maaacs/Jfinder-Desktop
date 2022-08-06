module com.example.jfinder {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.jfinder to javafx.fxml;
    exports com.example.jfinder;
}