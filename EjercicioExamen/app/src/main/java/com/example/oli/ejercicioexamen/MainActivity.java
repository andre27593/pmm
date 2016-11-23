package com.example.oli.ejercicioexamen;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) findViewById(R.id.texto1);

        Button boton1 = (Button) findViewById(R.id.boton1);


        final ListView lista = (ListView) findViewById(R.id.lstOpciones);
        final CheckBox caja = (CheckBox) findViewById(R.id.caja);
        final CheckBox dedicatoria = (CheckBox) findViewById(R.id.dedicatoria);

        AdaptadorDestino adaptadorDestino = new AdaptadorDestino(this);
        lista.setAdapter(adaptadorDestino);



        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView arg0, View arg1, int position, long id) {
                String mensaje = "Zona: " + datos[position].getZona() + " , Continente: " + datos[position].getContinente() + " , Precio: " + datos[position].getPrecio();
                Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG).show();

                TextView zona = (TextView) findViewById(R.id.zona);
                TextView cont = (TextView) findViewById(R.id.continente);
                TextView pre = (TextView) findViewById(R.id.precio);



                zona.setText(datos[position].getZona());
                cont.setText(datos[position].getContinente());
                pre.setText(datos[position].getPrecio());


            }

            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });

        boton1.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {

                final Intent miIntent = new Intent(MainActivity.this, Factura.class);

                Bundle miBundle = new Bundle();



                TextView zonatext = (TextView) findViewById(R.id.zona);
                TextView conttext = (TextView) findViewById(R.id.continente);
                TextView pretext = (TextView) findViewById(R.id.precio);
                EditText peso = (EditText) findViewById(R.id.peso);
                RadioButton normal = (RadioButton) findViewById(R.id.normal);
                RadioButton urgente = (RadioButton) findViewById(R.id.urgente);
                RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radiogroup);



                String zona = zonatext.getText().toString();
                String continente = conttext.getText().toString();
                String precio = pretext.getText().toString();

                Destino destino = new Destino(zona, continente, precio);

                double preciopeso = 0;
                if (Double.parseDouble(peso.getText().toString())<6){
                    preciopeso = Double.parseDouble(peso.getText().toString()) * 1;
                }
                if (Double.parseDouble(peso.getText().toString())>=6 &&Double.parseDouble(peso.getText().toString())<10 ){
                    preciopeso = Double.parseDouble(peso.getText().toString()) * 1.5;
                }
                if (Double.parseDouble(peso.getText().toString())>=10){
                    preciopeso = Double.parseDouble(peso.getText().toString()) * 2;
                }

                double total = 0;

                if(destino.getZona().contains("Zona A")){
                    total = preciopeso + 30;
                }

                if(destino.getZona().contains("Zona B")){
                    total = preciopeso + 20;
                }

                if(destino.getZona().contains("Zona C")){
                    total = preciopeso + 10;
                }

                String nombre= " ";
                double tarifa = 0;

                if(radioGroup.getCheckedRadioButtonId() == R.id.normal){
                    tarifa = (total*30)/100;
                    nombre = normal.getText().toString();

                }
                if(radioGroup.getCheckedRadioButtonId() == R.id.urgente){
                    tarifa = 0;
                    nombre = urgente.getText().toString();

                }

                boolean checked = false;

                if(caja.isChecked()){
                    checked = true;
                    miIntent.putExtra("caja", caja.getText().toString());
                    miIntent.putExtra("selected", checked);

                }

                if(dedicatoria.isChecked()){
                    checked = true;
                    miIntent.putExtra("dedicatoria", dedicatoria.getText().toString());
                    miIntent.putExtra("selected", checked);
                }


                //Coger el precio de cada zona para sumarselo al precio del peso

                miBundle.putSerializable("informacion", destino);
                miIntent.putExtras(miBundle);

                miIntent.putExtra("nombretarifa", nombre);
                miIntent.putExtra("tarifa", String.valueOf(tarifa));
                miIntent.putExtra("preciopeso", String.valueOf(preciopeso));
                miIntent.putExtra("precio", String.valueOf(destino.getPrecio()));
                total = total + tarifa;
                miIntent.putExtra("total", String.valueOf(total));


                startActivity(miIntent);




            }
        });

    }

    public boolean onCreateOptionsMenu (Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);
        return true;
    }
    public boolean onOptionsItemSelected (MenuItem item){
        switch (item.getItemId()){
            case R.id.acerca:
                Intent acerca = new Intent(MainActivity.this, acerca_de.class);
                startActivity(acerca);
                return true;
            case R.id.dibujar:
                Intent dibujo = new Intent(MainActivity.this, dibujar.class);
                startActivity(dibujo);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
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

            TextView zona = (TextView) item.findViewById(R.id.zona);
            zona.setText(datos[i].getZona());

            TextView cont = (TextView) item.findViewById(R.id.continente);
            cont.setText(datos[i].getContinente());

            TextView pre = (TextView) item.findViewById(R.id.precio);
            pre.setText(datos[i].getPrecio());

            return item;
        }


    }


}



