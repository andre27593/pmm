package com.example.mati.proyectofinal;

import java.io.Serializable;

/**
 * Created by oli on 17/01/2017.
 */

public class Libros implements Serializable{

    private String titulo;
    private String subtitulo;
    private String autor;
    private String precio;
    private String genero;

    public Libros(String titulo, String subtitulo, String autor, String precio, String genero){

        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.autor = autor;
        this.precio = precio;
        this.genero = genero;

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Libros{" +
                "titulo='" + titulo + '\'' +
                ", subtitulo='" + subtitulo + '\'' +
                ", autor='" + autor + '\'' +
                ", precio='" + precio + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }
}
