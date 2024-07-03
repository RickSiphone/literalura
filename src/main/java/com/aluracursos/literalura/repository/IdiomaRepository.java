package com.aluracursos.literalura.repository;

import com.aluracursos.literalura.modelos.Idioma;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IdiomaRepository extends JpaRepository<Idioma,Long> {
    public Optional<Idioma> findByDescripcion(String idioma);
}
