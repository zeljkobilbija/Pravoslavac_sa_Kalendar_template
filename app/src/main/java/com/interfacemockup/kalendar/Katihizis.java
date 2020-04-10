package com.interfacemockup.kalendar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.interfacemockup.kalendar.pravoslavnekalkulacije.PravoslavneKonstante;

import static com.interfacemockup.kalendar.R.array.katehizis_odgovori;
import static com.interfacemockup.kalendar.R.array.katehizis_pitanja;

public class Katihizis extends AppCompatActivity {

    private TextView _pitanje;
    private TextView _odgovor;
    private ImageView _left;
    private ImageView _right;
    private int _counter;

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_katihizis);

        MobileAds.initialize(this, "ca-app-pub-7920431183682527~1369121836");


        _counter = 0;

        _pitanje = findViewById(R.id.id_pitanje_textView);
        _odgovor = findViewById(R.id.id_odgovor_textView);
        _odgovor.setMovementMethod(new ScrollingMovementMethod());
        _left = findViewById(R.id.id_nazad_imageView);
        _right = findViewById(R.id.id_napred_imageView);

        setBtnVisibility(_counter);
        setPitanjeOdgovor(_counter);
        // TODO: aktivirati AdMob
        //addMob();
    }


    private void setPitanjeOdgovor(int brojac){
        _pitanje.setText(getResources().getStringArray(katehizis_pitanja)[brojac]);
        _odgovor.setText(getResources().getStringArray(katehizis_odgovori)[brojac]);
    }



    public void left_klik(View view) {
        setBtnVisibility(_counter);
        if (_counter == 0) {
            _left.setAlpha((float) 0.0);
            _counter = 0;
        }else {
            _left.setAlpha((float) 1.0);
            _counter = _counter - 1;
        }
        setPitanjeOdgovor(_counter);
        setBtnVisibility(_counter);
    }

    public void right_klik_btn(View view) {
        setBtnVisibility(_counter);
        if (_counter == 561){
            _counter = 561;
            _right.setAlpha((float) 0.0);
        }else {
            _right.setAlpha((float) 1.0);
            _counter = _counter + 1;
        }
        setPitanjeOdgovor(_counter);
        setBtnVisibility(_counter);
    }

    private void setBtnVisibility(int brojac){

        if (brojac < 561 && brojac > 0){
            _right.setAlpha((float) 1.0);
            _left.setAlpha((float) 1.0);
        }else{
            if (brojac == 0){
                _left.setAlpha((float) 0.0);
            }
            if (brojac == 561){
                _right.setAlpha((float) 0.0);
            }
        }
    }

    public void backKatihizis(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    private void addMob(){
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adKatihizis);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }
}
