package com.example.mati.spinnerobjetos;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Titular[] datos = new Titular[]{

            new Titular("Cazadores de Sombras 1", "Ciudad de hueso",R.drawable.img1),
            new Titular("Cazadores de Sombras 2", "Ciudad de ceniza",R.drawable.img2),
            new Titular("Cazadores de Sombras 3", "Ciudad de cristal",R.drawable.img3)

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdaptadorTitulares adaptador = new AdaptadorTitulares(this);
        Spinner lstOpciones = (Spinner) findViewById(R.id.lstOpciones);
        lstOpciones.setAdapter(adaptador);

        lstOpciones.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView arg0, View arg1, int position, long id) {
               String mensaje = "Titulo: " + datos[position].getTitulo() + ", Subtitulo: " + datos[position].getTitulo();
               Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG).show();
            }

            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public class AdaptadorTitulares extends ArrayAdapter {

        Activity context;

        AdaptadorTitulares(Activity context){

            super(context,R.layout.activity_titular,datos);
            this.context = context;

        }

        public View getDropDownView(int position, View convertView, ViewGroup parent){

            View vistaDesplegada = getView(position,convertView,parent);
            return vistaDesplegada;
        } //Método necesario para que despliegue la lista, sin este método no funciona

        public View getView(int i, View convertView, ViewGroup parent){

            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.activity_titular,null);

            TextView lblTitulo = (TextView) item.findViewById(R.id.LblTitulo);
            lblTitulo.setText(datos[i].getTitulo());

            TextView lblSubtitulo = (TextView) item.findViewById(R.id.LblSubTitulo);
            lblSubtitulo.setText(datos[i].getSubtitulo());

            ImageView imagen = (ImageView) item.findViewById(R.id.lbimagen);
            imagen.setBackground(getDrawable(datos[i].getImagen()));


            return (item);
        }

    }
}
