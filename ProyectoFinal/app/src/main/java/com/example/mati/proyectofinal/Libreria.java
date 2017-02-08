package com.example.mati.proyectofinal;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Libreria extends AppCompatActivity implements Fragmento.OnFragmentInteractionListener{

    private Libros[] datos;
    private FragmentManager fragmentManager = getFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_libreria);


        BaseDeDatos cliBDh = new BaseDeDatos(this, "BaseDeDatos", null, 1);

        //Obtenemos referencia a la base de datos para poder modificarla.
        final SQLiteDatabase bd = cliBDh.getWritableDatabase();


        final Button factura = (Button) findViewById(R.id.factura);
        final TextView titulo = (TextView) findViewById(R.id.titulo);
        final Spinner libros = (Spinner) findViewById(R.id.libros);
        final TextView subtitulo = (TextView) findViewById(R.id.subtitulo);
        final CheckBox txt = (CheckBox) findViewById(R.id.txt);
        final CheckBox epub = (CheckBox) findViewById(R.id.epub);
        final CheckBox html = (CheckBox) findViewById(R.id.html);
        final CheckBox mobi = (CheckBox) findViewById(R.id.mobi);
        final CheckBox pdf = (CheckBox) findViewById(R.id.pdf);
        final TextView frase = (TextView) findViewById(R.id.formatofrase);
        final CheckBox ebook = (CheckBox) findViewById(R.id.ebook);
        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radiogroup);
        final RadioButton bolsillo = (RadioButton) findViewById(R.id.bolsillo);
        final RadioButton normal = (RadioButton) findViewById(R.id.normal);
        final Button volver = (Button) findViewById(R.id.volver);


        //INSERTAMOS LOS DATOS EN LA BASE DE DATOS

        //bd.execSQL("INSERT INTO Libros (titulo,subtitulo,autor,precio,genero) VALUES ('Cazadores de Sombras 1', 'Ciudad de Ceniza', 'Cassandra Clare', '20', 'Fantasia')");
        //bd.execSQL("INSERT INTO Libros (titulo,subtitulo,autor,precio,genero) VALUES ('Harry Potter 5', 'La orden del Fénix', 'J. K. Rowling', '22', 'Fantasia')");
        //bd.execSQL("INSERT INTO Libros (titulo,subtitulo,autor,precio,genero) VALUES ('La Quinta Ola 1', 'La Quinta Ola', 'Rick Yancey', '17', 'Ciencia Ficción')");
        //bd.execSQL("INSERT INTO Libros (titulo,subtitulo,autor,precio,genero) VALUES ('The Century 1', 'La Caída de los gigantes', 'Ken Follet', '20.50', 'Historia')");
        //bd.execSQL("INSERT INTO Libros (titulo,subtitulo,autor,precio,genero) VALUES ('Cazadores de Sombras. Artifices Oscuros 1','La dama de medianoche', 'Cassandra Clare', '18', 'Fantasia')");

        //SACAR LOS DATOS DE LA BASE DE DATOS
        String[] campos = new String[] {"Titulo", "Subtitulo", "Autor", "Precio", "Genero"};
        Cursor c = bd.query("Libros", campos, null, null, null, null, null);
        datos=new Libros[c.getCount()];
        int i=0;
        //Nos aseguramos de que exista al menos un registro
        if (c.moveToFirst()) {
            //Recorremos el cursor hasta que no haya más registros
            do {
                String tit = c.getString(0);
                String sub = c.getString(1);
                String autor=c.getString(2);
                String precio = c.getString(3);
                String genero = c.getString(4);


                datos[i]= new Libros(tit,sub,autor,precio,genero);

                i++;

            } while (c.moveToNext());
        }


        //DEFINIR EL SPINNER
        AdaptadorLibros adaptador = new AdaptadorLibros(this);
        final Spinner libreria = (Spinner) findViewById(R.id.libros);
        libros.setAdapter(adaptador);


        libreria.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView arg0, View arg1, int position, long id) {
                String mensaje = "Titulo: " + datos[position].getTitulo() + ", Subtitulo: " + datos[position].getSubtitulo() + ", Autor: " + datos[position].getAutor()
                        + ", Precio: " +datos[position].getPrecio() + ", Genero: " +datos[position].getGenero();
                Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG).show();
            }

            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Cerramos la base de datos
        bd.close();

        //DEFINIR EL BOTÓN DE FACTURA
        factura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Bundle miBundle = new Bundle();
                String formato="";
                String formato1="";
                String formato2="";
                String formato3="";
                String formato4="";
                double descuento=0;
                double precio_final=0;
                //CONVERTIR EL PRECIO STRING EN DOUBLE
                double precio = Double.parseDouble(datos[libreria.getSelectedItemPosition()].getPrecio());

                //DEFINIR LOS RADIOBUTTONS
                //SI ES DE BOLSILLO, TIENE UN DESCUENTO DEL 25%
                //PASAMOS EL NOMBRE, EL DESCUENTO Y EL PRECIO QUE SE QUEDA DESPUÉS DE APLICARLO
                if (radioGroup.getCheckedRadioButtonId() == R.id.bolsillo){

                    descuento = precio*0.25;//si es de bolsillo, un 25% más barato
                    precio_final = precio-descuento;
                    miBundle.putString("radiogroup", bolsillo.getText().toString());

                }

                //SI ES DE TAPA DURA, SOLO PASO EL NOMBRE
                if (radioGroup.getCheckedRadioButtonId() == R.id.normal){

                    miBundle.putString("radiogroup", normal.getText().toString());


                }

                //DEFINIR LOS CHECKBOX
                //SI ES EBOOK, DEFINO UNA VARIABLE BOOLEANA PARA SABER SI EL USUARIO HA ESCOGIDO EBOOK O NO Y
                //TIENE UN 35% DE DESCUENTO
                boolean eb = false;
                if(ebook.isChecked()){
                    //PASO EL BOOLEANO, EL DESCUENTO Y EL PRECIO QUE SE QUEDA DESPUÉS DE APLICARLO
                    eb=true;
                    descuento = precio*0.35;//si es ebook, un 35% más barato
                    precio_final = precio-descuento;
                    miBundle.putBoolean("ebook", eb);

                }

                //COMO EL DE BOLSILLO Y EL EBOOK TIENEN DOS DESCUENTOS DISTINTOS, CREO OTRA VARIABLE BOOLEANA
                //Y APLICO EL DESCUENTO TOTAL
                boolean dos = false;
                if(ebook.isChecked() && bolsillo.isChecked()){
                    //PASO EL BOOLEANO, EL DESCUENTO Y EL PRECIO QUE SE QUEDA DESPUÉS DE APLICARLO
                    dos = true;
                    descuento = precio*0.60;
                    precio_final = precio - descuento;
                    miBundle.putBoolean("dos", dos);

                }

                //DEFINIR EL FORMATO SI SE ESCOGE EBOOK
                //CREO 5 VARIABLES PARA QUE CUANDO EL USUARIO ESCOJA MÁS DE UNO, SALGAN TODOS EN EL FRAGMENTO
                //PASO EL NOMBRE DEL FORMATO
                if(txt.isChecked()){

                    formato = txt.getText().toString();

                }

                if(epub.isChecked()){

                    formato1 = epub.getText().toString();

                }

                if(html.isChecked()){

                    formato2 = html.getText().toString();

                }

                if(mobi.isChecked()){

                    formato3 = mobi.getText().toString();

                }

                if(pdf.isChecked()){

                    formato4 = pdf.getText().toString();

                }

                //PASAR LOS DATOS SELECCIONADOS EN EL SPINNER AL FRAGMENTO DINÁMICO
                Libros libro = new Libros(datos[libreria.getSelectedItemPosition()].getTitulo(), datos[libreria.getSelectedItemPosition()].getSubtitulo(),
                        datos[libreria.getSelectedItemPosition()].getAutor(), datos[libreria.getSelectedItemPosition()].getPrecio(), datos[libreria.getSelectedItemPosition()].getGenero());

                miBundle.putSerializable("datos", libro);

                //PASAR LOS DATOS DE LOS RADIOBUTTONS Y LOS CHECKBOX AL FRAGMENTO DINÁMICO
                miBundle.putSerializable("formato", formato);
                miBundle.putSerializable("formato1", formato1);
                miBundle.putSerializable("formato2", formato2);
                miBundle.putSerializable("formato3", formato3);
                miBundle.putSerializable("formato4", formato4);
                miBundle.putSerializable ("descuento", descuento);
                miBundle.putSerializable("precio final", precio_final);
                String usuario = getIntent().getStringExtra("usuario");
                miBundle.putSerializable("usu", usuario);


                //DEFINIR EL FRAGMENTO DINÁMICO
                FragmentTransaction transaction = fragmentManager.beginTransaction();

                Fragmento fragment = new Fragmento();
                fragment.setArguments(miBundle);
                transaction.add(R.id.activity_libreria,fragment);

                transaction.commit();

                //HACER TODOS LOS COMPONENTES INVISIBLES PARA QUE SALGA EL FRAGMENTO DINÁMICO
                titulo.setVisibility(View.INVISIBLE);
                libros.setVisibility(View.INVISIBLE);
                subtitulo.setVisibility(View.INVISIBLE);
                txt.setVisibility(View.INVISIBLE);
                epub.setVisibility(View.INVISIBLE);
                html.setVisibility(View.INVISIBLE);
                mobi.setVisibility(View.INVISIBLE);
                pdf.setVisibility(View.INVISIBLE);
                frase.setVisibility(View.INVISIBLE);
                ebook.setVisibility(View.INVISIBLE);
                radioGroup.setVisibility(View.INVISIBLE);
                bolsillo.setVisibility(View.INVISIBLE);
                normal.setVisibility(View.INVISIBLE);
                factura.setVisibility(View.INVISIBLE);

                //EL BOTÓN DE CANCELAR PEDIDO ESTÁ FUERA DEL FRAGMENT Y OCULTO EN LA PANTALLA DE LA LIBRERÍA
                //CUANDO PASO LOS DATOS AL FRAGMENTO, LO HAGO VISIBLE PARA PODER VOLVER A LA PANTALLA DE LA LIBRERÍA
                volver.setVisibility(View.VISIBLE);






            }
        });

        //DEFINIR EL BOTÓN CANCELAR PEDIDO
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent1 = new Intent(Libreria.this,Libreria.class);
                startActivity(intent1);

            }
        });



    }

    //DEFINIR EL ADAPTADOR PARA EL SPINNER Y METER LOS DATOS DE LA BASE DE DATOS EN ÉL
    public class AdaptadorLibros extends ArrayAdapter {

        Activity context;

        AdaptadorLibros(Activity context) {

            super(context, R.layout.activity_libros, datos);
            this.context = context;

        }

        public View getDropDownView(int position, View convertView, ViewGroup parent) {

            View vistaDesplegada = getView(position, convertView, parent);
            return vistaDesplegada;
        }

        public View getView(int i, View convertView, ViewGroup parent) {

            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.activity_libros, null);

            TextView titulo = (TextView) item.findViewById(R.id.titulo);
            titulo.setText(datos[i].getTitulo());

            TextView subtitulo = (TextView) item.findViewById(R.id.subtitulo);
            subtitulo.setText(datos[i].getSubtitulo());

            TextView autor = (TextView) item.findViewById(R.id.autor);
            autor.setText(datos[i].getAutor());

            TextView precio = (TextView) item.findViewById(R.id.precio);
            precio.setText(datos[i].getPrecio());

            TextView genero = (TextView) item.findViewById(R.id.genero);
            genero.setText(datos[i].getGenero());


            return (item);
        }


    }


    //CREAR EL MENÚ ITEM
    public boolean onCreateOptionsMenu (Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);
        return true;
    }
    public boolean onOptionsItemSelected (MenuItem item){
        switch (item.getItemId()){
            case R.id.acerca:
                Intent acerca = new Intent(Libreria.this, SobreNosotros.class);
                startActivity(acerca);
                return true;
            case R.id.vendidos:
                //METER EL DIALOG FRAGMENT EN EL MENÚ ITEM
                DialogFragment vendidos = Vendidos.newInstance("Vendidos");
                vendidos.show(getFragmentManager(),"vendidos");
                return true;
            case R.id.noticias:
                //BUSCAR NOTICIAS
                Intent noticias = new Intent(Libreria.this, Noticias.class);
                startActivity(noticias);
                return true;
            case R.id.salir:
                //OPCIÓN PARA VOLVER A LA PANTALLA DE LOG IN
                Intent salir = new Intent(this, MainActivity.class);
                startActivity(salir);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //PARA EL FRAGMENTO DINÁMICO
    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
