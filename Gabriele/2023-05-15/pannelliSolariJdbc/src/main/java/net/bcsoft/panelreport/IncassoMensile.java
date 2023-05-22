package net.bcsoft.panelreport;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class IncassoMensile {
    private List<Incasso> incassoList = null;

    public IncassoMensile(String pathIniziale) throws IOException {
        Path path = Path.of(pathIniziale);
        List<String> righeList = Files.readAllLines(path);
        incassoList = new ArrayList<>();

        for (String riga : righeList) {
            try {
                Incasso incassoCorrente = new Incasso(riga);
                incassoList.add(incassoCorrente);
            } catch (IOException e) {
                Logger.addException(String.valueOf(e.getMessage()));
            }
        }
    }

    public List<Incasso> getIncassoList() {
        return incassoList;
    }
}
