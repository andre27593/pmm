package com.example.mati.spinnerobjetosotrapantalla;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
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
        final Spinner lstOpciones = (Spinner) findViewById(R.id.lstOpciones);
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

    public static class ViewHolder{

        TextView titulo;
        TextView subtitulo;

    }

    public class AdaptadorTitulares extends ArrayAdapter {

        Activity context;


        AdaptadorTitulares(Activity context){

            super(context,R.layout.activity_titular,datos);
            this.context = context;

        }

        public View getDropDownView(final int position, View convertView, ViewGroup parent){

            View vistaDesplegada = getView(position,convertView,parent);


            vistaDesplegada.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                final TextView tituloText = (TextView) findViewById(R.id.LblTitulo);
                tituloText.setText(datos[position].getTitulo());
                final TextView subtituloText = (TextView) findViewById(R.id.LblSubTitulo);
                subtituloText.setText(datos[position].getSubtitulo());


                String titulo = tituloText.getText().toString();
                String subtitulo = subtituloText.getText().toString();


                Intent miIntent = new Intent(MainActivity.this, Pantalla2.class);
                Bundle miBundle = new Bundle();
                Titular titular = new Titular(titulo,subtitulo,R.id.lbimagen);

                miBundle.putSerializable("información",titular);
                miIntent.putExtras(miBundle);
                startActivity(miIntent);



                }
            });

            return vistaDesplegada;

        } //Método necesario para que despliegue la lista, sin este método no funciona

        public View getView(int i, View convertView, ViewGroup parent) {

            View item = convertView;
            ViewHolder holder;

            if (item == null) {

                LayoutInflater inflater = context.getLayoutInflater();
                item = inflater.inflate(R.layout.activity_titular, null);

                holder = new ViewHolder();

                holder.titulo = (TextView) item.findViewById(R.id.LblTitulo);
                holder.subtitulo = (TextView) item.findViewById(R.id.LblSubTitulo);

                item.setTag(holder);

            } else {

                holder=(ViewHolder) item.getTag();
            }



                holder.titulo.setText(datos[i].getTitulo());


                holder.subtitulo.setText(datos[i].getSubtitulo());

                ImageView imagen = (ImageView) item.findViewById(R.id.lbimagen);
                imagen.setBackground(getDrawable(datos[i].getImagen()));


                return (item);
            }
        }

}
