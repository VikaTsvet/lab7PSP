package com.example.laba7.controllers;


import com.example.laba7.library.Book;
import com.example.laba7.library.BookConsts;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import static com.example.laba7.controllers.LibraryTableController.dopTable;
import static com.example.laba7.library.BookCreater.createBook;
import static com.example.laba7.library.BookGetter.getBooksData;
import static com.example.laba7.utilities.AlertConfirmation.alertConfMessage;
import static com.example.laba7.utilities.StageChanger.newStage;

public class CreateBookController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane mainScene;

    @FXML
    private TextField authorBookField;

    @FXML
    private TextField nameBookField;

    @FXML
    private TextField isNewBookField;

    @FXML
    private TextField priceBookField;

    @FXML
    private ImageView addImageView;

    @FXML
    void initialize() {

        mainScene.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode().getName().equals("Esc")) {
                newStage.getScene().getWindow().hide();
            }
        });

//        clearSurnameFieldImageView.setOnMouseClicked(mouseEvent -> surnameField.clear());
//        clearNameFieldImageView.setOnMouseClicked(mouseEvent -> nameField.clear());
//        clearPatronymicFieldImageView.setOnMouseClicked(mouseEvent -> patronymicField.clear());
//        clearPositionFieldImageView.setOnMouseClicked(mouseEvent -> positionField.clear());
//        clearSalaryFieldImageView.setOnMouseClicked(mouseEvent -> salaryField.clear());
//
//        clearImageView.setOnMouseClicked(mouseEvent -> {
//            surnameField.clear();
//            nameField.clear();
//            patronymicField.clear();
//            positionField.clear();
//            salaryField.clear();
//        });

        addImageView.setOnMouseClicked(mouseEvent -> {
            if (Objects.equals(createBook(new Book(authorBookField.getText(), nameBookField.getText(), Double.parseDouble(priceBookField.getText()), isNewBookField.getText())),"Книга добавлена")) {
                newStage.getScene().getWindow().hide();
                dopTable.setItems(getBooksData("SELECT * FROM " + BookConsts.BOOK_TABLE));
                alertConfMessage("Книга добавлена");
            }
        });

//        returnImageView.setOnMouseClicked(mouseEvent -> newStage.getScene().getWindow().hide());
    }
}
