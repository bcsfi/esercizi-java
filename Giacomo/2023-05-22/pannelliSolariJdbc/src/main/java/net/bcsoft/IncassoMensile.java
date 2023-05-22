package net.bcsoft;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IncassoMensile
{
    private List<Incasso> incassoList = null;
    //private Path directoryPath;

    private String eccezioni;

    public IncassoMensile() throws IllegalArgumentException, DateTimeParseException, SQLException, ClassNotFoundException {
        this.eccezioni = "";
        caricareDatiFile();
    }

    /*public Path getDirectoryPath() {
        return directoryPath;
    }*/

    private void caricareDatiFile() throws SQLException, ClassNotFoundException {
        incassoList = new ArrayList<>();
        //Path filePath = Path.of(directoryPath.toString() + "\\file.txt");

        String query = "select * from incassi";
        Connection connection = ConnectionManager.createConnection();
        Statement statement = connection.createStatement(); //Inviare comandi SQL
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next())
        {
            try {
                Incasso incasso = buildIncasso(resultSet);
                incassoList.add(incasso);
            } catch (SQLException | IllegalArgumentException e) {
                eccezioni += resultSet.getString(2) + ";" + resultSet.getString(3) + ";" + resultSet.getString(4) + " Errore: " + e.getMessage();
            }

        }

        resultSet.close();
        statement.close();
        connection.close();

        //List<String> lineList = Files.readAllLines(filePath);
        Exception exception = null;

        /*for (String line:lineList)
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
        } */
    }



    public List<Incasso> getIncassoList()
    {
        return incassoList;
    }

    public String getEccezioni() {
        return eccezioni;
    }

    /*public void setEccezioni(String eccezioni) {
        this.eccezioni = eccezioni;
    }*/

    private static Incasso buildIncasso(ResultSet resultSet) throws SQLException {
        LocalDate date = resultSet.getDate(2).toLocalDate();
        ProvinciaEnum provincia = ProvinciaEnum.valueOf(resultSet.getString(3));
        Double importo = resultSet.getDouble(4);
        return new Incasso(date, provincia, importo);
    }
}
