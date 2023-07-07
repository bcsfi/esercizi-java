package net.bcsoft.bcvinaino.service;

import net.bcsoft.bcvinaino.entity.Ordine;
import net.bcsoft.bcvinaino.entity.dettaglio.OrdineCompleto;

import java.sql.Date;
import java.util.List;

public interface OrdineService {
    List<Ordine> selectAll();

    List<Ordine> insert(OrdineCompleto ordineCompleto);

    List<Ordine> deleteByID(Long id);

    List<Ordine> deleteByData(Date data);
}
