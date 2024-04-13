package groupId;

import java.util.Scanner;

public class Main_BuscadorPalabras {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresa el nombre del archivo:");
        String nombreArchivo = scanner.nextLine();
        String rutaArchivo = "Carpeta txt/" + nombreArchivo;

        System.out.println("Ingresa la palabra a buscar:");
        String palabra = scanner.nextLine();

        int contador = BuscadorPalabras.contarOcurrenciasPalabra(rutaArchivo, palabra); // Llamada directa al método estático

        System.out.println("La palabra '" + palabra + "' aparece " + contador + " vez/veces en el archivo seleccionado '" + nombreArchivo + "'.");
    }
}
