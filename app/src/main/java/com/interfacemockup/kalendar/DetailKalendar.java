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

        setUI(_month, _day);

        Animation anim = AnimationUtils.loadAnimation(this, R.anim.sample_anim);
        _ikona.startAnimation(anim);

    }


    private void setUI(int mesec, int dan){
        switch (mesec){
            case 0:
                // Januar
                _ikona.setImageResource(_konst.drawables_januar[dan]);
                _svetac.setText(getResources().getStringArray(R.array.svetitelji_januar)[dan]);
                _zitije.setText(getResources().getStringArray(R.array.zitija_januar)[dan]);
                break;
            case 1:
                // Februar
                break;
            case 2:
                //Mart
                _ikona.setImageResource(_konst.drawables_mart[dan]);
                _svetac.setText(getResources().getStringArray(R.array.svetitelji_mart)[dan]);
                _zitije.setText(getResources().getStringArray(R.array.zitija_mart)[dan]);

                break;
            case 3:
                //April
                _ikona.setImageResource(_konst.drawables_april[dan]);
                _svetac.setText(getResources().getStringArray(R.array.svetitelji_april)[dan]);
                _zitije.setText(getResources().getStringArray(R.array.zitija_april)[dan]);

                break;
            case 4:
                //Maj

                break;
            case 5:
                //JUN

                break;
            case 6:
                //Jul

                break;
            case 7:
                //Avgust

                break;
            case 8:
                //Septembar

                break;
            case 9:
                //Oktobar

                break;
            case 10:
                //Nobvembar

                break;
            case 11:
                //Decembar

                break;
            default:
                break;

        }

    }






    public void backDetail(View view) {
        Intent backIntent = new Intent();
        backIntent.putExtra("mmm", _month);
        setResult(RESULT_OK, backIntent);
        finish();;
    }

}


