package RepasoPrimerExamen.manejoFicheros.EJERCICIOS_3_1.ejercicio4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Ejercicio4 {

    //Crea un metodo renombrarArchivo(Path fichero, String nuevoNombre) que
    //renombre el fichero indicado. Pruébalo con el fichero del ejercicio anterior.

    void renombrarArchivo(Path fichero, String nuevoNombre) throws IOException {
        Path dir = Path.of("bingo");
        Files.move(fichero, dir.resolve(nuevoNombre),
                StandardCopyOption.REPLACE_EXISTING);
    }

}
