package com.example.laba7.utilities;

import javafx.scene.control.Alert;

public class AlertInformation {

    public static void alertInfoMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Информационное окно");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
    }
}
