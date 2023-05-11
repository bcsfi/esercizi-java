import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] array5 = new int[5];

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("\nQuale valore intero vuoi inserire nel vettore : ");
            int number = scanner.nextInt();

            System.out.print("In che posizione del vettore lo vuoi inserire (da 1 a 5) : ");
            int position = scanner.nextInt();

            try {
                array5[position - 1] = number;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.print(e + " -> La posizione che hai scelto non esiste!");
            }
        } catch (InputMismatchException e) {
            System.out.print(e + " -> Non si tratta di un numrto intero!");
        }
    }
}