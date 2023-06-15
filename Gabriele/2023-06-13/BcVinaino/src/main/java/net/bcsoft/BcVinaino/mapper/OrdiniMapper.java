package net.bcsoft.bcvinaino.mapper;

import net.bcsoft.bcvinaino.entity.Menu;
import net.bcsoft.bcvinaino.entity.Ordini;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.Date;
import java.util.List;

public interface OrdiniMapper {

    @Insert({"INSERT INTO ordini (data_ordine) VALUES (#{dataOrdine}) "})
    @Options(useGeneratedKeys = true, keyProperty = "idOrdine", keyColumn = "id_ordine")
    public Long insert (Ordini ordine);

    @Update({"UPDATE ordini SET data_ordijne = #{dataOrdine} WHERE id_ordine = #{idOrdine}"})
    public int update(Ordini ordini);

    @Select({
            "SELECT id_ordine, data_ordine FROM ordini",
            "ORDER BY id_ordine"
    })
    @Results(id = "ordine", value = {
            @Result(column = "id_ordine", property = "idOrdine", id = true),
            @Result(column = "data_ordine", property = "dataOrdine", jdbcType = JdbcType.DATE),
    })
    public List<Ordini> selectAll();

    @Select({
            "SELECT id_ordine, data_ordine FROM ordini WHERE id_ordine = #{ordineId, jdbcType=NUMERIC}" //con il cancelletto prende il parametro alla riga 26 e lo butta dentro
    })  //il jdbcType si usa quando menuId deve essere interpretato in un determinato tipo, qui in teoria non serve.
    @ResultMap("ordini")
    public Menu selectByPrimaryKey(Long ordineId);
}
