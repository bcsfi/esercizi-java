import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

public class GameStore {
    private static ArrayList<VideoGame> videoGames = new ArrayList<>();

    private static void addGame()
    {
        Scanner scanner = new Scanner(System.in);

        Set<Character> correctValues = Set.of('c', 'p');

        String titolo, piattaforma, requisitiDiSistema;
        double prezzo;
        int anno;
        char tipo;

        System.out.print("\nAdding video game\n  title | ");
        titolo = scanner.nextLine();

        System.out.print("  price | ");
        prezzo = scanner.nextDouble();

        System.out.print(" relase | ");
        anno = scanner.nextInt();

        System.out.print("   type | Is this a console ('c') or PC ('p') video game?  | ");
        tipo = scanner.next().charAt(0);

        while (!correctValues.contains(tipo))
        {
            System.out.print("      # | Error, the value entered is incorrect, try again | ");
            tipo = scanner.next().charAt(0);
        }

        if (tipo == 'c')
        {
            System.out.print("        | Which platform does the game belong to?\n        | ");
            piattaforma = scanner.nextLine();
            scanner.nextLine();
            VideoGame consoleGame = new ConsoleGame(titolo, prezzo, anno, piattaforma);
            videoGames.add(consoleGame);
        } else {
            System.out.print("        | What are the minimum system requirements?\n        | ");
            requisitiDiSistema = scanner.nextLine();
            scanner.nextLine();
            VideoGame pCGames = new PCGame(titolo, prezzo, anno, requisitiDiSistema);
            videoGames.add(pCGames);
        }
    }

    public static void seeGames()
    {
        System.out.println();
        for (int i = 0; i < videoGames.size(); i++) {
            System.out.println(videoGames.get(i).toString());
        }
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        Set<Character> correctValues = Set.of('a', 's', 'e');
        Character scelta = 'e';

        System.out.print("\nExercise: \"GameStore\"");

        do {
            System.out.print("\nWhat do you want to do?\n" +
                                " a | Add a game\n" +
                                " s | See all the games\n" +
                                " e | Exit\n" +
                                "   | ");
            scelta = scanner.next().charAt(0);

            while (!correctValues.contains(scelta))
            {
                System.out.print("\n # | Error, the value entered is incorrect,\n # | please try again: ");
                scelta = scanner.next().charAt(0);
            }

            switch(scelta)
            {
                case 'a' -> addGame();
                case 's' -> seeGames();
                //case 'e' -> scelta = aruSure();
            }
        } while (scelta != 'e');
    }
}