package groupId;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Herramienta_dibujo {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Herramienta de Dibujo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        DrawingPanel drawingPanel = new DrawingPanel();
        frame.add(drawingPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton saveButton = new JButton("Guardar");
        saveButton.addActionListener(e -> drawingPanel.save());
        buttonPanel.add(saveButton);

        JButton loadButton = new JButton("Cargar");
        loadButton.addActionListener(e -> drawingPanel.load());
        buttonPanel.add(loadButton);

        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}

class DrawingPanel extends JPanel {
    private ArrayList<Point> points = new ArrayList<>();
    private StringBuilder text = new StringBuilder();

    public DrawingPanel() {
        setFocusable(true);
        requestFocusInWindow();

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                points.add(e.getPoint());
                repaint();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                points.add(e.getPoint());
                repaint();
            }
        });

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                text.append(e.getKeyChar());
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        for (Point point : points) {
            g2d.fillOval(point.x, point.y, 4, 4);
        }
        g2d.drawString(text.toString(), 10, 20);
    }

    public void save() {
        JFileChooser fileChooser = new JFileChooser(new File("Carpeta txt"));
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
                writer.println(text.toString());
                for (Point point : points) {
                    writer.println(point.x + "," + point.y);
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error al guardar el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void load() {
        JFileChooser fileChooser = new JFileChooser(new File("Carpeta txt"));
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (Scanner scanner = new Scanner(file)) {
                text = new StringBuilder(scanner.nextLine());
                points.clear();
                while (scanner.hasNextLine()) {
                    String[] parts = scanner.nextLine().split(",");
                    points.add(new Point(Integer.parseInt(parts[0]), Integer.parseInt(parts[1])));
                }
                repaint();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error al cargar el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}