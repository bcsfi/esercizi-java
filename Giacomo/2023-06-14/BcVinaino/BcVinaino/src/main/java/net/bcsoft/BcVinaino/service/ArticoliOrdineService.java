package net.bcsoft.BcVinaino.service;

import net.bcsoft.BcVinaino.entity.ArticoliOrdine;
import net.bcsoft.BcVinaino.entity.dettaglio.ArticoliOrdineCompleto;

import java.util.List;


public interface ArticoliOrdineService {
    void insert(ArticoliOrdineCompleto articoliOrdine, Integer idOrdine);
    void deletePerIdOrdine(Integer id);
    List<ArticoliOrdine> selectAll();
}