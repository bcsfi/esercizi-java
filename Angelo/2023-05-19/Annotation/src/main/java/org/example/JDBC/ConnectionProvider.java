package org.example.JDBC;

import java.sql.*;

public class CreateDriver {
    private String IP_ADD, PORT, DATABASE_NAME, userNameDatabase, passwordDatabase;

    private Connection conn = null;


    public CreateDriver(String IP_ADD, String PORT, String DATABASE_NAME, String userNameDatabase, String passwordDatabase) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        this.IP_ADD=IP_ADD;
        this.PORT=PORT;
        this.DATABASE_NAME=DATABASE_NAME;
        this.userNameDatabase=userNameDatabase;
        this.passwordDatabase=passwordDatabase;
    }


    public Connection getConnection() throws SQLException, ClassNotFoundException {
        if (conn == null || (conn != null && conn.isClosed())) {
            conn = DriverManager.getConnection("jdbc:postgresql://" + IP_ADD + ":" + PORT + "/" + DATABASE_NAME, userNameDatabase, passwordDatabase);
        }
        return conn;
    }

    public void closeConnection() throws SQLException {
        conn.close();
        conn = null;
    }

}
