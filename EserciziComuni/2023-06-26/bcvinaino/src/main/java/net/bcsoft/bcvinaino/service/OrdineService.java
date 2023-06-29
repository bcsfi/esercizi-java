package net.bcsoft.bcvinaino.service;

import net.bcsoft.bcvinaino.entity.Ordine;
import net.bcsoft.bcvinaino.entity.dettaglio.OrdineCompleto;
import net.bcsoft.bcvinaino.entity.dettaglio.OrdineFinale;

import java.time.LocalDate;
import java.util.List;


public interface OrdineService {
    Ordine insert(OrdineCompleto ordineCompleto);

    void deleteOrdinePerId(Integer id);

    List<OrdineFinale> getOrdineCompleto(Integer id);

    void deleteOrdinePerData(LocalDate data);
}
