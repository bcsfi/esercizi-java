package net.bcsoft.bcvinaino.daos;

import net.bcsoft.bcvinaino.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MenuDAO {
    @Select({
            "SELECT menu.focaccia AS nome, SUM(articoli_ordine.qta) AS qta_articoli",
            "FROM menu",
            "LEFT JOIN articoli_ordine ON menu.id_menu = articoli_ordine.id_menu",
            "JOIN ordini ON articoli_ordine.id_ordine = ordini.id_ordine",
            "WHERE ordini.data_ordine > CURRENT_DATE - interval '1 month'",
            "GROUP BY menu.focaccia",
            "HAVING SUM(articoli_ordine.qta) IS NOT NULL AND SUM(articoli_ordine.qta) != 0",
            "ORDER BY qta_articoli DESC;"
    })
    @Results(id = "focaccePerOrdine", value = {
            @Result(column = "nome", property = "nome"),
            @Result(column = "qta_articoli", property = "qta")
    })
    public List<Menu> focaccePerOrdine();

}
