package com.example.mati.proyectofinal;

import android.content.Intent;
import android.database.Cursor;
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
        BaseUsuarios cliBDh = new BaseUsuarios(this, "BaseDeDatos", null, 1);

        //Obtenemos referencia a la base de datos para poder modificarla.
        final SQLiteDatabase bd = cliBDh.getWritableDatabase();

        final Button login = (Button) findViewById(R.id.login);
        final Button registro = (Button) findViewById(R.id.registrar);
        final EditText usu = (EditText) findViewById(R.id.usuario);
        final EditText cont = (EditText) findViewById(R.id.contraseña);

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


                String usuario = usu.getText().toString();
                String contraseña = cont.getText().toString();

                Cursor login = bd.rawQuery("SELECT usuario,contraseña FROM Usuarios WHERE usuario= '" + usuario + "' and contraseña= '" + contraseña + "'", null);

                if (login.moveToFirst()) {

                    String usu_correcto = login.getString(0);
                    String cont_correcta = login.getString(1);

                    if (usuario.equals(usu_correcto) && contraseña.equals(cont_correcta)) {
                        Intent intent2 = new Intent(MainActivity.this, Libreria.class);
                        startActivity(intent2);

                    }

                }
            }
        });


        }

}

