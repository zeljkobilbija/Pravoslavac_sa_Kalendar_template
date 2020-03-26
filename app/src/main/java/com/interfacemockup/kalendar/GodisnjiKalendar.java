package com.interfacemockup.kalendar;

import android.content.Intent;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class GodisnjiKalendar extends AppCompatActivity {

    View view;
    private Button backBtn;
    private ListView listaMeseci;
    private String[] naziviMeseca = {"Јануар", "Фебруар", "Март", "Април", "Мај", "Јун", "Јул", "Август", "Септембар", "Октобар", "Новембар", "Децембар"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_godisnji_kalendar);

        backBtn = findViewById(R.id.backButton);
        listaMeseci = findViewById(R.id.idDvanaestMeseci);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });



    }

}
