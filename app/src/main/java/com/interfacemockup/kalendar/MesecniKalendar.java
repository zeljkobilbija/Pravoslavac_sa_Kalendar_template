package com.interfacemockup.kalendar;

import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import static com.interfacemockup.kalendar.pravoslavnekalkulacije.PravoslavneKonstante.SELECTED_ROW;

public class MesecniKalendar extends AppCompatActivity {


    int redniBroj;
    private ListView list_View;
    private TextView text_View;
    private String[] list_Item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mesecni_kalendar);

        list_View = findViewById(R.id.id_Trideset_dana_ListView);
        text_View = findViewById(R.id.id_ime_svetitelja);
        list_Item = getResources().getStringArray(R.array.imena_svetitelja_prestupna_godina);

        redniBroj = getIntent().getIntExtra(SELECTED_ROW, redniBroj);

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.dan_cell, R.id.id_ime_svetitelja, list_Item);

        list_View.setAdapter(adapter);


    }

    public void mesecni_kal_home_btn_click(View view) {
        Intent intent = new Intent(getApplicationContext(), GodisnjiKalendar.class);
        startActivity(intent);
    }


    private void izaberiMesecnuPlist(int izbor){
        switch (izbor){
            case 0:
                System.out.println("QQQQQQQQ");
                System.out.println(0b1);
                break;
            case 1:
                System.out.println("QQQQQQQQ");
                System.out.println(0b10);
                break;
            case 2:
                System.out.println("QQQQQQQQ");
                System.out.println(0b11);
                break;
            case 3:
                System.out.println("QQQQQQQQ");
                System.out.println(izbor);
                break;
            case 4:
                System.out.println("QQQQQQQQ");
                System.out.println(izbor);
                break;
            case 5:
                System.out.println("QQQQQQQQ");
                System.out.println(izbor);
                break;
            case 6:
                System.out.println("QQQQQQQQ");
                System.out.println(izbor);
                break;
            case 7:
                System.out.println("QQQQQQQQ");
                System.out.println(izbor);
                break;
            case 8:
                System.out.println("QQQQQQQQ");
                System.out.println(izbor);
                break;
            case 9:
                System.out.println("QQQQQQQQ");
                System.out.println(izbor);
                break;
            case 10:
                System.out.println("QQQQQQQQ");
                System.out.println(izbor);
                break;
            case 11:
                System.out.println("QQQQQQQQ");
                System.out.println(izbor);
                break;
            default:
                System.out.println("KKKKKKK");

        }
    }



}
