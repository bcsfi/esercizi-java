package net.bcsoft.BcVinaino.dao;


import net.bcsoft.BcVinaino.entity.Ordine;
import net.bcsoft.BcVinaino.entity.dettaglio.OrdineCompleto;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface OrdiniDAO {
    List<Ordine> selectAll();

    Long insert(Ordine ordine);

    void deletePerId(Integer id);

    List<Integer> getOrdiniPerData(LocalDate data);


    OrdineCompleto getById(Integer id);

    boolean getIdOrdine(Integer id);
}