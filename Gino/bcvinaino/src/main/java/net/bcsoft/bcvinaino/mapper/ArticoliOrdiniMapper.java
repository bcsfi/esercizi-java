package net.bcsoft.bcvinaino.mapper;

import net.bcsoft.bcvinaino.entity.ArticoliOrdine;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ArticoliOrdiniMapper
{
    @Insert("INSERT INTO articoli_ordine (id_ordine, id_menu, qta) VALUES (#{idOrdine}, #{idMenu}, #{qta})")
    @Options(useGeneratedKeys = true, keyProperty = "idOrdine", keyColumn = "id_ordine")
    public Long insert(ArticoliOrdine menu);

    @Update("UPDATE ordini SET id_ordine = #{idOrdine}, id_menu = #{idMenu}, qta = #{qta} WHERE id_articoli_ordine = #{idArticoliOrdine}")
    public int update(ArticoliOrdine articoliOrdine);

    @Select({"SELECT id_ordine, id_menu, qta FROM articoli_ordine ORDER BY id_articoli_ordine"})
    @Results(id = "articoliOrdine", value = {
            @Result(column = "id_articoli_ordine", property = "idArticoliOrdine", id = true),
            @Result(column = "id_ordine", property = "idOrdine"),
            @Result(column = "id_menu", property = "idMenu"),
            @Result(column = "qta", property = "qta")
    })
    public List<ArticoliOrdine> selectAll();

    @Select({"SELECT id_ordine, id_menu, qta FROM articoli_ordine WHERE id_articoli_ordine = #{idArticoliOrdine, jdbcType=NUMERIC}"})
    @ResultMap("articoliOrdine")
    public ArticoliOrdine selectByPrimaryKey(Long idArticoliOrdine);
}
