package net.bcsoft.bcvinaino.dao;

import net.bcsoft.bcvinaino.entity.Menu;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper // Da controllare se include anche @Component
@Component
public interface MenuDAO {
    @Insert("INSERT INTO menu (focaccia, prezzo) VALUES (#{focaccia}, #{prezzo})")
    @Options(useGeneratedKeys = true, keyProperty = "idMenu", keyColumn = "id_menu")
    public Long insert(Menu menu);

    @Update("UPDATE menu SET focaccia = #{focaccia}, prezzo = #{prezzo} WHERE id_menu = #{idMenu}")
    public int update(Menu menu);

    @Select({"SELECT id_menu, focaccia, prezzo FROM menu ORDER BY id_menu"})
    @Results(id = "menu", value = {@Result(column = "id_menu", property = "idMenu", id = true), @Result(column = "focaccia", property = "focaccia"), @Result(column = "prezzo", property = "prezzo")})
    public List<Menu> selectAll();

    @Select({"SELECT id_menu, focaccia, prezzo FROM menu WHERE id_menu = #{idMenu, jdbcType=NUMERIC}"})
    @ResultMap("menu")
    public Menu selectByPrimaryKey(Long menuId);
}
