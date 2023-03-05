package com.example.textify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CardView card_imgtxt = (CardView) findViewById(R.id.card_imgtxt);
        CardView card_translatetxt = (CardView) findViewById(R.id.card_translatetxt);
        CardView card_voicetxt = (CardView) findViewById(R.id.card_voicetxt);
        CardView card_pdftxt =  (CardView) findViewById(R.id.card_pdftxt);

        //for cardview card_imgtxt
        card_imgtxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ImagetextActivity.class);
                startActivity(intent);
            }
        });

        //for cardview card_translatetxt
        card_translatetxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,TranslatetextActivity.class);
                startActivity(intent);
            }
        });

        //for cardview card_voicetxt
        card_voicetxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,VoicetextActivity.class);
                startActivity(intent);
            }
        });

        //for cardview pdftxt
        card_pdftxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,PdftextActivity.class);
                startActivity(intent);
            }
        });
    }
}