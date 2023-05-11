/*
    ESERCIZIO
    Sulla falsariga dell’esercizio precedente, creare due liste di Coppie<T, S>.
    Se le due liste hanno elementi dello stesso tipo, fare lo stesso controllo
    dell’esercizio precedente. Altrimenti, stampare una riga di errore: “Tipi incompatibili”

    VERSIONE MODIFICATA
    Considerando due liste popolate dall'utente con elementi di potenziale tipo diverso.
    - 1 Verificare per ogni elemnto di una lista, quante volte il suo tipo è presente nell'altra
    - 2 Qualora il tipo fosse il medesimo, verificare se l'elemento ha anche il solito valore
    - 3 Stampare per ciascun tipo il risultato del punto 1 e la quantita totale di casi del punto 2
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main<T>
{
    private static <T> String matchCount(List<T> list1, List<T> list2)
    {
        long typeEquals, valueEquals = 0;

        String result = " ";

        for (T element1 : list1)
        {
            typeEquals = 0;

            for (T element2 : list2)
            {
                if (element1.getClass().equals(element2.getClass()))
                {
                    typeEquals ++;

                    if (element1 == element2)
                    {
                        valueEquals ++;
                    }
                }
            }

            result += element1.getClass() + " " + typeEquals + "    ";
            typeEquals = 0;
        }

        result += "                " + valueEquals;

        return result;
    }
    Scanner in = new Scanner(System.in);
		System.out.println("Digita un intero:
    private static <T> void populateList(List<T> list)
    {
        Scanner scanner = new Scanner(System.in);


        T value;

        do {
            String stringValue = scanner.next();
            Integer integerValue = null;
            try {
                integerValue = Integer.parseInt(stringValue);
            } catch (NumberFormatException e) {}
            if (integerValue == null) {
                //---fai il controllo per il boolean +
            }
            value = (T) scanner.next();
            if (value)
            list.add(value);
        }
        while(!value.equals("§"));
    }

    public static <T> void main(String[] args)
    {
        List<T> list1 = new ArrayList<T>(), list2 = new ArrayList<T>();
        populateList(list1);
        populateList(list2);
        System.out.println(matchCount(list1, list2));
    }
}