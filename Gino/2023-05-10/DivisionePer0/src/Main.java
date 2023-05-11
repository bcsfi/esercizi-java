import java.util.Scanner;
import java.util.Random;


public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        System.out.print("Inserisci un numero intero : ");
        int number = scanner.nextInt();

        int randomNumber = rand.nextInt(4);

        try {
            double risultato = number / randomNumber;
            System.out.print("Il numero casuale (tra 0 e 3) e' " + randomNumber + ", il risultato della divisione e' " + risultato);
        } catch (ArithmeticException e) {
            System.out.print(e);
        }
    }
}