package groupId;

// Importaciones necesarias
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label; // Importación para la etiqueta
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class EditorTexto extends Application {

    // Método para validar el correo electrónico
    public static boolean validarEmail(String email) {
        // Expresión regular para validar un email
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(regex);
    }

    @Override
    public void start(Stage primaryStage) {
        TextArea textArea = new TextArea();
        Button saveButton = new Button("Guardar");
        Button loadButton = new Button("Cargar");

        // Etiqueta para la validación del correo
        Label etiquetaValidacion = new Label("Correo no válido");

        // Listener para validar el correo al modificar el texto
        textArea.textProperty().addListener((obs, oldValue, newValue) -> {
            if (validarEmail(newValue)) {
                etiquetaValidacion.setText("Correo válido");
            } else {
                etiquetaValidacion.setText("Correo no válido");
            }
        });

        // Botón para guardar el contenido del TextArea en un archivo
        saveButton.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setInitialDirectory(new File("Carpeta txt"));
            File file = fileChooser.showSaveDialog(primaryStage);
            if (file != null) {
                try (FileWriter writer = new FileWriter(file)) {
                    writer.write(textArea.getText());
                } catch (IOException ex) {
                    System.out.println("Error al guardar el archivo." + ex.getMessage());
                }
            }
        });

        // Botón para cargar el contenido de un archivo en el TextArea
        loadButton.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setInitialDirectory(new File("Carpeta txt"));
            File file = fileChooser.showOpenDialog(primaryStage);
            if (file != null) {
                try {
                    String content = new String(Files.readAllBytes(Paths.get(file.toURI())));
                    textArea.setText(content);
                } catch (IOException ex) {
                    System.out.println("Error al cargar el archivo." + ex.getMessage());
                }
            }
        });

        VBox vbox = new VBox(textArea, saveButton, loadButton, etiquetaValidacion); // Añadir la etiqueta al VBox
        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
