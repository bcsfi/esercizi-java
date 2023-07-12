package net.bcsoft.bcvinaino.toDTO;

import net.bcsoft.bcvinaino.dto.OrdineDTO;
import net.bcsoft.bcvinaino.entity.Ordine;
import net.bcsoft.bcvinaino.service.implement.OrdineServiceImplement;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ToOrdineDTO {
    private final List <OrdineDTO> ordineDTOList;
    private final OrdineServiceImplement ordineServiceImplement;
    public ToOrdineDTO(List<OrdineDTO> ordineDTOList, OrdineServiceImplement ordineServiceImplement) {
        this.ordineDTOList = ordineDTOList;
        this.ordineServiceImplement = ordineServiceImplement;
    }

    public List <OrdineDTO> selectAllDTO(){
        List <Ordine> ordineList = ordineServiceImplement.selectAll();

        for(Ordine ordine : ordineList){
            OrdineDTO ordineDTO = new OrdineDTO(ordine);
            ordineDTOList.add(ordineDTO);
        }
        return ordineDTOList;
    }

}
