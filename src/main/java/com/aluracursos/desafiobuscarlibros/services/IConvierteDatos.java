package com.aluracursos.desafiobuscarlibros.services;

public interface IConvierteDatos {

    <T> T obtenerDatos(String json, Class<T> clase);
}
