import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        long number = 0, sum = 0;
        Scanner input = new Scanner(System.in);

        do{
            sum += number;
            System.out.print("| enter number: ");
            number = input.nextInt();
        }
        while(((number < 0) && (number %2 == 0)) || ((number > 0) && (number %3 == 0)));

        System.out.print("The sum is: " + sum);
    }
}