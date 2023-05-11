import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        List<Number> list5 = new ArrayList<>();

        for(int i = 0; i < 5; i++)
        {
            list5.add(null);
        }

        Number number = null;
        Integer position = null;

        /*try {
            System.out.print("In che posizione del vettore lo vuoi inserire (da 1 a 5) : ");
            int position = scanner.nextInt();

            System.out.print("\nQuale valore intero vuoi inserire nel vettore : ");
            int number = scanner.nextInt();

            try {
                try {
                    list5[position - 1].add(number);
                } catch (NullPointerException e) {
                    list5[position - 1] = new ArrayList<>();
                    list5[position - 1].add(number);
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.print(e + " -> La posizione che hai scelto non esiste!");
            }
        } catch (InputMismatchException e) {
            System.out.print(e + " -> Non si tratta di un numrto intero!");
        }*/

        try
        {
            // int
            System.out.print("\nQuale valore vuoi inserire nel vettore : ");
            number = Integer.valueOf(scanner.nextInt());
        }
        catch (InputMismatchException ei)
        {
            try
            {
                // long
                number = Long.valueOf(scanner.nextLong());
            }
            catch (InputMismatchException el)
            {
                try
                {
                    // double
                    number = Double.valueOf(scanner.nextDouble());
                }
                catch (InputMismatchException ed)
                {
                    System.out.print("Il valore che hai inserito non è valido in quanto non è di tipo int, long o double!");
                    return;
                }
            }
        }

        try
        {
            // valore posizione
            System.out.print("In che posizione del vettore lo vuoi inserire (da 1 a 5) : ");
            position = scanner.nextInt();
        }
        catch (InputMismatchException e)
        {
            System.out.print(e + " -> Non hai inserito un intero ( non è una posizione valida)!");
            return;
        }

        try
        {
            // inserimento in posizione
            list5.set(position, number);
        }
        catch (IndexOutOfBoundsException e)
        {
            System.out.print(e + " -> La posizione che hai scelto non esiste!");
            e.printStackTrace();
        }
    }
}