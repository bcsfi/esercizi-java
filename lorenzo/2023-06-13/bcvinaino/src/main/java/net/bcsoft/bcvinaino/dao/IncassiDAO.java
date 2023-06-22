package net.bcsoft.bcvinaino.dao;

import net.bcsoft.bcvinaino.entity.Incasso;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface IncassiDAO {
    @Select({
            "SELECT ordini.data_ordine AS giorno, SUM (menu.prezzo*articoli_ordine.qta) AS somma_totale",
            "FROM ordini JOIN articoli_ordine ON ordini.id_ordine = articoli_ordine.id_ordine",
            "JOIN menu ON articoli_ordine.id_menu = menu.id_menu",
            "WHERE ordini.data_ordine > (current_date - interval '1 month')",
            "GROUP BY ordini.data_ordine",
            "ORDER BY ordini.data_ordine DESC"
    })
    @Results(id = "incassi30giorni", value = {
            @Result(column = "giorno", property = "data"),
            @Result(column = "somma_totale", property = "sommaTotale")
    })
    public List<Incasso> incassi30Giorni();
}
