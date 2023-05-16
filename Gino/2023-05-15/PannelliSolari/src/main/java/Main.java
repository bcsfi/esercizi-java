import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main
{
    public static void main(String[] args)
    {
        String desktopPath = System.getProperty("user.home") + "/Desktop";
        Path filePath = Path.of(desktopPath, "file.txt");

        if (!Files.exists(filePath))
        {
            System.out.println("Il file 'file.txt' non esiste.");
            return;
        }

        Path newFilePath = Path.of(desktopPath, "report.txt");

        if (!Files.exists(newFilePath))
        {
            try
            {
                Files.createFile(newFilePath);
                System.out.println("Il file 'report.txt' è stato creato.");
            }
            catch (IOException e)
            {
                System.out.println("Impossibile creare il file 'report.txt'. Errore: " + e.getMessage());
                return;
            }
        }

        try (BufferedReader br1 = new BufferedReader(new FileReader(filePath.toFile()));
             BufferedReader br2 = new BufferedReader(new FileReader(newFilePath.toFile())))
        {
            String line1;
            String line2;

            while (line1 == br1.readLine()) != null)
            {
                String[] parts1 = line1.split(";");
                String[] parts2 = line2.split(";");

                while (line2 = br2.readLine()) != null)
                {

                /*for (String part1 : parts1)
                {
                    System.out.println(part1);
                }

                for (String part2 : parts2)
                {
                    System.out.println(part2);
                }*/
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
