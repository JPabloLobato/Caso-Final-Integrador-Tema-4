package groupId;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main_AgendaContactos {

    private static AgendaContactos agenda;

    public static void main(String[] args) {
        agenda = new AgendaContactos();

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("¿Deseas agregar un contacto? (s/n)");
                String respuesta = scanner.nextLine();
                if (!respuesta.equalsIgnoreCase("s")) {
                    break;
                }

                System.out.println("Ingresa el nombre del contacto:");
                String nombre = scanner.nextLine();
                System.out.println("Ingresa el email del contacto:");
                String email = scanner.nextLine();
                System.out.println("Ingresa el teléfono del contacto:");
                String telefono = scanner.nextLine();

                Contacto contacto = new Contacto(nombre, telefono, email);
                agenda.agregarContacto(contacto);
            }

            System.out.println("Contactos agregados:");
            for (Contacto contacto : agenda.getContactos()) {
                System.out.println(contacto);
                guardarContactoEnArchivo(contacto);
            }
        }
    }

    private static void guardarContactoEnArchivo(Contacto contacto) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("contactos.txt", true))) {
            writer.write(contacto.toString());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error al guardar el contacto en el archivo: " + e.getMessage());
        }
    }
}