package net.bcsoft.bcvinaino.service;

import net.bcsoft.bcvinaino.entity.Ordine;
import net.bcsoft.bcvinaino.entity.dettaglio.OrdineCompleto;

import java.sql.Date;
import java.util.List;

public interface OrdineService {
    List<Ordine> getAll();

    OrdineCompleto get(Long id);

    List<Ordine> create(OrdineCompleto ordineCompleto);

    List<Ordine> deleteByID(Long id);

    List<Ordine> deleteByData(Date data);
}
