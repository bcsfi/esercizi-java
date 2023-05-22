package net.bcsoft.panelreport;

import net.bcsoft.panelreport.Enum.ProvinciaEnum;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class Incasso {
    private LocalDate data;
    private ProvinciaEnum provincia;
    private Float importo;
    private String pathFinale;

    public Incasso(ResultSet resultSet) throws SQLException, IllegalArgumentException {
        this.data = resultSet.getDate(2).toLocalDate();
        this.provincia = ProvinciaEnum.valueOf(resultSet.getString(3));
        this.importo = resultSet.getFloat(4);
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

    public void setPathFinale(String pathFinale) {
        this.pathFinale = pathFinale;
    }
}
