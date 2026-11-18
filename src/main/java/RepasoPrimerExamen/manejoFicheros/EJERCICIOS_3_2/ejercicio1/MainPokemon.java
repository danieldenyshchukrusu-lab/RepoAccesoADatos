package RepasoPrimerExamen.manejoFicheros.EJERCICIOS_3_2.ejercicio1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MainPokemon {
    static void main() throws IOException {
        //10. Crea una clase que represente algo de tu elección (personaje, producto, etc.) con
        //al menos: un String para el nombre, otro String, un entero, un double y un
        //boolean.

        //Crea varios objetos y escríbelos en un fichero .csv separado por punto y coma.
        //Comprueba que se carga correctamente en una hoja de cálculo.

        Pokemon pk1 = new Pokemon("Garchomp","dragon",430,40.3,true);
        Pokemon pk2 = new Pokemon("Infernape","fuego",400,20.3,true);
        Pokemon pk3 = new Pokemon("Galvantula","electrico/bicho",550,0.3,false);

        List<Pokemon> pokemons = new ArrayList<>();
        pokemons.add(pk1);
        pokemons.add(pk2);
        pokemons.add(pk3);

        File f = new File("holi\\pokemon.csv");

        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(f))) {
            for (Pokemon e : pokemons) {
                escritor.write(e.toString());
                escritor.newLine();
            }
        } catch (IOException ex) {
            System.out.println("Error al escribir: " + ex.getMessage());
        }

        //11. Añade un metodo que permita escribir un nuevo objeto de esa clase al final del
        //fichero CSV

        /* Pokemon pk4 = new Pokemon("Caterpie","bicho",1,30.0,false);

        pk4.escribirSinSobreescribir(f); */

        //12. Lee los objetos del fichero CSV y muéstralos por pantalla, con un texto delante
        //de cada campo. Sobrescribe toString para ayudarte. ¿Qué sucede si intentas
        //escribir un nuevo elemento abriendo el fichero en modo lectura?

        //Salta una excepción y no se escribe nada. El sistema operativo abre el fichero solo para leer y rechaza cualquier escritura.

        try (BufferedReader lector = Files.newBufferedReader(Path.of(f.getAbsolutePath()))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
