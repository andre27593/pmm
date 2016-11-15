package com.example.mati.ejerciciorecopilatorio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Factura extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factura);


        TextView info = (TextView) findViewById(R.id.texto2);


        Bundle miBundle = getIntent().getExtras();
        Destino destino = (Destino) miBundle.getSerializable("informacion");

        info.setText(destino.getZona() + destino.getContinente()+ destino.getPrecio());


    }
}
