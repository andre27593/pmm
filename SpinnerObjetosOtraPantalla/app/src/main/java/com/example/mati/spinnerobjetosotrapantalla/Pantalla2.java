package com.example.mati.spinnerobjetosotrapantalla;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Pantalla2 extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        final TextView info = (TextView) findViewById(R.id.texto);
        final ImageView imagen = (ImageView) findViewById(R.id.imagen);
        final Button boton = (Button) findViewById(R.id.volver);

        Bundle miBundle = getIntent().getExtras();
        Titular titular = (Titular) miBundle.getSerializable("información");


        info.setText("Titulo: " + titular.getTitulo() + ", subtitulo: " + titular.getSubtitulo());



        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent miIntent = new Intent(Pantalla2.this,MainActivity.class);
                startActivity(miIntent);

            }
        });




    }
}
