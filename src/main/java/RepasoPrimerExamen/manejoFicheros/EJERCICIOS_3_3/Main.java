package RepasoPrimerExamen.manejoFicheros.EJERCICIOS_3_3;

import RepasoPrimerExamen.manejoFicheros.EJERCICIOS_3_2.ejercicio1.Pokemon;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import static RepasoPrimerExamen.manejoFicheros.EJERCICIOS_3_3.Pokemonn.*;

public class Main {
    static void main() throws IOException, ClassNotFoundException {

        /* 1. Haz serializable la clase que creaste en el ejercicio 3.2.10. Añádele un campo
    fecha. Implementa dos métodos estáticos: uno para escribir una lista de objetos
    en un fichero y otro para leerlos. Prueba a leer un fichero con datos incompatibles,
    ¿qué sucede? */

        Pokemonn pk1 = new Pokemonn("Garchomp","dragon",430,40.3,true,new GregorianCalendar(2026,3,15));
        Pokemonn pk2 = new Pokemonn("Infernape","fuego",400,20.3,true,new GregorianCalendar(2025,3,15));
        Pokemonn pk3 = new Pokemonn("Galvantula","electrico/bicho",550,0.3,false,new GregorianCalendar(2024,3,15));
        Pokemonn pk4 = new Pokemonn("Mono","normal",20,15.0,false,new GregorianCalendar(2023,3,15));

        List<Pokemonn> pokemones = new ArrayList<>();
        pokemones.add(pk1);
        pokemones.add(pk2);
        pokemones.add(pk3);

        Path fichero = Path.of("holi\\pokemonSerial.csv");

        escribir(fichero, pokemones);

        List<Pokemonn> listaLeida = leer(fichero);
        System.out.println("Pokemon leidos: " +listaLeida.size());
        for (Pokemonn p : listaLeida) {
            System.out.println(p);
        }
        System.out.println();

        //Salta una excepción, y cuál depende de qué tipo de “incompatible” sea el fichero.

        //PRUEBA 1. El fichero no lo creó un ObjectOutputStream (el más fácil de probar)
        //PRUEBA 2. La clase ha cambiado desde que se escribió el fichero



        /* 2. Añade un métodoo que escriba un único objeto al final del fichero existente sin
        corromper los datos anteriores. */

        escribirUnicoObjeto(fichero,pk4);

        List<Pokemonn> listaLeida2 = leer(fichero);
        System.out.println("Pokemon leidos: " +listaLeida2.size());
        for (Pokemonn p : listaLeida2) {
            System.out.println(p);
        }

        /* 3. Refactoriza la clase del ejercicio anterior para que implemente Externalizable
        en lugar de Serializable. ¿Qué ocurre con el campo fecha? */

        //(Explicado en pokemonn)

    }
}
