package net.bcsoft.bcvinaino.service;

import net.bcsoft.bcvinaino.entity.Ordine;
import net.bcsoft.bcvinaino.entity.dettaglio.OrdineCompleto;
import java.time.LocalDate;

public interface OrdineService {
    Ordine insert(OrdineCompleto ordineCompleto);

    void deleteOrdinePerId(Integer id);

   // List<OrdineFinale> getOrdineFinale(Integer id);
    OrdineCompleto getById(Integer id);

    void deleteOrdinePerData(LocalDate data);
}
