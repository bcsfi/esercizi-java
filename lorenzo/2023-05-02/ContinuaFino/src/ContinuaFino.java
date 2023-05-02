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
        exitCondition(getUserInput());
    }

    private static int getUserInput() {
        Scanner scanInput = new Scanner(System.in);
        System.out.print("Inserisci numero: ");
        int userInput = scanInput.nextInt();
        return userInput;
    }

    private static String exitCondition(int userInput) {
        String list = null;
        while((userInput/2)!=0 && (userInput/2)<0 || (userInput/3)!=0 && (userInput/3)>0){
            list = list + " " + userInput;
        }
        return list;
    }
}