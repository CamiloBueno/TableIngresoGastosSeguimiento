module com.example.sguimiento14cab {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.seguimiento14cab to javafx.fxml;
    exports com.example.seguimiento14cab;
}