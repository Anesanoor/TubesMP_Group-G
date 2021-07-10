package com.example.kasir;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
public class splashcreen extends AppCompatActivity {
    String tag = "Lifecycle Step";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashcreen);
        Log.d(tag,"Activity oncreate");
        int loadingTime = 4000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent home = new
                        Intent(splashcreen.this, Dashboard.class);
                startActivity(home);
                finish();
            }
        },loadingTime);
    }
}