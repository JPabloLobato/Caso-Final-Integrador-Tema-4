package groupId;

public class Buscador_de_Palabras {
    public int buscarPalabra(String palabra, String texto) {
        String[] palabras = texto.split("\\s+");
        int contador = 0;
        for (String p : palabras) {
            if (p.equalsIgnoreCase(palabra)) {
                contador++;
            }
        }
        return contador;
    }
}
