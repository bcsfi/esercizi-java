import java.util.Scanner;
import java.util.ArrayList;

public class UserInput {
    public static void main(int numeroIterazioni, int numeroLista) {
        ArrayList<Integer> returnList = new ArrayList<Integer>();
        Scanner inputScanner = new Scanner(System.in);

        for(int i=0; i<numeroIterazioni; i++){
            System.out.print("Inserisci numero lista " + numeroLista);
            int userInput = inputScanner.nextInt();
            returnList.add(userInput);
        }
    }
}
