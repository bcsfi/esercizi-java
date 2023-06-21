package net.bcsoft.bcvinaino.service;

import net.bcsoft.bcvinaino.entity.ArticoliOrdine;
import net.bcsoft.bcvinaino.entity.Menu;
import net.bcsoft.bcvinaino.entity.Ordini;
import net.bcsoft.bcvinaino.mapper.ArticoliOrdiniMapper;
import net.bcsoft.bcvinaino.mapper.MenuMapper;
import net.bcsoft.bcvinaino.mapper.OrdiniMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service // sarebbe un tipo @component
public class ReportServiceImpl implements ReportService
{
    @Autowired
    MenuMapper menuMapper;

    @Autowired
    ArticoliOrdiniMapper articoliOrdiniMapper;

    @Autowired
    OrdiniMapper ordiniMapper;

    @Override
    public String calcolaIncassi()
    {
        String report = "";

        List<Menu> menuList = menuMapper.selectAll();
        List<ArticoliOrdine> articoliOrdiniList = articoliOrdiniMapper.selectAll();
        List<Ordini> ordiniList = ordiniMapper.selectAll();
        
        return report;
    }

    @Override
    public String getOrdini(LocalDate dataInput) {
        List<Menu> menuList = menuMapper.selectAll();
        List<ArticoliOrdine> articoliOrdineList = articoliOrdiniMapper.selectAll();
        List<Ordini> ordiniList = ordiniMapper.selectAll();

        StringBuffer response = new StringBuffer();
        double totale;

        LocalDate startDate = LocalDate.now();

        for (LocalDate data = startDate; data.isAfter(dataInput); data = data.minusDays(1))
        {
            totale = 0D;

            for (Ordini ordine : ordiniList)
            {
                if (dataInput.getDayOfMonth() == ordine.getDataOrdine().getDayOfMonth())
                {
                    for (ArticoliOrdine articoliOrdine : articoliOrdineList)
                    {
                        if (ordine.getIdOrdine() == articoliOrdine.getIdOrdine())
                        {
                            for (Menu menu : menuList)
                            {
                                if (articoliOrdine.getIdMenu() == menu.getIdMenu())
                                {
                                    totale += articoliOrdine.getQta() * menu.getPrezzo();
                                }
                            }
                        }
                    }
                }
            }

            response.append(data).append(" ").append(totale).append("\n");
        }

        return response.toString();
    }
}
