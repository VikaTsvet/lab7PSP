package com.example.laba7.library;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.example.laba7.utilities.AlertError.alertErrorMessage;
import static com.example.laba7.utils.DatabaseHandler.getDbConnection;

public class BookCreater {

    public static String createBook(Book book) {

        try {
            PreparedStatement prSt =
                    getDbConnection().prepareStatement(
                            "INSERT INTO " +
                                BookConsts.BOOK_TABLE + "(" +
                                    BookConsts.BOOK_NAME + "," +
                                    BookConsts.BOOK_AUTHOR + "," +
                                    BookConsts.BOOK_ISNEW + "," +
                                    BookConsts.BOOK_PRICE + ")" +
                                "VALUES(?,?,?,?)");

            prSt.setString(1, book.getNameBook());
            prSt.setString(2, book.getAuthorBook());
            prSt.setString(3, book.getIsNewBook());
            prSt.setDouble(4, book.getPriceBook());

            prSt.executeUpdate();
            return "Книга добавлена";
        } catch (SQLException | ClassNotFoundException error) {
            alertErrorMessage(String.valueOf(error));
            return null;
        }
    }
}
