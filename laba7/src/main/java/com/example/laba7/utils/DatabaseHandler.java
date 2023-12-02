package com.example.laba7.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHandler {

    public static Connection getDbConnection() throws ClassNotFoundException, SQLException {

        String connectionString = "jdbc:mysql://" + "localHost" + ":" + "3306" + "/" + "test";

        Class.forName("com.mysql.cj.jdbc.Driver");

        return DriverManager.getConnection(connectionString, "vika", "PASSWORD");
    }
}
