import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        long nextNumber = 0, actualNumber = 0, previousNumber = 0;
        Scanner input = new Scanner(System.in);

        do{
            previousNumber = actualNumber;
            actualNumber = nextNumber;
            System.out.print("| enter number: ");
            nextNumber = input.nextInt();
        }
        while(nextNumber != 0);

        System.out.print((previousNumber > 0 && actualNumber < 0) ? "OK" : "NO");
    }
}