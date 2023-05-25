package net.bcsoft.panelreport.util;

import net.bcsoft.panelreport.enumeration.ProvinciaEnum;
import net.bcsoft.panelreport.model.Incasso;
import net.bcsoft.panelreport.model.IncassoMensile;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Elaboratore {
    public Elaboratore() {
    }

    public IncassoMensile costruisciIncassoMensile(ResultSet resultSet) throws SQLException {
        LocalDate data;
        ProvinciaEnum provincia;
        Float importo;

        List<Incasso> incassoList = new ArrayList<>();
        List<String> incassiSbagliati = new ArrayList<>();
        while (resultSet.next()) {
            try {
                data = resultSet.getDate(2).toLocalDate();
                provincia = ProvinciaEnum.valueOf(resultSet.getString(3));
                importo = resultSet.getFloat(4);

                Incasso incassoCorrente = new Incasso(data, provincia, importo);
                incassoList.add(incassoCorrente);
            } catch (SQLException | IllegalArgumentException e) {
                //incassiSbagliati.add(stringa che rappresenta la riga del db piu' eccezione piu' a capo
                Logger.addException(String.valueOf(e.getMessage())); //potenzialmente non serve più
            }
        }
        return new IncassoMensile(incassoList, incassiSbagliati);
    }
}
