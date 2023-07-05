package net.bcsoft.bcvinaino.service;

import net.bcsoft.bcvinaino.entity.Ordine;
import net.bcsoft.bcvinaino.entity.dettaglio.OrdineCompleto;
import org.apache.ibatis.javassist.NotFoundException;

import java.time.LocalDate;
import java.util.List;

public interface OrdineService {
    Ordine insert(OrdineCompleto ordineCompleto);
    List<Ordine> selectAll();
    void deleteOrdinePerId(Integer id) throws NotFoundException;

   // List<OrdineFinale> getOrdineFinale(Integer id);
    OrdineCompleto getById(Integer id) throws NotFoundException;

    void deleteOrdinePerData(LocalDate data) throws NotFoundException;
}
