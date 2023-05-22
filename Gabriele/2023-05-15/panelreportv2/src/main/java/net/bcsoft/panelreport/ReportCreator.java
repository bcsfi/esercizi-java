package net.bcsoft.panelreport;

import net.bcsoft.panelreport.Enum.ProvinciaEnum;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.*;

public class ReportCreator {
    private IncassoMensile incassoMensile = null;
    private String pathFinale;
    private Map<ProvinciaEnum, Float> mappaPerProvincia = new HashMap<>();
    private Map<LocalDate, Float> mappaPerData = new HashMap<>();

    public ReportCreator( String pathFinale) throws IOException {
        this.pathFinale = pathFinale;
        incassoMensile = new IncassoMensile();
    }

    public void creaMappaPerProvincia() {
        List<Incasso> incassoList = incassoMensile.getIncassoList();
        for (Incasso incasso : incassoList) {
            if (!mappaPerProvincia.containsKey(incasso.getProvincia())) {
                mappaPerProvincia.put(incasso.getProvincia(), incasso.getImporto());
            } else {
                mappaPerProvincia.put(incasso.getProvincia(), mappaPerProvincia.get(incasso.getProvincia()) + incasso.getImporto());
            }
        }
    }

    public void creaMappaPerData() {
        List<Incasso> incassoList = incassoMensile.getIncassoList();
        for (Incasso incasso : incassoList) {
            if (!mappaPerData.containsKey(incasso.getData())) {
                mappaPerData.put(incasso.getData(), incasso.getImporto());
            } else {
                mappaPerData.put(incasso.getData(), mappaPerData.get(incasso.getData()) + incasso.getImporto());
            }
        }
    }

    public void stampaSuFile() throws IOException {
        Path pathProvincia = Path.of(pathFinale + "Provincia.txt");
        Files.deleteIfExists(pathProvincia);
        Files.createFile(pathProvincia);
        StringBuilder outputProvincia = new StringBuilder();
        for (ProvinciaEnum provincia : mappaPerProvincia.keySet()) {
            Float importo = mappaPerProvincia.get(provincia);
            outputProvincia.append("Provincia: " + provincia + " Importo: " + importo + "\n");
        }
        Files.writeString(pathProvincia, outputProvincia.toString());

        Path pathData = Path.of(pathFinale + "Data.txt");
        Files.deleteIfExists(pathData);
        Files.createFile(pathData);
        StringBuilder outputData = new StringBuilder();
        for (LocalDate data : mappaPerData.keySet()) {
            Float importo = mappaPerData.get(data);
            outputData.append("Data: " + data + " Importo: " + importo + "\n");
        }
        Files.writeString(pathData, outputData.toString());
    }
}
