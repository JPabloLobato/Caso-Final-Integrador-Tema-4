package groupId;

import java.io.File;
import java.util.Scanner;

public class Main_Comparador_Analizador {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresa el nombre del primer archivo:");
        String nombreArchivo1 = scanner.nextLine();
        File archivo1 = new File("Carpeta txt/" + nombreArchivo1);

        System.out.println("Ingresa el nombre del segundo archivo:");
        String nombreArchivo2 = scanner.nextLine();
        File archivo2 = new File("Carpeta txt/" + nombreArchivo2);

        Analizador.contarPalabras(archivo1);
        Analizador.frecuenciaPalabras(archivo1);

        Comparador.compararArchivo(archivo1, archivo2);
    }
}
