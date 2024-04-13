package groupId;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AgendaContactos {
    private final List<Contacto> contactos;

    public AgendaContactos() {
        this.contactos = new ArrayList<>();
    }

    public void agregarContacto(Contacto contacto) {
        this.contactos.add(contacto);
    }

    public List<Contacto> getContactos() {
        return new ArrayList<>(this.contactos);
    }

    public void guardarContactoEnArchivo() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("contactos.txt", true))) {
            for (Contacto contacto : this.contactos) {
                writer.write(contacto.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar el contacto en el archivo: " + e.getMessage());
        }
    }
}
