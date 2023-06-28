package com.bcvinaini.bcvinaini.mapper.MapperNoXML;
import com.bcvinaini.bcvinaini.entity.Menu;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface MenuMapper {

    @Select({"select id_menu, focaccia, prezzo from menu"})
    @Results(id = "menu", value = {
            @Result(column = "id_menu", property = "id"),
            @Result(column = "focaccia", property = "focaccia"),
            @Result(column = "prezzo", property = "prezzo")
    })

    List<Menu> selectAll();

    @Insert("INSERT INTO menu (focaccia, prezzo) VALUES (#{focaccia}, #{prezzo})")
    @Options(useGeneratedKeys = true, keyProperty="id", keyColumn = "id_menu")
    public Long insert(Menu menu);

    @Update("UPDATE menu SET focaccia = #{focaccia}, prezzo = #{prezzo} WHERE id_menu = #{id}")
    public Long update(Menu menu);

    @Delete("DELETE FROM menu WHERE id = #{id}")
    public int deleteById(int id);

    @Select("SELECT id_menu, focaccia, prezzo from menu where id = #{id}")
    @ResultMap("menu")
    public Menu selectMenuById(int id);

}
