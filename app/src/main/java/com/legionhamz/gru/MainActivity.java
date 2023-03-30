package com.legionhamz.gru;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity
{
    EditText emailTxt, passTxt;
    Button girisBtn, kayitBtn;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailTxt = findViewById(R.id.email);
        passTxt = findViewById(R.id.password);
        girisBtn = findViewById(R.id.giris);
        kayitBtn = findViewById(R.id.kayit);

        mAuth = FirebaseAuth.getInstance();

        FirebaseUser guncelKullanici = mAuth.getCurrentUser();


        if(guncelKullanici != null)
        {
            String getGuncelKullanici = emailToName(guncelKullanici.getEmail().toString());

            Intent intent = new Intent(MainActivity.this, AnaMenu.class);
            intent.putExtra("user",getGuncelKullanici);
            startActivity(intent);
            finish();
        }

    }

    public void girisYap(View view)
    {
        String getEmail = emailTxt.getText().toString();
        String getPass = passTxt.getText().toString();

        mAuth.signInWithEmailAndPassword(getEmail, getPass).addOnCompleteListener(task -> {
            if(task.isSuccessful())
            {
                String guncelKullanici = emailToName(mAuth.getCurrentUser().getEmail().toString());
                Toast.makeText(MainActivity.this, "Hoşgeldin: " + guncelKullanici ,Toast.LENGTH_LONG).show();

                Intent intent = new Intent(MainActivity.this, AnaMenu.class);
                intent.putExtra("user",guncelKullanici);
                startActivity(intent);
                finish();
            }
        }).addOnFailureListener(exception -> {
            Toast.makeText(MainActivity.this, exception.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
        });


    }

    public void kayitOl(View view)
    {
        String getEmail = emailTxt.getText().toString();
        String getPass = passTxt.getText().toString();

        String guncelKullanici = emailToName(mAuth.getCurrentUser().getEmail().toString());

        if(getEmail.isEmpty() && getPass.isEmpty())
        {
            Toast.makeText(MainActivity.this, "Boş alan kalmasın!", Toast.LENGTH_SHORT).show();
        }
        else
        {
            mAuth.createUserWithEmailAndPassword(getEmail,getPass).addOnCompleteListener(task -> {
                if(task.isSuccessful())
                {
                    Intent intent = new Intent(MainActivity.this, AnaMenu.class);
                    intent.putExtra("user",guncelKullanici);
                    startActivity(intent);
                    finish();
                }

            }).addOnFailureListener(exception ->{
                Toast.makeText(MainActivity.this, exception.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            });
        }

    }

    public String emailToName(String getEmail)
    {

        char id = '@';

        int sayac = 0;

        for(int i = 0; i < getEmail.length(); i++)
        {
            if(id == getEmail.charAt(i))
            {
                sayac += i;
                break;
            }
        }

        String getName = "";
        for(int j = 0; j < sayac; j++)
        {
            getName += getEmail.charAt(j);
        }

        return getName;
    }

}



