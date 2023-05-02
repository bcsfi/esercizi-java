import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Insert the word : ");
        String word = input.nextLine();

        for(int i = word.length(); i > 0; i--)
        {
            System.out.print(word.substring(i-1, i));
        }
    }
}