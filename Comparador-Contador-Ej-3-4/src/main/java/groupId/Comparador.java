package groupId;

// Clases necesarias para la creación de la interfaz gráfica.
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

// Clase principal que compara archivos de texto.
public class Comparador {
    
    public static void compararArchivo(File archivo1, File archivo2) {
        try {
            List<String> lineasArchivo1 = Files.readAllLines(archivo1.toPath());
            List<String> lineasArchivo2 = Files.readAllLines(archivo2.toPath());
            if (lineasArchivo1.equals(lineasArchivo2)) {
                System.out.println("Los archivos son iguales.");
            } else {
                System.out.println("Los archivos son diferentes.");
            }
        } catch (IOException e) {
            System.out.println("Error al leer los archivos: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        File archivo1 = new File("archivo1.txt");
        File archivo2 = new File("archivo2.txt");
        compararArchivo(archivo1, archivo2);
    }
    
}
