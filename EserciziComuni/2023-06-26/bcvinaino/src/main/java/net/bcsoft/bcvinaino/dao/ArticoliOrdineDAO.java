package net.bcsoft.bcvinaino.dao;

import net.bcsoft.bcvinaino.entity.ArticoliOrdine;
import net.bcsoft.bcvinaino.entity.dettaglio.ArticoliOrdiniCompleto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;

@Mapper
public interface ArticoliOrdineDAO {
    List<ArticoliOrdine> selectAll();

    void insert(@Param("articolo") ArticoliOrdiniCompleto articoliOrdine, @Param("idOrdine") Long idOrdine);

    void deleteByIdOrdine(Long idOrdine);

    void deleteByDataOrdine(Date dataOrdine);
}
