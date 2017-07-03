package com.example.matija.simulatorstednje;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class VariableActivity extends AppCompatActivity {

    Button mPlayButton;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_variable);
        mPlayButton = (Button) findViewById(R.id.btnPlay);
        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(VariableActivity.this, PlayActivity.class);
                float pocVal = 0;
                float stedVal = 0;
                float kamVal = 0;
                float stVal = 0;
                float fnVal = 0;
                try {
                    EditText poc = (EditText) findViewById(R.id.pocetnoVal);
                    pocVal = Float.valueOf(poc.getText().toString());
                    EditText sted = (EditText) findViewById(R.id.stednjaVal);
                    stedVal = Float.valueOf(sted.getText().toString());
                    EditText kam = (EditText) findViewById(R.id.kamataVal);
                    kamVal = Float.valueOf(kam.getText().toString());
                    EditText st = (EditText) findViewById(R.id.startVal);
                    stVal = Float.valueOf(st.getText().toString());
                    EditText fn = (EditText) findViewById(R.id.endVal);
                    fnVal = Float.valueOf(fn.getText().toString());
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                intent.putExtra("pocVal", pocVal);
                intent.putExtra("stedVal", stedVal);
                intent.putExtra("kamVal", kamVal);
                intent.putExtra("stVal", stVal);
                intent.putExtra("fnVal", fnVal);
                startActivity(intent);
                finish();
            }
        });

    }
    }

