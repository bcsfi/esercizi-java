package net.bcsoft.bcvinaino.mapper;

import net.bcsoft.bcvinaino.entity.ArticoliOrdine;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ArticoliOrdineMapper {
    @Insert({"INSERT INTO articoli_ordine(id_ordine, id_menu, qta) VALUES (#{idOrdine}, #{idMenu}, #{qta}) "})
    @Options(useGeneratedKeys = true, keyProperty = "idArticoliOrdine", keyColumn = "id_articoli_ordine")
    public Long insert(ArticoliOrdine articoliOrdine);
    @Update({"UPDATE articoli_ordine SET id_ordine = #{idOrdine}, id_menu = #{idMenu}, qta = #{qta} WHERE id_articoli_ordine = #{idArticoliOrdine}"})
    public int update(ArticoliOrdine articoliOrdine);
    @Select({
            "SELECT id_menu, focaccia, prezzo FROM menu ORDER BY id_menu"
    })
    @Results(id= "articoli_ordine", value = {
            @Result(column = "id_articoli_ordine", property = "idArticoliOrdine", id = true),
            @Result(column = "id_ordine", property = "idOrdine" ),
            @Result(column = "id_menu", property = "idMenu"),
            @Result(column = "qta", property = "qta")
    })
    public List <ArticoliOrdine> SelectAll();
    @Select({
            "SELECT id_articoli_ordine, id_ordine, id_menu, qta FROM articoli_ordine WHERE id_articoli_ordine = #{idArticoliOrdine, jdbcType=NUMERIC}"
    })
    @ResultMap("articoli_ordine")
    public ArticoliOrdine selectByPrimaryKey(Long idArticoliOrdine);
}
