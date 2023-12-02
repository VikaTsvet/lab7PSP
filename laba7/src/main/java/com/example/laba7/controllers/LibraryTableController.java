package com.example.laba7.controllers;

import com.example.laba7.library.Book;
import com.example.laba7.library.BookConsts;
import com.example.laba7.library.Reader;
import com.example.laba7.library.ReaderConsts;
import com.example.laba7.library.BookGetter;
import com.example.laba7.library.ReaderGetter;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.DoubleStringConverter;

import java.net.URL;
import java.util.ResourceBundle;

import static com.example.laba7.library.BookDeleter.deleteBook;
import static com.example.laba7.library.BookGetter.getBooksData;
import static com.example.laba7.library.ReaderGetter.getReadersData;
import static com.example.laba7.library.UpdateCaller.callForUpdate;
import static com.example.laba7.utilities.AlertConfirmation.alertConfMessage;
import static com.example.laba7.utilities.AlertError.alertErrorMessage;
import static com.example.laba7.utilities.StageChanger.openNewStage;

public class LibraryTableController {
//    @FXML
//    private ResourceBundle resources;
//
//    @FXML
//    private URL location;

    @FXML
    private TableView<Book> bookTable;

    @FXML
    private TableView<Reader> readerTable;

    @FXML
    private TableColumn<Book, Integer> idBookColumn;

    @FXML
    private TableColumn<Book, String> nameBookColumn;

    @FXML
    private TableColumn<Book, String> authorBookColumn;

    @FXML
    private TableColumn<Book, Double> priceBookColumn;

    @FXML
    private TableColumn<Book, String> isNewBookColumn;

    @FXML
    private TableColumn<Reader, Integer> idReaderColumn;

    @FXML
    private TableColumn<Reader, String> ticketNumberColumn;

    @FXML
    private TableColumn<Reader, String> phoneColumn;

    @FXML
    private TableColumn<Reader, String> nameReaderColumn;

    public static TableView<Book> dopTable;
    public static TableView<Reader> dopTable2;

    @FXML
    void initialize() {
        dopTable = bookTable;
        dopTable2 = readerTable;

        idBookColumn.setCellValueFactory(new PropertyValueFactory<>(BookConsts.BOOK_ID));
        nameBookColumn.setCellValueFactory(new PropertyValueFactory<>(BookConsts.BOOK_NAME));
        authorBookColumn.setCellValueFactory(new PropertyValueFactory<>(BookConsts.BOOK_AUTHOR));
        isNewBookColumn.setCellValueFactory(new PropertyValueFactory<>(BookConsts.BOOK_ISNEW));
        priceBookColumn.setCellValueFactory(new PropertyValueFactory<>(BookConsts.BOOK_PRICE));

        idReaderColumn.setCellValueFactory(new PropertyValueFactory<>(ReaderConsts.READER_ID));
        ticketNumberColumn.setCellValueFactory(new PropertyValueFactory<>(ReaderConsts.READER_NUMBER));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>(ReaderConsts.READER_PHONE));
        nameReaderColumn.setCellValueFactory(new PropertyValueFactory<>(ReaderConsts.READER_NAME));

        bookTable.setItems(getBooksData("SELECT * FROM " + BookConsts.BOOK_TABLE));
        readerTable.setItems(getReadersData("SELECT * FROM " + ReaderConsts.READER_TABLE));

        bookTable.setEditable(true);

        authorBookColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        nameBookColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        isNewBookColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        priceBookColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));

        authorBookColumn.setOnEditCommit(cellEditEvent ->
                callForUpdate(cellEditEvent.getOldValue(),
                        cellEditEvent.getNewValue(),
                        BookConsts.BOOK_TABLE,
                        BookConsts.BOOK_AUTHOR,
                        bookTable.getColumns().get(1).getText(),
                        BookConsts.BOOK_ID,
                        cellEditEvent.getRowValue().getIdBook(),
                        bookTable));

        nameBookColumn.setOnEditCommit(cellEditEvent ->
                callForUpdate(cellEditEvent.getOldValue(),
                        cellEditEvent.getNewValue(),
                        BookConsts.BOOK_TABLE,
                        BookConsts.BOOK_NAME,
                        bookTable.getColumns().get(2).getText(),
                        BookConsts.BOOK_ID,
                        cellEditEvent.getRowValue().getIdBook(),
                        bookTable));

        isNewBookColumn.setOnEditCommit(cellEditEvent ->
                callForUpdate(cellEditEvent.getOldValue(),
                        cellEditEvent.getNewValue(),
                        BookConsts.BOOK_TABLE,
                        BookConsts.BOOK_ISNEW,
                        bookTable.getColumns().get(3).getText(),
                        BookConsts.BOOK_ID,
                        cellEditEvent.getRowValue().getIdBook(),
                        bookTable));

        priceBookColumn.setOnEditCommit(cellEditEvent ->
                callForUpdate(String.valueOf(cellEditEvent.getOldValue()),
                        String.valueOf(cellEditEvent.getNewValue()),
                        BookConsts.BOOK_TABLE,
                        BookConsts.BOOK_PRICE,
                        bookTable.getColumns().get(4).getText(),
                        BookConsts.BOOK_ID,
                        cellEditEvent.getRowValue().getIdBook(),
                        bookTable));

        bookTable.setOnKeyPressed(keyEvent -> {
            Book book = bookTable.getSelectionModel().getSelectedItem();
            switch (keyEvent.getCode().getName()) {
                case "F1":
                    openNewStage("/com/example/laba7/createBook.fxml");
                    break;

                case "Delete":
                    try {
                        deleteBook(book.getIdBook());
                        bookTable.setItems(getBooksData("SELECT * FROM " + BookConsts.BOOK_TABLE));
                        alertConfMessage("Книга успешно удалёна");
                    } catch (NullPointerException error) {
                        alertErrorMessage(String.valueOf(error));
                    }
                    break;
            }
        });
    }
}
