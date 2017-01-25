package com.example.mati.proyectofinal;

/**
 * Created by oli on 17/01/2017.
 */

public class Libros {

    private String titulo;
    private String autor;
    private String genero;

    public Libros(String titulo, String autor, String genero){

        this.titulo = titulo;
        this.autor = autor;
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

    @Override
    public String toString() {
        return "Libros{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }
}
