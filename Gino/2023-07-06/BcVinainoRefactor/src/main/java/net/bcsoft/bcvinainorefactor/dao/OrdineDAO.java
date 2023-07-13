package net.bcsoft.bcvinainorefactor.dao;

import net.bcsoft.bcvinainorefactor.entity.Ordine;
import net.bcsoft.bcvinainorefactor.entity.dettaglio.OrdineCompleto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrdineDAO {
    List<Ordine> selectAll();

    void insert(Ordine ordine);

    void deleteById(Integer id);

    OrdineCompleto selectOrdineCompleto(Integer id);
}
