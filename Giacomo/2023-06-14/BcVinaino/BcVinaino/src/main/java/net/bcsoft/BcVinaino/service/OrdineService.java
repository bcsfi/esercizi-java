package net.bcsoft.BcVinaino.service;

import net.bcsoft.BcVinaino.entity.Ordine;
import net.bcsoft.BcVinaino.entity.dettaglio.OrdineCompleto;
import java.time.LocalDate;
import java.util.List;

public interface OrdineService {
    Ordine insert(OrdineCompleto ordineCompleto);
    List<Ordine> selectAll();
    void deleteOrdinePerId(Integer id);

    // List<OrdineFinale> getOrdineFinale(Integer id);
    OrdineCompleto getById(Integer id);

    void deleteOrdinePerData(LocalDate data);
}