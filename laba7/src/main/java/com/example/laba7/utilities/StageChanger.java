package com.example.laba7.utilities;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class StageChanger {

    public static Stage newStage;

    public static void openNewStage(String window) {

        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(StageChanger.class.getResource(window));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setTitle("Библиотека");
        stage.setScene(new Scene(root));
        stage.show();

        newStage = stage;
    }
}
