package net.bcsoft.bcvinaino.service;

import net.bcsoft.bcvinaino.entity.Ordine;
import net.bcsoft.bcvinaino.entity.dettaglio.OrdineCompleto;

import java.sql.Date;
import java.util.List;

public interface OrdineService {
    List<Ordine> selectAll();

    OrdineCompleto select(Long id);

    List<Ordine> insert(OrdineCompleto ordineCompleto);

    List<Ordine> deleteByID(Long id);

    List<Ordine> deleteByData(Date data);
}
