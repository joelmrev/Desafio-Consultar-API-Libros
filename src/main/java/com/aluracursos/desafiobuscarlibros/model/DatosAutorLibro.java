package com.aluracursos.desafiobuscarlibros.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosAutorLibro(
        @JsonAlias("name") String autores,
        @JsonAlias("birth_year") Integer fechaNacimiento
) {
}
