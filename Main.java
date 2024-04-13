import groupId.Main_Editor;
import groupId.Main_Comparador_Analizador;
import groupId.Main_BuscadorPalabras;
import groupId.Main_AgendaContactos;
import groupId.Main_Interfaz;
import groupId.Herramienta_dibujo;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Menú Principal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));

        JButton itemEditorTexto = new JButton("Abrir Editor de texto");
        itemEditorTexto.addActionListener(e -> {
            Main_Editor.main(new String[]{});
        });
        menuPanel.add(itemEditorTexto);

        JButton itemComparadorAnalizador = new JButton("Abrir Comparador y analizador de texto");
        itemComparadorAnalizador.addActionListener(e -> {
            Main_Comparador_Analizador.main(new String[]{});
        });
        menuPanel.add(itemComparadorAnalizador);

        JButton itemBuscador = new JButton("Abrir Buscador de Palabras");
        itemBuscador.addActionListener(e -> {
            Main_BuscadorPalabras.main(new String[]{});
        });
        menuPanel.add(itemBuscador);

        JButton itemContactos = new JButton("Contactos");
        itemContactos.addActionListener(e -> {
            Main_AgendaContactos.main(new String[]{});
        });
        menuPanel.add(itemContactos);

        JButton itemInterfaz = new JButton("Multiplicidad de ventanas");
        itemInterfaz.addActionListener(e -> {
            Main_Interfaz.main(new String[]{});
        });
        menuPanel.add(itemInterfaz);

        JButton itemDibujo = new JButton("Herramienta de dibujo");
        itemDibujo.addActionListener(e -> {
            Herramienta_dibujo.main(new String[]{});
        });
        menuPanel.add(itemDibujo);

        frame.add(menuPanel);
        frame.setVisible(true);
    }
}
