package RepasoPrimerExamen.manejoFicheros.EJERCICIOS_3_1.ejercicio5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Ejercicio5 {

    //Crea un metodo eliminarDirectorio(Path directorio) que elimine el directorio indicado si está vacío o contiene solo ficheros
    //e informe de que no puede hacerlo si contiene subdirectorios.

    void eliminarDirectorio(Path directorio) throws IOException {
        if (Files.isDirectory(directorio)) {
            try (var stream = Files.list(directorio)) {
                if (stream.equals(null)) {
                    Files.deleteIfExists(directorio);
                }
            }
        }
    }

}
