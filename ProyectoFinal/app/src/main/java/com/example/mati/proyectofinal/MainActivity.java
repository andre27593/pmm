package com.example.mati.proyectofinal;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Abrimos la base de datos en modo escritura
        BaseDeDatos cliBDh = new BaseDeDatos(this, "BaseDeDatos", null, 1);

        //Obtenemos referencia a la base de datos para poder modificarla.
        final SQLiteDatabase bd = cliBDh.getWritableDatabase();

        final Button login = (Button) findViewById(R.id.login);
        final Button registro = (Button) findViewById(R.id.registrar);
        final EditText usu = (EditText) findViewById(R.id.usuario);
        final EditText cont = (EditText) findViewById(R.id.contraseña);

        //DEFINIR EL BOTÓN DE REGISTRO
        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent1 = new Intent(MainActivity.this, Registro.class);
                startActivity(intent1);


            }
        });


        //DEFINIR EL BOTÓN DE LOG IN
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //COGEMOS EL USUARIO Y LA CONTRASEÑA QUE INTRODUCIMOS
                String usuario = usu.getText().toString();
                String contraseña = cont.getText().toString();

                Bundle miBundle = new Bundle();

                //HACEMOS UN SELECT DE LA TABLA USUARIOS PARA, COMPROBANDO EL USUARIO Y LA CONTRASEÑA, SABER SI EL USUARIO ESTÁ REGISTRADO
                Cursor login = bd.rawQuery("SELECT usuario,contraseña FROM Usuarios WHERE usuario= '" + usuario + "' and contraseña= '" + contraseña + "'", null);

                //CON EL CURSOR, COMPROBAMOS LOS REGISTROS QUE HAY EN LA TABLA DE USUARIOS Y SI COINCIDEN CON LOS QUE INTRODUCIMOS
                //PASAMOS A LA PANTALLA DE LIBRERÍA, SI NO NOS QUEDAMOS AQUI
                if (login.moveToFirst()) {

                    String usu_correcto = login.getString(0);
                    String cont_correcta = login.getString(1);

                    if (usuario.equals(usu_correcto) && contraseña.equals(cont_correcta)) {
                        Intent intent2 = new Intent(MainActivity.this, Libreria.class);
                        //PASAR EL USUARIO
                        miBundle.putString("usuario", usu_correcto);
                        intent2.putExtras(miBundle);
                        startActivity(intent2);

                    }

                }
            }
        });


        }

}

