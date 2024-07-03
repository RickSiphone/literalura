package com.aluracursos.literalura.modelos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record RInfoLibro(
        @JsonAlias("authors") List<RAutor> autor,
        @JsonAlias("languages") List<String> idiomas
) {
}
