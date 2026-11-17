package RepasoPrimerExamen.manejoFicheros.EJERCICIOS_3_1.ejercicio3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Ejercicio3 {

    //Crea un metodo generarArchivo(Path directorio) que cree en la ruta indicada un fichero .txt con tu nombre y apellido.
    //¿Qué ocurre si el directorio no existe?
    //Modifica el metodo para que lo cree si es necesario.

    void generarArchivo(Path directorio) throws IOException {
        if (!Files.isDirectory(directorio)) {
            Files.createDirectories(directorio); //Si no existe el directorio lo creamos.

            Path fich = Path.of(directorio+"\\Daniel_Denyshchuk.txt"); //Y para crear dentro del directorio el archivo, tenemos que adjuntar el camino del nuevo directorio al camino del fichero.
            Files.createFile(fich);
        } else {
            Path fich = Path.of("Daniel_Denyshchuk.txt");
            Files.createFile(fich);
        }
    }

}
