package net.bcsoft.panelreport;

import net.bcsoft.panelreport.Enum.ProvinciaEnum;

import java.sql.*;
import java.time.LocalDate;


public class Incasso {
    private LocalDate data = null;
    private ProvinciaEnum provincia;
    private Float importo;


    public Incasso(ResultSet resultSet) throws SQLException, IllegalArgumentException {
        this.data = resultSet.getDate(1).toLocalDate();
        this.provincia = ProvinciaEnum.valueOf(resultSet.getString(2));
        this.importo = resultSet.getFloat(3);
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public ProvinciaEnum getProvincia() {
        return provincia;
    }

    public void setProvincia(ProvinciaEnum provincia) {
        this.provincia = provincia;
    }

    public Float getImporto() {
        return importo;
    }

    public void setImporto(Float importo) {
        this.importo = importo;
    }
}
