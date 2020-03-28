package com.interfacemockup.kalendar;

import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.interfacemockup.kalendar.pravoslavnekalkulacije.PravoslavniKalendar;

import static com.interfacemockup.kalendar.pravoslavnekalkulacije.PravoslavneKonstante.SELECTED_ROW;

public class MesecniKalendar extends AppCompatActivity {


    int redniBroj;
    private ListView list_View;
    private String[] list_Item;
    private String[] lista_ikona;
    private TextView nazivMeseca;
    private ArrayAdapter<String> svetacAdapter;
    private ArrayAdapter<String> svetacIkonaAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mesecni_kalendar);

        list_View = findViewById(R.id.id_Trideset_dana_ListView);
        nazivMeseca = findViewById(R.id.id_mesec_textView);
        redniBroj = getIntent().getIntExtra(SELECTED_ROW, redniBroj);
        izaberiMesecnuPlist(redniBroj);

    }

    public void mesecni_kal_home_btn_click(View view) {
        Intent intent = new Intent(getApplicationContext(), GodisnjiKalendar.class);
        startActivity(intent);
    }


    private void izaberiMesecnuPlist(int izbor){
        switch (izbor){
            case 0:
                list_Item = getResources().getStringArray(R.array.svetitelji_januar);
                svetacAdapter = new ArrayAdapter<>(this, R.layout.dan_cell, R.id.id_ime_svetitelja, list_Item);
                list_View.setAdapter(svetacAdapter);
                //lista_ikona = getResources().getStringArray(R.array.ikone_prosta_godina);
                //svetacIkonaAdapter = new ArrayAdapter<>(this, R.layout.dan_cell, R.id.id_ikona_svetitelja, lista_ikona);
                //list_View.setAdapter(svetacIkonaAdapter);
                nazivMeseca.setText(getResources().getStringArray(R.array.nazivi_meseca)[izbor]);
                break;
            case 1:

                if (PravoslavniKalendar.getInstance().prestupnaGodina()){
                    list_Item = getResources().getStringArray(R.array.svetitelji_februar_big);
                }else {
                    list_Item = getResources().getStringArray(R.array.svetitelji_februar_small);
                }
                svetacAdapter = new ArrayAdapter<>(this, R.layout.dan_cell, R.id.id_ime_svetitelja, list_Item);
                list_View.setAdapter(svetacAdapter);
                nazivMeseca.setText(getResources().getStringArray(R.array.nazivi_meseca)[izbor]);
                break;
            case 2:
                list_Item = getResources().getStringArray(R.array.svetitelji_mart);
                svetacAdapter = new ArrayAdapter<>(this, R.layout.dan_cell, R.id.id_ime_svetitelja, list_Item);
                list_View.setAdapter(svetacAdapter);
                nazivMeseca.setText(getResources().getStringArray(R.array.nazivi_meseca)[izbor]);
                break;
            case 3:
                list_Item = getResources().getStringArray(R.array.svetitelji_april);
                svetacAdapter = new ArrayAdapter<>(this, R.layout.dan_cell, R.id.id_ime_svetitelja, list_Item);
                list_View.setAdapter(svetacAdapter);
                nazivMeseca.setText(getResources().getStringArray(R.array.nazivi_meseca)[izbor]);
                break;
            case 4:
                list_Item = getResources().getStringArray(R.array.svetitelji_majs);
                svetacAdapter = new ArrayAdapter<>(this, R.layout.dan_cell, R.id.id_ime_svetitelja, list_Item);
                list_View.setAdapter(svetacAdapter);
                nazivMeseca.setText(getResources().getStringArray(R.array.nazivi_meseca)[izbor]);
                break;
            case 5:
                list_Item = getResources().getStringArray(R.array.svetitelji_jun);
                svetacAdapter = new ArrayAdapter<>(this, R.layout.dan_cell, R.id.id_ime_svetitelja, list_Item);
                list_View.setAdapter(svetacAdapter);
                nazivMeseca.setText(getResources().getStringArray(R.array.nazivi_meseca)[izbor]);
                break;
            case 6:
                list_Item = getResources().getStringArray(R.array.svetitelji_jul);
                svetacAdapter = new ArrayAdapter<>(this, R.layout.dan_cell, R.id.id_ime_svetitelja, list_Item);
                list_View.setAdapter(svetacAdapter);
                nazivMeseca.setText(getResources().getStringArray(R.array.nazivi_meseca)[izbor]);
                break;
            case 7:
                list_Item = getResources().getStringArray(R.array.svetitelji_avgust);
                svetacAdapter = new ArrayAdapter<>(this, R.layout.dan_cell, R.id.id_ime_svetitelja, list_Item);
                list_View.setAdapter(svetacAdapter);
                nazivMeseca.setText(getResources().getStringArray(R.array.nazivi_meseca)[izbor]);
                break;
            case 8:
                list_Item = getResources().getStringArray(R.array.svetitelji_septembar);
                svetacAdapter = new ArrayAdapter<>(this, R.layout.dan_cell, R.id.id_ime_svetitelja, list_Item);
                list_View.setAdapter(svetacAdapter);
                nazivMeseca.setText(getResources().getStringArray(R.array.nazivi_meseca)[izbor]);
                break;
            case 9:
                list_Item = getResources().getStringArray(R.array.svetitelji_oktobar);
                svetacAdapter = new ArrayAdapter<>(this, R.layout.dan_cell, R.id.id_ime_svetitelja, list_Item);
                list_View.setAdapter(svetacAdapter);
                nazivMeseca.setText(getResources().getStringArray(R.array.nazivi_meseca)[izbor]);
                break;
            case 10:
                list_Item = getResources().getStringArray(R.array.svetitelji_novembar);
                svetacAdapter = new ArrayAdapter<>(this, R.layout.dan_cell, R.id.id_ime_svetitelja, list_Item);
                list_View.setAdapter(svetacAdapter);
                nazivMeseca.setText(getResources().getStringArray(R.array.nazivi_meseca)[izbor]);
                break;
            case 11:
                list_Item = getResources().getStringArray(R.array.svetitelji_decembar);
                svetacAdapter = new ArrayAdapter<>(this, R.layout.dan_cell, R.id.id_ime_svetitelja, list_Item);
                list_View.setAdapter(svetacAdapter);
                nazivMeseca.setText(getResources().getStringArray(R.array.nazivi_meseca)[izbor]);
                break;
            default:
                break;

        }
    }



}
