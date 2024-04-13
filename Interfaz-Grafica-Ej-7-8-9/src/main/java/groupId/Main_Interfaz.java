package groupId;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main_Interfaz {
    public static void main(String[] args) {
        // Preguntar al usuario cuántas ventanas desea abrir
        int numVentanas = pedirNumeroVentanas();

        // Crear y mostrar las ventanas
        for (int i = 0; i < numVentanas; i++) {
            Ventanas ventana = new Ventanas();
            ventana.abrirDocumento("Contenido del documento " + (i + 1));
        }
    }

    private static int pedirNumeroVentanas() {
        int numVentanas;
        try {
            numVentanas = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántas ventanas deseas abrir?"));
        } catch (NumberFormatException e) {
            // En caso de que el usuario no introduzca un número válido
            System.out.println("Debes introducir un número válido. Abriendo una ventana por defecto.");
            numVentanas = 1;
        }
        return numVentanas;
    }
}
