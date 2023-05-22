package net.bcsoft.panelreport;

import net.bcsoft.panelreport.Enum.ProvinciaEnum;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class IncassoMensile {
    private List<Incasso> incassoList = null;

    public IncassoMensile(){
        incassoList = new ArrayList<>();
        try {
            String query = "SELECT incassi_data, incassi_provincia, incassi_importo, incassi_id FROM incassi";
            Connection connection = ConnectorManager.createConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            try {
                while (resultSet.next()) {
                    Incasso incassoCorrente = new Incasso(resultSet);
                    incassoList.add(incassoCorrente);
                }
            }finally{
                resultSet.close();
                statement.close();
                connection.close();
            }
        } catch (SQLException | ClassNotFoundException e) {
            Logger.addException(String.valueOf(e.getMessage()));
        }
    }

    public List<Incasso> getIncassoList() {
        return incassoList;
    }
}
