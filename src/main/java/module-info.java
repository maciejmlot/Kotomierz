module com.example.kotomierz {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.kotomierz to javafx.fxml;
    exports com.example.kotomierz;
}