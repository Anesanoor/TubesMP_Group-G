package com.example.kasir;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    EditText u;
    EditText p;
    Button l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        u = (EditText) findViewById(R.id.username);
        p = (EditText)findViewById(R.id.password);
        l = (Button)findViewById(R.id.btnlogin);
        login();
    }

    public void login(){
        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(u.getText().toString().equals("admin")&&p.getText().toString().equals("admin")){
                    startActivity(new Intent(MainActivity.this, splashcreen.class));
                }else {
                    Toast.makeText(MainActivity.this,"Login anda gagal, periksa kembali username dan password anda",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}

