package net.bcsoft.bcvinaino.service;

import net.bcsoft.bcvinaino.entity.Ordine;
import net.bcsoft.bcvinaino.entity.dettaglio.OrdineCompleto;


public interface OrdineService {
    Ordine insert(OrdineCompleto ordineCompleto);

    void deleteOrdinePerData(Integer id);
}
