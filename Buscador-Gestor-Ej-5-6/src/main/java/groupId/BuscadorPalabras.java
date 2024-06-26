package groupId;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
}
