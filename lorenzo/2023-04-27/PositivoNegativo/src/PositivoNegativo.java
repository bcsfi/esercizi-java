import java.util.Scanner;

public class PositivoNegativo {
    public static void main(String[] args) {
        long previousNumber = 0, actualNumber = 0, nextNumber = 0;
        Scanner input = new Scanner(System.in);

        do{
            previousNumber = actualNumber;
            actualNumber = nextNumber;
            nextNumber = userInput();
        }
        while(nextNumber != 0);

        if (previousNumber > 0 && actualNumber <0){
            System.out.println("OK");
        }
        else{
            System.out.println("NO");
        }
    }

    private static long userInput() {
        System.out.print("Inserisci numero: ");
        Scanner scanner = new Scanner(System.in);
        long Input = scanner.nextLong();
        return Input;
    }
}