package RepasoPrimerExamen.manejoFicheros.EJERCICIOS_3_3;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class Pokemonn implements Serializable {
    String nombre;
    String tipo;
    int pokedex;
    double especial;
    boolean habilidad;
    private GregorianCalendar fecha;

    public Pokemonn(String nombre, String tipo, int pokedex, double especial, boolean habilidad, GregorianCalendar fecha) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.pokedex = pokedex;
        this.especial = especial;
        this.habilidad = habilidad;
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return  nombre + ';' +
                tipo + ';' +
                pokedex + ';' +
                especial + ';' +
                habilidad + ';' +
                fecha;
    }

    static void escribir(Path fichero, List<Pokemonn> pokemons) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(
                Files.newOutputStream(fichero))) {
            for (Pokemonn p : pokemons) {
                out.writeObject(p);
            }
        }
    }

    static List<Pokemonn> leer(Path fichero) throws IOException, ClassNotFoundException {
        List<Pokemonn> jugadores = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(
                Files.newInputStream(fichero))) {
            while (true) {
                jugadores.add((Pokemonn) in.readObject());
            }
        } catch (EOFException e) {
            /// Fin de fichero: es la forma normal de terminar la lectura
        }
        return jugadores;
    }

    //ESTO LO HE BUSCADO

    static void escribirUnicoObjeto(Path fichero, Pokemonn pokemon) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(
                Files.newOutputStream(fichero, StandardOpenOption.APPEND)) {
            @Override
            protected void writeStreamHeader() {
                // no escribe la cabecera
            }
        }) {
            out.writeObject(pokemon);
        }
    }

    //ESTO PARA EL EXTERNALIZABLE

    /* @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(nombre);
        out.writeUTF(tipo);
        out.writeInt(puntos);
        out.writeDouble(peso);
        out.writeBoolean(evoluciona);
        out.writeObject(fechaCaptura); // la fecha hay que escribirla a mano
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        nombre = in.readUTF();
        tipo = in.readUTF();
        puntos = in.readInt();
        peso = in.readDouble();
        evoluciona = in.readBoolean();
        fechaCaptura = (GregorianCalendar) in.readObject();
    } */

}
