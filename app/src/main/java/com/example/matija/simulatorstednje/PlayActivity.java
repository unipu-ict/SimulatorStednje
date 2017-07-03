package com.example.matija.simulatorstednje;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.FloatRange;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class PlayActivity extends AppCompatActivity {

    float ukupnoVrijednost;
    float pocetnoVrijednost;
    float stednjaVrijednost;
    float kamataVrijednost;
    int pocetakVrijednost;
    int krajVrijednost;
    float prinos;
    float pomocna;
    int pomocnaVremenska;
    Intent intent;
    float pocetniUlogDisplay;
    float godisnjeUlaganjeDisplay;
    float kamataDoSada;
    float duzina;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        Bundle bundle = getIntent().getExtras();
        float pocValFlo = bundle.getFloat("pocVal");
        float stedValFlo = bundle.getFloat("stedVal");
        float kamValFlo = bundle.getFloat("kamVal");
        float stValFlo = bundle.getFloat("stVal");
        float fnValFlo = bundle.getFloat("fnVal");
        final TextView uv = (TextView) findViewById(R.id.ukupnoVrijednostTV);
        final TextView pv = (TextView) findViewById(R.id.pocetnoVrijednostTV);
        final TextView sv = (TextView) findViewById(R.id.stednjaVrijednostTV);
        final TextView kv = (TextView) findViewById(R.id.kamataVrijednostTV);
        final TextView pocv = (TextView) findViewById(R.id.pocetakVrijednostTV);
        final TextView krajv = (TextView) findViewById(R.id.krajVrijednostTV);
        final TextView pomovr = (TextView) findViewById(R.id.ben);


        pocetakVrijednost = Math.round(stValFlo);
        krajVrijednost = Math.round(fnValFlo);
        pocetnoVrijednost = pocValFlo;
        stednjaVrijednost = stedValFlo;
        kamataVrijednost = kamValFlo;
        pomocnaVremenska = krajVrijednost - pocetakVrijednost + 1;
        pocetniUlogDisplay = pocValFlo;
        godisnjeUlaganjeDisplay = stedValFlo;

        final Handler h = new Handler();
        final int delay = 1000; //milliseconds
        h.postDelayed(new Runnable() {
            public void run() {
                prinos = ukupnoVrijednost * (kamataVrijednost / 100);
                pomocna = ukupnoVrijednost + prinos + stednjaVrijednost;
                ukupnoVrijednost = pomocna;
                kamataDoSada = kamataDoSada + prinos;
                duzina = krajVrijednost - pocetakVrijednost;
                String ukupnoVrijednostSTR = Float.toString(ukupnoVrijednost);
                String pocetnoVrijednostSTR = Float.toString(pocetniUlogDisplay);
                String stednjaVrijednostSTR = Float.toString(godisnjeUlaganjeDisplay);
                String kamataVrijednostSTR = Float.toString(kamataDoSada);
                String pocetakVrijednostSTR = Float.toString(pocetakVrijednost);
                String krajVrijednostSTR = Float.toString(krajVrijednost);
                String pomocVrijemeSTR = Float.toString(pomocnaVremenska);
                String duzinaSTR = Float.toString(duzina);
                uv.setText(ukupnoVrijednostSTR);
                pv.setText(pocetnoVrijednostSTR);
                sv.setText(stednjaVrijednostSTR);
                kv.setText(kamataVrijednostSTR);
                pocv.setText(pocetakVrijednostSTR);
                krajv.setText(krajVrijednostSTR);
                pomovr.setText(pomocVrijemeSTR);
                pomocnaVremenska = pomocnaVremenska - 1;
                if (pomocnaVremenska < 0) {
                    h.removeCallbacks(this);
                    intent = new Intent(PlayActivity.this, FinalActivity.class);
                    intent.putExtra("FWDukupno", ukupnoVrijednostSTR);
                    intent.putExtra("FWDstednja", stednjaVrijednostSTR);
                    intent.putExtra("FWDkamata", kamataVrijednostSTR);
                    intent.putExtra("FWDulog", pocetnoVrijednostSTR);
                    intent.putExtra("FWDduzina", duzinaSTR);
                    startActivity(intent);
                    finish();
                    return;
                }else
                    h.postDelayed(this, delay);
            }
        }, delay);




    }
}
