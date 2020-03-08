package com.interfacemockup.kalendar;


import android.graphics.Color;
import android.icu.util.Calendar;
import android.icu.util.GregorianCalendar;
import android.os.Build;
import android.view.View;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.interfacemockup.kalendar.pravoslavnekalkulacije.*;

public class MainActivity extends AppCompatActivity {

    private PravoslavniPostLabel _postLabel;
    private PravoslavniGregorijanskiDatumLabel _gregorijanskiDatumLabel;
    private PravoslavnaIkona _ikona;
    private PravoslavniSvetacLabel _svetitelj;

    private PravoslavniJulijanskiDatumLabel _julijanskiDatumLabel;
    private View _view;
    private int _rb_danaUgodini = 0;
    private Calendar _calendar;
    private int _counter;
    private PravoslavniKalendar shared_kalendar_instance;
    private PravoslavneKonstante _konstante;

    private AdView mAdView;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, "ca-app-pub-7920431183682527~1369121836");

        _counter = 0;
        _calendar = GregorianCalendar.getInstance();
        shared_kalendar_instance = PravoslavniKalendar.getInstance();
        _konstante = new PravoslavneKonstante();
        //_rb_danaUgodini = shared_kalendar_instance.getRedniBrojDanaUGodini(_counter);
        _rb_danaUgodini = shared_kalendar_instance.vratiBrojDana(_counter);

        _view = findViewById(R.id.bgView);

        _postLabel = findViewById(R.id.idPostLabe);
        _gregorijanskiDatumLabel = findViewById(R.id.idGregorijanskiDatumLabel);
        _ikona = findViewById(R.id.idIkona);
        _svetitelj = findViewById(R.id.idSvetacLabel);
        _julijanskiDatumLabel = findViewById(R.id.idJulijanskiDatumLabel);

        setUI(_counter);

        setSwipes(_rb_danaUgodini);



    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void setUI(int counter_to_add){

        _postLabel.setPostLabelText(counter_to_add);
        _postLabel.setPostLabelColor(counter_to_add);

        _gregorijanskiDatumLabel.napisiIzmenjeniDatum(counter_to_add);
        _gregorijanskiDatumLabel.setBojuTexta(counter_to_add);

        setIkonu(counter_to_add);
        setSvetitelja(counter_to_add);

        _julijanskiDatumLabel.napisiJulijanskiDatum(counter_to_add);
        _julijanskiDatumLabel.setBojuTexta(counter_to_add);

        addMob();

    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    private void setIkonu(int counter){
        Calendar cal = GregorianCalendar.getInstance();

        if (cal.isLenient()){
            _ikona.setImageResource(_konstante.dravables_prestupna_godina[shared_kalendar_instance.vratiBrojDana(counter)- 1]);

        }else {
            _ikona.setImageResource(_konstante.drawables_prosta_godina[shared_kalendar_instance.vratiBrojDana(counter) - 1]);
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void setSvetitelja(int counter){
        Calendar cal = GregorianCalendar.getInstance();
        String[] imeSvetitelja;
        if (cal.isLenient()){
            imeSvetitelja = getResources().getStringArray(R.array.imena_svetitelja_prestupna_godina);
        }else {
            imeSvetitelja = getResources().getStringArray(R.array.imena_svetitelja_prosta_godina);
        }
        _svetitelj.setText(imeSvetitelja[shared_kalendar_instance.vratiBrojDana(counter) - 1]);
        _svetitelj.setBojuTexta(counter);
    }




    /*  TODO: SWIPE GESTURES AND ANIMATIONS     */
    public void setSwipes(int rb_dana_u_god) {
        _view.setOnTouchListener(new OnSwipeTouchListener(MainActivity.this) {


            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onSwipeLeft() {
                super.onSwipeLeft();
                YoYo.with(Techniques.ZoomInRight)
                        .duration(650)
                        .repeat(0)
                        .playOn(_ikona);
                _rb_danaUgodini = _rb_danaUgodini + 1;
                _counter = _counter + 1;
                setUI(_counter);
            }

            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onSwipeRight() {
                super.onSwipeRight();
                YoYo.with(Techniques.ZoomInLeft)
                        .duration(650)
                        .repeat(0)
                        .playOn(_ikona);
                _rb_danaUgodini = _rb_danaUgodini - 1;
                _counter = _counter - 1;
                setUI(_counter);
            }

            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onSwipeBottom() {
                super.onSwipeBottom();
                YoYo.with(Techniques.ZoomIn)
                        .duration(550)
                        .repeat(0)
                        .playOn(_ikona);
                _rb_danaUgodini = _calendar.get(Calendar.DAY_OF_YEAR)-1;
                _counter = 0;
                setUI(_counter);
            }

            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onSwipeTop() {
                super.onSwipeTop();
                YoYo.with(Techniques.ZoomIn)
                        .duration(550)
                        .repeat(0)
                        .playOn(_ikona);
                _rb_danaUgodini = _calendar.get(Calendar.DAY_OF_YEAR)-1;
                _counter = 0;
                setUI(_counter);
            }

        });

    }


    private void addMob(){
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }
}


