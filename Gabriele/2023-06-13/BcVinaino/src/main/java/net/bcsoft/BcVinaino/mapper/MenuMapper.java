package net.bcsoft.bcvinaino.mapper;

import java.util.List;
import net.bcsoft.bcvinaino.entity.Menu;
import org.apache.ibatis.annotations.*;

public interface MenuMapper {

    @Insert({"INSERT INTO menu (focaccia, prezzo) VALUES (#{focaccia}, #{prezzo}) "})
    @Options(useGeneratedKeys = true, keyProperty = "idMenu", keyColumn = "id_menu")
    public Long insert(Menu menu);

    @Update({"UPDATE menu SET focaccia = #{focaccia}, prezzo = #{prezzo} WHERE id_menu = #{idMenu}"})
    public int update(Menu menu);

    @Select({
            "SELECT id_menu, focaccia, prezzo FROM menu",
            "ORDER BY id_menu"
    })
    @Results(id = "menu", value = {
            @Result(column = "id_menu", property = "idMenu", id = true),
            @Result(column = "focaccia", property = "focaccia"),
            @Result(column = "prezzo", property = "prezzo")
    })
    public List <Menu> selectAll();

    @Select({
            "SELECT id_menu, focaccia, prezzo FROM menu WHERE id_menu = #{menuId, jdbcType=NUMERIC}" //con il cancelletto prende il parametro alla riga 26 e lo butta dentro
    })  //il jdbcType si usa quando menuId deve essere interpretato in un determinato tipo, qui in teoria non serve.
    @ResultMap("menu")
    public Menu selectByPrimaryKey(Long menuId);
}
