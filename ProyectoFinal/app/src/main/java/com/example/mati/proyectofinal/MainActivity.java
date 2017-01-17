package com.example.mati.proyectofinal;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Abrimos la base de datos en modo escritura
        BaseDeDatos cliBDh = new BaseDeDatos(this, "BaseDeDatos", null, 1);

        //Obtenemos referencia a la base de datos para poder modificarla.
        SQLiteDatabase bd = cliBDh.getWritableDatabase();

        final Button login = (Button) findViewById(R.id.login);
        final Button registro = (Button) findViewById(R.id.registrar);
        final EditText usu = (EditText) findViewById(R.id.usuario);

        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent1 = new Intent(MainActivity.this, Registro.class);
                startActivity(intent1);


            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (usu.equals("")) {

                    Intent intent2 = new Intent(MainActivity.this, Libreria.class);
                    startActivity(intent2);

                }else{

                    Toast toast = Toast.makeText(getApplicationContext(), "Usuario incorrecto", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });


    }
}
