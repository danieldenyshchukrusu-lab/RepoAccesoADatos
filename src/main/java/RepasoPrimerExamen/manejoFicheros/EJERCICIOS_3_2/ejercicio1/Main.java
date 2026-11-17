package RepasoPrimerExamen.manejoFicheros.EJERCICIOS_3_2.ejercicio1;

public class Main {
    static void main() {

        //1. Crea una clase ArchivoTXT cuyo constructor reciba un String con una ruta y lo
        //guarde como Path. Debe comprobar que la ruta hace referencia a un fichero (no
        //directorio) y que este existe.

        ArchivoTXT archivo1 = new ArchivoTXT("holi\\fichero1.txt");
        ArchivoTXT archivoErroneo = new ArchivoTXT("holi\\fichero4.txt");

    }
}
