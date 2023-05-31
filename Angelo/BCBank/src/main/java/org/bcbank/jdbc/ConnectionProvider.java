package org.bcbank.jdbc;
import java.sql.*;

public class ConnectionProvider {

    private String ipAdd, port, databaseName, userNameDatabase, passwordDatabase;
    private Connection conn = null;

    public ConnectionProvider(String ipAdd, String port, String databaseName, String userNameDatabase, String passwordDatabase) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        this.ipAdd=ipAdd;
        this.port=port;
        this.databaseName=databaseName;
        this.userNameDatabase=userNameDatabase;
        this.passwordDatabase=passwordDatabase;
    }


    public Connection getConnection() throws SQLException, ClassNotFoundException {
        if (conn == null || (conn != null && conn.isClosed())) {
            conn = DriverManager.getConnection("jdbc:postgresql://" + ipAdd + ":" + port + "/" + databaseName, userNameDatabase, passwordDatabase);
        }
        return conn;
    }

    public void closeConnection() throws SQLException {
        conn.close();
        conn = null;
    }

}

