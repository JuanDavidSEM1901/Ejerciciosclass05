import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

public class Ejercicio04 {
    static int opcion;

    public static void main(String[] args) {
        List<String> correos = new ArrayList<>();
        List<String> correosDuplicados = new ArrayList<>();
        var entry = new Scanner(System.in);

        do {
            System.out.println(
                    "GESTION DE CORREOS:\n1.Agregar Correo\n2.Ver correos agregados\n3.Ver correos duplicados\n4.Salir");
            opcion = entry.nextInt();
            entry.nextLine();

            switch (opcion) {
                case 1:

                    leerCorreos(correos, entry, correosDuplicados);
                    break;
                case 2:
                    showCorreosAdd(entry, correos);
                    break;
                case 3:
                    leerDuplicados(correos, entry, correosDuplicados);
                    break;
                default:
                    break;
            }

        } while (opcion != 3);

        entry.close();

    }

    private static void leerDuplicados(List<String> correos, Scanner entry, List<String> correosDuplicados) {
        for (String mostrarDuplicados : correosDuplicados) {
            System.out.println(mostrarDuplicados);
            if (correosDuplicados.isEmpty()) {
                System.out.println("NO HAY POR EL MOMENTO CORREOS DUPLICADOS");
            }
        }
    }

    private static void showCorreosAdd(Scanner entry, List<String> correos) {

        for (String showCorreosAdd : correos) {
            System.out.println(showCorreosAdd);
            if (correos.isEmpty()) {
                System.out.println("NO SE HA INGRESADO NINGUN CORREO!");
            }
        }

    }

    private static void leerCorreos(List<String> correos, Scanner entry, List<String> correosDuplicados) {
        System.out.println("Ingrese un correo: ");
        String correo = entry.nextLine();
        // SI LA LISTA CORREOS YA CONTIENE EL CORREO ENTONCES ALMACENELO EN LA LISTA DE
        // DUPLICADOS
        verficateDuplicated(correos, correosDuplicados, correo);

        // SI EL CORREO INGRESADO POR EL USUARIO CONTIENE @ Y . ES UN CORREO VALIDO Y SE
        // AGREGA A CORREOS.ADD y que la lista correos no contenga el correo
        if (correo.contains("@") && correo.contains(".") && !correos.contains(correo)) {
            correos.add(correo);
            System.out.println("CORREO AGREGADO CON EXITO!");
        } else if (!correo.contains("@") && !correo.contains(".") && !correos.contains(correo)) {
            System.out.println("El correo no es valido! Debe contener @ y .com u otro");
            System.out.println("Intente de nuevo.");
            leerCorreos(correos, entry, correosDuplicados);
        }

    }

    private static void verficateDuplicated(List<String> correos, List<String> correosDuplicados, String correo) {
        if (correos.contains(correo)) {
            // agregar el correo duplicado a LA LISTA DE CORREOS DUPLICADOS
            correosDuplicados.add(correo);
            System.out.println("CORREO DUPLICADO!");
        }
    }
}
