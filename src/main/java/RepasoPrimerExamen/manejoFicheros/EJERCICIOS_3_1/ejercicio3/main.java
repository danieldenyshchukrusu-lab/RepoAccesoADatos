package RepasoPrimerExamen.manejoFicheros.EJERCICIOS_3_1.ejercicio3;

import java.io.IOException;
import java.nio.file.Path;

public class main {
    static void main() throws IOException {

        //Crea un metodo generarArchivo(Path directorio) que cree en la ruta indicada un fichero .txt con tu nombre y apellido.
        //¿Qué ocurre si el directorio no existe?
        //Modifica el metodo para que lo cree si es necesario.

        Ejercicio3 ej3 = new Ejercicio3();

        Path directorio = Path.of("bingo");

        ej3.generarArchivo(directorio);

    }
}
