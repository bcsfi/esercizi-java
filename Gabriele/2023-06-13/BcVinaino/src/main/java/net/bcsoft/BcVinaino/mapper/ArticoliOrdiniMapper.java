package net.bcsoft.bcvinaino.mapper;

import net.bcsoft.bcvinaino.entity.ArticoliOrdini;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ArticoliOrdiniMapper {
    @Insert({"INSERT INTO articoli_ordine (id_ordine, id_menu, qta) VALUES (#{id_ordine}, #{id_menu}, #{qta}) "})
    @Options(useGeneratedKeys = true, keyProperty = "idArticoliOrdine", keyColumn = "id_articoli_ordine")
    public Long insert(ArticoliOrdini articoliOrdini);

    @Update({"UPDATE articoli_ordine SET id_ordine = #{idOrdine}, id_menu = #{idMenu}, qta = #{qta} WHERE id_articoli_ordine = #{idArticoliOrdine}"})
    public int update(ArticoliOrdini articoliOrdini);

    @Select({
            "SELECT id_articoli_ordine, id_menu, id_ordine, qta FROM articoli_ordine",
            "ORDER BY id_articoli_ordine"
    })
    @Results(id = "articoli_ordine", value = {
            @Result(column = "id_articoli_ordine", property = "idArticoliOrdine", id = true),
            @Result(column = "id_menu", property = "idMenu"),
            @Result(column = "id_ordine", property = "idOrdine"),
            @Result(column = "qta", property = "qta")
    })
    public List<ArticoliOrdini> selectAll();

    @Select({
            "SELECT id_articoli_ordine, id_menu, id_ordine, qta FROM articoli_ordine WHERE id_articoli_ordine = #{articoliOrdineId, jdbcType=NUMERIC}" //con il cancelletto prende il parametro alla riga 26 e lo butta dentro
    })  //il jdbcType si usa quando menuId deve essere interpretato in un determinato tipo, qui in teoria non serve.
    @ResultMap("articoli_ordine")
    public ArticoliOrdini selectByPrimaryKey(Long articoliOrdineId);
}
