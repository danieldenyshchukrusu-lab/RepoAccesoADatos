package RepasoPrimerExamen.manejoFicheros.EJERCICIOS_3_1.ejercicio1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Ejercicio1 {

        //Crea un metodo listarDirectorio(Path directorio) que muestre por pantalla el contenido del directorio indicado,
        //comprobando primero que la ruta corresponde a un directorio.

        void listarDirectorio(Path directorio) throws IOException {
            if (Files.isDirectory(directorio)) {
                try (var stream = Files.list(directorio)) {
                    stream.forEach(System.out::println);
                }
            }
        }

}
