package net.bcsoft.bcvinaino.service;

import net.bcsoft.bcvinaino.entity.ArticoliOrdine;
import net.bcsoft.bcvinaino.entity.dettaglio.ArticoliOrdiniCompleto;
import org.springframework.stereotype.Service;


public interface ArticoliOrdineService {
    void insert(ArticoliOrdiniCompleto articoliOrdine);
    void deletePerId(Integer id);
}
