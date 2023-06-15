package net.bcsoft.bcvinaino.mapper;

import net.bcsoft.bcvinaino.entity.Ordini;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface OrdiniMapper
{
    @Insert("INSERT INTO ordini (data_ordine) VALUES (#{dataOrdine}")
    @Options(useGeneratedKeys = true, keyProperty = "idOrdine", keyColumn = "id_ordine")
    public Long insert(Ordini ordine);

    @Update("UPDATE ordini SET data_ordine = #{dataOrdine} WHERE id_ordine = #{idOrdine}")
    public int update(Ordini ordine);

    @Select({"SELECT id_ordine, data_ordine FROM ordini ORDER BY id_ordine"})
    @Results(id = "ordine", value = {
            @Result(column = "id_ordine", property = "idOrdine", id = true),
            @Result(column = "data_ordine", property = "dataOrdine", jdbcType = JdbcType.DATE)
    })
    public List<Ordini> selectAll();

    @Select({"SELECT data_ordine FROM ordini WHERE id_ordine = #{idOrdine, jdbcType=NUMERIC}"})
    @ResultMap("ordine")
    public Ordini selectByPrimaryKey(Long ordineId);
}
