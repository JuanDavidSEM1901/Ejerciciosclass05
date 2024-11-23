import java.util.Scanner;

public class Ejercicio02 {
    public static void main(String[] args) {
        var entry = new Scanner(System.in);

        int[][] matriz = new int[3][3];

        // INGRESAR MATRIZ
        getMatriz(entry, matriz);

        entry.close();

    }

    private static void getMatriz(Scanner entry, int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.println("Ingrese los datos para la posicion" + (i + 1) + " " + (j + 1));
                matriz[i][j] = entry.nextInt();

            }
        }

        // IMPRIMIR MATRIZ
        printMatriz(matriz);

        int[][] matriz90g = new int[3][3];

        // MATRIZ 90º
        rotateMatriz90g(matriz, matriz90g);

    }

    private static void rotateMatriz90g(int[][] matriz, int[][] matriz90g) {
        int z = matriz.length - 1;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                matriz90g[j][z - i] = matriz[i][j];
            }
        }

        System.out.println("Matriz rotada 90º");
        printMatriz(matriz90g);
    }

    private static void printMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}