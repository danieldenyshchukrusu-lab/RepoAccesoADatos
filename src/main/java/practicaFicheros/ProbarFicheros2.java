package practicaFicheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ProbarFicheros2 {
    static void main() throws IOException {
        /*1. Crea una clase ArchivoTXT cuyo constructor reciba un String con una ruta y lo
        guarde como Path. Debe comprobar que la ruta hace referencia a un fichero (no
        directorio) y que este existe. */

        /*ArchivoTXT archivo1 = new ArchivoTXT("C:\\Users\\AlumnoD\\Desktop\\prueba.txt.txt");

        ArchivoTXT archivo2 = new ArchivoTXT("C:\\Users\\AlumnoD\\Desktop\\ubu.txt");*/

        ArchivoTXT archivo3 = new ArchivoTXT("C:\\Users\\AlumnoD\\Desktop\\CarpetaMover\\ubuntu.txt");

        ArchivoTXT archivoPruebaEJ6 = new ArchivoTXT("C:\\Users\\Zombo\\Desktop\\ficheroPruebaEJ6.txt");

       /* 2. Añade un metodo aVerso que lea el contenido del fichero y lo devuelva
       introduciendo un salto de línea después de cada punto. */

        /*archivo1.aVerso();*/

        /*3. Añade un metodo codifica que reciba la ruta de otro fichero (puede existir o no),
        lea el contenido del fichero original, elimine todas las vocales y escriba el
        resultado en el fichero destino. Usa Files.newBufferedReader y Files.newBufferedWriter.*/

        /*String ruta = "C:\\Users\\AlumnoD\\Desktop\\ubu.txt";
        archivo1.codifica(ruta);*/

        /*4. Añade un metodo mover que reciba otra ruta y mueva el fichero a ella. Si el
        directorio origen queda vacío, debe eliminarse también.*/

        /* String ruta2 = "C:\\Users\\AlumnoD\\Desktop\\CarpetaMover\\ubuntu.txt";
        archivo3.mover(Path.of("C:\\Users\\AlumnoD\\Desktop\\Destino\\")); */


        /*5. Añade tres métodos:
        contarCaracteres: número total de caracteres.
        contarLetras: número total de letras.
        contarPuntuacion: número total de signos de puntuación.*/



        /*6. Añade un metodo contarLineas que cuente las frases del fichero (hasta cada
        punto) ayudándose de aVerso.*/

        System.out.println("");
        System.out.println("Ejercicio 6 (Contar frases por '.' en el fichero: ");
        archivoPruebaEJ6.contarLineas();

        /*7. Añade un metodo contarPalabras que cuente todas las palabras del fichero.*/

        System.out.println("");
        System.out.println("Ejercicio 7 contador de palabras");
        archivoPruebaEJ6.contadorDePalabras();

        /*8. Implementa contarVocales que escriba el número de vocales de cada palabra
        en un fichero numVocales.txt en el mismo directorio que el original. Cada número
        irá seguido de un espacio. Mayúsculas y minúsculas se contarán juntas. Modifica
        el metodo para que tenga en cuenta tildes y diéresis.*/

        System.out.println("");
        System.out.println("Ejercicio 8 Escribir el numero de vocales de un fichero a otro con espaciados ");
        archivoPruebaEJ6.contadorVocales("C:\\Users\\Zombo\\Desktop\\ficheroVocales.txt");

        /*9. Implementa frecuenciaLetras que muestre la frecuencia de aparición de cada
        letra (a-z, incluyendo mayúsculas) del fichero.*/

        //Preguntar a Sergio sobre como hacer este ejercicio.

        /*10. Crea una clase que represente algo de tu elección (personaje, producto, etc.) con
        al menos: un String para el nombre, otro String, un entero, un double y un
        boolean. Crea varios objetos y escríbelos en un fichero .csv separado por punto y coma.
        Comprueba que se carga correctamente en una hoja de cálculo.*/

        Pokemon pokemon1 = new Pokemon("Garchomp","tiburon",120,80,true);
        Pokemon pokemon2 = new Pokemon("Lucario","perro",110,75,true);
        Pokemon pokemon3 = new Pokemon("Deoxys","alien",150,60,false);
        Pokemon pokemon4 = new Pokemon("Magearna","maquina",120,90,false);

        List<Pokemon> pokemons = new ArrayList<>();
        pokemons.add(pokemon1);
        pokemons.add(pokemon2);
        pokemons.add(pokemon3);
        pokemons.add(pokemon4);

        try (BufferedWriter escritor = new BufferedWriter(new FileWriter("C:\\Users\\Zombo\\Desktop\\Pokemon.csv"))) {
            for (Pokemon e : pokemons) {
                escritor.write(e.toString());
                escritor.newLine();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        /*11. Añade un metodo que permita escribir un nuevo objeto de esa clase al final del
        fichero CSV.*/

        Pokemon pokemon5 = new Pokemon("Absol","lobo",180,60,true);
        pokemon5.escribirSinSobreescribir("C:\\Users\\Zombo\\Desktop\\Pokemon.csv");

        /*12. Lee los objetos del fichero CSV y muéstralos por pantalla, con un texto delante
        de cada campo. Sobrescribe toString para ayudarte. ¿Qué sucede si intentas
        escribir un nuevo elemento abriendo el fichero en modo lectura?*/

        String linea;

        System.out.println("");
        System.out.println("Leer fichero .CSV de pokemons");
        try (BufferedReader lector = Files.newBufferedReader(Path.of("C:\\Users\\Zombo\\Desktop\\Pokemon.csv"))) {
            while ((linea = lector.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
