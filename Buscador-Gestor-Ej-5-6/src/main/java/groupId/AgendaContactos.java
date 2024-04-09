package groupId;

import java.util.ArrayList;
import java.util.List;

public class AgendaContactos {
    private List<Contactos> contactos;

    public AgendaContactos() {
        this.contactos = new ArrayList<>();
    }

    public void agregarContacto(Contactos contacto) {
        this.contactos.add(contacto);
    }

    public void eliminarContacto(Contactos contacto) {
        this.contactos.remove(contacto);
    }

    public List<Contactos> obtenerContactos() {
        return this.contactos;
    }
}
