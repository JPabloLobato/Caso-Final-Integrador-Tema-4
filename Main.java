import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Menú Principal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));

        JButton itemEditor = new JButton("Abrir Editor de texto");
        itemEditor.addActionListener(e -> {
            Main_Editor.main(new String[]{});
        });
        menuPanel.add(itemEditor);

        JButton itemComparador = new JButton("Comparador y Contador de contenido");
        itemComparador.addActionListener(e -> {
            Main_Comparador_Analizador.main(new String[]{});
        });
        menuPanel.add(itemComparador);

        JButton itemBusqueda = new JButton("Búsqueda de Palabras por archivos");
        itemBusqueda.addActionListener(e -> {
            Main_BuscadorPalabras.main(new String[]{});
        });
        menuPanel.add(itemBusqueda);

        JButton itemContactos = new JButton("Contactos");
        itemContactos.addActionListener(e -> {
            Main_AgendaContactos.main(new String[]{});
        });
        menuPanel.add(itemContactos);

        JButton itemInterfaz = new JButton("Interfaz Gráfica");
        itemInterfaz.addActionListener(e -> {
            Main_Interfaz.main(new String[]{});
        });
        menuPanel.add(itemInterfaz);

        JButton itemDibujo = new JButton("Herramienta de Dibujo");
        itemDibujo.addActionListener(e -> {
            Main_Dibujo.main(new String[]{});
        });

        menuPanel.add(itemDibujo);
        frame.add(menuPanel, BorderLayout.WEST);
        frame.setVisible(true);
    }
}