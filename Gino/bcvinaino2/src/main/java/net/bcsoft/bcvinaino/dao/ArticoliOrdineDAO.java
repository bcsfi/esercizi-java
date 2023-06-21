package net.bcsoft.bcvinaino.dao;

import net.bcsoft.bcvinaino.entity.ArticoliOrdine;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ArticoliOrdineDAO {
    @Insert("INSERT INTO articoli_ordine (id_ordine, id_menu, qta) VALUES (#{idOrdine}, #{idMenu}, #{qta})")
    @Options(useGeneratedKeys = true, keyProperty = "idOrdine", keyColumn = "id_ordine")
    Long insert(ArticoliOrdine menu);

    @Update("UPDATE ordini SET id_ordine = #{idOrdine}, id_menu = #{idMenu}, qta = #{qta} WHERE id_articoli_ordine = #{idArticoliOrdine}")
    int update(ArticoliOrdine articoliOrdine);

    @Select({"SELECT id_articoli_ordine, id_ordine, id_menu, qta FROM articoli_ordine ORDER BY id_articoli_ordine"})
    @Results(id = "articoliOrdine", value = {
            @Result(column = "id_articoli_ordine", property = "idArticoliOrdine", id = true),
            @Result(column = "id_ordine", property = "idOrdine"),
            @Result(column = "id_menu", property = "idMenu"),
            @Result(column = "qta", property = "qta")
    })
    List<ArticoliOrdine> selectAll();

    @Select({"SELECT id_ordine, id_menu, qta FROM articoli_ordine WHERE id_articoli_ordine = #{idArticoliOrdine, jdbcType=NUMERIC}"})
    @ResultMap("articoliOrdine")
    ArticoliOrdine selectByPrimaryKey(Long idArticoliOrdine);
}
