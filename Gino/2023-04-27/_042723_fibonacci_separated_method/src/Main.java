import java.util.Arrays;
import java.util.Scanner;

public class Main
{
    /**Main*/
    public static void main(String[] args)
    {
        if(!args[0].matches("^[0-9]*$")) {
            System.out.print("la stringa non è un numero");
            return;
        }

        long length = Long.parseLong(args[0]);

        while(length < 0)
        {
            System.out.print("| Incorrect entry!\n| Enter a positive number: ");
            Scanner input = new Scanner(System.in);
            args[0] = String.valueOf(input.nextInt());
        }
        System.out.print(Arrays.toString(calculateSuccession(args[0])));
    }

    /**int*/
    private static long[] calculateSuccession(int length)
    {
        long currentNumber = 0, nextNumber = 1, support;
        long[] fibonacciSuccession = new long [length];
        for (int i = 0; i < length; i++)
        {
            fibonacciSuccession[i] = currentNumber;
            support = currentNumber;
            currentNumber = nextNumber;
            nextNumber += support;
        }
        return fibonacciSuccession;
    }

    /**long*/
    private static long[] calculateSuccession(long length)
    {
        long currentNumber = 0, nextNumber = 1, support;
        long[] fibonacciSuccession = new long [(int) length];

        System.out.println("| Java does not allow the creation of arrays of type 'Long',\n| so the number entered was converted to 'Int'");

        for (int i = 0; i < length; i++)
        {
            fibonacciSuccession[i] = currentNumber;
            support = currentNumber;
            currentNumber = nextNumber;
            nextNumber += support;
        }
        return fibonacciSuccession;
    }

    /**String*/
    private static long[] calculateSuccession(String length)
    {
        long currentNumber = 0, nextNumber = 1, support;
        long[] fibonacciSuccession = new long [Integer.parseInt(length)];
        for (int i = 0; i < Integer.parseInt(length); i++)
        {
            fibonacciSuccession[i] = currentNumber;
            support = currentNumber;
            currentNumber = nextNumber;
            nextNumber += support;
        }
        return fibonacciSuccession;
    }
}