package com.example.mati.ejemplayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button miBoton1 = (Button) findViewById(R.id.miBtn1);
        final Button miBoton2 = (Button) findViewById(R.id.miBtn2);
        final Button miBoton3 = (Button) findViewById(R.id.miBtn3);
        final Button miBoton4 = (Button) findViewById(R.id.miBtn4);



        miBoton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent miIntent1 = new Intent(MainActivity.this,LinearLayout.class);
                startActivity(miIntent1);

            }
        });


        miBoton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent miIntent2 = new Intent(MainActivity.this, TableLayout.class);
                startActivity(miIntent2);

            }

            });


        miBoton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent miIntent3 = new Intent(MainActivity.this, RelativeLayout.class);
                startActivity(miIntent3);

            }
        });

        miBoton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent miIntent4 = new Intent(MainActivity.this, GridLayout.class );
                startActivity(miIntent4);

            }
        });

    }
}
