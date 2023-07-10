package net.bcsoft.BcVinaino.dao;

import net.bcsoft.BcVinaino.entity.ArticoliOrdine;
import net.bcsoft.BcVinaino.entity.dettaglio.ArticoliOrdineCompleto;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface ArticoliOrdineDAO {
    List<ArticoliOrdine> selectAll();
    void insert(@Param("articolo") ArticoliOrdineCompleto articolo, @Param("idOrdine") Integer idOrdine);
    void deletePerId(Integer id);
}