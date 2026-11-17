package RepasoPrimerExamen.manejoFicheros.EJERCICIOS_3_1.ejercicio2;

import java.io.IOException;
import java.nio.file.Path;

public class main {
    static void main() throws IOException {

        //Crea un metodo existeFichero(Path directorio, String nombre)
        //que devuelva true si el fichero existe en el directorio indicado.

        Ejercicio2 ej2 = new Ejercicio2();

        Path directorio = Path.of("holi");

        System.out.println("El fichero existe?: " +ej2.existeFichero(directorio,"fichero2.txt"));

    }
}
