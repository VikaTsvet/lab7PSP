module com.example.laba7 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;
    requires mysql.connector.java;


    opens com.example.laba7 to javafx.fxml;
    opens com.example.laba7.library to javafx.base;
    exports com.example.laba7;
    exports com.example.laba7.controllers;
    opens com.example.laba7.controllers to javafx.fxml;
}