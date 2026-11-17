package RepasoPrimerExamen.manejoFicheros.EJERCICIOS_3_2.ejercicio1;

import java.nio.file.Files;
import java.nio.file.Path;

public class ArchivoTXT {

    //1. Crea una clase ArchivoTXT cuyo constructor reciba un String con una ruta y lo
    //guarde como Path. Debe comprobar que la ruta hace referencia a un fichero (no
    //directorio) y que este existe.

    public ArchivoTXT(String ruta) {
        if (!Files.isDirectory(Path.of(ruta)) && Files.exists(Path.of(ruta))) {
            Path fich = Path.of(ruta);
            System.out.println("Fichero creado correctamente");
        } else {
            System.out.println("no valido");
        }
    }
}
