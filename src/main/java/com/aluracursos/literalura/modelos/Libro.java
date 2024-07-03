package com.aluracursos.literalura.modelos;

import com.aluracursos.literalura.repository.AutorRepository;
import com.aluracursos.literalura.repository.IdiomaRepository;
import jakarta.persistence.*;
import java.util.Optional;

@Entity
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String titulo;

    private long descargas;

    @ManyToOne
    private Autor autor;

    @ManyToOne
    private Idioma idioma;

    public Libro() {}

    public Libro(RLibro libro) {
        this.titulo = libro.titulo();
        this.descargas = libro.descargas();
    }

    public void agregarAutor(RLibro libro, AutorRepository repositorio) {
        for (RAutor autor : libro.autor()) {
            Optional<Autor> autorBuscado = repositorio.findByNombreContainingIgnoreCase(autor.nombre());
            if (autorBuscado.isPresent()) {
                Autor autorLibro = autorBuscado.get();
                this.autor = autorLibro;
            }  else {
                Autor nuevoAutor = new Autor(autor);
                repositorio.save(nuevoAutor);
                this.autor = repositorio.findByNombreContainingIgnoreCase(nuevoAutor.getNombre()).get();
            }
        }
    }

    public void agregarIdioma(RLibro libro, IdiomaRepository repositorio) {
        for (String idioma : libro.idiomas()) {
            Optional<Idioma> idiomaBuscado = repositorio.findByDescripcion(idioma);
            if (idiomaBuscado.isPresent()) {
                Idioma idiomaEncontrado = idiomaBuscado.get();
                this.idioma = idiomaEncontrado;
            } else {
                Idioma nuevoIdioma = new Idioma(idioma);
                repositorio.save(nuevoIdioma);
                this.idioma = repositorio.findByDescripcion(nuevoIdioma.getDescripcion()).get();
            }
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public long getDescargas() {
        return descargas;
    }

    @Override
    public String toString() {
        return "-----------------------------------------------" +
                "\nTitulo: " + titulo +
                "\nAutor: " + autor +
                "\nIdioma disponible: " + idioma +
                "\nDescargas realizadas: " + descargas;
    }
}
