import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("\nFibonacci\nEnter the amount of numbers you want in the sequence: ");
        Scanner input = new Scanner(System.in);
        int quantity = input.nextInt();
        long currentNumber = 0, nextNumber = 1, support;
        for (int i = 0; i < quantity; i++) {
            System.out.println(currentNumber);
            support = currentNumber;
            currentNumber = nextNumber;
            nextNumber += support;
        }
    }
}