package com.aluracursos.desafiobuscarlibros.principal;

import com.aluracursos.desafiobuscarlibros.model.Datos;
import com.aluracursos.desafiobuscarlibros.model.DatosLibro;
import com.aluracursos.desafiobuscarlibros.services.ConsumoAPI;
import com.aluracursos.desafiobuscarlibros.services.ConvierteDatos;

import java.awt.desktop.OpenFilesEvent;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private static final String URL_BASE = "https://gutendex.com/books/";
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();
    public void muestraElMenu() {

        var json = consumoApi.obtenerDatos(URL_BASE);
        System.out.println(json);
        var datos = conversor.obtenerDatos(json, Datos.class);
        System.out.println(datos);

        // TOP 10 LIBROS MÁS DESCARGADOS
        System.out.println("TOP 10 LIBROS MÁS DESCARGADOS");
        datos.resultados().stream()
                .sorted(Comparator.comparing(DatosLibro::descargas).reversed())
                .limit(10)
                .map(l ->l.titulo().toUpperCase())
                .forEach(System.out::println);


        //BUSQUEDA DE LIBROS POR NOMBRE
        System.out.println("Ingresa el nombre del Libro que deseas buscar");
        var tituloLibro = teclado.nextLine().toLowerCase();
        json = consumoApi.obtenerDatos(URL_BASE + "?search=" + tituloLibro.replace(" ","+"));
        var datosBusqueda = conversor.obtenerDatos(json, Datos.class);
        Optional<DatosLibro> libroBuscado = datosBusqueda.resultados().stream()
                .filter(l -> l.titulo().toUpperCase().contains(tituloLibro.toUpperCase()))
                .findFirst();
        if (libroBuscado.isPresent()) {
            System.out.println("Libro Encontrado!");
            System.out.println("Los Datos del Libro son: " + libroBuscado.get());
        } else {
            System.out.println("Libro NO Encontrado");
        }

        //GENERANDO ESTADISTICAS
        DoubleSummaryStatistics est = datos.resultados().stream()
                .filter(d -> d.descargas() > 0.0)
                .collect(Collectors.summarizingDouble(DatosLibro::descargas));
        System.out.println("Descargas promedio: " + est.getAverage());
        System.out.println("Descargas Máxima: " + est.getMax());
        System.out.println("Descargas Mínima: " + est.getMin());
        System.out.println("Cantidad de registros evaluados para generar estadisticas: " + est.getCount());

    }

}
