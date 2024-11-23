import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio03 {

    static List<String> addHomework = new ArrayList<>();

    public static void main(String[] args) {
        var entry = new Scanner(System.in);

        int opcion;

        do {
            System.out.println("SISTEMA DE GESTION DE TAREAS PENDIENTES");

            System.out.println("Seleccione:\n1.Agregar nueva tarea\n2.Mostrar tareas pendientes\n3.Eliminar tarea");
            opcion = entry.nextInt();
            entry.nextLine();

            switch (opcion) {
                case 1:
                    getAddHomework(entry);

                    break;
                case 2:
                    // Mostrar tareas pendientes
                    getshowHomeworks(addHomework);

                    break;
                case 3:
                    // Eliminar tarea
                    deleteHomework(entry);

                    break;

                default:
                    break;
            }
        } while (opcion == 1 || opcion == 2 || opcion == 3);
    }

    private static void deleteHomework(Scanner entry) {
        if (addHomework.isEmpty()) {
            System.out.println("NO HAY TAREAS AGREGADAS POR LO TANTO NO PUEDO ELIMINAR NINGUNA TAREA");
            return;
        }
        // eliminar tarea por indice
        System.out.println("Ingrese la posicion en la que se encuentra la tarea a eliminar");
        var eliminarTarea = entry.nextInt();
        entry.nextLine();
        addHomework.remove(eliminarTarea - 1);

        System.out.println("Tarea eliminada con exito!");

    }

    private static void getshowHomeworks(List<String> addHomework) {
        System.out.println("|| TAREAS PENDIENTES ||");
        for (int i = 0; i < addHomework.size(); i++) {
            // mostrar tareas pendientes en lista con posicion
            System.out.println((i + 1) + " " + addHomework.get(i));
        }
    }

    private static void getAddHomework(Scanner entry) {
        // ArrayList

        System.out.println("Ingrese la tarea a agregar:");
        // leer tarea al usuario
        var leerTarea = entry.nextLine();
        addHomework.add(leerTarea);

        System.out.println("Tarea agregada con exito!");

    }

}
