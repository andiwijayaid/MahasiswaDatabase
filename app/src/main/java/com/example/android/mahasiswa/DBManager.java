package com.example.android.mahasiswa;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by Asus on 23/04/2018.
 */

public class DBManager {

    private SQLiteDatabase sqlDB;
    static final String dbName = "Mahasiswa";
    static final String tableName = "Mahasiswa";
    static final String colNama = "nama";
    static final String colProdi = "prodi";
    static final String colNIM = "nim";
    static final String colEmail = "email";
    static final int dbVersion = 1;

    static final String createTable = "CREATE TABLE IF NOT EXISTS " + tableName +
            " (" + colNIM + "TEXT PRIMARY KEY, " +
            colNama + " TEXT, " +
            colProdi + " TEXT, " +
            colEmail + " TEXT)";

    public DBManager(Context context) {
        DatabaseHelperUser db = new DatabaseHelperUser(context);
        sqlDB = db.getWritableDatabase();
    }

    static class DatabaseHelperUser extends SQLiteOpenHelper {

        Context context;

        DatabaseHelperUser(Context context) {
            super(context, dbName, null, dbVersion);
            this.context = context;
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL(createTable);
            Toast.makeText(context, "Database is created", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + tableName);
            onCreate(sqLiteDatabase);
        }
    }

}