package TestFibonacci;
import java.util.Scanner;

public class Fibonacci {
    static int fibMethod(int n) {

        Scanner input = new Scanner(System.in);
        System.out.print("Inserisci il numero di elementi della sequenza di Fibonacci: ");
        //int n = input.nextInt();

        int val1 = 0;
        int val2 = 1;

        //System.out.print("Sequenza di " + n + " elementi: ");

        for (int i = 1; i <= n; i++) {
            System.out.println(val1 + " ");

            int NextVal = val1 + val2;
            val1 = val2;
            val2 = NextVal;
        }
        return 0;
    }

    static String fibMethod(String n) {
        Scanner input = new Scanner(System.in);
        System.out.print("Inserisci il numero di elementi della sequenza di Fibonacci: ");
        int val1 = 0;
        int val2 = 1;
        int a = Integer.parseInt(n);
        for (long i = 1; i <= a; i++) {
            System.out.println(val1 + " ");

            int NextVal = val1 + val2;
            val1 = val2;
            val2 = NextVal;
        }
        return "";
    }

    static Long fibMethod(Long n) {
        Scanner input = new Scanner(System.in);
        System.out.print("Inserisci il numero di elementi della sequenza di Fibonacci: ");
        long val1 = 0;
        long val2 = 1;
        for (long i = 1; i <= n; i++) {
            System.out.println(val1 + " ");

            long NextVal = val1 + val2;
            val1 = val2;
            val2 = NextVal;
        }
        return n;
    }
}


