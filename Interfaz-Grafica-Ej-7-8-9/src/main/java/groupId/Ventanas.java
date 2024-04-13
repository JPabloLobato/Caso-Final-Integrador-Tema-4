package groupId;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class Ventanas extends JFrame {
    private final JTextArea areaTexto;
    private final JLabel etiquetaPosicion;
    private final JLabel etiquetaProgreso;
    private final JLabel etiquetaValidacionEmail;  // Nueva etiqueta para mostrar la validación del correo

    public Ventanas() {
        areaTexto = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(areaTexto);
        etiquetaPosicion = new JLabel();
        etiquetaProgreso = new JLabel();
        etiquetaValidacionEmail = new JLabel();  // Inicialización de la nueva etiqueta
        JPanel panelInferior = new JPanel(new GridLayout(1, 3));  // Aumentamos a 3 columnas
        panelInferior.add(etiquetaPosicion);
        panelInferior.add(etiquetaProgreso);
        panelInferior.add(etiquetaValidacionEmail);  // Añadimos la nueva etiqueta al panel
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
        JScrollBar barraDesplazamiento = scrollPane.getVerticalScrollBar();

        barraDesplazamiento.addAdjustmentListener(e -> {
            int valorMaximo = barraDesplazamiento.getMaximum() - barraDesplazamiento.getVisibleAmount();
            int valorActual = barraDesplazamiento.getValue();
            int progreso = (int) (((double) valorActual / valorMaximo) * 100);
            etiquetaProgreso.setText("Progreso del documento: " + progreso + "%");
        });

        areaTexto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                validarCorreo();  // Validar el correo cada vez que se suelte una tecla
            }
        });

        setVisible(true);
    }

    private void validarCorreo() {
        String texto = areaTexto.getText();
        String[] palabras = texto.split("\\s+");

        for (String palabra : palabras) {
            if (Validacion_Email.validarEmail(palabra)) {
                etiquetaValidacionEmail.setText("Correo válido: " + palabra);
                return;
            }
        }
        etiquetaValidacionEmail.setText("Correo no válido");
    }
}
