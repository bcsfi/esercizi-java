import com.sun.source.doctree.SinceTree;

import java.util.Scanner;

class Main {

    public static void main(String[] args) {

        try {

            Scanner scan = new Scanner(System.in);
            System.out.print("What day of the week do you want the number? \n");
            String choiceDey = scan.nextLine();
            System.out.print(choiceDey);


        } catch (Exception IllegalArgumentException){
            System.out.print("Error, this value not exist in main enum.");
        }

    }


}


