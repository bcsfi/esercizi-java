package net.bcsoft.bcvinaino.dao;

import net.bcsoft.bcvinaino.entity.ArticoliOrdine;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticoliOrdineDAO {
    List<ArticoliOrdine> selectAll();

    void insert(ArticoliOrdine articoliOrdine, long id_ordine);
}
