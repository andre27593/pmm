package com.example.mati.primerosejercicioslayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Button boton1 = (Button) findViewById(R.id.button1);
        final Button boton2 = (Button) findViewById(R.id.button2);
        final Button boton3 = (Button) findViewById(R.id.button3);


        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent miIntent1 = new Intent(MainActivity.this, LinearLayout.class);
                startActivity(miIntent1);

            }
        });


        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent miIntent2 = new Intent(MainActivity.this, TableLayout.class);
                startActivity(miIntent2);

            }
        });


        boton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent miIntent3 = new Intent(MainActivity.this, RelativeLayout.class);
                startActivity(miIntent3);

            }
        });

    }


}
