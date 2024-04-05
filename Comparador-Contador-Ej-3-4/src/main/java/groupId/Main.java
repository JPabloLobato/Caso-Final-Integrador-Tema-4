package groupId;

import java.io.File;

// Clase principal que ejecuta los métodos de las clases Analizador y Comparador.
public class Main {
    public static void main(String[] args) {
        File archivo = new File("archivo.txt");

        Analizador.contarPalabras(archivo);
        Analizador.frecuenciaPalabras(archivo);

        // Se necesitan dos archivos para poder compararlos.
        File archivo2 = new File("archivo2.txt");
        Comparador.compararArchivo(archivo, archivo2);
    }
}