package net.bcsoft.bcvinaino.mapper;

import net.bcsoft.bcvinaino.entity.Ordini;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface OrdiniMapper {
    @Insert({"INSERT INTO ordini (data_ordine) VALUES (#{dataOrdine}) "})
    @Options(useGeneratedKeys = true, keyProperty = "idOrdine", keyColumn = "id_ordine")
    public Long insert(Ordini ordini);
    @Update({"UPDATE ordini SET data_ordine = #{dataOrdine}, WHERE id_ordine = #{idOrdine}"})
    public int update(Ordini ordini);
    @Select({
            "SELECT id_menu, focaccia, prezzo FROM menu ORDER BY id_menu"
    })
    @Results(id= "ordini", value = {
            @Result(column = "id_ordine", property = "idOrdine", id = true),
            @Result(column = "data_ordine", property = "dataOrdine", jdbcType = JdbcType.DATE)
    })
    public List<Ordini> SelectAll();
    @Select({
            "SELECT id_ordine, data_ordine FROM ordini WHERE id_ordine = #{idOrdine, jdbcType=NUMERIC}"
    })
    @ResultMap("ordini")
    public Ordini selectByPrimaryKey(Long idOrdine);
}
