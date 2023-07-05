package net.bcsoft.bcvinaino.service;

import net.bcsoft.bcvinaino.entity.ArticoliOrdine;
import net.bcsoft.bcvinaino.entity.dettaglio.ArticoliOrdineCompleto;
import java.util.List;


public interface ArticoliOrdineService {
    void insert(ArticoliOrdineCompleto articoliOrdine, Integer idOrdine);
    void deletePerIdOrdine(Integer id);
    List <ArticoliOrdine> selectAll();
}
