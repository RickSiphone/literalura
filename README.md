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
* `agregarLibro`: Consulta a la API para saber si existe el libro buscado, obtiene el archivo JSON que contiene información general del libro

* `obtenerEquivalenteDeUnaMoneda`: Recibe la moneda origen y la moneda destino para poder obtener la razón de cambio en la moneda destino y regresa esa tasa de cambio en una variable de tipo double

* `convertirDinero`: Recibe la moneda origen, la moneda destino y la cantidad de dinero a cambiar. Al final regresa la conversión de esa cantidad de dinero en la moneda destino.

* `imprimirMonedasDisponibles`: Imprime todas las monedas disponibles para realizar las conversiones.

### Demostración
Antes de mostrar un ejemplo sobre como se usa el programa, es importante mencionar que el programa no diferencia entre mayúsculas y minúsculas, por lo que puedes escribir como tu quieras.

**Paso 1. Inicio del programa**: Al ejecutar el programa muestra un menú sencillo con el cual puedes interactuar mediante el teclado.
![image](https://github.com/RickSiphone/Challenge_ONE-ConversorDeMoneda/assets/156386884/5a58a431-57c7-42df-b2be-fc5deda4c1b0)
Aqui se puede apreciar que hay 3 opciones: 
 + Empezar la conversión de la moneda
 + Mostrar todas las divisas disponibles
 + Finalizar el programa

**Paso 2. Interactuar con el menú**: Para esta demostración primero mostraré las monedas disponibles escribiendo "mostrar divisas".
![image](https://github.com/RickSiphone/Challenge_ONE-ConversorDeMoneda/assets/156386884/743544f2-2f95-438e-90f3-280e2e01966d)
Después de que se imprimen todas las monedas, tambien se vuelve a imprimir el menú para que puedas hacer lo que tu quieras.

**Paso 3. Realizar la conversión de una moneda a otra**: Basta con escribir directamente la abreviación de la moneda que quieres convertir, después la cantidad y finalmente la moneda a la que quieres convertir el dinero.
Para esta demostración, ingrese de forma incorrecta la moneda que quería utilizar.
![image](https://github.com/RickSiphone/Challenge_ONE-ConversorDeMoneda/assets/156386884/d47ba666-a732-4feb-87a1-8be2648814a8)
Como marca un error se regresa al menú y ahora ingreso todos los datos de manera correcta.
![image](https://github.com/RickSiphone/Challenge_ONE-ConversorDeMoneda/assets/156386884/7a776d2b-966e-4035-88c9-ae0c1359c954)

**Paso 4. Finalizar el programa**: Se debe escribir la palabra "salir" y posteriormente el programa terminará.
![image](https://github.com/RickSiphone/Challenge_ONE-ConversorDeMoneda/assets/156386884/0df01c8e-3946-408f-992e-e30b7741c759)
**Paso 5. Historial de conversiones**: Después de que se cierra el programa, se creará un archivo txt que mostrará todos los movimientos relacionados con las conversiones hechas y en caso el programa se ejecute varías veces, el historial no se borrará, solo se añadirá la nueva información.
Para ver este archivo solo basta con abrirlo con cualquier editor de textos como el bloc de Notas de Windows.
![image](https://github.com/RickSiphone/Challenge_ONE-ConversorDeMoneda/assets/156386884/0bfc812e-4e71-4b54-b654-57bf02e3c3c4)

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
