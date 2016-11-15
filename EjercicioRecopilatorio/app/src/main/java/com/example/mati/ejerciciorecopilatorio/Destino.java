package com.example.mati.ejerciciorecopilatorio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.Serializable;

public class Destino implements Serializable{

    private String zona;
    private String continente;
    private String precio;

    public Destino(String zona, String continente, String precio) {
        this.zona = zona;
        this.continente = continente;
        this.precio = precio;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Destino{" +
                "zona='" + zona + '\'' +
                ", continente='" + continente + '\'' +
                ", precio=" + precio +
                '}';
    }
}
