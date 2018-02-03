package com.example.alvar.todolist;

import android.provider.BaseColumns;

/**
 * Created by Alvar on 03/02/2018.
 */

public final class ToDoListDatabaseContract {

    private ToDoListDatabaseContract() {}; // makes the class non-creatable


    public static final class ToDoListInfoEntry implements BaseColumns {

        public static final String TABLE_NAME = "todolist";
        public static final String COLUMN_TODOLIST_ID = "todolistId";
        public static final String COLUMN_TODOLIST_TITLE = "todolistTitle";
        public static final String COLUMN_TODOLIST_DATE = "todolistDate";
        public static final String COLUMN_TODOLIST_CATEGORY_ID = "todolistCategoryId";
        public static final String SQL_DELETE_TABLE = "DROP TABLE IF EXISTS ";

        // CREATE TABLE todolist (todolistID INTEGER PRIMARY KEY, todolistTitle TEXT, todolistDate TEXT, todolistCategoryID INT)
        public static final String SQL_CREATE_TABLE =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        _ID + " INTEGER PRIMARY KEY, " +
                        COLUMN_TODOLIST_TITLE + " TEXT, " +
                        COLUMN_TODOLIST_DATE + " TEXT, " +
                        COLUMN_TODOLIST_CATEGORY_ID + " INT" +
                        ")";
    }

    public static final class CategoriesInfoEntry implements BaseColumns {
        //Category table
        public static final String TABLE_NAME = "category";
        public static final String COLUMN_CATEGORY_ID = "categoryId";
        public static final String COLUMN_CATEGORY_NAME = "categoryName";
        public static final String SQL_DELETE_TABLE = "DROP TABLE IF EXISTS ";


        // CREATE TABLE category (COLUMN_CATEGORY_ID INTEGER PRIMARY KEY, COLUMN_CATEGORY_NAME TEXT);
        public static final String SQL_CREATE_TABLE =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        _ID + " INTEGER PRIMARY KEY, " +
                        COLUMN_CATEGORY_NAME + " TEXT" +
                        ")";
    }
}
