package net.bcsoft.bcvinaino.mapper;

import net.bcsoft.bcvinaino.dto.OrdineDTO;
import net.bcsoft.bcvinaino.entity.Ordine;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrdineMapper {
    private OrdineDTO toDTO(Ordine ordine) {
        OrdineDTO dto = new OrdineDTO();
        dto.setIdOrdine(ordine.getIdOrdine());
        dto.setDataOrdine(ordine.getDataOrdine());
        return dto;
    }

    public List<OrdineDTO> toDTOs(List<Ordine> ordini) {
        return ordini.stream()
                .map(ordine -> this.toDTO(ordine))
                .collect(Collectors.toList());

    }
}
