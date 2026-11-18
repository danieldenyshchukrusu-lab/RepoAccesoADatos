package RepasoPrimerExamen.manejoFicheros.EJERCICIOS_3_2.ejercicio1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class ArchivoTXT {

    Path ruta;

    //1. Crea una clase ArchivoTXT cuyo constructor reciba un String con una ruta y lo
    //guarde como Path. Debe comprobar que la ruta hace referencia a un fichero (no
    //directorio) y que este existe.

    public ArchivoTXT(String rutaArchivo) {
        if (!Files.isDirectory(Path.of(rutaArchivo)) && Files.exists(Path.of(rutaArchivo))) {
            this.ruta = Path.of(rutaArchivo);
            System.out.println("Fichero creado correctamente");
        } else {
            System.out.println("no valido");
        }
    }

    //2. Añade un metodo aVerso que lea el contenido del fichero y lo devuelva introduciendo un salto de línea después de cada punto.

    public void aVerso() throws IOException {
        try (BufferedReader lector = Files.newBufferedReader(this.ruta)) {

            String linea;
            while ((linea = lector.readLine())!=null) {
                String [] partes = linea.split("\\.");
                    for (String e : partes) {
                        System.out.println(e);
                    }
            }
        }
    }

    //3. Añade un metodo codifica que reciba la ruta de otro fichero (puede existir o no),
    //lea el contenido del fichero original, elimine todas las vocales y escriba el resultado en el fichero destino.
    //Usa Files.newBufferedReader y Files.newBufferedWriter.

    public void codifica(Path destino) throws IOException {
        try (BufferedReader lector = Files.newBufferedReader(this.ruta);
             BufferedWriter escritor = Files.newBufferedWriter(destino)) { //No hace falta createFile. NewBufferedWriter crea el fichero si este no existe.

            int c;
            while ((c = lector.read()) != -1) {
                char caracter = (char) c;
                if (caracter == 'a' || caracter == 'e' || caracter == 'i' || caracter == 'o' || caracter == 'u') {
                    escritor.write("");
                } else {
                    escritor.write(caracter);
                }
            }
        }
        System.out.println("Completado correctamente");
    }

    //4. Añade un metodo mover que reciba otra ruta y mueva el fichero a ella.
    //Si el directorio origen queda vacío, debe eliminarse también.

    public void mover(Path destino) throws IOException {

        if (Files.isDirectory(destino)) {
            destino = destino.resolve(this.ruta.getFileName());   // bingo + fichero1.txt
        }

        //Utilizamos toAbsolutePath para evitarnos problemas con las rutas relativas, de que no hay nada antes.
        //Utilizamos el GetParent, porque en el caso de que queramos borrar el directorio del fichero origen, si no hacemos getParent no podemos apuntar a su carpeta, si no estariamos apuntando solo al fichero.

        Path carpetaOrigen = this.ruta.toAbsolutePath().getParent();
        Files.move(this.ruta, destino);

        this.ruta = destino;
        try {
            Files.delete(carpetaOrigen);
        } catch (DirectoryNotEmptyException e) {
            System.out.println("El directorio no se ha borrado porque esta vacio");
        }
    }

    //5. Añade tres métodos:
    //contarCaracteres: número total de caracteres.
    //contarLetras: número total de letras.
    //contarPuntuacion: número total de signos de puntuación.

    public void contarCaracteres() throws IOException {
        int contador = 0;
        try (BufferedReader lector = Files.newBufferedReader(this.ruta)) {
            int c;
            while ((c = lector.read()) != -1) {
                contador++;
            }
        }
        System.out.println("El fichero tiene: " +contador+ " caracteres");
    }

    public void contarLetras() throws IOException {
        int contador = 0;
        try (BufferedReader lector = Files.newBufferedReader(this.ruta)) {
            int c;
            while ((c = lector.read()) != -1) {
                char caracter = (char) c;
                if (Character.isLetter(caracter)) {
                    contador++;
                }
            }
        }
        System.out.println("El fichero tiene: " +contador+ " letras");
    }

    public void contarPuntuacion() throws IOException {
        int contador = 0;
        try (BufferedReader lector = Files.newBufferedReader(this.ruta)) {
            int c;
            while ((c = lector.read()) != -1) {
                char caracter = (char) c;
                if (caracter == '.' || caracter == ',' || caracter == ';' || caracter == ':') {
                    contador++;
                }
            }
        }
        System.out.println("El fichero tiene: " +contador+ " signos de puntuacion");
    }

    //6. Añade un metodo contarLineas que cuente las frases del fichero (hasta cada
    //punto) ayudándose de aVerso.

    public void contarLinea() throws IOException {
        int contador = 0;
        try (BufferedReader lector = Files.newBufferedReader(this.ruta)) {
            String linea;
            while ((linea = lector.readLine())!=null) {
                String [] partes = linea.split("\\.");
                    for (String e : partes) {
                        contador++;
                    }
            }
        }
        System.out.println("El fichero tiene: " +contador+ " lineas.");
    }

    //7. Añade un metodo contarPalabras que cuente todas las palabras del fichero

    public void contarPalabras() throws IOException {
        int contador = 0;
        try (BufferedReader lector = Files.newBufferedReader(this.ruta)) {
            String linea;
            while ((linea = lector.readLine())!=null) {
                linea = linea.trim();
                String [] partes = linea.split("\\s+");
                for (String e : partes) {
                    contador++;
                }
            }
        }
        System.out.println("El fichero tiene: " +contador+ " palabras");
    }

    //8. Implementa contarVocales que escriba el número de vocales de cada palabra
    //en un fichero numVocales.txt en el mismo directorio que el original. Cada número irá seguido de un espacio.
    //Mayúsculas y minúsculas se contarán juntas. Modifica el metodo para que tenga en cuenta tildes y diéresis.

    public void contarVocales() throws IOException {
        int contador = 0;

        Path dir = this.ruta.getParent(); //Sacamos el directorio de donde esta ahora mismo nuestro fichero.
        Path fich = dir.resolve("numVocales.txt");

        //Files.createFile(fich);
        //Sin el files.createFile seguiria funcionado porque bufferedWriter crea el fichero si no existe.

        try (BufferedReader lector = Files.newBufferedReader(this.ruta);
             BufferedWriter escritor = Files.newBufferedWriter(fich)) {
            int c;
            while ((c = lector.read()) != -1) {
                char caracter = (char) c;
                if (caracter == 'a' || caracter == 'e' || caracter == 'i' || caracter == 'o' || caracter == 'u' ||
                    caracter == 'A' || caracter == 'E' || caracter == 'I' || caracter == 'O' || caracter == 'U') {
                    contador++;
                }
            }
        }
        System.out.println("El fichero tiene: " +contador+ " vocales.");
    }

    //9. Implementa frecuenciaLetras que muestre la frecuencia de aparición de cada
    //letra (a-z, incluyendo mayúsculas) del fichero.

}
