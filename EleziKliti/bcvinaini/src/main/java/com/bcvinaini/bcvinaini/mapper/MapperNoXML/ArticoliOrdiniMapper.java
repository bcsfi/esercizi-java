package com.bcvinaini.bcvinaini.mapper.MapperNoXML;
import com.bcvinaini.bcvinaini.entity.ArticoliOrdine;
import com.bcvinaini.bcvinaini.entity.Ordini;
import org.apache.ibatis.annotations.*;
import java.util.List;


@Mapper
public interface ArticoliOrdiniMapper {

    @Select({"select id_articoli_ordine, id_ordine, id_menu, qta from articoli_ordine"})
    @Results(id = "articoli", value = {
            @Result(column = "id_articoli_ordine", property = "idArticoliOrdine"),
            @Result(column = "id_ordine", property = "idOrdine"),
            @Result(column = "id_menu", property = "idMenu"),
            @Result(column = "qta", property = "qta")
            })

    public List<ArticoliOrdine> selectAll();


    @Insert("INSERT INTO articoli_ordine (id_ordine, id_menu, qta) VALUES (#{idOrdine}, #{idMenu}, #{qta})")
    @Options(useGeneratedKeys = true, keyProperty="idArticoliOrdine", keyColumn = "id_articoli_ordine")
    public Long insert(ArticoliOrdine ArticoliOrdine);

    @Update("UPDATE ordini SET id_articoli_ordine = #{idArticoliOrdine}, id_ordine = #{idOrdine}, id_menu = #{idMenu} WHERE id_articoli_ordine = #{idArticoliOrdine}")
    public Long update(ArticoliOrdine ArticoliOrdine);

    @Delete("DELETE FROM articoli_ordine WHERE id_articoli_ordine = #{id}")
    public int deleteById(int id);



}
