package com.example.alvar.todolist;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static com.example.alvar.todolist.ToDoListDatabaseContract.*;

/**
 * Created by Alvar on 03/02/2018.
 */

public class ToDoListDBHelper extends SQLiteOpenHelper {

    private static final String LOGTAG = "Todolist";
    private static final String DATABASE_NAME = "todolist.db";
    private static final int DATABASE_VERSION = 3;

    public ToDoListDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CategoriesInfoEntry.SQL_CREATE_TABLE);
        db.execSQL(ToDoListInfoEntry.SQL_CREATE_TABLE);
        Log.i(LOGTAG, "Tables created");

        db.execSQL("INSERT INTO category (categoryName) VALUES ('Home'), ('Work'), ('School'), ('Sports'), ('Family'), ('Hobbies')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < newVersion) {
            db.execSQL(CategoriesInfoEntry.SQL_DELETE_TABLE + CategoriesInfoEntry.TABLE_NAME);
            db.execSQL(ToDoListInfoEntry.SQL_DELETE_TABLE + ToDoListInfoEntry.TABLE_NAME);
            onCreate(db);
            Log.i(LOGTAG, "Database upgraded from " + oldVersion + " to " + newVersion);

        }
    }


    public Cursor getAllCategories() {

        SQLiteDatabase db = getReadableDatabase();
        String[] categoryColumns = {
                CategoriesInfoEntry.COLUMN_CATEGORY_NAME,
                CategoriesInfoEntry._ID
        };

        Cursor cursor = db.query(CategoriesInfoEntry.TABLE_NAME, categoryColumns, null, null, null, null, null);
        return cursor;

    }
}
