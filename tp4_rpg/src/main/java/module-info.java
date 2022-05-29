module com.example.tp4_rpg {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tp4_rpg to javafx.fxml;
    exports com.example.tp4_rpg;
}