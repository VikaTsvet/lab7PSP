package com.example.laba7.library;

import javafx.scene.control.TableView;

import static com.example.laba7.library.BookGetter.getBooksData;
import static com.example.laba7.library.EmployeeUpdater.updateEmployeeData;

public class UpdateCaller {

    public static void callForUpdate(String oldData,
                                  String newData,
                                  String tableName,
                                  String dbColumn,
                                  String tableColumn,
                                  String idColumnName,
                                  int id,
                                  TableView<Book> table) {

        // Вызываем метод, который обновляет данные в БД, и передаём ему необходимые параметры
        updateEmployeeData(oldData, newData, tableName, dbColumn, tableColumn, idColumnName, id);

        // Обновляем таблицу пользователей
        table.setItems(getBooksData("SELECT * FROM " + BookConsts.BOOK_TABLE));
    }
}
