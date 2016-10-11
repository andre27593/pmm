package com.example.mati.objetosentrepantallas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Pantalla2 extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_pantalla2);

            final TextView otrosaludo = (TextView) findViewById(R.id.saludo);

            Bundle miBundle = getIntent().getExtras();
            Persona persona = (Persona) miBundle.getSerializable("informacion");
            otrosaludo.setText("Nombre: " + persona.getNombre() + ", apellidos: " + persona.getApellido() + " con edad: " + persona.getEdad());

        }

    }


