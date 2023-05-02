import java.util.Vector;

public class ArraySum {
    static int arrayStringSum(Vector<String> someWord ){

        int sum = 0;

        // Elenco di tutti i ascii che tengono caratteri speciali (22 tasti)
        int[] specialChar = {33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,58,59,60,61,62,63,64};


        // Cicla tutte le stringhe del vettore
        for(int a=0; a < someWord.size(); a++)
        {
            // Cattura la prima stringa
            String captureWord = someWord.get(a);

            // Crea un ciclo per un char presente sulla frase catturata
            for(int b=0; b < captureWord.length(); b++)
            {

                // Trasforma ogni lettera della frase catturata in intero
                char letterCap = captureWord.charAt(b);
                int letterCapAscii = (int) letterCap;

                // Cicla per la lungezza di tutti i caratteri speciali

                for(int c=0; c < specialChar.length; c++)
                {
                    // e confronta i due interi della lettera e dei caratteri
                    if(letterCapAscii == specialChar[c])
                    {
                        sum++;
                    }

                }

            }


        }

        return sum;
    }

}
