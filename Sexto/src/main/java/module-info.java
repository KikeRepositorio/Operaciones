module com.example.sexto {
    requires javafx.controls;
    requires javafx.fxml;


    opens Control to javafx.fxml;
    exports Control;
}