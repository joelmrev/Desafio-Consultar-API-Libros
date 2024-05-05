package com.aluracursos.desafiobuscarlibros.principal;

import com.aluracursos.desafiobuscarlibros.model.DatosLibros;
import com.aluracursos.desafiobuscarlibros.services.ConsumoAPI;
import com.aluracursos.desafiobuscarlibros.services.ConvierteDatos;

public class Principal {
    private static final String URL_BASE = "https://gutendex.com/books/?search=Don+Quijote";
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();
    public void muestraElMenu() {

        var json = consumoApi.obtenerDatos(URL_BASE);
        System.out.println(json);
//        var datos = conversor.obtenerDatos(json, DatosLibros.class);
//        System.out.println(datos);

    }
}
