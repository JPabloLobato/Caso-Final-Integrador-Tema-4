package groupId;

// Clases necesarias para la creación de la interfaz gráfica.
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/* Clase principal editor de texto simple con función de guardar y cargar de archivos,
   que llama a la subclase de Application, parte específica de JavaFX. */
public class EditorTexto extends Application {

    /* Método start que se ejecuta al iniciar la aplicación.
       Override para indicar que vamos ha sobrescribir la superclase. */
    @Override
    public void start(Stage primaryStage) {
        TextArea textArea = new TextArea();
        Button saveButton = new Button("Guardar");
        Button loadButton = new Button("Cargar");

        // Botón para guardar el contenido del TextArea en un archivo.
        saveButton.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showSaveDialog(primaryStage);
            if (file != null) {
                try (FileWriter writer = new FileWriter(file)) {
                    writer.write(textArea.getText());
                } catch (IOException ex) {
                    System.out.println("Error al guardar el archivo" + ex.getMessage());
                }
            }
        });

        // Botón para cargar el contenido de un archivo en el TextArea.
        loadButton.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showOpenDialog(primaryStage);
            if (file != null) {
                try {
                    String content = new String(Files.readAllBytes(Paths.get(file.toURI())));
                    textArea.setText(content);
                } catch (IOException ex) {
                    System.out.println("Error al cargar el archivo" + ex.getMessage());
                }
            }
        });
        VBox vbox = new VBox(textArea, saveButton, loadButton);
        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    // Función principal que ejecutar la aplicación.
    public static void main(String[] args) {
        launch(args);
    }

}
