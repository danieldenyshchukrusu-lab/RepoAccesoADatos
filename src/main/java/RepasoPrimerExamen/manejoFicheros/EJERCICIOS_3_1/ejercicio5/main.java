package RepasoPrimerExamen.manejoFicheros.EJERCICIOS_3_1.ejercicio5;

import java.io.IOException;
import java.nio.file.Path;

public class main {
    static void main() throws IOException {

        //Crea un metodo eliminarDirectorio(Path directorio) que elimine el directorio indicado si está vacío o contiene solo ficheros
        //e informe de que no puede hacerlo si contiene subdirectorios.

        Ejercicio5 ej5 = new Ejercicio5();
        Path dir = Path.of("bango");

        ej5.eliminarDirectorio(dir);

        //TODAVIA NO HECHO AL 100%.


    }
}
