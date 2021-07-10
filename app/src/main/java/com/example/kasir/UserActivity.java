package com.example.kasir;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class UserActivity extends AppCompatActivity {
    String[] daftar;
    String[] daftar2;
    ListView ListView01;
    Menu menu;
    protected Cursor cursor;
    DataHelper dbcenter;
    public static UserActivity da;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        Button btn = (Button) findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent inte = new Intent( UserActivity.this, InputActivity.class);
                startActivity(inte);
            }
        });
        da=this;
        dbcenter = new DataHelper(this);
        RefreshList();
    }

    public void RefreshList() {
        SQLiteDatabase db = dbcenter.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM user", null);
        daftar = new String[cursor.getCount()];
        daftar2 = new String[cursor.getCount()];
        cursor.moveToFirst();
        for (int cc = 0; cc < cursor.getCount(); cc++) {
            cursor.moveToPosition(cc);
            daftar[cc] = cursor.getString(0).toString()+ "-" + cursor.getString(1).toString();
        }
        for (int cc = 0; cc < cursor.getCount(); cc++) {
            cursor.moveToPosition(cc);
            daftar2[cc] = cursor.getString(0).toString();
        }

        ListView01 = (ListView) findViewById(R.id.listView1);
        ListView01.setAdapter(new ArrayAdapter(this,android.R.layout.simple_list_item_1, daftar));
        ListView01.setSelected(true);

        //set on click
//        ListView01.setSelected(true); //ini ga usah di pake cukup di panggil sekali aja soalnya di line 54 udah di panggil
        ListView01.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView arg0, View arg1, int arg2, long arg3) {
                final String selection = daftar2[arg2];
                //.getItemAtPosition(arg2).toString();
                final CharSequence[] dialogitem = {"Lihat Data", "Update Data", "Hapus Data"};
                AlertDialog.Builder builder = new  AlertDialog.Builder(UserActivity.this);// aku ngerubah posisi ini yg asalnya di line 62 dirubah ke 63
                builder.setTitle("Pilihan");
                builder.setItems(dialogitem, new DialogInterface.OnClickListener()    { // ini aku rubah yg new dialog yg asalnya di line 66 disatuin ke line 65. kalo bikin objek harus satubaris jangan di pisah jadi dua baris
                    public void onClick(DialogInterface dialog, int item)
                    {
                        switch (item)
                        {
                            case 0:
                                // akan memanggil activity detail data
                                Intent i = new Intent(getApplicationContext(), profilActivity.class);
                                i.putExtra("nomer", selection);
                                startActivity(i);
                                break;
                            case 1:
                                Intent in = new Intent(getApplicationContext(), UpdateActivity.class);
                                in.putExtra("nama", selection);
                                startActivity(in);
                                break;
                            case 2:
                                SQLiteDatabase db = dbcenter.getWritableDatabase();
                                db.execSQL("delete from user where nomer = '" + selection + "'");
                                RefreshList();
                                break;
                        }
                    }
                });
                builder.create().show();
            }
        });
        ((ArrayAdapter)ListView01.getAdapter()).notifyDataSetInvalidated();
    }
}