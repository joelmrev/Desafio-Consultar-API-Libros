package com.aluracursos.desafiobuscarlibros.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibroBuscado(
        @JsonAlias("title") String titulo,
        @JsonAlias("authors") List<DatosAutorLibro> autores,
        @JsonAlias("download_count") Integer descargas) {
}
