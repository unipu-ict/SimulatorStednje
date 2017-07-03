package com.example.matija.simulatorstednje;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FinalActivity extends AppCompatActivity {

    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        Bundle bundle = getIntent().getExtras();

        Button mRetryButton = (Button) findViewById(R.id.btnRetry);

        final TextView pocetak = (TextView) findViewById(R.id.pocetniulog);
        final TextView godisnje = (TextView) findViewById(R.id.godisnje);
        final TextView duzina = (TextView) findViewById(R.id.duzina);
        final TextView usteda = (TextView) findViewById(R.id.usteda);
        final TextView kamata = (TextView) findViewById(R.id.kamata);

        String pocetnoFWD = bundle.getString("FWDulog");
        String godisnjeFWD = bundle.getString("FWDstednja");
        String duzinaFWD = bundle.getString("FWDduzina");
        String ukupnoVrijednostFWD = bundle.getString("FWDukupno");
        String kamataFWD = bundle.getString("FWDkamata");

        float pocetnoFLO = Float.valueOf(pocetnoFWD);
        float godisnjeFLO = Float.valueOf(godisnjeFWD);
        float duzinaFLO = Float.valueOf(duzinaFWD);
        float ukupnoVrijednostFLO = Float.valueOf(ukupnoVrijednostFWD);
        float kamataFLO = Float.valueOf(kamataFWD);

        int pocetnoFLORN = Math.round(pocetnoFLO);
        int godisnjeFLORN = Math.round(godisnjeFLO);
        int duzinaFLORN = Math.round(duzinaFLO);
        int ukupnoVrijednostFLORN = Math.round(ukupnoVrijednostFLO);
        int kamataFLORN = Math.round(kamataFLO);

//        String pocetnoFLORNSTR = Float.toString(pocetnoFLORN);
//        String godisnjeFLORNSTR = Float.toString(godisnjeFLORN);
//        String duzinaFLORNSTR = Float.toString(duzinaFLORN);
//        String ukupnoVrijednostFLORNSTR = Float.toString(ukupnoVrijednostFLORN);
//        String kamataFLORNSTR = Float.toString(kamataFLORN);

        pocetak.setText(""+pocetnoFLORN + " kn");
        godisnje.setText(""+godisnjeFLORN + " kn");
        duzina.setText(""+duzinaFLORN + " godina");
        usteda.setText(""+ukupnoVrijednostFLORN + " kn");
        kamata.setText(""+kamataFLORN + " kn");

        mRetryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(FinalActivity.this, VariableActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }
}
