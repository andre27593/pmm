package com.example.oli.ejercicioexamen;

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



        TextView zonatext = (TextView) findViewById(R.id.zona);
        TextView context = (TextView) findViewById(R.id.continente);
        TextView prtext = (TextView) findViewById(R.id.precio);
        TextView caja = (TextView) findViewById(R.id.caja);
        TextView dedicatoria = (TextView) findViewById(R.id.dedicatoria);
        TextView tarifas = (TextView) findViewById(R.id.tarifas);
        TextView preciopeso = (TextView) findViewById(R.id.preciopeso);
        TextView tarifa = (TextView) findViewById(R.id.tarifa);
        TextView total = (TextView) findViewById(R.id.total);

        Bundle miBundle = getIntent().getExtras();
        Destino destino = (Destino) miBundle.getSerializable("informacion");

        zonatext.setText(destino.getZona());
        context.setText(destino.getContinente());
        prtext.setText(destino.getPrecio());
        tarifas.setText(getIntent().getStringExtra("nombretarifa"));

        if(getIntent().getExtras().getBoolean("selected", false) == true){
            caja.setText(getIntent().getStringExtra("caja"));
        }
        if(getIntent().getBooleanExtra("selected", false) == true){
           dedicatoria.setText(getIntent().getStringExtra("dedicatoria"));
        }

        if(getIntent().getStringExtra("nombretarifa").equalsIgnoreCase("TARIFA URGENTE")){
            tarifa.setText(getIntent().getStringExtra("nombretarifa") + " (+30%)");
        }else{
            tarifa.setText(getIntent().getStringExtra("nombretarifa"));
        }

        double precio = 0;

        if(destino.getZona().contains("Zona A")){
            precio = 30;
        }

        if(destino.getZona().contains("Zona B")){
            precio = 20;
        }

        if(destino.getZona().contains("Zona C")){
             precio = 10;
        }

        preciopeso.setText(getIntent().getStringExtra("preciopeso") + " €");



        total.setText(precio + "€+ " +getIntent().getStringExtra("preciopeso")+
                "€ +" + getIntent().getStringExtra("tarifa") + "€ = " +getIntent().getStringExtra("total") + " €");





















    }
}


















