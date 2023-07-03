package net.bcsoft.bcvinaino.dao;

import net.bcsoft.bcvinaino.entity.ArticoliOrdine;
import net.bcsoft.bcvinaino.entity.dettaglio.ArticoliOrdineCompleto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ArticoliOrdineDAO {
    List<ArticoliOrdine> selectAll();

    void insert(@Param("articolo") ArticoliOrdineCompleto articolo, @Param("idOrdine") Integer idOrdine);
    void deletePerId(Integer id);
}
