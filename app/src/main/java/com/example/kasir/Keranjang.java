package com.example.kasir;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class Keranjang extends AppCompatActivity {


    int quantity=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keranjang);
    }


    public void increment(View view){//perintah tombol tambah
        if(quantity==100){
            Toast.makeText(this,"pesanan maximal 100",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity+1 ;
        display(quantity);
    }
    public void decrement(View view){//perintah tombol tambah
        if (quantity==1){
            Toast.makeText(this,"pesanan minimal 1",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity -1;
        display(quantity);
    }


    public void Submitorder(View view) {
        EditText nameEditText=(EditText)findViewById(R.id.edt_name);
        String name=nameEditText.getText().toString();
        Log.v("MainActivity","Nama:"+name);

        CheckBox vanila= (CheckBox) findViewById(R.id.Vanila_checkbox);
        boolean hasvanila=vanila.isChecked();//mengidentifikasi check
        Log.v("MainActivity","has Vanila:"+hasvanila);

        CheckBox strawberry= (CheckBox) findViewById(R.id.Strawberry_checkbox);
        boolean hasstrawberry=strawberry.isChecked();//mengidentifikasi check
        Log.v("MainActivity","has Strawberry:"+hasstrawberry);

        CheckBox chocooreo= (CheckBox) findViewById(R.id.ChocoOreo_checkbox);
        boolean haschocooreo=chocooreo.isChecked();//mengidentifikasi check
        Log.v("MainActivity","has Chocooreo:"+haschocooreo);

        CheckBox matchalatte= (CheckBox) findViewById(R.id.MatchaLatte_checkbox);
        boolean hasmatchalatte=matchalatte.isChecked();//mengidentifikasi check
        Log.v("MainActivity","has Matchalatte:"+hasmatchalatte);

        CheckBox original= (CheckBox) findViewById(R.id.Original_checkbox);
        boolean hasoriginal=original.isChecked();//mengidentifikasi check
        Log.v("MainActivity","has Original:"+hasoriginal);

        CheckBox keju= (CheckBox) findViewById(R.id.Keju_checkbox);
        boolean haskeju=keju.isChecked();//mengidentifikasi check
        Log.v("MainActivity","has Keju:"+haskeju);

        CheckBox coklat= (CheckBox) findViewById(R.id.Coklat_checkbox);
        boolean hascoklat=coklat.isChecked();//mengidentifikasi check
        Log.v("MainActivity","has Coklat:"+hascoklat);

        CheckBox kacang= (CheckBox) findViewById(R.id.Kacang_checkbox);
        boolean haskacang=kacang.isChecked();//mengidentifikasi check
        Log.v("MainActivity","has Kacang:"+haskacang);

        CheckBox chocoalmond= (CheckBox) findViewById(R.id.ChocoAlmond_checkbox);
        boolean haschocoalmond=chocoalmond.isChecked();//mengidentifikasi check
        Log.v("MainActivity","has Chocoalmond:"+haschocoalmond);

        CheckBox kacangalmond= (CheckBox) findViewById(R.id.KacangAlmond_checkbox);
        boolean haskacangalmond=kacangalmond.isChecked();//mengidentifikasi check
        Log.v("MainActivity","has KacangAlmond:"+haskacangalmond);

        CheckBox greentea= (CheckBox) findViewById(R.id.GreenTea_checkbox);
        boolean hasgreentea=greentea.isChecked();//mengidentifikasi check
        Log.v("MainActivity","has Greentea:"+hasgreentea);

        CheckBox oreo= (CheckBox) findViewById(R.id.Oreo_checkbox);
        boolean hasoreo=oreo.isChecked();//mengidentifikasi check
        Log.v("MainActivity","has Oreo:"+hasoreo);

        int price=calculateprice(hasvanila,hasstrawberry, haschocooreo, hasmatchalatte, hasoriginal, haskeju,
                hascoklat, haskacang, haschocoalmond, haskacangalmond, hasgreentea, hasoreo);//memanggil method jumlah harga
        String pricemessage=createOrderSummary(price,name,hasvanila,hasstrawberry, haschocooreo, hasmatchalatte, hasoriginal, haskeju,
                hascoklat, haskacang, haschocoalmond, haskacangalmond, hasgreentea, hasoreo);


        displayMessage(pricemessage);

    }
    private int calculateprice(boolean addvanila,boolean addstrawberry, boolean addchocooreo,
                               boolean addmatchalatte, boolean addoriginal, boolean addkeju,
                               boolean addcoklat, boolean addkacang, boolean addchocoalmond,
                               boolean addkacangalmond, boolean addgreentea, boolean addoreo){//jumlah pesanan * harga
        int harga= 0;

        if(addvanila){
            harga= harga + 8000;//harga vanila
        }

        if (addstrawberry){
            harga= harga + 8000; //harga strawberry
        }

        if (addchocooreo){
            harga= harga + 8000; //harga strawberry
        }

        if (addmatchalatte){
            harga= harga + 10000; //harga strawberry
        }

        if (addoriginal){
            harga= harga + 2000; //harga strawberry
        }

        if (addkeju){
            harga= harga + 2500; //harga strawberry
        }

        if (addcoklat){
            harga= harga + 2500; //harga strawberry
        }

        if (addkacang){
            harga= harga + 2500; //harga strawberry
        }

        if (addchocoalmond){
            harga= harga + 2500; //harga strawberry
        }

        if (addkacangalmond){
            harga= harga + 2500; //harga strawberry
        }

        if (addgreentea){
            harga= harga + 2500; //harga strawberry
        }

        if (addoreo){
            harga= harga + 2500; //harga strawberry
        }

        return quantity * harga;
    }
    private String createOrderSummary(int price, String name, boolean addvanila, boolean addstrawberry,
                                      boolean addchocooreo, boolean addmatchalatte, boolean addoriginal,
                                      boolean addkeju, boolean addcoklat, boolean addkacang,
                                      boolean addchocoalmond, boolean addkacangalmond,
                                      boolean addgreentea, boolean addoreo) {//hasil pemesanan
        String pricemessage=" Nama = "+name;
//        pricemessage+="\n Vanila = "+addvanila;
//        pricemessage+="\n Strawberry = "+addstrawberry;
//        pricemessage+="\n Choco Oreo = "+addchocooreo;
//        pricemessage+="\n Matcha Latte = "+addmatchalatte;
//        pricemessage+="\n Original = "+addoriginal;
//        pricemessage+="\n Keju = "+addkeju;
//        pricemessage+="\n Coklat = "+addcoklat;
//        pricemessage+="\n Kacang = "+addkacang;
//        pricemessage+="\n Choco Almond = "+addchocoalmond;
//        pricemessage+="\n Kacang Almond = "+addkacangalmond;
//        pricemessage+="\n Greentea = "+addgreentea;
//        pricemessage+="\n Oreo = "+addoreo;
        pricemessage+="\n quantity = "+quantity;
        pricemessage+="\n Total Rp."+price;
        pricemessage+="\n Thankyou for Order";
        return  pricemessage;
    }

    //method ini untuk mencetak hasil perintah yang di tampilkan dengan inisial quantity_textview di textview 0
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_textview);
        priceTextView.setText(message);
    }
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_textview);
        quantityTextView.setText("" + number);
    }
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_textview);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

}