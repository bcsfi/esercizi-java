package net.bcsoft.bcvinaino.service;

import net.bcsoft.bcvinaino.entity.Ordine;
import net.bcsoft.bcvinaino.entity.dettaglio.OrdineCompleto;

import java.time.LocalDate;
import java.util.Date;


public interface OrdineService {
    Ordine insert(OrdineCompleto ordineCompleto);

    void deleteOrdinePerId(Integer id);
    void deleteOrdinePerData(LocalDate date);
}
