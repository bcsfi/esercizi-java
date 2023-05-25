package net.bcsoft.panelreport.util;

import net.bcsoft.panelreport.enumeration.ProvinciaEnum;
import net.bcsoft.panelreport.model.Incasso;
import net.bcsoft.panelreport.model.IncassoMensile;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportCreator {
    private String pathFinale;
    private Map<ProvinciaEnum, Float> mappaPerProvincia = new HashMap<>();
    private Map<LocalDate, Float> mappaPerData = new HashMap<>();

    public ReportCreator(String pathFinale) {
        this.pathFinale = pathFinale;
    }

    public void creaReport() throws SQLException {
        Connection connection = DatabaseConnection.createConnection();
        DatabaseManager databaseManager = new DatabaseManager(connection);
        ResultSet resultSet = databaseManager.ottieniResultSet(
                "select " +
                "id, " +
                "incassi_data, " +
                "incassi_provincia, " +
                "incassi_importo " +
                "from incassi");
        Elaboratore elaboratore = new Elaboratore();
        IncassoMensile incassoMensile = elaboratore.costruisciIncassoMensile(resultSet);
        //TODO partendo da incasso mensile, pdoduci i report tramite FileManager
    }

    public void creaMappaPerProvincia() {
        List<Incasso> incassoList = IncassoMensile.
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
        List<Incasso> incassoList = incassoMensile.getIncassoList() != null ? incassoMensile.getIncassoList() : Collections.emptyList();
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
