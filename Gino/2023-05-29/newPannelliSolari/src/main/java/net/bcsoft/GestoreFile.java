package net.bcsoft;

import net.bcsoft.model.Incasso;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class GestoreFile <T>
{
    public GestoreFile() {}

    private static String creaStringaRisultatiCorretti(List<Incasso> incassiCorretti)
    {
        String incassiCorrettiS = "";

        for (Incasso incasso : incassiCorretti)
        {
            incassiCorrettiS += incasso.getData() + " | " + incasso.getProvincia() + " | " + incasso.getImporto() + "\n";
        }

        return incassiCorrettiS;
    }

    public static void creaFile(List<Incasso> incassiCorretti, String incassiErrati, String path) throws IOException
    {
        Files.deleteIfExists(Path.of(path + "risultato.txt"));
        Files.deleteIfExists(Path.of(path + "errori.txt"));

        if (!incassiCorretti.isEmpty())
        {
            Path path1 = Path.of(path + "risultato.txt");
            Path path2 = Files.createFile(path1);
            Files.writeString(path2, creaStringaRisultatiCorretti(incassiCorretti));
        }

        if (!incassiErrati.isEmpty())
        {
            Files.writeString(Files.createFile(Path.of(path + "errori.txt")), incassiErrati);
        }
    }
}
