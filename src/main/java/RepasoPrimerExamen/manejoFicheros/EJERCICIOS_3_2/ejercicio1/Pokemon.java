package RepasoPrimerExamen.manejoFicheros.EJERCICIOS_3_2.ejercicio1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Pokemon {
    String nombre;
    String tipo;
    int pokedex;
    double especial;
    boolean habilidad;

    public Pokemon(String nombre, String tipo, int pokedex, double especial, boolean habilidad) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.pokedex = pokedex;
        this.especial = especial;
        this.habilidad = habilidad;
    }

    @Override
    public String toString() {
        return  nombre + ';' +
                tipo + ';' +
                pokedex + ';' +
                especial + ';' +
                habilidad;
    }

    public void escribirSinSobreescribir(File f) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(f,true))) { //Ponemos el true para poder sobreescribir
            escritor.write(this.toString());
            escritor.newLine();
        } catch (IOException ex) {
            System.out.println("Error al escribir: " + ex.getMessage());
        }
    }


}
