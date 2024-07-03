package com.aluracursos.literalura.principal;

import com.aluracursos.literalura.modelos.*;
import com.aluracursos.literalura.repository.AutorRepository;
import com.aluracursos.literalura.repository.IdiomaRepository;
import com.aluracursos.literalura.repository.LibroRepository;
import com.aluracursos.literalura.servicio.ConsultaApi;
import com.aluracursos.literalura.servicio.ConvertirDatos;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {
    private String url_base = "https://gutendex.com/";
    private Scanner input = new Scanner(System.in);
    private ConsultaApi consulta = new ConsultaApi();
    private ConvertirDatos convertirDatos = new ConvertirDatos();
    private ConvertirDatos convertirInfoLibros = new ConvertirDatos();
    private LibroRepository repositorioLibro;
    private AutorRepository repositorioAutor;
    private IdiomaRepository repositorioIdioma;

    public Principal(LibroRepository repositorio, AutorRepository repositorioAutor, IdiomaRepository repositorioIdioma) {
        this.repositorioLibro = repositorio;
        this.repositorioAutor = repositorioAutor;
        this.repositorioIdioma = repositorioIdioma;
    }

    public void menu() {
        int opcion = -1;
        while(opcion != 0) {
            System.out.println(" ****************** MENÚ ******************");
            System.out.println("""
                    1. Añadir libro
                    2. Buscar libro
                    3. Consultar libros
                    4. Consultar autores
                    5. Consultar libros por idioma
                    6. Consultar libros por autor
                    7. Consultar autores vivos en un determinado año
                    8. Top libros más descargados
                    9. Información y estadísticas sobre los libros disponibles en diferentes idiomas
                    0. Salir""");
            System.out.print("Escribe el número asociado a la opción que deseas acceder: ");
            opcion = Integer.parseInt(input.nextLine());
            switch (opcion) {
                case 1:
                    Libro libroEncontrado = agregarLibro();
                    if (libroEncontrado != null) {
                        System.out.println("Esta es la información del libro buscado");
                        System.out.println(libroEncontrado);
                    } else {
                        System.out.println("No se encontró el libro");
                    }
                    break;
                case 2:
                    System.out.print("Escribe el nombre del libro que deseas buscar: ");
                    var titulo = input.nextLine();
                    var libroBuscado = buscarLibro(titulo);
                    if (libroBuscado != null) {
                        System.out.println("Estos son los datos disponibles del libro");
                        System.out.println(libroBuscado);
                    } else {
                        System.out.println("No se ha encontrado el libro");
                    }
                    break;
                case 3:
                    consultarLibros();
                    break;
                case 4:
                    consultarAutores();
                    break;
                case 5:
                    buscarLibroPorIdioma();
                    break;
                case 6:
                    buscarLibrosPorAutor();
                    break;
                case 7:
                    buscarAutoresPorAnio();
                    break;
                case 8:
                    topLibrosDescargados();
                    break;
                case 9:
                    estadisticas();
                    break;
                case 0:
                    opcion = 0;
                    break;
                default:
                    System.out.println("ERROR: Ingrese un número asociado a alguna opción");
            }
        }
    }

    private Libro agregarLibro() {
        System.out.print("Escribe el título: ");
        var titulo = input.nextLine();
        Libro revisarLibro = buscarLibro(titulo);
        if (revisarLibro == null) {
            String url = consulta.formatoCorrectoDeURL(url_base,"books/?search=",titulo);
            String json = consulta.realizarConsulta(url);
            RBusquedaLibros busquedas = convertirDatos.transformarDatos(json, RBusquedaLibros.class);
            for (RLibro libro : busquedas.libros()) {
                if (libro.titulo().toLowerCase().compareTo(titulo.toLowerCase()) == 0){
                    Libro libroEncontrado = new Libro(libro);
                    repositorioLibro.save(libroEncontrado);
                    url = consulta.formatoCorrectoDeURL(url_base,"books/", Integer.toString(libro.id()) + "/");
                    json = consulta.realizarConsulta(url);
                    RInfoLibro info = convertirInfoLibros.transformarDatos(json,RInfoLibro.class);
                    libroEncontrado.agregarAutor(info,repositorioAutor);
                    libroEncontrado.agregarIdioma(info,repositorioIdioma);
                    repositorioLibro.save(libroEncontrado);
                    return libroEncontrado;
                }
            }
            System.out.println("\nNo se encontró el título indicado pero puedes ver titulos similares. Para escogerlo escribe el número o si" +
                    " quieres detener la busqueda escribe el número -1\n");
            for (int i = 0; i < busquedas.libros().size(); i++) {
                System.out.println(i + ". " + busquedas.libros().get(i).titulo());
            }
            System.out.print("Escribe el número asociado al título que te interesa: ");
            var indice = Integer.parseInt(input.nextLine());
            if (indice != -1) {
                Libro libroEncontrado = new Libro(busquedas.libros().get(indice));
                repositorioLibro.save(libroEncontrado);
                url = consulta.formatoCorrectoDeURL(url_base,"books/", Integer.toString(busquedas.libros().get(indice).id()));
                json = consulta.realizarConsulta(url);
                RInfoLibro info = convertirDatos.transformarDatos(json, RInfoLibro.class);
                libroEncontrado.agregarAutor(info,repositorioAutor);
                libroEncontrado.agregarIdioma(info,repositorioIdioma);
                return libroEncontrado;
            } else{
                return null;
            }
        }
        System.out.println("El libro ya fue guardado anteriormente");
        return null;
    }

    private Libro buscarLibro(String nombre) {
        Optional<Libro> libroBuscado = repositorioLibro.findByTituloContainingIgnoreCase(nombre);
        if (libroBuscado.isPresent()) {
            return libroBuscado.get();
        }
        return null;
    }

    private void consultarLibros() {
        List<Libro> libros = repositorioLibro.findAll();
        System.out.println("Estos son todos los libros disponibles en la base de datos");
        libros.forEach(System.out::println);
    }

    private void consultarAutores() {
        List<Autor> autores = repositorioAutor.findAll();
        System.out.println("Estos son los autores de los libros  almacenados actualmente:");
        autores.forEach(System.out::println);
    }

    private void buscarLibroPorIdioma() {
        System.out.println("Estos son todos los idiomas disponibles: ");
        List<Idioma> idiomas = repositorioIdioma.findAll();
        System.out.println(idiomas);
        System.out.print("\nEscribe el idioma que deseas buscar: ");
        var idioma = input.nextLine();
        long indice = -1;
        List<Libro> librosFiltrados = null;
        for (Idioma idioma1 : idiomas) {
            if (idioma1.getDescripcion().toLowerCase().compareTo(idioma.toLowerCase()) == 0) {
                librosFiltrados = repositorioLibro.findByIdioma(idioma1);
                break;
            }
        }
        if (librosFiltrados == null) {
            System.out.println("ERROR: No se ha encontrado algún libro en ese idioma");
        } else {
            System.out.println("Hay " + librosFiltrados.size() + " libros disponibles en ese idioma");
            librosFiltrados.forEach(System.out::println);
        }
    }

    private void buscarLibrosPorAutor() {
        System.out.print("Escribe el nombre del escritor: ");
        var nombre = input.nextLine();
        Optional<Autor> autor = repositorioAutor.findByNombreContainingIgnoreCase(nombre);
        if (autor.isPresent()) {
            Autor autorEncontrado = autor.get();
            List<Libro> libros = repositorioLibro.findByAutor(autorEncontrado);
            System.out.println("Estos son los libros escritos por " + autorEncontrado.getNombre());
            libros.forEach(System.out::println);
        } else {
            System.out.println("No se encontró al autor en la base de datos");
        }
    }

    private void buscarAutoresPorAnio() {
        System.out.print("Escribe el año: ");
        var fecha = Integer.parseInt(input.nextLine());
        List<Autor> autoresVivos = repositorioAutor.encontrarAutoresPorAnio(fecha);
        autoresVivos.forEach(System.out::println);
    }

    private void topLibrosDescargados() {
        System.out.print("Escribe cuantos libros quieres ver: ");
        var top = Integer.parseInt(input.nextLine());
        List<Libro> libros = repositorioLibro.buscarTopLibros(top);
        libros.forEach(System.out::println);
    }

    private void estadisticas() {
        List<Idioma> idiomas = repositorioIdioma.findAll();
        List<Long> descargas = new ArrayList<>();
        long total = 0;
        for (Idioma idioma : idiomas) {
            List<Libro> libros = repositorioLibro.findByIdioma(idioma);
            for (Libro libro : libros) {
                total += libro.getDescargas();
            }
            descargas.add(total);
        }
        System.out.println("A continuación se presentan los idiomas disponibles y la cantidad de descargas total que hay por cada uno");
        for (int i = 0; i < idiomas.size(); i++) {
            System.out.println(i + ". [" + idiomas.get(i).getDescripcion() + "] Descargas: " + descargas.get(i));
        }
    }
}
