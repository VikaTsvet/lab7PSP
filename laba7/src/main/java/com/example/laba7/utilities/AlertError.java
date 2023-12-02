package com.example.laba7.utilities;

import javafx.scene.control.Alert;

public class AlertError {

    public static void alertErrorMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Ошибка");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
    }
}
