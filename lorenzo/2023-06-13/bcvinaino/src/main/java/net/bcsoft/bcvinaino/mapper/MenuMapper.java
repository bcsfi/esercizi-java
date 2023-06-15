package net.bcsoft.bcvinaino.mapper;

import net.bcsoft.bcvinaino.entity.Menu;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/*
@annotazione per passare a MyBatis dati
diachiarazione del metodo
 */

public interface MenuMapper {
    @Insert({"INSERT INTO menu (focaccia, prezzo) VALUES (#{focaccia}, #{prezzo})"})
    @Options(useGeneratedKeys = true, keyProperty = "idMenu", keyColumn = "id_menu")
    public Long insert(Menu menu);

    @Update("UPDATE menu SET focaccia = #{focaccia}, prezzo = #{prezzo} WHERE id_menu = #{id}")
    public int update(Menu menu); //è int perchè Mybatis restituisce il numero di righe aggiornate

    @Select({
            "SELECT id_menu, focaccia, prezzo FROM menu", //Concatenazione MyBatis
            "ORDER BY id_menu"
    })
    @Results(id = "menu", value = { // Mappatura select, deve esistere da qualche parte prima di usarlo
            @Result(column = "id_menu", property = "id", id = true),
            @Result(column = "focaccia", property = "focaccia"),
            @Result(column = "prezzo", property = "prezzo")
    })
    public List <Menu> selectAll();

    @Select({
            "SELECT id_menu,focaccia, prezzo FROM menu WHERE id_menu = #{menuId, jdbcType = NUMERIC}"
    })
    @ResultMap("menu") // Fai riferimento alla mappatura "menu" (riga 21)
    public Menu selectByPrimaryKey(Long menuId);
}
