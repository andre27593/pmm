package com.example.mati.proyectofinal;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Registro extends AppCompatActivity {

    private BaseDeDatos cliBDh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        //VOLVEMOS A ABRIR LA BASE DE DATOS
        cliBDh = new BaseDeDatos(this, "BaseDeDatos", null, 1);


        final Button volver = (Button) findViewById(R.id.volver);
        final Button guardar = (Button) findViewById(R.id.guardar);
        final EditText usu = (EditText) findViewById(R.id.usuario);
        final EditText cont = (EditText) findViewById(R.id.contraseña);
        final EditText conf = (EditText) findViewById(R.id.conf);
        final EditText nom = (EditText) findViewById(R.id.nom);
        final EditText email = (EditText) findViewById(R.id.email);

        //DEFINIR EL BOTON PARA GUARDAR LOS DATOS DEL USUARIO EN LA TABLA USUARIOS
        //CON UN INSERT DE TODOS LOS CAMPOS QUE TIENE LA TABLA
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SQLiteDatabase bd = cliBDh.getWritableDatabase();

                bd.execSQL("INSERT INTO Usuarios (usuario, contraseña, confirmar, nombre, correo) VALUES " +
                        "('"+usu.getText().toString()+"', '"+cont.getText().toString()+"', '"+conf.getText().toString()+"', '"+nom.getText().toString()+"'" +
                        ", '"+email.getText().toString()+"')");

               
                //CUANDO SE GUARDA SALE EL MENSAJE DE REGISTRO GUARDADO
                Toast.makeText(getApplicationContext(), "Registro guardado", Toast.LENGTH_SHORT).show();


            }
        });

        //CON EL BOTON VOLVER VOLVEMOS A LA PANTALLA DE LOG IN
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent2 = new Intent(Registro.this, MainActivity.class);
                startActivity(intent2);


            }
        });

    }
}
