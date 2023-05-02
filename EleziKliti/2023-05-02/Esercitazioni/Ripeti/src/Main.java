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
        String captureString=""; int captureInt=0;

        // Queste variabili serverono a capire se si l'utente ha inserito la string e l'input del giusto tipo;
        boolean activeString=false, activeInt=false;

        while(true)
        {

            Scanner scan = new Scanner(System.in);

            // Verifica se viene inserita una stringa
            if(activeString==false){
                System.out.print("Enter your String (q for quit): ");
                if(scan.hasNextLine()){
                    captureString = scan.nextLine();
                    activeString=true;
                } else {System.out.print("Error, this is not an string. Please Try agin.\n");};
            }


            // Verifica se viene inserito un numero
            if(activeInt==false) {
                System.out.print("Enter your Number (q for quit): ");
                if(scan.hasNextInt()){
                    captureInt = scan.nextInt();
                    if(captureInt > 0){
                        activeInt=true;
                    } else {
                        System.out.print("Error, this is not greater of 0. \n");
                    }
                } else {System.out.print("Error, this is not an int. Please Try agin. \n");};
            }


            // Verifica che tutto sia inserito correttamente
            boolean status = (activeString == true && activeInt == true);
            if(status)
            {
                System.out.print("Stringa e numero inserito correttamente");
                Print.PrintOfNumber(captureString, captureInt);
                break;
            }

        }


    }

    private class Print {
        private static void PrintOfNumber(String captureString, int captureInt){
            System.out.print("\n");
            System.out.print("NUMERO" + "\t" + "STRINGA");
            for(int a=0; a < captureInt; a++){
                System.out.print("\n");
                System.out.print("\t" + a + "\t" + captureString);
            }
        }
    }

}



