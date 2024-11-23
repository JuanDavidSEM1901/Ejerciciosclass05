import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio01 {

    public static void main(String[] args) {
        var entry = new Scanner(System.in);

        System.out.println("Ingrese el tamaño del array");
        int size = entry.nextInt();

        int[] numeros = new int[size];

        // SUMA ARRAY

        getSuma(entry, size, numeros);

        // VALOR MAXIMO

        getMaxNum(size, numeros);

        // VALOR MINIMO

        getMinNum(size, numeros);

        // INVERT ARRAY

        invertido(size, numeros);
        // Ordenar array
        ordenadoMaM(numeros);

        // MEDIA

        getMedia(size, numeros);

        // REPETICIONES

        getRepeticiones(size, numeros);
        entry.close();
    }

    private static void getRepeticiones(int size, int[] numeros) {
        int maxRepeticiones = 0;
        int numeroRepetido = 0;
        for (int i = 0; i < size; i++) {
            int repeticiones = 0;
            for (int j = 0; j < size; j++) {
                if (numeros[i] == numeros[j]) {
                    repeticiones++;
                }
            }
            if (repeticiones > maxRepeticiones) {
                maxRepeticiones = repeticiones;
                numeroRepetido = numeros[i];
            }
        }
    }

    private static void getMedia(int size, int[] numeros) {

        int suma = 0;
        for (int i = 0; i < size; i++) {
            suma += numeros[i];
        }
        double media = (double) suma / size;
        System.out.println("La media del array es: " + media);
    }

    private static void ordenadoMaM(int[] numeros) {
        Arrays.sort(numeros);
        System.out.println("Array ordenado de mayor a menor: ");
        for (int i = numeros.length - 1; i >= 0; i--) {
            System.out.println(numeros[i] + " ");

        }
    }

    private static void invertido(int size, int[] numeros) {
        for (int i = 0; i < size / 2; i++) {
            int temporal = numeros[i];
            numeros[i] = numeros[size - i - 1];
            numeros[size - i - 1] = temporal;

        }

        System.out.println("El array invetido es: ");

        for (int nums : numeros) {
            System.out.println(nums + " ");
        }
        System.out.println();
    }

    private static void getMinNum(int size, int[] numeros) {
        int minNum = numeros[0];

        for (int i = 1; i < size; i++) {
            if (numeros[i] < minNum) {
                minNum = numeros[i];
            }
        }

        System.out.println("El numero minimo del array es: " + minNum);
    }

    private static void getMaxNum(int size, int[] numeros) {
        int maxNum = numeros[0];

        for (int i = 1; i < size; i++) {
            if (numeros[i] > maxNum) {
                maxNum = numeros[i];
            }
        }

        System.out.println("EL NUMERO MAXIMO DEL ARRAY ES: " + maxNum);
    }

    private static void getSuma(Scanner entry, int size, int[] numeros) {
        int suma = 0;

        for (int i = 0; i < size; i++) {
            System.out.println("Ingrese el número en la posición " + (i + 1) + ":");
            numeros[i] = entry.nextInt();
            suma += numeros[i];

        }

        System.out.println("La suma del los elementos del array es: " + suma);
    }
}