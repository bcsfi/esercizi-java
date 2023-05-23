package net.bcsoft.panelreport;

import net.bcsoft.panelreport.Enum.ProvinciaEnum;
import net.bcsoft.panelreport.util.FileManager;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportCreator {
    private IncassoMensile incassoMensile = null;
    private String pathFinale;
    private Map<ProvinciaEnum, Float> mappaPerProvincia = new HashMap<>();
    private Map<LocalDate, Float> mappaPerData = new HashMap<>();

    public ReportCreator(String pathFinale) throws SQLException {
        this.pathFinale = pathFinale;
        incassoMensile = new IncassoMensile();
    }

    public void creaMappaPerProvincia() {
        List<Incasso> incassoList = incassoMensile.getIncassoList();
        for (Incasso incasso : incassoList) {
            if (!mappaPerProvincia.containsKey(incasso.getProvincia())) {
                mappaPerProvincia.put(incasso.getProvincia(), incasso.getImporto());
            } else {
                mappaPerProvincia.put(incasso.getProvincia(),
                        mappaPerProvincia.get(incasso.getProvincia()) +
                                incasso.getImporto());
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
        StringBuilder outputProvincia = new StringBuilder();
        for (ProvinciaEnum provincia : mappaPerProvincia.keySet()) {
            Float importo = mappaPerProvincia.get(provincia);
            outputProvincia.append("Provincia: " + provincia + " Importo: " + importo + "\n");
        }
        FileManager.buildFile(pathFinale, "Provincia.txt", outputProvincia.toString());

        StringBuilder outputData = new StringBuilder();
        for (LocalDate data : mappaPerData.keySet()) {
            Float importo = mappaPerData.get(data);
            outputData.append("Data: " + data + " Importo: " + importo + "\n");
        }
        FileManager.buildFile(pathFinale, "Data.txt", outputData.toString());
    }
}
