package com.example.kasir;

import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.kasir.DataHelper;
import com.example.kasir.R;

public class profilActivity extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;
    TextView text1, text2, text3, text4, text5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        dbHelper = new DataHelper(this);
        text1 = (TextView) findViewById(R.id.textView1);
        text2 = (TextView) findViewById(R.id.textView2);
        text3 = (TextView) findViewById(R.id.textView3);
        text4 = (TextView) findViewById(R.id.textView4);
        text5 = (TextView) findViewById(R.id.textView5);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String getinfo = getIntent().getStringExtra("nomer"); // ini harusnya nim bukan nama soalnya di main activity kamu bungkus data dari intent nya namanya nim bukan nama
        String[] pecah = getinfo.split("-");
        cursor = db.rawQuery("SELECT * FROM user WHERE nomer ='"+pecah[0]+"'",null); // ini harusnya pecah[0] soalnya kamu parameternya pake nim bukan nama kalo nama baru pake [1]
        cursor.moveToFirst();
        if (cursor.getCount()>0)
        {
            cursor.moveToPosition(0);
            text1.setText(cursor.getString(0).toString());
            text2.setText(cursor.getString(1).toString());
            text3.setText(cursor.getString(2).toString());
            text4.setText(cursor.getString(3).toString());
            text5.setText(cursor.getString(4).toString());
        }
    }
}
