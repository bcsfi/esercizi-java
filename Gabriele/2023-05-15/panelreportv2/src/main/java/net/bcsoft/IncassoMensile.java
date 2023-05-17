package net.bcsoft;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IncassoMensile {
    private List<Incasso> incassoList = null;

    public IncassoMensile(String pathIniziale) throws IOException {
        List<String> righeFile;
        Path path = Path.of(pathIniziale);
        boolean exist = Files.exists(path);
        if (!exist) {
            throw new IOException("FILE INESISTENTE");
        }
        righeFile = Files.readAllLines(path);
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
