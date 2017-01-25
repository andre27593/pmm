package com.example.mati.proyectofinal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by mati on 25/01/17.
 */

public class BaseUsuarios extends SQLiteOpenHelper {

    String sqlCreateUsuarios = "CREATE TABLE IF NOT EXISTS 'Usuarios' (" +
            " 'usuario' TEXT NOT NULL, " +
            " 'contraseña' TEXT NOT NULL, " +
            " 'confirmar' TEXT NOT NULL, " +
            " 'nombre' TEXT " +
            " 'email' TEXT " +
            " );";

    String sqlCreateLibroS = "CREATE TABLE IF NOT EXISTS 'Libros' (" +
            " 'titulo' TEXT NOT NULL, " +
            " 'subtitulo' TEXT NOT NULL, " +
            " 'precio' TEXT NOT NULL, " +
            " 'genero' TEXT " +
            " );";

    public BaseUsuarios(Context contexto, String nombre, SQLiteDatabase.CursorFactory almacen, int version){
        super(contexto, nombre, almacen, version);
    }

    //Este metodo se ejecuta automaticamente cuando sea necesaria la creacion de la base de datos.
    //Es decir, se ejecutará cuando la base de datos todavia no exista.
    //Aqui deben crearse todas las tablas necesarias e insertar los datos iniciales si es necesario.
    @Override
    public void onCreate(SQLiteDatabase bd) {
        //Ejecutamos la sentencia SQL para crear la tabla Clientes
        //El metodo execSQL se limita a ejecutar directamente el codigo SQL que le pasemos.

        bd.execSQL(sqlCreateUsuarios);
        bd.execSQL(sqlCreateLibroS);
    }


    //Este metodo se lanza automaticamente cuando es necesaria una actualizacion de la estructura
    //de la base de datos o una conversion de los datos.
    @Override
    public void onUpgrade(SQLiteDatabase bd, int versionAnterior, int versionNueva) {


    }

}
