package groupId;

// Clases necesarias para la creación de la interfaz gráfica.
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

// Clase principal que analiza archivos de texto.
public class Analizador {

    // Clase que cuenta el número de palabras en un archivo de texto.
    public static void contarPalabras(File archivo) {
        try {
            String contenido = new String(Files.readAllBytes(archivo.toPath()));
            String[] palabras = contenido.split("\\s+");
            System.out.println("Número de palabras: " + palabras.length);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    // 1 Ejemplo de ayuda de edición y el mejoramiento del texto.
    // Clase que muestra la frecuencia de cada palabra en un archivo de texto.
    public static void frecuenciaPalabras(File archivo) {
        try {
            String contenido = new String(Files.readAllBytes(archivo.toPath()));
            String[] palabras = contenido.split("\\s+");
            Map<String, Integer> frecuenciaPalabras = new HashMap<>();

            for (String palabra : palabras) {
                frecuenciaPalabras.put(palabra, frecuenciaPalabras.getOrDefault(palabra, 0) + 1);
            }

            for (Map.Entry<String, Integer> entrada : frecuenciaPalabras.entrySet()) {
                System.out.println("Palabra: " + entrada.getKey() + ", Frecuencia: " + entrada.getValue());
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        File archivo = new File("archivo.txt");
        contarPalabras(archivo);
        frecuenciaPalabras(archivo);
    }
}