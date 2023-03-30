package com.legionhamz.gru;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

import com.google.firebase.auth.FirebaseAuth;

public class AnaMenu extends AppCompatActivity
{
    //Dersler
    int sayisalAnalizV, sayisalTasarimV, programlamaDilleriV, algoritmalarV, olasilikV;
    int sayisalAnalizB, sayisalTasarimB, programlamaDilleriB, algoritmalarB, olasilikB;
    TextView getUser;
    Button transkript, yemek, duyurular,senaryo;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ana_menu);

        mAuth = FirebaseAuth.getInstance();
        Intent getName = getIntent();
        String userName = getName.getStringExtra("user");

        getUser = findViewById(R.id.username);
        getUser.setText("id: " + userName);

        transkript = findViewById(R.id.transkript);
        yemek = findViewById(R.id.yemekmenu);
        duyurular = findViewById(R.id.duyurular);
        senaryo = findViewById(R.id.senaryo);

        Random rnd = new Random();

        sayisalAnalizV = rnd.nextInt(101);
        sayisalTasarimV = rnd.nextInt(101);
        programlamaDilleriV = rnd.nextInt(101);
        algoritmalarV = rnd.nextInt(101);
        olasilikV = rnd.nextInt(101);

        sayisalAnalizB = rnd.nextInt(101);
        sayisalTasarimB = rnd.nextInt(101);
        programlamaDilleriB = rnd.nextInt(101);
        algoritmalarB = rnd.nextInt(101);
        olasilikB = rnd.nextInt(101);

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
            Intent intent = new Intent(AnaMenu.this, MainActivity.class);
            startActivity(intent);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    public void transkript(View view)
    {
        Intent intent = new Intent(AnaMenu.this, Transkript.class);
        intent.putExtra("sayisalAnalizV",String.valueOf(sayisalAnalizV));
        intent.putExtra("sayisalTasarimV",String.valueOf(sayisalTasarimV));
        intent.putExtra("programlamaDilleriV",String.valueOf(programlamaDilleriV));
        intent.putExtra("algoritmalarV",String.valueOf(algoritmalarV));
        intent.putExtra("olasilikV",String.valueOf(olasilikV));

        intent.putExtra("sayisalAnalizB",String.valueOf(sayisalAnalizB));
        intent.putExtra("sayisalTasarimB",String.valueOf(sayisalTasarimB));
        intent.putExtra("programlamaDilleriB",String.valueOf(programlamaDilleriB));
        intent.putExtra("algoritmalarB",String.valueOf(algoritmalarB));
        intent.putExtra("olasilikB",String.valueOf(olasilikB));
        startActivity(intent);
    }

    public void yemekMenu(View view)
    {
        Intent intent = new Intent(AnaMenu.this, YemekhaneMenu.class);
        startActivity(intent);
    }

    public void duyuru(View view)
    {
        Intent intent = new Intent(AnaMenu.this, Duyurular.class);
        startActivity(intent);
    }

    public void senaryo(View view)
    {
        Intent intent = new Intent(AnaMenu.this, Senaryo.class);
        startActivity(intent);
    }

}





