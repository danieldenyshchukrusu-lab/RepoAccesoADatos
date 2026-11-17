package RepasoPrimerExamen.manejoFicheros.EJERCICIOS_3_1.ejercicio1;

import java.io.IOException;
import java.nio.file.Path;

public class main {
    static void main() throws IOException {

        //Crea un metodo listarDirectorio(Path directorio) que muestre por pantalla el contenido del directorio indicado,
        //comprobando primero que la ruta corresponde a un directorio.

        Ejercicio1 ej1 = new Ejercicio1();

        Path directorio = Path.of("holi");

        ej1.listarDirectorio(directorio);

        //En este ejercicio se nos muestra como comprobar si un camino es un directorio, y luego listarlo.

    }
}
