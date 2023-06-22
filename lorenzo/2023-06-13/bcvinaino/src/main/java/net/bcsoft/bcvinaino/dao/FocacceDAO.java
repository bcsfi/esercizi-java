package net.bcsoft.bcvinaino.dao;

import net.bcsoft.bcvinaino.entity.Focaccia;
import net.bcsoft.bcvinaino.entity.Incasso;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FocacceDAO {
    @Select({
            "SELECT menu.focaccia AS nome, COALESCE(quantita_differente_zero.quantita, 0) AS quantita",
            "FROM menu LEFT JOIN(",
            "SELECT menu.id_menu AS id_quantita_differente_zero, SUM(articoli_ordine.qta) AS quantita",
            "FROM menu JOIN articoli_ordine ON menu.id_menu = articoli_ordine.id_menu",
            "JOIN ordini ON articoli_ordine.id_ordine = ordini.id_ordine",
            "WHERE ordini.data_ordine > CURRENT_DATE - interval '1 month'",
            "GROUP BY(menu.id_menu)",
            "HAVING(SUM(articoli_ordine.qta) != 0)",
            ") AS quantita_differente_zero ON menu.id_menu = quantita_differente_zero.id_quantita_differente_zero",
            "ORDER BY quantita DESC;"
    })
    @Results(id = "focacce30giorni", value = {
            @Result(column = "nome", property = "nome"),
            @Result(column = "quantita", property = "quantita")
    })
    public List<Focaccia> focaccePiuVendute30Giorni();

}
