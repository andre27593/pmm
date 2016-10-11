package com.example.mati.objetosentrepantallas;

import java.io.Serializable;

/**
 * Created by mati on 5/10/16.
 */
public class Persona implements Serializable{
    String nombre;
    String apellido;
    int edad;


    public Persona() {

    }

    public Persona(String nombre, String apellido, int edad){

        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;


    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }


    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                '}';
    }
}
