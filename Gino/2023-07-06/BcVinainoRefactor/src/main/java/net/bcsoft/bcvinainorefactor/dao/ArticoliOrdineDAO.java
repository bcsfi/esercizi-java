package net.bcsoft.bcvinainorefactor.dao;

import net.bcsoft.bcvinainorefactor.entity.ArticoliOrdine;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ArticoliOrdineDAO {
    List<ArticoliOrdine> selectAll();

    void insert(@Param("articolo") ArticoliOrdine articoliOrdine, @Param("idOrdine") long idOrdine);

    void delete(Integer id);
}
