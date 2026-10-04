package practicaFicheros;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Pokemon {
    String nombre;
    String tipo;
    int ataqueBase;
    double defensaBase;
    boolean habilidad;

    public Pokemon(String nombre, String tipo, int ataqueBase, double defensaBase, boolean habilidad) {
        this.nombre=nombre;
        this.tipo=tipo;
        this.ataqueBase=ataqueBase;
        this.defensaBase=defensaBase;
        this.habilidad=habilidad;
    }

    @Override
    public String toString() {
        return "nombre='" + nombre + '\'' +
                "; tipo='" + tipo + '\'' +
                "; ataqueBase=" + ataqueBase +
                "; defensaBase=" + defensaBase +
                "; habilidad=" + habilidad;
    }

    public void escribirSinSobreescribir(String rutaFichero) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(rutaFichero, true))) {
            escritor.write(this.toString());
            escritor.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
