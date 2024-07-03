package com.aluracursos.literalura.modelos;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private int nacimiento;
    private int fallecimiento;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Libro> librosCreados;

    public Autor() {}

    public Autor(RAutor autor) {
        this.nombre = autor.nombre();
        this.nacimiento = autor.nacimiento();
        this.fallecimiento = autor.fallecimiento();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Libro> getLibrosCreados() {
        return librosCreados;
    }

    public void setLibrosCreados(List<Libro> librosCreados) {
        //Esto permite la relación bidireccional
        librosCreados.forEach(e -> e.setAutor(this));
        this.librosCreados = librosCreados;
    }

    public int getNacimiento() {
        return nacimiento;
    }

    public int getFallecimiento() {
        return fallecimiento;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre +
                " | Tiempo de vida: " + nacimiento + "-" + fallecimiento;
    }
}
