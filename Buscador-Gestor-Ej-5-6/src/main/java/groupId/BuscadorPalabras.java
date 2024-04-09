package groupId;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class BuscadorPalabras {

    public static int contarOcurrenciasPalabra(String rutaArchivo, String palabra) {
        int contador = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;

            while ((linea = reader.readLine()) != null) {
                int indice = 0;

                while ((indice = linea.indexOf(palabra, indice)) != -1) {
                    contador++;
                    indice += palabra.length();
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        return contador;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresa el nombre del archivo:");
        String nombreArchivo = scanner.nextLine();
        String rutaArchivo = "Carpeta txt/" + nombreArchivo;

        System.out.println("Ingresa la palabra a buscar:");
        String palabra = scanner.nextLine();

        int contador = contarOcurrenciasPalabra(rutaArchivo, palabra);

        System.out.println("La palabra '" + palabra + "' aparece " + contador + " vez/veces en el archivo selecionado. '" + nombreArchivo + "'.");
    }
}