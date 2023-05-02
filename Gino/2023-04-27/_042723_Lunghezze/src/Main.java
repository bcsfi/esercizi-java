import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String word = " ";
        long sum = 0;

        while(word != "")
        {
            if(Character.isUpperCase(word.charAt(0)))
            {
                sum += word.length();
            }

            System.out.print("Insert the word : ");
            word = input.nextLine();
        }

        System.out.print("The sum of all the characters of the words is : " + sum);
    }
}