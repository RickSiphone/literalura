package com.aluracursos.literalura.modelos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record RLibro(
        @JsonAlias("id") int id,
        @JsonAlias("title") String titulo,
        @JsonAlias("download_count") long descargas
) {
}
