package com.interfacemockup.kalendar;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.interfacemockup.kalendar.pravoslavnekalkulacije.PravoslavneKonstante;
import com.interfacemockup.kalendar.pravoslavnekalkulacije.PravoslavniKalendar;

import java.util.ArrayList;

import static com.interfacemockup.kalendar.R.array.nazivi_meseca;
import static com.interfacemockup.kalendar.pravoslavnekalkulacije.PravoslavneKonstante.SELECTED_ROW;

public class MesecniKalendar extends AppCompatActivity {

    int redniBroj;
    private PravoslavneKonstante _konstante;
    private ListView list_View;
    private String[] list_Item;
    private String datumField;
    private TextView nazivMeseca;
    private MyCustomArrayAdapter adapter;
    private ArrayList<Item> lista;

    private String kojiJeMesec;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mesecni_kalendar);
        _konstante = new PravoslavneKonstante();

        list_View = findViewById(R.id.id_Trideset_dana_ListView);
        nazivMeseca = findViewById(R.id.id_mesec_textView);
        redniBroj = getIntent().getIntExtra(SELECTED_ROW, redniBroj);
        lista = new ArrayList<>();

        list_View.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // TODO Auto-generated method stub
                //String value=adapter.getItem(position);
                // Toast.makeText(getApplicationContext(),value,Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), DetailKalendar.class);
                intent.putExtra(PravoslavneKonstante.SELECTED_ROW, redniBroj);

                startActivity(intent);

            }
        });



        mesec(redniBroj);
        izaberiMesecnuPlist(redniBroj);

    }

    public void mesecni_kal_home_btn_click(View view) {
        Intent intent = new Intent(getApplicationContext(), GodisnjiKalendar.class);
        intent.putExtra(PravoslavneKonstante.SELECTED_ROW, redniBroj);

        startActivity(intent);
    }

    private void mesec(int izbor){
        switch (izbor){
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                kojiJeMesec = getResources().getStringArray(nazivi_meseca)[izbor];
                break;
            default:
                break;
        }
    }



    private void izaberiMesecnuPlist(int izbor){
        switch (izbor){
            case 0:
                list_Item = getResources().getStringArray(R.array.svetitelji_januar);
                for (int i = 0; i <= 30; i++){
                    datumField = i+1 + ". " + kojiJeMesec;
                    lista.add(new Item(list_Item[i], _konstante.drawables_januar[i], datumField));
                }
                adapter = new MyCustomArrayAdapter(this,R.layout.dan_cell,lista );
                list_View.setAdapter(adapter);
                nazivMeseca.setText(getResources().getStringArray(nazivi_meseca)[izbor]);
                break;
            case 1:

                if (PravoslavniKalendar.getInstance().prestupnaGodina()){
                    list_Item = getResources().getStringArray(R.array.svetitelji_februar_big);
                    for (int i = 0; i <= 28; i++){
                        datumField = i+1 + ". " + kojiJeMesec;
                        lista.add(new Item(list_Item[i], _konstante.drawables_februar_big[i], datumField));
                    }
                }else {
                    list_Item = getResources().getStringArray(R.array.svetitelji_februar_small);
                    for (int i = 0; i <= 27; i++) {
                        datumField = i+1 + ". " + kojiJeMesec;
                        lista.add(new Item(list_Item[i], _konstante.drawables_februar_small[i], datumField));
                    }
                    }
                adapter = new MyCustomArrayAdapter(this,R.layout.dan_cell,lista );
                list_View.setAdapter(adapter);
                nazivMeseca.setText(getResources().getStringArray(nazivi_meseca)[izbor]);
                break;
            case 2:
                list_Item = getResources().getStringArray(R.array.svetitelji_mart);
                for (int i = 0; i <= 30; i++){
                    datumField = i+1 + ". " + kojiJeMesec;
                    lista.add(new Item(list_Item[i], _konstante.drawables_mart[i], datumField));
                }
                adapter = new MyCustomArrayAdapter(this,R.layout.dan_cell,lista );
                list_View.setAdapter(adapter);
                nazivMeseca.setText(getResources().getStringArray(nazivi_meseca)[izbor]);
                break;
            case 3:
                list_Item = getResources().getStringArray(R.array.svetitelji_april);
                for (int i = 0; i <= 29; i++){
                    datumField = i+1 + ". " + kojiJeMesec;
                    lista.add(new Item(list_Item[i], _konstante.drawables_april[i], datumField));
                }
                adapter = new MyCustomArrayAdapter(this,R.layout.dan_cell,lista );
                list_View.setAdapter(adapter);
                nazivMeseca.setText(getResources().getStringArray(nazivi_meseca)[izbor]);
                break;
            case 4:
                list_Item = getResources().getStringArray(R.array.svetitelji_majs);
                for (int i = 0; i <= 30; i++){
                    datumField = i+1 + ". " + kojiJeMesec;
                    lista.add(new Item(list_Item[i], _konstante.drawables_maj[i], datumField));
                }
                adapter = new MyCustomArrayAdapter(this,R.layout.dan_cell,lista );
                list_View.setAdapter(adapter);
                nazivMeseca.setText(getResources().getStringArray(nazivi_meseca)[izbor]);
                break;
            case 5:
                list_Item = getResources().getStringArray(R.array.svetitelji_jun);
                for (int i = 0; i <= 29; i++){
                    datumField = i+1 + ". " + kojiJeMesec;
                    lista.add(new Item(list_Item[i], _konstante.drawables_jun[i], datumField));
                }
                adapter = new MyCustomArrayAdapter(this,R.layout.dan_cell,lista );
                list_View.setAdapter(adapter);
                nazivMeseca.setText(getResources().getStringArray(nazivi_meseca)[izbor]);
                break;
            case 6:
                list_Item = getResources().getStringArray(R.array.svetitelji_jul);
                for (int i = 0; i <= 30; i++){
                    datumField = i+1 + ". " + kojiJeMesec;
                    lista.add(new Item(list_Item[i], _konstante.drawables_jul[i], datumField));
                }
                adapter = new MyCustomArrayAdapter(this,R.layout.dan_cell,lista );
                list_View.setAdapter(adapter);
                nazivMeseca.setText(getResources().getStringArray(nazivi_meseca)[izbor]);
                break;
            case 7:
                list_Item = getResources().getStringArray(R.array.svetitelji_avgust);
                for (int i = 0; i <= 30; i++){
                    datumField = i+1 + ". " + kojiJeMesec;
                    lista.add(new Item(list_Item[i], _konstante.drawables_avgust[i], datumField));
                }
                adapter = new MyCustomArrayAdapter(this,R.layout.dan_cell,lista );
                list_View.setAdapter(adapter);
                nazivMeseca.setText(getResources().getStringArray(nazivi_meseca)[izbor]);
                break;
            case 8:
                list_Item = getResources().getStringArray(R.array.svetitelji_septembar);
                for (int i = 0; i <= 29; i++){
                    datumField = i+1 + ". " + kojiJeMesec;
                    lista.add(new Item(list_Item[i], _konstante.drawables_septembar[i], datumField));
                }
                adapter = new MyCustomArrayAdapter(this,R.layout.dan_cell,lista );
                list_View.setAdapter(adapter);
                nazivMeseca.setText(getResources().getStringArray(nazivi_meseca)[izbor]);
                break;
            case 9:
                list_Item = getResources().getStringArray(R.array.svetitelji_oktobar);
                for (int i = 0; i <= 30; i++){
                    datumField = i+1 + ". " + kojiJeMesec;
                    lista.add(new Item(list_Item[i], _konstante.drawables_oktobar[i], datumField));
                }
                adapter = new MyCustomArrayAdapter(this,R.layout.dan_cell,lista );
                list_View.setAdapter(adapter);
                nazivMeseca.setText(getResources().getStringArray(nazivi_meseca)[izbor]);
                break;
            case 10:
                list_Item = getResources().getStringArray(R.array.svetitelji_novembar);
                for (int i = 0; i <= 29; i++){
                    datumField = i+1 + ". " + kojiJeMesec;
                    lista.add(new Item(list_Item[i], _konstante.drawables_novembar[i], datumField));
                }
                adapter = new MyCustomArrayAdapter(this,R.layout.dan_cell,lista );
                list_View.setAdapter(adapter);
                nazivMeseca.setText(getResources().getStringArray(nazivi_meseca)[izbor]);
                break;
            case 11:
                list_Item = getResources().getStringArray(R.array.svetitelji_decembar);
                for (int i = 0; i <= 30; i++){
                    datumField = i+1 + ". " + kojiJeMesec;
                    lista.add(new Item(list_Item[i], _konstante.drawables_decembar[i], datumField));
                }
                adapter = new MyCustomArrayAdapter(this,R.layout.dan_cell,lista );
                list_View.setAdapter(adapter);
                nazivMeseca.setText(getResources().getStringArray(nazivi_meseca)[izbor]);
                break;
            default:
                break;

        }
    }



}
