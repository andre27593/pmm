package com.example.mati.objetosentrepantallas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.Serializable;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



            final EditText nombreText = (EditText) findViewById(R.id.nombre);
            final EditText apellidosText = (EditText) findViewById(R.id.apellidos);
            final EditText edadText = (EditText) findViewById(R.id.edad);

            final Button pulsar = (Button) findViewById(R.id.pulsar);



            pulsar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                            String nombre = nombreText.getText().toString();
                            String apellido = apellidosText.getText().toString();
                            int edad = Integer.parseInt(edadText.getText().toString());

                            Intent miIntent = new Intent(MainActivity.this, Pantalla2.class);
                            Bundle miBundle = new Bundle();
                            Persona persona = new Persona(nombre,apellido,edad);

                            miBundle.putSerializable("informacion",persona);
                            miIntent.putExtras(miBundle);
                            startActivity(miIntent);
                        }





            });


    }

}
