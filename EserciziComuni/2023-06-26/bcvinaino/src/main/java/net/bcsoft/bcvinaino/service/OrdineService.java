package net.bcsoft.bcvinaino.service;

import net.bcsoft.bcvinaino.entity.Ordine;
import net.bcsoft.bcvinaino.entity.dettaglio.OrdineCompleto;
import org.springframework.stereotype.Service;


public interface OrdineService {
    Ordine insert(OrdineCompleto ordineCompleto);
}
