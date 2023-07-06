package net.bcsoft.bcvinaino.service;

import net.bcsoft.bcvinaino.entity.dettaglio.ArticoliOrdiniCompleto;

import java.sql.Date;

public interface ArticoliOrdineService {

    void insert(ArticoliOrdiniCompleto articoliOrdine, Long idOrdine);

    void deleteByIdOrdine(Long idOrdine);

    void deleteByDataOrdine(Date dataOrdine);
}
