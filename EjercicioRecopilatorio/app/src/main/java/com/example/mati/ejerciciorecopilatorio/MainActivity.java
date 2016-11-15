package com.example.mati.ejerciciorecopilatorio;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Destino[] datos = new Destino[]{
            new Destino("Zona A:", " Asia y Oceanía ", "30"),
            new Destino("Zona B:", " América y África ", "20"),
            new Destino("Zona C:", " Europa son", "10")
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) findViewById(R.id.texto1);

        Button boton1 = (Button) findViewById(R.id.boton1);

        EditText editText = (EditText) findViewById(R.id.editText);

        ListView lista = (ListView) findViewById(R.id.lstOpciones);

        CheckBox checkBox1 = (CheckBox) findViewById(R.id.check1);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.check2);

        RadioButton radio1 = (RadioButton) findViewById(R.id.radio1);
        RadioButton radio2 = (RadioButton) findViewById(R.id.radio2);

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radiogroup);




        AdaptadorDestino adaptadorDestino = new AdaptadorDestino(this);
        lista.setAdapter(adaptadorDestino);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView arg0, View arg1, int position, long id) {
                String mensaje = "Zona: " +datos[position].getZona() + " , Continente: " +datos[position].getContinente() + " , Precio:" +datos[position].getPrecio();
                Toast.makeText(getApplicationContext(),mensaje,Toast.LENGTH_LONG).show();
            }

            public void onNothingSelected(AdapterView<?> adapterView){

            }

        });

        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView text = (TextView) findViewById(R.id.texto2);

                final String zona = text.getText().toString();
                final String continente = text.getText().toString();
                final String precio = text.getText().toString();

                Intent miIntent = new Intent(MainActivity.this, Factura.class);
                Bundle miBundle = new Bundle();

                Destino destino = new Destino(zona,continente,precio);

                miBundle.putSerializable("informacion", destino);
                miIntent.putExtras(miBundle);
                startActivity(miIntent);
            }
        });

    }

    public class AdaptadorDestino extends ArrayAdapter {
        Activity context;

        AdaptadorDestino(Activity context) {
            super(context, R.layout.activity_destino, datos);
            this.context = context;
        }


        public View getView(int i, View convertView, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.activity_factura,null);

            TextView zona = (TextView) item.findViewById(R.id.texto2);
            zona.setText(datos[i].getZona() + datos[i].getContinente() + datos[i].getPrecio());

            return item;
        }

    }




}
