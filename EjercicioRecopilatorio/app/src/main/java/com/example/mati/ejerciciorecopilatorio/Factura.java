package com.example.mati.ejerciciorecopilatorio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Factura extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factura);



        TextView zonatext = (TextView) findViewById(R.id.texto2);
        TextView context = (TextView) findViewById(R.id.texto3);
        TextView prtext = (TextView) findViewById(R.id.texto4);
        TextView checkbox = (TextView) findViewById(R.id.check);
        TextView radio = (TextView) findViewById(R.id.radio);
        TextView resul = (TextView) findViewById(R.id.resul);

        Bundle miBundle = getIntent().getExtras();
        Destino destino = (Destino) miBundle.getSerializable("informacion");

        zonatext.setText(destino.getZona());
        context.setText(destino.getContinente());
        prtext.setText(destino.getPrecio());

        if(getIntent().getExtras().getBoolean("boolean1")==true){
            checkbox.setText(getIntent().getStringExtra("checkbox1"));
        }
        if(getIntent().getExtras().getBoolean("boolean2")==true){
            checkbox.setText(checkbox.getText() + getIntent().getStringExtra("checkbox2"));
        }



        radio.setText(radio.getText() + getIntent().getStringExtra("grupo"));
        resul.setText(String.valueOf(destino.getPrecio()));









    }
}
