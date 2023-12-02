package com.example.laba7.library;

import com.example.laba7.utils.DatabaseHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookGetter {
    public static ObservableList<Book> getBooksData(String sql) {

        ObservableList<Book> booksList = FXCollections.observableArrayList();

        Connection dbConnection;

        try {
            dbConnection = DatabaseHandler.getDbConnection();
            PreparedStatement ps = dbConnection.prepareStatement(sql);
            ResultSet getData = ps.executeQuery();
            booksList.clear();
            while (getData.next()) {
                booksList.add(new Book(getData.getInt(BookConsts.BOOK_ID),
                        getData.getString(BookConsts.BOOK_AUTHOR),
                        getData.getString(BookConsts.BOOK_NAME),
                        getData.getDouble(BookConsts.BOOK_PRICE),
                        getData.getString(BookConsts.BOOK_ISNEW)));
            }
            ps.close();
            getData.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return booksList;
    }
}
