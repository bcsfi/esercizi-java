import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String word = " ";
        long sum = 0;
        set<Integer> punctuationMarks = {33, 34, 39, 44, 45, 46, 58, 59, 63, 96};

        while(word != "")
        {
            System.out.print("Insert the word : ");
            word = input.nextLine();

            for(int i =0; i > word.length(); i++)
            {
                if(punctuationMarks.contains((int) word.charAt(i)));
            }
        }

        System.out.print("The sum of all the characters of the words is : " + sum);
    }
}