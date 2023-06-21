package net.bcsoft.bcvinaino.dao;

import net.bcsoft.bcvinaino.entity.ArticoliOrdine;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ArticoliOrdineDAO {
    @Insert({"INSERT INTO articoli_ordine (id_ordine,id_menu,qta) VALUES (#{idOrdine},#{idMenu},#{qta})"})
    @Options(useGeneratedKeys = true, keyProperty = "idArticoliOrdine", keyColumn = "id_articoli_ordine")
    public Long insert(ArticoliOrdine articoliOrdine);

    @Update("UPDATE ordini SET data_ordine = #{dataOrdine} WHERE id_ordine = #{idOrdini}")
    public int update(ArticoliOrdine articoliOrdine); //è int perchè Mybatis restituisce il numero di righe aggiornate

    @Select({
            "SELECT id_articoli_ordine, id_ordine, id_menu,qta FROM articoli_ordine", //Concatenazione MyBatis
            "ORDER BY id_articoli_ordine"
    })
    @Results(id = "articoli_ordine", value = { // Mappatura select, deve esistere da qualche parte prima di usarlo
            @Result(column = "id_articoli_ordine", property = "idArticoliOrdine", id = true),
            @Result(column = "id_menu", property = "idMenu"),
            @Result(column = "id_ordine", property = "idOrdine"),
            @Result(column = "qta", property = "qta"),
    })
    public List<ArticoliOrdine> selectAll();

    @Select({
            "SELECT id_articoli_ordine, id_ordine, id_menu, qta FROM ordini WHERE id_articoli_ordine = #{idArticoliOrdine, jdbcType = NUMERIC}"
    })
    @ResultMap("articoli_ordine")
    public ArticoliOrdine selectByPrimaryKey(Long idArticoliOrdine);
}
