package groupId;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class Ventanas extends JFrame {
    private final JTextArea areaTexto;
    private final JLabel etiquetaPosicion;
    private final JLabel etiquetaProgreso;
    private JScrollBar barraDesplazamiento;

    public Ventanas() {
        areaTexto = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(areaTexto);
        etiquetaPosicion = new JLabel();
        etiquetaProgreso = new JLabel();
        JPanel panelInferior = new JPanel(new GridLayout(1, 2));
        panelInferior.add(etiquetaPosicion);
        panelInferior.add(etiquetaProgreso);
        add(scrollPane, BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        areaTexto.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                etiquetaPosicion.setText("Posición del ratón: X=" + e.getX() + ", Y=" + e.getY());
            }
        });
    }

    public void abrirDocumento(String contenido) {
        areaTexto.setText(contenido);

        JScrollPane scrollPane = (JScrollPane) areaTexto.getParent().getParent();
        scrollPane.validate();
        barraDesplazamiento = scrollPane.getVerticalScrollBar();

        barraDesplazamiento.addAdjustmentListener(e -> {
            int valorMaximo = barraDesplazamiento.getMaximum() - barraDesplazamiento.getVisibleAmount();
            int valorActual = barraDesplazamiento.getValue();
            int progreso = (int) (((double) valorActual / valorMaximo) * 100);
            etiquetaProgreso.setText("Progreso del documento: " + progreso + "%");
        });

        setVisible(true);
    }
}