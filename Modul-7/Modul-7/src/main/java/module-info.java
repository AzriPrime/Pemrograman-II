module com.example.modul7 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.modul7 to javafx.fxml;
    exports com.example.modul7;
}