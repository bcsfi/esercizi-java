package net.bcsoft.bcvinaino.daos;

import net.bcsoft.bcvinaino.entity.Incasso;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface IncassiMensiliDAO {
    @Select({
            "SELECT ordini.data_ordine, SUM (menu.prezzo*articoli_ordine.qta) AS somma_totale",
            "FROM ordini JOIN articoli_ordine ON ordini.id_ordine = articoli_ordine.id_ordine",
            "JOIN menu ON articoli_ordine.id_menu = menu.id_menu",
            "WHERE ordini.data_ordine > (current_date - interval '1 month')",
            "GROUP BY ordini.data_ordine",
            "ORDER BY ordini.data_ordine DESC"
    })
    @Results(id = "incassi30giorni", value = {
            @Result(column = "data_ordine", property = "data"),
            @Result(column = "somma_totale", property = "somma")
    })
    public List<Incasso> incassiMensili();
}