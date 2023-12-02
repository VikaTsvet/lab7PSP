package com.example.laba7.library;

import com.example.laba7.utils.DatabaseHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReaderGetter {
    public static ObservableList<Reader> getReadersData(String sql) {

        ObservableList<Reader> readersList = FXCollections.observableArrayList();

        Connection dbConnection;

        try {
            dbConnection = DatabaseHandler.getDbConnection();
            PreparedStatement ps = dbConnection.prepareStatement(sql);
            ResultSet getData = ps.executeQuery();
            readersList.clear();
            while (getData.next()) {
                readersList.add(new Reader(getData.getInt(ReaderConsts.READER_ID),
                        getData.getString(ReaderConsts.READER_NUMBER),
                        getData.getString(ReaderConsts.READER_PHONE),
                        getData.getString(ReaderConsts.READER_NAME)
                ));
            }
            ps.close();
            getData.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return readersList;
    }
}
