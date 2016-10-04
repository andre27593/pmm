package com.example.mati.primerosejercicioslayout;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TableLayout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_layout);

        final Context context = this;

        final Button rojo = (Button) findViewById(R.id.button1);
        final Button amarillo = (Button) findViewById(R.id.button2);
        final Button azul = (Button) findViewById(R.id.button3);

        final TextView fondo = (TextView) findViewById(R.id.textView2);

        final Button limpiar = (Button) findViewById(R.id.button4);


        rojo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               fondo.setBackgroundColor(ContextCompat.getColor(context, R.color.rojo));

            }
        });

        amarillo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fondo.setBackgroundColor(ContextCompat.getColor(context, R.color.amarillo));

            }
        });

        azul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fondo.setBackgroundColor(ContextCompat.getColor(context, R.color.azul));

            }
        });

        limpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fondo.setBackgroundColor(ContextCompat.getColor(context, R.color.blanco));

            }
        });



    }
}
