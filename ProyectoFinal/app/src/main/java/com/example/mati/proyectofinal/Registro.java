package com.example.mati.proyectofinal;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Registro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        BaseDeDatos cliBDh = new BaseDeDatos(this, "BaseDeDatos", null, 1);
        final SQLiteDatabase bd = cliBDh.getWritableDatabase();

        final Button volver = (Button) findViewById(R.id.volver);
        final Button guardar = (Button) findViewById(R.id.guardar);
        final EditText usu = (EditText) findViewById(R.id.usuario);
        final EditText cont = (EditText) findViewById(R.id.contraseña);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String usuario = "Usuario: " + usu.getText();
                String contraseña = "Contraseña: " +cont.getText();

                bd.execSQL("INSERT INTO Usuarios (usuario, contraseña) " +
                    "VALUES ('" + usuario + "', '" + contraseña + "')");

                Toast toast = Toast.makeText(getApplicationContext(), "Registro guardado", Toast.LENGTH_SHORT);

                toast.show();
            }
        });


        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent2 = new Intent(Registro.this, MainActivity.class);
                startActivity(intent2);


            }
        });

    }
}
