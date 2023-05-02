import java.util.Vector;

public class ArraySum {
    static int arrayStringSum(Vector<String> someWord ){

        int sum = 0;

        // Elenco di tutti i ascii che tengono caratteri speciali (22 tasti)
        // Qua puoi scrivere il primo valore che vuoi trovare
        int[] specialChar = {32,/*109*/};

        // Elenco dei ascii che tengono delle vocali
        // Qua puoi scrivere quale altro deve stare accanto al primo.  MAIUSCOLE E MINUSCOLE
        int[] vocali = {97, 101, 105, 111, 117, 65, 69, 73, 79, 85 /*110*/};

        // Cicla tutte le stringhe del vettore
        for(int a=0; a < someWord.size(); a++)
        {
            // Cattura la prima stringa
            String captureWord = someWord.get(a);

            // Crea un ciclo per un char presente sulla frase catturata
            for(int b=0; b < captureWord.length(); b++)
            {
                // Trasforma la lettera in intero dell'input in caratteri
                char letterCap = captureWord.charAt(b);
                int letterCapAscii = (int) letterCap;

                int cons = b + 1;
                // Trasforma la lettera successiva ai caratteri speciali in ascii
                char nextLetterCap = captureWord.charAt(cons);
                int nextLetterCapToAscii = (int) nextLetterCap;

                // Controllo se la lettera dopo non esiste di fermare il ciclo
                if(cons >= captureWord.length()-1){break;}

                // Cicla per la lungezza di tutti i caratteri speciali
                for(int c=0; c < specialChar.length; c++)
                {
                    // e confronta i due interi della lettera e dei caratteri
                    for(int r=0; r < vocali.length; r++  )
                    {

                        // Confronta che la lettera è uguale allo spazio e se è uguale a una vocale
                        if(letterCapAscii == specialChar[0] && nextLetterCapToAscii == vocali[r])
                        {
                            // se è true aggiungi alla calcolo finale +1
                            System.out.print("Rilevata " + letterCapAscii + "Uguale a " + nextLetterCapToAscii + "\n");
                            sum++;
                        }
                    }

                }

            }

        }

        return sum;
    }

}
