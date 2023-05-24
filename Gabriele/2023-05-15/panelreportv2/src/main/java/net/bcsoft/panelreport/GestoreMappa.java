package net.bcsoft.panelreport;

import net.bcsoft.panelreport.Enum.ProvinciaEnum;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestoreMappa {
    private Map <ProvinciaEnum, Float> mappaPerProvincia = new HashMap<>();
    private Map<LocalDate, Float> mappaPerData = new HashMap<>();
    IncassoMensile incassoMensile = new IncassoMensile();

    public Map <ProvinciaEnum, Float> creaMappaPerProvincia() {
        List<Incasso> incassoList = incassoMensile.getIncassoList();
        for (Incasso incasso : incassoList) {
            if (!mappaPerProvincia.containsKey(incasso.getProvincia())) {
                mappaPerProvincia.put(incasso.getProvincia(), incasso.getImporto());
            } else {
                mappaPerProvincia.put(incasso.getProvincia(), mappaPerProvincia.get(incasso.getProvincia()) + incasso.getImporto());
            }
        }
        return mappaPerProvincia;
    }

    public Map <LocalDate, Float> creaMappaPerData() {
        List<Incasso> incassoList = incassoMensile.getIncassoList();
        for (Incasso incasso : incassoList) {
            if (!mappaPerData.containsKey(incasso.getData())) {
                mappaPerData.put(incasso.getData(), incasso.getImporto());
            } else {
                mappaPerData.put(incasso.getData(), mappaPerData.get(incasso.getData()) + incasso.getImporto());
            }
        }
        return mappaPerData;
    }
}
