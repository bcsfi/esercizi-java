package net.bcsoft.bcvinaino.service;

import net.bcsoft.bcvinaino.entity.ArticoliOrdine;
import org.springframework.stereotype.Service;


public interface ArticoliOrdineService {

    void insert(ArticoliOrdine articoliOrdine, long idOrdine);
}
