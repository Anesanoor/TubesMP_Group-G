package com.example.kasir;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "aplikasi.db";
    private static final int DATABASE_VERSION = 1;
    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        String sql = "create table user(nomer integer primary key, nama text null, tgl text null, jk text null, alamat text null);";
        Log.d("Data", "onCreate: " + sql);
        db.execSQL(sql);
        //insert data dummy
        sql = "INSERT INTO user(nomer, nama, tgl, jk, alamat) VALUES ('1', 'Andika Dwi Cipta', '2020-07-11', 'Laki-laki','Cianjur')";
        db.execSQL(sql);
        sql = "INSERT INTO user(nomer, nama, tgl, jk, alamat) VALUES ('2', 'Anesa Noor Aulia', '2020-07-11', 'Perempuan','Cimahi')";
        db.execSQL(sql);
        sql = "INSERT INTO user(nomer, nama, tgl, jk, alamat) VALUES ('3', 'Dicky Setiawan', '2000-07-15', 'Laki-laki','Cimahi')";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {

    }
}


