<div align="center">
    <h1>Challenge ONE - Java Back End - Literalura</h1>
</div>


 ## Descripción del proyecto
Este proyecto fue realizado con el objetivo de poner en práctica los conocimientos adquiridos durante los cursos sobre el framework Spring, consultas con Spring Data JPA y las consultas a las APIs. 
Esta aplicación permite guardar libros y trabajar con la información obtenida de distintas formas.


 ## Índice
 
 * [Funciones](#Funciones)

 * [Demostración](#demostracion)
 
 * [Como acceder al proyecto](#Como-acceder-al-proyecto)
 
 * [Tecnologías utilizadas](#Tecnologías-utilizadas)
 

## :hammer:[Características de la aplicación y demostración](#Características-de-la-aplicación-y-demostración)
### [Funciones](#Funciones)
* `agregarLibro`: Consulta a la API para saber si existe el libro buscado, obtiene el archivo JSON que contiene información del libro lo almacena en un objeto y almacena la información en las tablas correspondientes dentro de la base de datos.

* `buscarLibro`: Solicita el nombre de algún libro y lo busca dentro de la base de datos para poder mostrar la información disponible acerca de este.

* `consultarLibros`: Obtiene todos los libros almacenados en la base de datos y muestra la información de cada libro en la terminal.

* `consultarAutores`: Consulta a la base de datos para mostrar todos los autores disponibles y su información.

* `buscarLibroPorIdioma`: Consulta a la base de datos para mostrar todos los libros que fueron publicados en determinado idioma.

* `buscarLibrosPorAutor`: Consulta a la base de datos para mostrar todos los libros que fueron creados por un autor en específico.

* `buscarAutoresPorAnio`: Consulta a la base de datos para mostrar todos los autores que estaban vivos en un determinado año.

* `topLibrosDescargados`: Debes indicar la cantidad de libros para mostrar el top de los libros más descargados que estan disponibles en la base de datos.

* `estadisticas`: Se recopila información sobre todos los libros que estan escritos en un mismo idioma. Muestra la cantidad de libros por idioma y la cantidad total de descargas.

### [Demostración](#demostracion)
Antes de mostrar un ejemplo sobre como se usa el programa, es importante mencionar que el programa no diferencia entre mayúsculas y minúsculas, por lo que puedes escribir como tu quieras.

**Paso 1. Inicio del programa**: Al ejecutar el programa muestra un menú con 9 opciones diferentes y para poder interactuar con el menú se debe realizar mediante el teclado.
![image](https://github.com/RickSiphone/literalura/assets/156386884/8c68c3bd-b3c9-47ab-a823-b0059dbaeea6)

**Paso 2. Interactuar con el menú**: Para esta demostración solo accederé a unas cuantas funciones.
![image](https://github.com/RickSiphone/literalura/assets/156386884/92ceb4bf-b6b0-49ec-a28f-f2fd51148fbf)

**Paso 3. Agregar un libro**: Solo debes proporcionar el titulo del libro que quieres buscar y en caso de que el libro no lo encuentre, te mostrará las opciones disponibles por si quieres escoger alguno.
En esta primera imagen se muestra el caso donde no se encuentre el libro solicitado.
![image](https://github.com/RickSiphone/literalura/assets/156386884/1910eb9c-dd11-459b-b06f-d0c9e62a8e23)


En esta segunda imagen se muestra el caso donde si encuentra el libro.
![image](https://github.com/RickSiphone/literalura/assets/156386884/10501303-75b7-431d-963d-ed5ea3055e73)


**Paso 4. Consultar libros**: Solo se debe ingresar el número asociado a la opción y esperar a que arroje toda la información de cada libro almacenado en la base de datos.
![image](https://github.com/RickSiphone/literalura/assets/156386884/11909f41-ddbf-4523-9c3a-54b5ca0eafa7)


**Paso 5. Consultar libros por idioma**: Al acceder a esta opción te solicitara el idioma por el cual quieres filtrar los libros.
![image](https://github.com/RickSiphone/literalura/assets/156386884/5500fd61-b6b5-4e47-926e-140adc03839d)


**Paso 6. Salir del programa**: Basta con escribir el número 0 para acceder a la última función y así poder finalizarlo de forma correcta.
![image](https://github.com/RickSiphone/literalura/assets/156386884/322c437a-1d1b-49f9-a3b2-abae9f7d6171)


## 👓[Como acceder al proyecto](#Como-acceder-al-proyecto)

**Paso 1. Descargar el proyecto**

![Captura de pantalla 2024-06-10 164415](https://github.com/RickSiphone/Challenge_ONE-ConversorDeMoneda/assets/156386884/e312adcf-9072-4565-9db4-56c6fb49ef0b)

**Paso 2. Descomprimir el programa**

![image](https://github.com/RickSiphone/Challenge_ONE-ConversorDeMoneda/assets/156386884/30a554f5-e4fc-48de-add7-31c8dd69ce87)

**Paso 3. Abrir el proyecto con alguna IDE como Intellij y ejecutar el programa**: 

Tambien si prefieres solo descargar el JAR del programa, se encuentra en la siguiente ruta: "out/artifacts/Challenge_ONE_ConversorDeMoneda_jar"


## 🧑‍💻[Tecnologías utilizadas](#Tecnologías-utilizadas)

Para la realización de este proyecto se utilizó:
* Lenguaje de programación: Java
* JDK 20.0.1
* IDE IntelliJ IDEA Community Edition 2024.1.2
* Biblioteca externa para el manejo de solicitudes de API gson-2.11.0