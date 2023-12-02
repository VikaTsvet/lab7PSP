package com.example.laba7.utilities;

import javafx.scene.control.Alert;

public class AlertConfirmation {

    public static void alertConfMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Подтверждение");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
    }
}
