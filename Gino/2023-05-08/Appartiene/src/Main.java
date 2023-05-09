import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main
{
    static List<Double> lista1 = new ArrayList<Double>();
    static List<Double> lista2 = new ArrayList<Double>();

    private static void populateList(List<Double> lista, String description)
    {
        Scanner scanner = new Scanner(System.in);

        double number;
        int choice;

        System.out.print("\n\033[0;33mPopolamento della " + description + "\033[0m ");

        System.out.print("\n" +
                "\033[0;36m 1\033[0;33m |\033[0m Inserisci un elemento nella " + description + "\n" +
                "\033[0;36m 2\033[0;33m |\033[0m Smetti di inserire elementi nella " + description + "\n" +
                "\033[0;36m 0\033[0;33m |\033[0m Esci\n" +
                "\033[0;32m >\033[0;33m |\033[0m ");
        choice = scanner.nextInt();

        while(true)
        {
            switch(choice)
            {
                case 1 :
                    System.out.print("\033[0;32m #\033[0;33m |\033[0;32m Quale numero vuoi aggiungere alla lista?\n >\033[0;33m | ");
                    number = scanner.nextDouble();
                    lista.add(number);

                    System.out.print(
                            "\033[0:32m #\033[0;33m |\n" +
                            "\033[0;36m 1\033[0;33m |\033[0m Inserisci un altro elemento nella" + description + "\n" +
                            "\033[0;36m 2\033[0;33m |\033[0m Smetti di inserire elementi nella" + description + "\n" +
                            "\033[0;36m 0\033[0;33m |\033[0m Esci\n" +
                            "\033[0;32m >\033[0;33m |\033[0m ");
                    choice = scanner.nextInt();
                    break;

                case 2 :
                    return;

                case 0 :
                    System.exit(0);

                default :
                    System.out.print(
                            "\033[0;31m # |\033[0m Inserimento invalido, riprova!\n" +
                            "\033[0;32m >\033[0;33m |\033[0m ");
                    choice = scanner.nextInt();
            }
        }
    }

    private static void showText()
    {
        System.out.println("\n\033[0;35m" +
                        "-----------------------------------------------------------------\n" +
                        "Date\033[0m due liste di numeri\033[0;35m (lista1 e lista2), inserite dall’utente:\n" +
                        "   1) Trovare l'\033[0mintersezione\033[0;35m delle due liste\n" +
                        "   2) Trovare la\033[0m cardinalità\033[0;35m dell'intersezione\n" +
                        "   3) \033[0mStampa\033[0;35mre i risultati dei due punti precedenti\n" +
                        "-----------------------------------------------------------------\n" +
                        "\033[0m");
    }

    private static String intersectionCardinality()
    {
        String intersection = " elementi di Lista2: ";
        int cardinality = 0;

        for (double element1 : lista1)
        {
            for (double element2 : lista2)
            {
                if (element1 == element2 && cardinality == 0)
                {
                    intersection += element1;
                    cardinality++;
                } else if (element1 == element2)
                {
                    intersection += ", " + element1;
                    cardinality++;
                }
            }
        }

        intersection = "\n\u001B[43m\u001B[30m Lista1 contiene " + cardinality + intersection + " \033[0m\u001B[49m\n";

        return intersection;
    }

    private static void exerciseManager()
    {
        populateList(lista1, "prima lista");
        populateList(lista2, "seconda lista");

        System.out.print(intersectionCardinality());

        System.exit(0);
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\n\033[0;33m" +
                        "Esercizio 'Appartiene' 2023.05.08\n" +
                        "\033[0;36m 1\033[0;33m |\033[0m Vedi testo esercizio\n" +
                        "\033[0;36m 2\033[0;33m |\033[0m Utilizza programma\n" +
                        "\033[0;36m 0\033[0;33m |\033[0m Esci\n" +
                        "\033[0;32m >\033[0;33m |\033[0m ");
        int choice = scanner.nextInt();

        while(true)
        {
            switch(choice)
            {
                case 1 :
                    showText();

                    System.out.print("\033[0;33m" +
                            "Come vuoi procedere?\n" +
                            "\033[0;36m 1\033[0;33m |\033[0m Vedi testo esercizio\n" +
                            "\033[0;36m 2\033[0;33m |\033[0m Utilizza programma\n" +
                            "\033[0;36m 0\033[0;33m |\033[0m Esci\n" +
                            "\033[0;32m >\033[0;33m |\033[0m ");
                    choice = scanner.nextInt();

                    break;

                case 2 :
                    exerciseManager();
                    break;

                case 0 :
                    return;

                default :
                    System.out.print(
                            "\033[0;31m # |\033[0m Inserimento invalido, riprova!\n" +
                            "\033[0;32m >\033[0;33m |\033[0m ");
                    choice = scanner.nextInt();
            }
        }
    }
}