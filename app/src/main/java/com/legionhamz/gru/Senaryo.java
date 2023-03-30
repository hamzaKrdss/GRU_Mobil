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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Senaryo extends AppCompatActivity
{
    TextView sonuc1, sonuc2, sonuc3, sonuc4, sonuc5;
    EditText vize1,vize2,vize3,vize4,vize5;
    int getVize1,getVize2,getVize3,getVize4,getVize5;
    EditText but1,but2,but3,but4,but5;
    int getBut1,getBut2,getBut3,getBut4,getBut5;
    Button hesapla;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senaryo);
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

        hesapla = findViewById(R.id.hesapla);



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
            Intent intent = new Intent(Senaryo.this, MainActivity.class);
            startActivity(intent);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
    public void hesapla(View view)
    {
        if( (!vize1.getText().toString().isEmpty()) || (!vize2.getText().toString().isEmpty()) || (!vize3.getText().toString().isEmpty()) ||
                (!vize4.getText().toString().isEmpty()) || (!vize5.getText().toString().isEmpty()) ||
                (!but1.getText().toString().isEmpty()) || (!but2.getText().toString().isEmpty()) ||
                (!but3.getText().toString().isEmpty()) || (!but4.getText().toString().isEmpty()) || (!but5.getText().toString().isEmpty()))
        {
            getVize1 = Integer.parseInt(vize1.getText().toString());
            getVize2 = Integer.parseInt(vize2.getText().toString());
            getVize3 = Integer.parseInt(vize3.getText().toString());
            getVize4 = Integer.parseInt(vize4.getText().toString());
            getVize5 = Integer.parseInt(vize5.getText().toString());

            getBut1 = Integer.parseInt(but1.getText().toString());
            getBut2 = Integer.parseInt(but2.getText().toString());
            getBut3 = Integer.parseInt(but3.getText().toString());
            getBut4 = Integer.parseInt(but4.getText().toString());
            getBut5 = Integer.parseInt(but5.getText().toString());

            if( (getVize1 < 0) || (getVize1 > 100) ||(getVize2 < 0) || (getVize2 > 100) ||(getVize3 < 0) || (getVize3 > 100) ||
                    (getVize4 < 0) || (getVize4 > 100) ||(getVize5 < 0) || (getVize5 > 100) ||
                    (getBut1 < 0) || (getBut1 > 100) || (getBut2 < 0) || (getBut2 > 100) || (getBut3 < 0) || (getBut3 > 100) ||
                    (getBut4 < 0) || (getBut4 > 100) || (getBut5 < 0) || (getBut5 > 100) )
            {
                Toast.makeText(Senaryo.this, "Kutucuklara 0 ile 100 arası sayılar giriniz", Toast.LENGTH_SHORT).show();
            }
            else
            {
                sonuc1.setText(  String.valueOf((getVize1 + getBut1)/2)  );
                sonuc2.setText(  String.valueOf((getVize2 + getBut2)/2)  );
                sonuc3.setText(  String.valueOf((getVize3 + getBut3)/2)  );
                sonuc4.setText(  String.valueOf((getVize4 + getBut4)/2)  );
                sonuc5.setText(  String.valueOf((getVize5 + getBut5)/2)  );

            }

        }
        else
        {
            Toast.makeText(Senaryo.this, "Kutucukları boş bırakmayınız", Toast.LENGTH_SHORT).show();
        }

    }


}





