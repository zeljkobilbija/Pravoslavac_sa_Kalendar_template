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

    private int _day;
    private int _month;
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
        _ikona = findViewById(R.id.ikona);
        _svetac = findViewById(R.id.svetac);
        _zitije = findViewById(R.id.zitije);

        Intent intent = getIntent();
        _day = intent.getIntExtra("day", 0);
        _month = intent.getIntExtra("month", 0);




        _ikona.setImageResource(_konst.drawables_januar[_day]);

        _zitije.setText(getResources().getStringArray(R.array.zitija_jun)[_day]);

        //Animation anim = AnimationUtils.loadAnimation(this, R.anim.mixed_anim);
        //_ikona.startAnimation(anim);




    }

    public void backDetail(View view) {
        Intent backIntent = new Intent();
        backIntent.putExtra("mmm", _month);
        setResult(RESULT_OK, backIntent);
        finish();;
    }

}


