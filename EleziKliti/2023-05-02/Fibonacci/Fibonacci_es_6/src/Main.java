import java.sql.Array;
import java.util.Scanner;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.Vector;

class Main {
    public static void main(String[] args)
    {

        // Vettore dove si andranno a salvare le diverse stringhe.
        Vector<String> someWord = new Vector<String>();

        // Dichiare l'oggetto scan come scanner del terminale.
        Scanner scan = new Scanner(System.in);


        while(true)
        {

            System.out.print("Insert your string: ");

            // Catturare la linea tramite l'oggetto scan
            String captureString = scan.nextLine();

            // Aggiungi la string al vettore
            someWord.add(captureString);


            // La regex torna true se l'input è vuoto oppure si trova -> "" -> inserito. Una volta true esce dal while.
            if(captureString == "" || captureString.matches("[\"]+(\").*"))
            {
                System.out.print("You kill the loop.");
                break;
            }

            // Aggiungi la stringa al vettore
            ArraySum.arrayStringSum(someWord);



        }


        // Stampa lunghezza delle parole capitalized
        int res = ArraySum.arrayStringSum(someWord);
        System.out.print(res + " Totale conteggio");

    }

}


