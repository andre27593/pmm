package com.example.mati.proyectofinal;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;


import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class Libreria extends AppCompatActivity implements Fragmento.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_libreria);

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




        factura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();

                Fragmento fragment = new Fragmento();
                transaction.add(R.id.activity_libreria,fragment);

                transaction.commit();


                if (radioGroup.getCheckedRadioButtonId() == R.id.bolsillo){

                    //(precio * 25)/100 --> 40%
                    //tipo =

                }

                if (radioGroup.getCheckedRadioButtonId() == R.id.normal){

                    //tipo =


                }

                if(ebook.isChecked()){

                    //(precio * 35) /100 --> 35%
                    //ebook =

                }

                if(txt.isChecked()){

                    //formato = txt.getText(),toString

                }



                Bundle miBundle = new Bundle();

                //miBundle.putSerializable("tipo", tipo);
                //miBundle.putSerializable("ebook", ebook);
                //miBundle.putSerializable ("formato", formato);



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


                volver.setVisibility(View.VISIBLE);






            }
        });


        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent1 = new Intent(Libreria.this,Libreria.class);
                startActivity(intent1);

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
                Intent acerca = new Intent(Libreria.this, AcercaDe.class);
                startActivity(acerca);
                return true;
           /* case R.id.menu_dibujar:
                Intent dibujo = new Intent(Libreria.this, Dibujar.class);
                startActivity(dibujo);
                return true;
            */default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
