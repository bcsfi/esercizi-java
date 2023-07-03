package net.bcsoft.bcvinaino.service;

import net.bcsoft.bcvinaino.entity.Ordine;
import net.bcsoft.bcvinaino.entity.dettaglio.OrdineCompleto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


public interface OrdineService {
//    Ordine insert(OrdineCompleto ordineCompleto);
    void deleteOrdineByID(Long id);
    void deleteOrdineByData(LocalDate data);
}
