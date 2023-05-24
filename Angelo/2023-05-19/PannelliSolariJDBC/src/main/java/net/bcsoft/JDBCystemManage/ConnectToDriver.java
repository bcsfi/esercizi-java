package net.bcsoft.JDBCystemManage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToDriver {

    CreateDriver driver;

    public ConnectToDriver (CreateDriver driver)  {
        this.driver = driver;
    }

    public Connection activeConnection() throws SQLException {

        Connection pannelli_solari = DriverManager.getConnection("jdbc:postgresql://"+ driver.getIP_ADDRESS() + ":" + driver.getPORT() + "/" + driver.getDATABASENAME(), "postgres", "3237" );
        return pannelli_solari;
    }


}
