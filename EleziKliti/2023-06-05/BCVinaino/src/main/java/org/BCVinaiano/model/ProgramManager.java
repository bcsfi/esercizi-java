package org.BCVinaiano.model;

import org.BCVinaiano.jdbc.ConnectionProvider;

import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

public class ProgramManager {




    public static List<EarningsByData> createEraningByData(Connection connesione, String Query) throws ClassNotFoundException, SQLException {


        PreparedStatement preparedStatement = connesione.prepareStatement(Query);
        preparedStatement.setDouble(1, 2D);
        preparedStatement.setDouble(2, 8D);

        ResultSet catpureData = preparedStatement.executeQuery();
        List<EarningsByData> elencoByData = new ArrayList<>();

        Calendar cal = new GregorianCalendar();
        cal.add(Calendar.DAY_OF_MONTH, -15);


        Timestamp timestamp = new Timestamp(cal.getTimeInMillis());
        preparedStatement.setTimestamp(1, timestamp);

        Date sqlDate = new Date(cal.getTimeInMillis());

        preparedStatement.setDate(1, sqlDate);


        while (catpureData.next()){
            LocalDate data =  catpureData.getDate(1).toLocalDate();
            Double price = catpureData.getDouble(2);
            System.out.print(data);
            System.out.print(price);

            EarningsByData riga = new EarningsByData(data, price);
            elencoByData.add(riga);
        }

        catpureData.close();
        preparedStatement.close();

        return elencoByData;
    }

    public static List<OrderByFoccacia> createOrderByFoccacia(Connection connesione, String Query) throws ClassNotFoundException, SQLException {

        PreparedStatement preparedStatement = connesione.prepareStatement(Query);
        preparedStatement.setInt(1, 5);
        preparedStatement.setInt(2, 8);

        ResultSet catpureData = preparedStatement.executeQuery();
        List<OrderByFoccacia> elencoByFoccacia  = new ArrayList<>();

        while (catpureData.next()){
            String focaccia =  catpureData.getString(1);
            int ordinate = catpureData.getInt(2);
            OrderByFoccacia riga = new OrderByFoccacia(focaccia, ordinate);
            elencoByFoccacia.add(riga);
            System.out.print(focaccia);
        }

        catpureData.close();
        preparedStatement.close();

        return elencoByFoccacia;
    }

}
