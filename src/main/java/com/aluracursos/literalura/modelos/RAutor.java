package com.aluracursos.literalura.modelos;

import com.fasterxml.jackson.annotation.JsonAlias;

public record RAutor(
        @JsonAlias("name") String nombre,
        @JsonAlias("birth_year") int nacimiento,
        @JsonAlias("death_year") int fallecimiento
) {
}
