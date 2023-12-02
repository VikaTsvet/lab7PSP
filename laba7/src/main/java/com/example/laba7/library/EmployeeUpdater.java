package com.example.laba7.library;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

import static com.example.laba7.utilities.AlertConfirmation.alertConfMessage;
import static com.example.laba7.utilities.AlertError.alertErrorMessage;
import static com.example.laba7.utils.DatabaseHandler.getDbConnection;

public class EmployeeUpdater {

    public static void updateEmployeeData(String oldData,
                                          String newData,
                                          String tableName,
                                          String dbColumn,
                                          String tableColumn,
                                          String idColumnName,
                                          int id) {

        try {
            if (!Objects.equals(oldData, newData)) {
                PreparedStatement prSt;
                prSt = getDbConnection().prepareStatement(
                        "UPDATE " + tableName +
                            " SET " + dbColumn + " = '" + newData +
                            "' WHERE " + idColumnName + " = " + id);
                prSt.executeUpdate();
                alertConfMessage("Данные в колонке '" + tableColumn + "' успешно обновлены.\n" +
                                "Старое значение: " + oldData + "\n" +
                                "Новое значение: " + newData);
            } else {
                alertErrorMessage("Старое значение совпадает с новым: " + oldData);
            }
        } catch (SQLException | ClassNotFoundException error) {
            alertErrorMessage(String.valueOf(error));
        }
    }
}
