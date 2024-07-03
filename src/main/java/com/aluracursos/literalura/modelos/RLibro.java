package com.aluracursos.literalura.modelos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record RLibro(
        @JsonAlias("id") int id,
        @JsonAlias("title") String titulo,
        @JsonAlias("download_count") long descargas,
        @JsonAlias("authors") List<RAutor> autor,
        @JsonAlias("languages") List<String> idiomas
) {
}
