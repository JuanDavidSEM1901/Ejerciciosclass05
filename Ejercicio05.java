import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import java.util.Scanner;

public class Ejercicio05 {
    static int opcion;
    static String documento;

    public static void main(String[] args) {
        List<String> extensiones = new ArrayList<>();
        extensiones.add("jpg");
        extensiones.add("jpeg");
        extensiones.add("png");
        extensiones.add("pdf");
        var entry = new Scanner(System.in);
        Queue<String> documentos = new LinkedList<>();
        do {
            System.out.println(
                    "GESTION DE DOCUMENTOS PARA IMPRESION\n1. Agregar documento\n2. Eliminar documento actual\n3. Mostrar documentos en orden\n4.Salir\n ARCHIVOS ADMITIDOS:\nPNG\nJPEG\nJPG\nPDF");
            opcion = entry.nextInt();
            entry.nextLine();
            switch (opcion) {
                case 1:
                    addDocumentQueue(documentos, entry, extensiones);
                    break;
                case 2:
                    deleteDocument(documentos);
                    break;

                    case 3:
                    showDocumentsQueue(documentos);

                default:
                    break;
            }
        } while (opcion != 4);

        entry.close();

    }

    private static void addDocumentQueue(Queue<String> documentos, Scanner entry, List<String> extensiones) {
        System.out.println("---------------------");
        System.out.println("Ingrese el documento");
        documento = entry.nextLine();
        System.out.println("---------------------");

        int indiceDelPunto = documento.lastIndexOf('.');
        if (indiceDelPunto >= 0) {
            String extension = documento.substring(indiceDelPunto + 1).toLowerCase();
            if (extensiones.contains(extension)) {
                System.out.println("--------------------------------");
                System.out.println("FORMATO DE ARCHIVO ADMITIDO");
                documentos.add(documento);
                System.out.println("--------------------------------");
            } else {
                System.out.println("-------------------------------");
                System.out.println("Formato de archivo no admitido");
                System.out.println("FORMATOS ADMITIDOS");
                for (String ext : extensiones) {
                    System.out.println(ext);
                }
                System.out.println("-------------------------------");
            }
        } else {
            System.out.println("--------------------------------");
            System.out.println("El documento no tiene extensión");
            System.out.println("FORMATOS ADMITIDOS");
            for (String ext : extensiones) {
                System.out.println(ext);
            }
            System.out.println("--------------------------------");
        }
    }

    private static void deleteDocument(Queue<String> documentos) {
        if (documentos.isEmpty()) {
            System.out.println("_______________________________");
            System.out.println("NO HAY DOCUMENTOS PARA ELIMINAR");
            System.out.println("_______________________________");
        } else {
            String eliminar = documentos.poll();
            System.out.println("_______________________________");
            System.out.println("DOCUMENTO ELIMINADO: " + eliminar);
            System.out.println("_______________________________");
        }
    }

    private static void showDocumentsQueue(Queue<String> documentos) {
        System.out.println("__________________________________");
        System.out.println("  DOCUMENTOS AGREGADOS EN ORDEN: ");
        for (String mostrardocs : documentos) {
            
            System.out.println(mostrardocs);
        }
        System.out.println("__________________________________");
    }
}
