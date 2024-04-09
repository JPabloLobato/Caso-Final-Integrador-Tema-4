package groupId;

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
}
