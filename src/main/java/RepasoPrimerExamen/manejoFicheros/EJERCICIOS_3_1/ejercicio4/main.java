package RepasoPrimerExamen.manejoFicheros.EJERCICIOS_3_1.ejercicio4;

import java.io.IOException;
import java.nio.file.Path;

public class main {
    static void main() throws IOException {

        //Crea un metodo renombrarArchivo(Path fichero, String nuevoNombre) que
        //renombre el fichero indicado. Pruébalo con el fichero del ejercicio anterior

        Ejercicio4 ej4 = new Ejercicio4();

        Path fich = Path.of("bingo\\Daniel_Denyshchuk.txt");

        ej4.renombrarArchivo(fich,"holimoli.txt");

    }
}
