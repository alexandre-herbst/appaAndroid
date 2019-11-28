package com.example.terceiroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private static final String sSharedPrefFile = "br.edu.ifsc.sj.minhaspreferencias";
    private SharedPreferences mSharedPreferences;
    private int mContador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mSharedPreferences = getSharedPreferences(sSharedPrefFile, MODE_PRIVATE);

        mContador = this.mSharedPreferences.getInt("contador", 0);

        TextView textView = findViewById(R.id.contador);
        textView.setText(""+ mContador);



    }

    public void decrementar(View view) {

        mContador--;

        TextView textView = findViewById(R.id.contador);
        textView.setText("" + mContador);


    }

    public void incrementar(View view) {

        mContador++;

        TextView textView = findViewById(R.id.contador);
        textView.setText("" + mContador);

        SharedPreferences.Editor prefsEditor = mSharedPreferences.edit();

        prefsEditor.putInt("contador", mContador);

        prefsEditor.apply();

    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences.Editor prefsEditor = mSharedPreferences.edit();

        prefsEditor.putInt("contador", mContador);

        prefsEditor.apply();

    }

    public void zerar(View view) {

        SharedPreferences.Editor  prefsEditor = mSharedPreferences.edit();
        prefsEditor.clear();
        prefsEditor.apply();

        mContador = 0;


        TextView textView = findViewById(R.id.contador);
        textView.setText("" + mContador);

    }


    // docente.ifsc.edu.br/mello/poo/imagens/
}
