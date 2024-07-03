package com.aluracursos.literalura.modelos;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Idioma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String descripcion;

    @OneToMany(mappedBy = "idioma", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Libro> libros;

    public Idioma(){}

    public Idioma(String idioma) {
        this.descripcion = idioma;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        //Esto permite que la relación sea bidireccional
        libros.forEach(e-> e.setIdioma(this));
        this.libros = libros;
    }

    @Override
    public String toString() {
        return descripcion;
    }
}
