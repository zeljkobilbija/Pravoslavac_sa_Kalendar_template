package com.interfacemockup.kalendar;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class GodisnjiKalendar extends AppCompatActivity {

    View view;

    private ListView listView;
    private TextView textView;
    private String[] listItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_godisnji_kalendar);

        listView=(ListView)findViewById(R.id.idDvanaestMeseciListView);
        textView=(TextView)findViewById(R.id.id_mesec_cell_textView);
        listItem = getResources().getStringArray(R.array.nazivi_meseca);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, listItem);

        final ArrayAdapter<String> adpt = new ArrayAdapter<>(this, R.layout.mesec_cell, R.id.id_mesec_cell_textView, listItem);

        listView.setAdapter(adpt);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // TODO Auto-generated method stub
                //String value=adapter.getItem(position);
               // Toast.makeText(getApplicationContext(),value,Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), MesecniKalendar.class);
                startActivity(intent);

            }
        });


    }


    public void home_btn_click(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

}
