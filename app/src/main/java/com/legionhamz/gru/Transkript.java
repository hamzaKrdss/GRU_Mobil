package com.legionhamz.gru;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class Transkript extends AppCompatActivity
{
    //Dersler
    String sayisalAnalizV, sayisalTasarimV, programlamaDilleriV, algoritmalarV, olasilikV;
    String sayisalAnalizB, sayisalTasarimB, programlamaDilleriB, algoritmalarB, olasilikB;
    TextView sonuc1, sonuc2, sonuc3, sonuc4, sonuc5, sonucYazdir;
    TextView vize1,vize2,vize3,vize4,vize5;
    TextView but1,but2,but3,but4,but5;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transkript);
        mAuth = FirebaseAuth.getInstance();
        vize1 = findViewById(R.id.vize1);
        vize2 = findViewById(R.id.vize2);
        vize3 = findViewById(R.id.vize3);
        vize4 = findViewById(R.id.vize4);
        vize5 = findViewById(R.id.vize5);

        but1 = findViewById(R.id.but1);
        but2 = findViewById(R.id.but2);
        but3 = findViewById(R.id.but3);
        but4 = findViewById(R.id.but4);
        but5 = findViewById(R.id.but5);

        sonuc1 = findViewById(R.id.sonuc1);
        sonuc2 = findViewById(R.id.sonuc2);
        sonuc3 = findViewById(R.id.sonuc3);
        sonuc4 = findViewById(R.id.sonuc4);
        sonuc5 = findViewById(R.id.sonuc5);
        sonucYazdir = findViewById(R.id.sonuc_yazdir);

        Intent getI = getIntent();
        sayisalAnalizV = getI.getStringExtra("sayisalAnalizV");
        sayisalTasarimV = getI.getStringExtra("sayisalTasarimV");
        programlamaDilleriV = getI.getStringExtra("programlamaDilleriV");
        algoritmalarV = getI.getStringExtra("algoritmalarV");
        olasilikV = getI.getStringExtra("olasilikV");

        vize1.setText(sayisalAnalizV);
        vize2.setText(sayisalTasarimV);
        vize3.setText(programlamaDilleriV);
        vize4.setText(algoritmalarV);
        vize5.setText(olasilikV);


        sayisalAnalizB = getI.getStringExtra("sayisalAnalizB");
        sayisalTasarimB = getI.getStringExtra("sayisalTasarimB");
        programlamaDilleriB = getI.getStringExtra("programlamaDilleriB");
        algoritmalarB = getI.getStringExtra("algoritmalarB");
        olasilikB = getI.getStringExtra("olasilikB");

        but1.setText(sayisalAnalizB);
        but2.setText(sayisalTasarimB);
        but3.setText(programlamaDilleriB);
        but4.setText(algoritmalarB);
        but5.setText(olasilikB);

        int hesap1 = (Integer.parseInt(sayisalAnalizV) + Integer.parseInt(sayisalAnalizB))/2;
        int hesap2 = (Integer.parseInt(sayisalTasarimV) + Integer.parseInt(sayisalTasarimB))/2;
        int hesap3 = (Integer.parseInt(programlamaDilleriV) + Integer.parseInt(programlamaDilleriB))/2;
        int hesap4 = (Integer.parseInt(algoritmalarV) + Integer.parseInt(algoritmalarB))/2;
        int hesap5 = (Integer.parseInt(olasilikV) + Integer.parseInt(olasilikB))/2;


        sonuc1.setText(String.valueOf(hesap1));
        sonuc2.setText(  String.valueOf(hesap2) );
        sonuc3.setText( String.valueOf(hesap3));
        sonuc4.setText( String.valueOf(hesap4) );
        sonuc5.setText( String.valueOf(hesap5) );

        String yazilicak = "";

        if(hesap1 < 60)
        {
            yazilicak += " Sayisal Analizden Kaldin";
        }
        if(hesap2 < 60)
        {
            yazilicak += " Sayisal Tasarimdan Kaldin";
        }
        if(hesap3 < 60)
        {
            yazilicak += " Programalama Dillerinden Kaldin";
        }
        if(hesap4 < 60)
        {
            yazilicak += " Algoritmalar Kaldin";
        }
        if(hesap5 < 60)
        {
            yazilicak += " Olasilik'dan  Kaldin";
        }

        sonucYazdir.setText("Sonuç:" + yazilicak);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.option_menu,menu);


        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.cikis_yap)
        {
            mAuth.signOut();
            Intent intent = new Intent(Transkript.this, MainActivity.class);
            startActivity(intent);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }


}




