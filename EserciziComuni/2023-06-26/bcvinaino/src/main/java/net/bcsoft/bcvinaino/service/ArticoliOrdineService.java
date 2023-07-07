package net.bcsoft.bcvinaino.service;

import net.bcsoft.bcvinaino.entity.ArticoliOrdine;
import net.bcsoft.bcvinaino.entity.dettaglio.ArticoliOrdiniCompleto;

import java.sql.Date;
import java.util.List;

public interface ArticoliOrdineService {

    List<ArticoliOrdine> selectAll();

    void insert(ArticoliOrdiniCompleto articoliOrdine, Long idOrdine);

    void deleteByIdOrdine(Long idOrdine);

    void deleteByDataOrdine(Date dataOrdine);
}
