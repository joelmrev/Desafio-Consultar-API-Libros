package com.aluracursos.desafiobuscarlibros.model;

import java.util.List;

public class Libro {
    private String autores;
    private String titulo;
    private Integer descargas;

    @Override
    public String toString() {
        return "autores='" + autores + '\'' +
                ", titulo='" + titulo + '\'' +
                ", descargas=" + descargas;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getDescargas() {
        return descargas;
    }

    public void setDescargas(Integer descargas) {
        this.descargas = descargas;
    }

    public Libro(String autores, DatosLibroBuscado d) {
        this.autores = autores;
        this.titulo = d.titulo();
        try {
            this.descargas = d.descargas();
        } catch (RuntimeException e) {
            System.out.println(e);
        }

    }
}
