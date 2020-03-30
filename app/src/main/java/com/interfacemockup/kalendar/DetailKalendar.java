package com.interfacemockup.kalendar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.interfacemockup.kalendar.pravoslavnekalkulacije.PravoslavneKonstante;

public class DetailKalendar extends AppCompatActivity {

    private int _selectedRow;
    private ImageView _ikona;
    private TextView _svetac;
    private EditText _zitije;
    private PravoslavneKonstante _konst;
    private ListView _list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_kalendar);

        _konst = new PravoslavneKonstante();
        _selectedRow = getIntent().getIntExtra(PravoslavneKonstante.SELECTED_ROW, 0);

        _ikona = findViewById(R.id.ikona);
        _svetac = findViewById(R.id.svetac);
        _zitije = findViewById(R.id.zitije);



        _ikona.setImageResource(_konst.drawables_januar[_selectedRow]);

        _zitije.setText(getResources().getStringArray(R.array.zitija_jun)[_selectedRow]);

        Animation anim = AnimationUtils.loadAnimation(this, R.anim.mixed_anim);
        _ikona.startAnimation(anim);




    }

    public void backDetail(View view) {
        Intent intent = new Intent(getApplicationContext(), MesecniKalendar.class);
        intent.putExtra(PravoslavneKonstante.SELECTED_ROW, _selectedRow);
        startActivity(intent);

    }

}


