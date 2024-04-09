package groupId;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validacion_Email {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Por favor ingresa tu dirección de correo electrónico: ");
        String email = scanner.nextLine();

        if (validarEmail(email)) {
            System.out.println("El correo electrónico ingresado es válido.");
        } else {
            System.out.println("El correo electrónico ingresado no es válido.");
        }
    }

    public static boolean validarEmail(String email) {
        // Expresión regular para validar un email
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }
}
