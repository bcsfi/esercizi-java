package net.bcsoft.Function;

import net.bcsoft.DataObject.Incasso;
import net.bcsoft.Enum.provinciaEnum;
import net.bcsoft.JDBCystemManage.ConnectToDriver;
import net.bcsoft.JDBCystemManage.CreateDriver;
import net.bcsoft.JDBCystemManage.SendQueryToDriver;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;

public class RaccoltaIncassi {

    private ArrayList<Incasso> listaIncassi = new ArrayList<Incasso>();

    CreateDriver driver = new CreateDriver("localhost","5432","pannelli_solari");
    ConnectToDriver conessioneDriver = new ConnectToDriver(driver);
    SendQueryToDriver commandMaster = new SendQueryToDriver(conessioneDriver);

    ResultSet setDiDatiLetti = commandMaster.sendCommand("SELECT * FROM incassi");


    public RaccoltaIncassi() throws SQLException, ClassNotFoundException {

            while (setDiDatiLetti.next()){
                Timestamp data = setDiDatiLetti.getTimestamp(2);
                LocalDate localDate = data.toLocalDateTime().toLocalDate();
                Incasso ogggettoIncasso = new Incasso(localDate, provinciaEnum.valueOf(setDiDatiLetti.getString(3)), setDiDatiLetti.getDouble(4));
                listaIncassi.add(ogggettoIncasso);
            }

    }

     public ArrayList<Incasso> getLista(){
        return this.listaIncassi;
     }


}
