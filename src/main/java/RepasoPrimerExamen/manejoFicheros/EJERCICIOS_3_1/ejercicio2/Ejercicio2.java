package RepasoPrimerExamen.manejoFicheros.EJERCICIOS_3_1.ejercicio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Ejercicio2 {

    //Crea un metodo existeFichero(Path directorio, String nombre)
    //que devuelva true si el fichero existe en el directorio indicado.

    boolean existeFichero(Path directorio, String nombre) throws IOException {
        boolean buleano = false;
        Path fich = directorio.resolve(nombre); //Basicamente nos da la ruta en donde esta el fichero.

        if (Files.exists(fich)) { //si ese fichero realemente existe, el buleano se vuelve true.
            buleano = true;
        }

        return buleano;
    }

}
