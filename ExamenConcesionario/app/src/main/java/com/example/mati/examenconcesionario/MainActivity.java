package com.example.mati.examenconcesionario;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Lista para el spinner
    private Coche[] datos = new Coche[]{
            new Coche("Megan: ", "Seat", 20),
            new Coche("Leon: ", "Seat", 30),
            new Coche("Fiesta: ", "Ford", 40),
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Para rellenear el spinner
        AdaptadorCoches adaptador = new AdaptadorCoches(this);
        final Spinner coches = (Spinner) findViewById(R.id.coches);
        coches.setAdapter(adaptador);

        Button total = (Button)findViewById(R.id.calcular);
        Button factura = (Button) findViewById(R.id.factura);
        final RadioGroup seguros = (RadioGroup)findViewById(R.id.seguros);
        final Button sin = (Button)findViewById(R.id.sin);
        final Button riesgo = (Button)findViewById(R.id.riesgo);
        final EditText horas = (EditText)findViewById(R.id.horas);
        final CheckBox aire = (CheckBox)findViewById(R.id.aire);
        final CheckBox gps = (CheckBox)findViewById(R.id.gps);
        final CheckBox radio = (CheckBox)findViewById(R.id.radio);


        total.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView precio = (TextView) findViewById(R.id.preciototal);

                double preciocoches = datos[coches.getSelectedItemPosition()].getPrecio();
                double preciocoche = Double.parseDouble(horas.getText().toString()) * preciocoches;

                double total = 0;

                double extra = 0;
                boolean checked = false;
                if(aire.isChecked()){
                    checked = true;
                    extra = 50;

                }
                if(gps.isChecked()){
                    checked = true;
                    extra = 50+50;

                }
                if(radio.isChecked()){
                    checked = true;
                    extra = 50+50+50;

                }

                double ext = extra + preciocoche;


                if (seguros.getCheckedRadioButtonId() == R.id.sin){
                    total = ext;

                }
                if (seguros.getCheckedRadioButtonId() == R.id.riesgo){
                    total = ext*1.20;

                }

                precio.setText(String.valueOf(total));

            }
        });


        factura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent miIntent = new Intent(MainActivity.this, Factura.class);




                double preciocoches = datos[coches.getSelectedItemPosition()].getPrecio();

                Coche coche = new Coche (datos[coches.getSelectedItemPosition()].getModelo(),
                        datos[coches.getSelectedItemPosition()].getMarca(),
                        datos[coches.getSelectedItemPosition()].getPrecio());




                if (horas.getText().toString().isEmpty()){
                    horas.setText("0");
                }

                double preciocoche = 0;


                preciocoche = Double.parseDouble(horas.getText().toString()) * preciocoches;
                miIntent.putExtra("horas", horas.getText().toString());
                miIntent.putExtra("preciocoche", String.valueOf(preciocoche));


                double extra = 0;
                boolean checked = false;
                if(aire.isChecked()){
                    checked = true;
                    extra = 50;
                    miIntent.putExtra("aireacondicionado", aire.getText().toString());
                    miIntent.putExtra("checked", checked);
                }
                if(gps.isChecked()){
                    checked = true;
                    extra = 50+50;
                    miIntent.putExtra("gps", gps.getText().toString());
                    miIntent.putExtra("checked", checked);
                }
                if(radio.isChecked()){
                    checked = true;
                    extra = 50+50+50;
                    miIntent.putExtra("radio/DVD", radio.getText().toString());
                    miIntent.putExtra("checked", checked);
                }

                double total = 0;

                double ext = extra + preciocoche;


                String nomseguro = " ";
                if (seguros.getCheckedRadioButtonId() == R.id.sin){
                    total = ext;
                    nomseguro = sin.getText().toString();

                }
                if (seguros.getCheckedRadioButtonId() == R.id.riesgo){
                    total = ext*1.20;
                    nomseguro = riesgo.getText().toString();
                }
                miIntent.putExtra("nomseguro", nomseguro);


                miIntent.putExtra("extra", String.valueOf(ext));
                miIntent.putExtra("total", String.valueOf(total));

                Bundle miBundle = new Bundle();

                miBundle.putSerializable("coche", coche);
                miIntent.putExtras(miBundle);

                startActivity(miIntent);
                //String mensaje = "Total = " + total;
                //Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG).show();
            }
        });
    }
    //Menu de Arcerca DE y dibujar
    public boolean onCreateOptionsMenu (Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);
        return true;
    }
    public boolean onOptionsItemSelected (MenuItem item){
        switch (item.getItemId()){
            case R.id.acerca:
                Intent acerca = new Intent(MainActivity.this, Acercade.class);
                startActivity(acerca);
                return true;
            case R.id.menu_dibujar:
                Intent dibujo = new Intent(MainActivity.this, Dibujar.class);
                startActivity(dibujo);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //Rellenando el spinner
    public class AdaptadorCoches extends ArrayAdapter<Coche> {
        Activity context;

        AdaptadorCoches(Activity context){
            super(context, R.layout.activity_coche, datos);
            this.context = context;
        }
        public  View getDropDownView (int position, View convertView, ViewGroup parent){
            View vistaDesplegada = getView(position, convertView, parent);
            return  vistaDesplegada;

        }


        public View getView(int i, View convertView, ViewGroup parent){
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.activity_coche, null);

            TextView lblTitulo = (TextView) item.findViewById(R.id.lblmodelo);
            lblTitulo.setText(datos[i].getModelo());

            TextView lblSubtitulo = (TextView) item.findViewById(R.id.lblmarca);
            lblSubtitulo.setText(datos[i].getMarca());

            TextView lblPrecio = (TextView)item.findViewById(R.id.lblprecio);
            lblPrecio.setText(String.valueOf(datos[i].getPrecio()) + "€");

            return (item);
        }

    }
}
