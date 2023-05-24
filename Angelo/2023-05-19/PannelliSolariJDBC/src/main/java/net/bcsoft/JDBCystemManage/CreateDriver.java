package net.bcsoft.JDBCystemManage;

import java.sql.SQLException;

public class CreateDriver {

    String IP_ADDRESS = "", PORT, DATABASENAME;

    public CreateDriver(String IP_ADDRESS, String PORT, String DATABASENAME) throws ClassNotFoundException, SQLException, NullPointerException {
        Class.forName("org.postgresql.Driver");
        this.IP_ADDRESS = IP_ADDRESS;
        this.PORT = PORT;
        this.DATABASENAME = DATABASENAME;
    }
    

    public String getIP_ADDRESS(){
        return this.IP_ADDRESS;
    }

    public String getPORT(){
        return this.PORT;
    }

    public String getDATABASENAME(){
        return this.DATABASENAME;
    }

}
