package net.bcsoft.panelreport;

import net.bcsoft.panelreport.util.DatabaseConnection;
import net.bcsoft.panelreport.util.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class IncassoMensile {
    private List<Incasso> incassoList = null;

    public IncassoMensile() throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DatabaseConnection.createConnection();
            statement = connection.createStatement();
            incassoList = new ArrayList<>();

            String query = "select id, incassi_data, incassi_provincia, incassi_importo from incassi";
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                try {
                    Incasso incassoCorrente = new Incasso(resultSet);
                    incassoList.add(incassoCorrente);
                } catch (SQLException | IllegalArgumentException e) {
                    Logger.addException(String.valueOf(e.getMessage()));
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            Logger.addException(String.valueOf(e.getMessage()));
        } finally {
            resultSet.close();
            statement.close();
            connection.close();
        }
    }

    public List<Incasso> getIncassoList() {
        return incassoList;
    }
}
