package com.example.kasir;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
public class DataHelper1 extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "kasir.db";
    private static final int DATABASE_VERSION = 1;
    public DataHelper1(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        String sql = "create table menu(id_menu text primary key, nama_menu text null, harga integer null);";
        Log.d("Data", "onCreate: " + sql);
        db.execSQL(sql);
        //insert data dummy
        sql = "INSERT INTO menu(id_menu, nama_menu, harga) VALUES ('m1', 'Vanilla', '8000');";
        db.execSQL(sql);
        sql = "INSERT INTO menu(id_menu, nama_menu, harga) VALUES ('m2', 'Strawberry', '8000');";
        db.execSQL(sql);
        sql = "INSERT INTO menu(id_menu, nama_menu, harga) VALUES ('m3', 'Choco Oreo', '8000');";
        db.execSQL(sql);
        sql = "INSERT INTO menu(id_menu, nama_menu, harga) VALUES ('m4', 'Matcha Latte', '10000');";
        db.execSQL(sql);
        sql = "INSERT INTO menu(id_menu, nama_menu, harga) VALUES ('m5', 'Original', '2000');";
        db.execSQL(sql);
        sql = "INSERT INTO menu(id_menu, nama_menu, harga) VALUES ('m6', 'Keju', '2500');";
        db.execSQL(sql);
        sql = "INSERT INTO menu(id_menu, nama_menu, harga) VALUES ('m7', 'Coklat', '2500');";
        db.execSQL(sql);
        sql = "INSERT INTO menu(id_menu, nama_menu, harga) VALUES ('m8', 'Kacang', '2500');";
        db.execSQL(sql);
        sql = "INSERT INTO menu(id_menu, nama_menu, harga) VALUES ('m9', 'Choco Almond', '2500');";
        db.execSQL(sql);
        sql = "INSERT INTO menu(id_menu, nama_menu, harga) VALUES ('m10', 'Kacang Almond', '2500');";
        db.execSQL(sql);
        sql = "INSERT INTO menu(id_menu, nama_menu, harga) VALUES ('m11', 'Green Tea', '2500');";
        db.execSQL(sql);
        sql = "INSERT INTO menu(id_menu, nama_menu, harga) VALUES ('m12', 'Oreo', '2500');";
        db.execSQL(sql);
    }
    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
    }
}