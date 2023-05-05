/*

3) Scrivere un programma ContinuaFino che chiede all’utente di inserire una sequenza di interi. Il programma continua a
chiedere all’utente di inserire valori fintanto che i valori inseriti soddisfano almeno una delle seguenti condizioni:
•	è negativo e divisibile per 2
•	è positivo e divisibile per 3
Al termine il programma stampa la somma di tutti i valori inseriti escluso quello che ha violato le condizioni.
Risolvere questo esercizio senza usare array.

 */
import java.util.Scanner;

public class ContinuaFino {
    public static void main(String[] args) {
        int input = userInput();
        int sum;
        while (sum)

    }
    private static int userInput() {
        Scanner scanInput = new Scanner(System.in);
        System.out.print("Inserire numero > ");
        int userInput = scanInput.nextInt();
        return userInput;
    }

    private static int test(int input, int sum) {
        if(input > 0 && input / 2 != 0 || input < 0 && input / 3 != 0) {
            sum = sum + input;
        }
        return sum;
    }
}