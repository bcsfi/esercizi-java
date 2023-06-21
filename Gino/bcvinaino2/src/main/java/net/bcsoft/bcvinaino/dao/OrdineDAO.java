package net.bcsoft.bcvinaino.dao;

import net.bcsoft.bcvinaino.entity.Ordine;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface OrdineDAO
{
    @Insert("INSERT INTO ordini (data_ordine) VALUES (#{dataOrdine}")
    @Options(useGeneratedKeys = true, keyProperty = "idOrdine", keyColumn = "id_ordine")
    public Long insert(Ordine ordine);

    @Update("UPDATE ordini SET data_ordine = #{dataOrdine} WHERE id_ordine = #{idOrdine}")
    public int update(Ordine ordine);

    @Select({"SELECT id_ordine, data_ordine FROM ordini ORDER BY id_ordine"})
    @Results(id = "ordine", value = {
            @Result(column = "id_ordine", property = "idOrdine", id = true),
            @Result(column = "data_ordine", property = "dataOrdine", jdbcType = JdbcType.DATE)
    })
    public List<Ordine> selectAll();

    @Select({"SELECT data_ordine FROM ordini WHERE id_ordine = #{idOrdine, jdbcType=NUMERIC}"})
    @ResultMap("ordine")
    public Ordine selectByPrimaryKey(Long ordineId);
}