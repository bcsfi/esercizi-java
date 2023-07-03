package net.bcsoft.bcvinaino.service;

import net.bcsoft.bcvinaino.entity.dettaglio.ArticoliOrdineCompleto;


public interface ArticoliOrdineService {
    void insert(ArticoliOrdineCompleto articoliOrdine, Integer idOrdine);
    void deletePerIdOrdine(Integer id);
}
