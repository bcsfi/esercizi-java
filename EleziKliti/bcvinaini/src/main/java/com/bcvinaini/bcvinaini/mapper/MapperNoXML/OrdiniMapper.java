package com.bcvinaini.bcvinaini.mapper.MapperNoXML;

import com.bcvinaini.bcvinaini.dao.ResponseOrdineDAO;
import com.bcvinaini.bcvinaini.entity.Ordini;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface OrdiniMapper {

    @Select({"select id_ordine, data_ordine from ordini"})
    @Results(id = "ordine", value = {
            @Result(column = "id_ordine", property = "id"),
            @Result(column = "data_ordine", property = "data")
    })
    List<Ordini> selectAll();

    @Insert("INSERT INTO ordini (data_ordine) VALUES (#{data})")
    @Options(useGeneratedKeys = true, keyProperty="id", keyColumn = "id_ordine")
    public int insert(Ordini Ordini);

    @Update("UPDATE ordini SET id_ordini = #{id}, data_ordine = #{data} WHERE id_ordine = #{id}")
    public Long update(Ordini Ordini);

    @Delete("DELETE FROM ordini where id_ordini = #{id}")
    public int delete(int id);

    @Delete({
            "DELETE FROM articoli_ordine WHERE articoli_ordine.id_ordine = #{id};",
            "DELETE FROM ordini WHERE ordini.id_ordine = #{id}"
    })
    public int deleteAllOrderById(int id);

    @Select("SELECT id_ordine from ordini WHERE ordini.data_ordine = #{data}")
    public List<Integer> getIdOrderByData(Date data);

    @Delete("DELETE FROM ordini WHERE ordini.data_ordine = #{data}")
    public int deleteOrderByData(Date data);

    @Delete("DELETE FROM articoli_ordine WHERE articoli_ordine.id_ordine = #{idOrdine}")
    public int deleteArticoliById(int idOrdine);

    @Select({
            "SELECT data_ordine, COUNT(articoli_ordine) as menu_ordinati, focaccia, sum(prezzo) as costo_ordine, qta FROM",
            "ordini, articoli_ordine, menu",
            "WHERE",
            "#{id} = ordini.id_ordine AND",
            "ordini.id_ordine = articoli_ordine.id_ordine AND",
            "menu.id_menu = articoli_ordine.id_menu",
            "GROUP BY",
            "data_ordine, focaccia, prezzo, qta"
    })
    @Results(id="letturaOrdini", value = {
            @Result(column = "data_ordine", property = "data_ordine"),
            @Result(column = "menu_ordinati", property = "menu_ordinati"),
            @Result(column = "focaccia", property = "focaccia"),
            @Result(column = "costo_ordine", property = "costo_ordine"),
            @Result(column = "qta", property = "qta")
    })
    List<ResponseOrdineDAO> recoverOrderListForId(int id);



}
