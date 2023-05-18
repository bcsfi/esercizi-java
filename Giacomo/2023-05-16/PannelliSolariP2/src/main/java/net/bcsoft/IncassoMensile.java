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

    public IncassoMensile(Path directoryPath) throws IOException, IllegalArgumentException, DateTimeParseException
    {
        this.directoryPath = directoryPath;
        caricareDatiFile();
    }

    public Path getDirectoryPath() {
        return directoryPath;
    }

    /*public void setDirectoryPath(Path directoryPath) {
        this.directoryPath = directoryPath;
    }*/

    private void caricareDatiFile() throws IOException, IllegalArgumentException, DateTimeParseException
    {
        incassoList = new ArrayList<>();
        Path filePath = Path.of(directoryPath.toString() + "\\file.txt");
        List<String> lineList = Files.readAllLines(filePath);

        for (String line:lineList)
        {
            Incasso incasso = new Incasso(line);
            incassoList.add(incasso);
        }
    }

    public List<Incasso> getIncassoList()
    {
        return incassoList;
    }
}
