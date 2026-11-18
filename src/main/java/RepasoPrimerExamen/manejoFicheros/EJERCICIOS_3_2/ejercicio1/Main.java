package RepasoPrimerExamen.manejoFicheros.EJERCICIOS_3_2.ejercicio1;

import java.io.IOException;
import java.nio.file.Path;

public class Main {
    static void main() throws IOException {

        //1. Crea una clase ArchivoTXT cuyo constructor reciba un String con una ruta y lo
        //guarde como Path. Debe comprobar que la ruta hace referencia a un fichero (no
        //directorio) y que este existe.

        System.out.println("---EJ 1---");

        ArchivoTXT archivo1 = new ArchivoTXT("holi\\fichero1.txt");
        ArchivoTXT archivo2 = new ArchivoTXT("holi\\fichero2.txt");

        ArchivoTXT archivoErroneo = new ArchivoTXT("holi\\fichero4.txt");


        System.out.println();

        //2. Añade un metodo aVerso que lea el contenido del fichero y lo devuelva introduciendo un salto de línea después de cada punto.

        System.out.println("---EJ 2---");

        archivo1.aVerso();

        System.out.println();

        //3. Añade un metodo codifica que reciba la ruta de otro fichero (puede existir o no),
        //lea el contenido del fichero original, elimine todas las vocales y escriba el resultado en el fichero destino.
        //Usa Files.newBufferedReader y Files.newBufferedWriter.

        System.out.println("---EJ 3---");

        archivo1.codifica(archivo2.ruta);

        System.out.println();

        //4. Añade un metodo mover que reciba otra ruta y mueva el fichero a ella.
        //Si el directorio origen queda vacío, debe eliminarse también.

        System.out.println("---EJ 4---");

        Path dir = Path.of("bingo");
        /*archivo1.mover(dir); */

        //Si es que no tienes comentado "archivo1.mover(dir) mira lo de abajo (Porque lo has ejecutado).
        //DESPUES DE HACER ESTO TIENES QUE TENER CUIDADO, VE A LOS ARCHIVOS DEL SISTEMA Y HAZ CORTAR Y PEGAR DEL FICHERO1 A HOLI. PARA QUE EL PROGRAMA FUNCIONE CORRECTAMENTE.

        System.out.println();

        //5. Añade tres métodos:
        //contarCaracteres: número total de caracteres.
        //contarLetras: número total de letras.
        //contarPuntuacion: número total de signos de puntuación

        System.out.println("---EJ 5---");

        archivo1.contarCaracteres();
        archivo1.contarPuntuacion();
        archivo1.contarLetras();

        System.out.println();

        //6. Añade un metodo contarLineas que cuente las frases del fichero (hasta cada
        //punto) ayudándose de aVerso.

        System.out.println("--- EJ 6---");
        archivo1.contarLinea();

        System.out.println();

        //7. Añade un metodo contarPalabras que cuente todas las palabras del fichero

        System.out.println("---EJ 7---");
        archivo1.contarPalabras();

        System.out.println();

        //8. Implementa contarVocales que escriba el número de vocales de cada palabra
        //en un fichero numVocales.txt en el mismo directorio que el original. Cada número irá seguido de un espacio.
        //Mayúsculas y minúsculas se contarán juntas. Modifica el metodo para que tenga en cuenta tildes y diéresis.

        System.out.println("---EJ 8---");

        archivo1.contarVocales();

        System.out.println();

    }
}
