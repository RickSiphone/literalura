package com.aluracursos.literalura.repository;

import com.aluracursos.literalura.modelos.Autor;
import com.aluracursos.literalura.modelos.Idioma;
import com.aluracursos.literalura.modelos.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LibroRepository extends JpaRepository<Libro,Long> {
    public Optional<Libro> findByTituloContainingIgnoreCase(String nombreLibro);
    public List<Libro> findByIdioma(Idioma idioma);
    public List<Libro> findByAutor(Autor autor);
    @Query("SELECT l FROM Libro l ORDER BY l.descargas DESC LIMIT :top")
    public List<Libro> buscarTopLibros(int top);
}
