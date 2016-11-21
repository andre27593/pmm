package com.example.mati.ejerciciorecopilatorio;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
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

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {

    private Destino[] datos = new Destino[]{
            new Destino("Zona A:", " Asia y Oceanía ", "30"),
            new Destino("Zona B:", " América y África ", "20"),
            new Destino("Zona C:", " Europa son", "10")
    };
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) findViewById(R.id.texto1);

        Button boton1 = (Button) findViewById(R.id.boton1);

        EditText editText = (EditText) findViewById(R.id.peso);

        final ListView lista = (ListView) findViewById(R.id.lstOpciones);

        final CheckBox checkBox1 = (CheckBox) findViewById(R.id.check1);
        final CheckBox checkBox2 = (CheckBox) findViewById(R.id.check2);

        final RadioButton radio1 = (RadioButton) findViewById(R.id.radio1);
        final RadioButton radio2 = (RadioButton) findViewById(R.id.radio2);

        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radiogroup);


        AdaptadorDestino adaptadorDestino = new AdaptadorDestino(this);
        lista.setAdapter(adaptadorDestino);



        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView arg0, View arg1, int position, long id) {
                String mensaje = "Zona: " + datos[position].getZona() + " , Continente: " + datos[position].getContinente() + " , Precio: " + datos[position].getPrecio();
                Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG).show();

                TextView text = (TextView) findViewById(R.id.texto2);


                text.setText(datos[position].getZona() + datos[position].getContinente() + datos[position].getPrecio());


            }

            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });

        boton1.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {

                final Intent miIntent = new Intent(MainActivity.this, Factura.class);

                TextView zonatext = (TextView) findViewById(R.id.texto2);
                TextView conttext = (TextView) findViewById(R.id.texto3);
                TextView pretext = (TextView) findViewById(R.id.texto4);
                TextView peso = (TextView) findViewById(R.id.peso);

                final String zona = zonatext.getText().toString();
                final String continente = conttext.getText().toString();
                final String precio = pretext.getText().toString();



                boolean selected1 = false;
                boolean selected2 = false;

                if(checkBox1.isChecked()){
                    selected1 = true;
                    TextView check1 = (TextView) findViewById(R.id.check1);
                    check1.setText(checkBox1.getText());


                }

                if(checkBox2.isChecked()){
                    selected2 = true;
                    TextView check2 = (TextView) findViewById(R.id.check2);
                    check2.setText((checkBox2.getText()));

                }


                String nombre;

                if (radioGroup.getCheckedRadioButtonId() == R.id.radio1) {
                    TextView radio1 = (TextView) findViewById(R.id.radio1);
                    radio1.setText(radio1.getText());
                    nombre=radio1.getText().toString();
                    miIntent.putExtra("grupo", nombre);


                }

                if (radioGroup.getCheckedRadioButtonId() == R.id.radio2) {
                    TextView radio2 = (TextView) findViewById(R.id.radio2);
                    radio2.setText((radio2.getText()));
                    nombre=radio2.getText().toString();
                    miIntent.putExtra("grupo", nombre);


                }


                double preciozona = Double.parseDouble(datos[lista.getSelectedItemPosition()].getPrecio());

                Destino destino = new Destino(datos[lista.getSelectedItemPosition()].getZona(), datos[lista.getSelectedItemPosition()].getContinente(), datos[lista.getSelectedItemPosition()].getPrecio());

                double preciopeso = 0;
                double total = 0;

                if(Double.parseDouble(peso.getText().toString())<6){
                    preciopeso = Double.parseDouble(peso.getText().toString())*1;
                    total = preciozona + preciopeso;
                }
                if(Double.parseDouble(peso.getText().toString())>=6 && Double.parseDouble(peso.getText().toString())<10){
                    preciopeso = Double.parseDouble(peso.getText().toString())*1.5;
                }
                if(Double.parseDouble(peso.getText().toString())>=10){
                    preciopeso = Double.parseDouble(peso.getText().toString())*2;
                }


                miIntent.putExtra("boolean1",selected1);
                miIntent.putExtra("boolean2",selected2);


                miIntent.putExtra("checkbox1", checkBox1.getText().toString());
                miIntent.putExtra("checkbox2", checkBox2.getText().toString());

                miIntent.putExtra("radio1", radio1.getText().toString());
                miIntent.putExtra("radio2", radio2.getText().toString());

                miIntent.putExtra("peso", peso.getText().toString());
                miIntent.putExtra("pesoprecio", Stringpreciopeso);


                Bundle miBundle = new Bundle();



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
            View item = inflater.inflate(R.layout.activity_factura, null);

            TextView zona = (TextView) item.findViewById(R.id.texto2);
            zona.setText(datos[i].getZona() + datos[i].getContinente() + datos[i].getPrecio());


            return item;
        }


    }


}
