package net.bcsoft.panelreport2;

import net.bcsoft.panelreport2.Exception.LetturaFileException;
import net.bcsoft.panelreport2.Exception.ProvinciaErrataException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class IncassoMensile {
    private List<Incasso> incassoList = null;

    public IncassoMensile(String pathIniziale) throws LetturaFileException, ProvinciaErrataException {
        List<String> righeFile;
        Path path = Path.of(pathIniziale);
        boolean exist = Files.exists(path);
        if (!exist) {
            throw new LetturaFileException();
        }
        try{
            righeFile = Files.readAllLines(path);
        } catch (IOException e) {
            throw new LetturaFileException();
        }
        incassoList = new ArrayList<>();
        List<String> fileLetto = righeFile;

        for (int i = 0; i < fileLetto.size(); i++) {
            Incasso incassoCorrente = new Incasso(fileLetto.get(i));
            incassoList.add(incassoCorrente);
        }
    }

    public List<Incasso> getIncassoList() {
        return incassoList;
    }
}
