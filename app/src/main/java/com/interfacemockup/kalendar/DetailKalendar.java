package com.interfacemockup.kalendar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.interfacemockup.kalendar.pravoslavnekalkulacije.PravoslavneKonstante;

public class DetailKalendar extends AppCompatActivity {

    private int _selectedRow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_kalendar);

        _selectedRow = getIntent().getIntExtra(PravoslavneKonstante.SELECTED_ROW, 0);
        System.out.println("AAAAAAAAAA");
        System.out.println(_selectedRow);


    }

    public void backDetail(View view) {
        Intent intent = new Intent(getApplicationContext(), MesecniKalendar.class);
        intent.putExtra(PravoslavneKonstante.SELECTED_ROW, _selectedRow);
        startActivity(intent);

    }

}


