package net.bcsoft.bcvinainorefactor.mapper;

import net.bcsoft.bcvinainorefactor.dto.ArticoliOrdineDTO;
import net.bcsoft.bcvinainorefactor.dto.OrdineCompletoDTO;
import net.bcsoft.bcvinainorefactor.dto.OrdineDTO;
import net.bcsoft.bcvinainorefactor.entity.ArticoliOrdine;
import net.bcsoft.bcvinainorefactor.entity.Ordine;
import net.bcsoft.bcvinainorefactor.entity.dettaglio.OrdineCompleto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrdineMapper {
    public OrdineCompleto toOrdineCompleto(OrdineCompletoDTO dto) {
        OrdineCompleto ordineCompleto = new OrdineCompleto();
        ordineCompleto.setId(dto.id);
        ordineCompleto.setData(dto.data);
        List<ArticoliOrdine> articoli = new ArrayList<>();
        for (ArticoliOrdineDTO articoliOrdineDTO : dto.articoli) {
            ArticoliOrdine articoliOrdine = new ArticoliOrdine();
            articoliOrdine.setQuantita(articoliOrdineDTO.quantita);
            articoliOrdine.setIdMenu(articoliOrdineDTO.idMenu);
            articoli.add(articoliOrdine);
        }
        ordineCompleto.setArticoli(articoli);
        return ordineCompleto;
    }

    public List<OrdineDTO> toDTOLista(List<Ordine> ordini) {
        return ordini.stream().map(this::toDTO).collect(Collectors.toList());
    }

    private OrdineDTO toDTO(Ordine ordine) {
        OrdineDTO dto = new OrdineDTO();
        dto.id = ordine.getId();
        dto.data = ordine.getData();
        return dto;
    }
}
