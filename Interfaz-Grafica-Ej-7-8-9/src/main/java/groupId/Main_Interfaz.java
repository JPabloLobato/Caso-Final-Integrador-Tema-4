package groupId;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main_Interfaz {
    public static void main(String[] args) {
        Ventanas ventana1 = new Ventanas();
        ventana1.abrirDocumento("Contenido del documento 1");

        Ventanas ventana2 = new Ventanas();
        ventana2.abrirDocumento("Contenido del documento 2");
    }
}