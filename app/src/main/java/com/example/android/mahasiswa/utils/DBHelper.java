package com.example.android.mahasiswa.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.android.mahasiswa.model.Mahasiswa;

import java.util.LinkedList;
import java.util.List;


public class DBHelper extends SQLiteOpenHelper  {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db_mahasiswa";
    private static final String TABLE_MAHASISWA = "table_mahasiswa";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NIM = "nim";
    private static final String COLUMN_NAMA = "nama";
    private static final String COLUMN_PRODI = "prodi";
    private static final String COLUMN_EMAIL = "email";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME , null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(" CREATE TABLE " + TABLE_MAHASISWA + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAMA + " TEXT NOT NULL, " +
                COLUMN_NIM + " TEXT NOT NULL, " +
                COLUMN_PRODI + " TEXT NOT NULL, " +
                COLUMN_EMAIL + " TEXT NOT NULL);"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_MAHASISWA);
        this.onCreate(sqLiteDatabase);
    }

    // Memasukkan record baru ke dalam database
    public void saveMahasiswa(Mahasiswa mahasiswa) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAMA, mahasiswa.getNamaMahasiswa());
        values.put(COLUMN_NIM, mahasiswa.getNimMahasiswa());
        values.put(COLUMN_PRODI, mahasiswa.getProdiMahasiswa());
        values.put(COLUMN_EMAIL, mahasiswa.getEmailMahasiswa());

        // insert
        db.insert(TABLE_MAHASISWA,null, values);
        db.close();
    }

    // Filter Option
    public List<Mahasiswa> mahasiswaList(String filter) {
        String query = null;
        if(filter.equals("")){
            // Query umum
            query = "SELECT  * FROM " + TABLE_MAHASISWA;
        }else if (filter.equals("Nama")){
            //Order berdasarkan Nama
            query = "SELECT  * FROM " + TABLE_MAHASISWA + " ORDER BY "+ COLUMN_NAMA;
        }else if (filter.equals("NIM")) {
            //Order berdasarkan NIM
            query = "SELECT  * FROM " + TABLE_MAHASISWA + " ORDER BY " + COLUMN_NIM;
        }else if (filter.equals("Program Studi")){
            //Order berdasarkan PRODI
            query = "SELECT  * FROM " + TABLE_MAHASISWA + " ORDER BY " + COLUMN_PRODI;
        }
        
        List<Mahasiswa> mahasiswaLinkedList = new LinkedList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Mahasiswa mahasiswa;

        if (cursor.moveToFirst()) {
            do {
                mahasiswa = new Mahasiswa();

                mahasiswa.setId(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)));
                mahasiswa.setNamaMahasiswa(cursor.getString(cursor.getColumnIndex(COLUMN_NAMA)));
                mahasiswa.setNimMahasiswa(cursor.getString(cursor.getColumnIndex(COLUMN_NIM)));
                mahasiswa.setProdiMahasiswa(cursor.getString(cursor.getColumnIndex(COLUMN_PRODI)));
                mahasiswa.setEmailMahasiswa(cursor.getString(cursor.getColumnIndex(COLUMN_EMAIL)));
                mahasiswaLinkedList.add(mahasiswa);
            } while (cursor.moveToNext());
        }

        return mahasiswaLinkedList;
    }


    // Query untuk satu record
    public Mahasiswa getMahasiswa(long id){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT  * FROM " + TABLE_MAHASISWA + " WHERE _id="+ id;
        Cursor cursor = db.rawQuery(query, null);

        Mahasiswa receivedMahasiswa = new Mahasiswa();
        if(cursor.getCount() > 0) {
            cursor.moveToFirst();

            receivedMahasiswa.setNamaMahasiswa(cursor.getString(cursor.getColumnIndex(COLUMN_NAMA)));
            receivedMahasiswa.setNimMahasiswa(cursor.getString(cursor.getColumnIndex(COLUMN_NIM)));
            receivedMahasiswa.setProdiMahasiswa(cursor.getString(cursor.getColumnIndex(COLUMN_PRODI)));
            receivedMahasiswa.setEmailMahasiswa(cursor.getString(cursor.getColumnIndex(COLUMN_EMAIL)));
        }

        return receivedMahasiswa;
    }

    // Menghapus sebuah record
    public void deleteMahasiswaRecord(long id, Context context) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("DELETE FROM "+ TABLE_MAHASISWA +" WHERE _id='"+id+"'");
        Toast.makeText(context, "Deleted successfully.", Toast.LENGTH_SHORT).show();

    }

    // Update sebuah record
    public void updateMahasiswaRecord(long mahasiswaId, Context context, Mahasiswa updatedMahasiswa) {
        SQLiteDatabase db = this.getWritableDatabase();
        //you can use the constants above instead of typing the column names
        db.execSQL("UPDATE  "+ TABLE_MAHASISWA +" SET nama ='"+ updatedMahasiswa.getNamaMahasiswa() +
                "', nim ='" + updatedMahasiswa.getNimMahasiswa()+
                "', prodi ='"+ updatedMahasiswa.getProdiMahasiswa() +
                "', email ='"+ updatedMahasiswa.getEmailMahasiswa() +
                "'  WHERE _id='" + mahasiswaId + "'");

        Toast.makeText(context, "Updated successfully.", Toast.LENGTH_SHORT).show();
    }

    public void deleteAllMahasiswaRecord(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_MAHASISWA);
    }
}
