package com.aluracursos.literalura.repository;

import com.aluracursos.literalura.modelos.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor,Long> {
    public Optional<Autor> findByNombreContainingIgnoreCase(String nombre);
    @Query("SELECT a FROM Autor a WHERE a.nacimiento <= :anio AND a.fallecimiento >= :anio")
    public List<Autor> encontrarAutoresPorAnio(int anio);
}
