package net.bcsoft.bcvinaino.daos;

import net.bcsoft.bcvinaino.entity.Ordini;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrdiniDAO {
    @Select({
            "SELECT o.id_ordine, o.data_ordine, SUM(m.prezzo * ao.qta) AS incasso_ordine",
            "FROM ordini o",
            "INNER JOIN articoli_ordine ao ON o.id_ordine = ao.id_ordine",
            "INNER JOIN menu m ON ao.id_menu = m.id_menu",
            "WHERE o.data_ordine > CURRENT_DATE - INTERVAL '30 day'",
            "GROUP BY o.id_ordine, o.data_ordine",
            "ORDER BY o.data_ordine DESC;"
    })
    @Results(id="ordiniSettimana", value = {
            @Result(column = "id_ordine", property = "idOrdine"),
            @Result(column = "data_ordine", property = "dataOrdine"),
            @Result(column = "incasso_ordine", property = "incassoOrdine")
    })
    public List<Ordini> incassoSettimana();
}