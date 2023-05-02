import java.lang.reflect.AccessFlag;
import java.sql.Array;
import java.util.Scanner;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.Vector;
import java.lang.reflect.Method;

class Main {

    public static void main(String[] args)
    {

        int[] list = new int[3];
        // Queste variabili serverono a capire se si l'utente ha inserito la string e l'input del giusto tipo;
        int i=0;
        while(i < 3)
        {

            Scanner scan = new Scanner(System.in);

            // Verifica se viene inserito un numero
                System.out.print("Enter your Number (q for quit): ");
                if(scan.hasNextInt()){
                    list[i] = scan.nextInt();
                    i++;
                    System.out.print("WoW! Let's go to the next. \n");
                } else {System.out.print("Error, this is not an int. Please Try agin. \n");};

        }

        Check.CheckSameNumber(list);

    }

    private class Check {
        private static void CheckSameNumber(int[] list){
            System.out.print("\n");
            System.out.print("NUMERO" + "\t" + "\n");

                // 3 2 5 6 8 5
                    for(int a=0; a < list.length; a++)
                    {
                        for(int b=1; b < list.length && b != a; b++)
                        {
                            if(b==a){System.out.print("Es.");}
                            if(list[a] == list[b])
                            {
                                System.out.print("Coppia uguale rilevata.");
                            }
                        }

                    }


        }
    }

}



