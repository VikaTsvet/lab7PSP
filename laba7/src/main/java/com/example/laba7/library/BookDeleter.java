package com.example.laba7.library;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.example.laba7.utils.DatabaseHandler.getDbConnection;


public class BookDeleter {

    public static void deleteBook(int id) {

        PreparedStatement ps;

        try {
            ps = getDbConnection().prepareStatement("DELETE FROM " + BookConsts.BOOK_TABLE +
                                                        " WHERE " + BookConsts.BOOK_ID + " = " + id);

            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
