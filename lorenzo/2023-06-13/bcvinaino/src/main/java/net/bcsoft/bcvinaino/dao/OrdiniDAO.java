package net.bcsoft.bcvinaino.dao;

import net.bcsoft.bcvinaino.entity.Ordine;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrdiniDAO {
    @Select({
            "SELECT ordini.id_ordine, ordini.data_ordine, SUM(menu.prezzo * articoli_ordine.qta) AS incasso_ordine",
            "FROM ordini JOIN articoli_ordine ON ordini.id_ordine = articoli_ordine.id_ordine",
            "JOIN menu ON articoli_ordine.id_menu = menu.id_menu",
            "WHERE ordini.data_ordine > CURRENT_DATE - interval '7 day'",
            "GROUP BY(ordini.id_ordine)",
            "ORDER BY(ordini.data_ordine) DESC;"
    })
    @Results(id="ordini7giorni", value = {
            @Result(column = "id_ordine", property = "idOrdine"),
            @Result(column = "data_ordine", property = "dataOrdine"),
            @Result(column = "incasso_ordine", property = "incassoOrdine")
    })
    public List<Ordine> incassoGiornaliero7Giorni();
}
