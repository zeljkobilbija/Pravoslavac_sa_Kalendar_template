package com.interfacemockup.kalendar;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MesecniKalendar extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mesecni_kalendar);




    }

    public void mesecni_kal_home_btn_click(View view) {
        Intent intent = new Intent(getApplicationContext(), GodisnjiKalendar.class);
        startActivity(intent);
    }
}
