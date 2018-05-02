package com.example.android.mahasiswa;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class DBHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db_mahasiswa";
    private static final String TABLE_MAHASISWA = "table_mahasiswa";
    private static final String COLUMN_NIM = "nim";
    private static final String COLUMN_NAMA = "nama";
    private static final String COLUMN_PRODI = "prodi";
    private static final String COLUMN_EMAIL = "email";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_MAHASISWA + "("
                + COLUMN_NIM + " TEXT PRIMARY KEY," + COLUMN_NAMA + " TEXT, "
                + COLUMN_PRODI + " TEXT, " + COLUMN_EMAIL + " TEXT" + ")";
        sqLiteDatabase.execSQL(CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_MAHASISWA);
        onCreate(sqLiteDatabase);
    }

    // FUNGSI UNTUK TAMBAH DATA MAHASISWA
    public void tambahMahasiswa(Mahasiswa mahasiswa){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NIM, mahasiswa.nimMahasiswa);
        values.put(COLUMN_NAMA, mahasiswa.namaMahasiswa);
        values.put(COLUMN_PRODI, mahasiswa.prodiMahasiswa);
        values.put(COLUMN_EMAIL, mahasiswa.emailMahasiswa);

        db.insert(TABLE_MAHASISWA, null, values);
        db.close();
    }

    // FUNGSI UNTUK AMBIL 1 DATA MAHASISWA
    public Mahasiswa getMahasiswa(int nim_mahasiswa){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_MAHASISWA, new String[]{COLUMN_NIM, COLUMN_NAMA, COLUMN_PRODI, COLUMN_EMAIL},
                COLUMN_NIM + "=?", new String[]{String.valueOf(nim_mahasiswa)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Mahasiswa mahasiswa = new Mahasiswa(cursor.getString(1), cursor.getString(0), cursor.getString(2), cursor.getString(3));
        return mahasiswa;
    }

    // FUNGSI UNTUK AMBIL SEMUA DATA MAHASISWA
    public List<Mahasiswa> getSemuaMahasiswa(){
        List<Mahasiswa> mahasiswaList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_MAHASISWA;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()){
            do {
                Mahasiswa mahasiswa = new Mahasiswa(cursor.getString(1), cursor.getString(0), cursor.getString(2), cursor.getString(3));
                mahasiswaList.add(mahasiswa);
            } while (cursor.moveToNext());
        }
        return mahasiswaList;
    }


}
