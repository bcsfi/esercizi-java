package net.bcsoft;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class IncassoMensile
{
    private List<Incasso> incassoList = null;
    private Path directoryPath;

    private String eccezioni;

    public IncassoMensile(Path directoryPath) throws IOException, IllegalArgumentException, DateTimeParseException//, Exception
    {
        this.directoryPath = directoryPath;
        this.eccezioni = "";
        caricareDatiFile();
    }

    public Path getDirectoryPath() {
        return directoryPath;
    }

    /*public void setDirectoryPath(Path directoryPath) {
        this.directoryPath = directoryPath;
    }*/

    private void caricareDatiFile() throws IOException//, Exception
    {
        incassoList = new ArrayList<>();
        Path filePath = Path.of(directoryPath.toString() + "\\file.txt");
        List<String> lineList = Files.readAllLines(filePath);
        Exception exception = null;

        for (String line:lineList)
        {
            try
            {
                Incasso incasso = new Incasso(line);
                incassoList.add(incasso);
            }
            catch (IllegalArgumentException | DateTimeParseException e)
            {
                eccezioni += line + "  -  " + e.getClass().getName() + "  -  " + e.getMessage() + "\n";
            }
        }

        /*if (exception != null)
        {
            throw exception;
        }*/
    }

    public List<Incasso> getIncassoList()
    {
        return incassoList;
    }

    public String getEccezioni() {
        return eccezioni;
    }

    public void setEccezioni(String eccezioni) {
        this.eccezioni = eccezioni;
    }
}
