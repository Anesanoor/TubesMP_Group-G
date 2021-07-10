package com.example.kasir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Button bmenu = (Button) findViewById(R.id.bmenu);
        bmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                startActivity(new Intent(Dashboard.this, MenuUtama.class));
            }
        });

        Button babout = (Button) findViewById(R.id.babout);
        babout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                startActivity(new Intent(Dashboard.this, InfoActivity.class));
            }
        });

        Button bkelola = (Button) findViewById(R.id.bkelola);
        bkelola.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                startActivity(new Intent(Dashboard.this, UserActivity.class));
            }
        });

        Button out = (Button) findViewById(R.id.out);
        out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                startActivity(new Intent(Dashboard.this, MainActivity.class));
            }
        });
    }
}