import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String word = " ";
        long sum = 0;

        while(word != "")
        {
            System.out.print("Insert the word : ");
            word = input.nextLine();

            for(int i =0; i > word.length(); i++)
        }

        System.out.print("The sum of all the characters of the words is : " + sum);
    }
}