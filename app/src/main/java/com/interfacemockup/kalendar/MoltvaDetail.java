package com.interfacemockup.kalendar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

import com.interfacemockup.kalendar.pravoslavnekalkulacije.PravoslavneKonstante;

public class MoltvaDetail extends AppCompatActivity {

    private TextView _molitva;
    private PravoslavneKonstante _konst;
    private int _counter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moltva_detail);
        _counter = getIntent().getIntExtra("molitva", 0);

        _konst = new PravoslavneKonstante();
        _molitva = findViewById(R.id.id_text_molitve);
        _molitva.setText(_konst.molitveTekst[_counter]);
        _molitva.setMovementMethod(new ScrollingMovementMethod());
    }

    public void kliknazad_sa_molitvi_detail(View view) {
        Intent intent = new Intent(getApplicationContext(), Molitve.class);
        startActivity(intent);
    }
}
