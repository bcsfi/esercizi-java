package net.bcsoft.bcvinaino.dao;

import net.bcsoft.bcvinaino.entity.Ordine;
import net.bcsoft.bcvinaino.entity.dettaglio.OrdineCompleto;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Date;
import java.util.List;

@Mapper
public interface OrdineDAO {
    List<Ordine> selectAll();

    OrdineCompleto select(Long id);

    void insert(Ordine ordine);

    void deleteByID(Long id);

    void deleteByData(Date data);
}
