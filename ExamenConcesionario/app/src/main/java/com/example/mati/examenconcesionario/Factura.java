package com.example.mati.examenconcesionario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Factura extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factura);


        TextView preciohora = (TextView) findViewById(R.id.preciohora);
        TextView seguro = (TextView) findViewById(R.id.tseguro);
        TextView extras = (TextView) findViewById(R.id.extras1);
        TextView total = (TextView) findViewById(R.id.total);
        TextView tiempo = (TextView) findViewById(R.id.ttiempo);
        TextView tmodelo = (TextView) findViewById(R.id.tmodelo);


        Bundle miBundle = getIntent().getExtras();
        Coche coche = (Coche) miBundle.getSerializable("coche");


        tmodelo.setText(coche.getModelo());


        preciohora.setText(String.valueOf(coche.getPrecio()) + "€");

        if (getIntent().getStringExtra("nomseguro").equalsIgnoreCase("SIN SEGURO")) {
            seguro.setText(getIntent().getStringExtra("nomseguro"));
        } else {
            seguro.setText(getIntent().getStringExtra("nomseguro"));
        }

        extras.setText(getIntent().getStringExtra("extra"));

        if (extras.getText().toString().isEmpty()){
            extras.setText("0");
        }


        tiempo.setText(getIntent().getStringExtra("horas"));



        total.setText(getIntent().getStringExtra("total") + "€");




    }

}

