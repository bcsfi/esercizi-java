import java.sql.Array;
import java.util.Scanner;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.Vector;

class Main {
    // Importo il colore verde.
    public static final String ANSI_YELLOW = "\u001B[33m";


    public static void main(String[] args)
    {

        // Vettore dove si andranno a salvare le diverse stringhe.
        Vector<String> someWord = new Vector<String>();

        // Dichiare l'oggetto scan come scanner del terminale.
        Scanner scan = new Scanner(System.in);


        while(true)
        {

            System.out.print("Insert your string (for exit q): ");

            // Catturare la linea tramite l'oggetto scan
            String captureString = scan.nextLine();

            boolean quit = (captureString.equals("q") || captureString.equals("Q"));

            // Se quit non si avvera aggiungere input al vettore
            if(!quit){someWord.add(captureString);} else
            {
                System.out.println("You go out.");
                break;
            }

        }

        // Una volta raccolti tutti i dati passa tutto add ArraySum e ritorna il risultato.
        int res = ArraySum.arrayStringSum(someWord);
        System.out.print(ANSI_YELLOW + "Total number space follow of vocal: " + res + "\n");
        System.out.print(someWord);

    }

}


