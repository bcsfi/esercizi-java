package net.bcsoft.bcvinaino.service;

import net.bcsoft.bcvinaino.entity.ArticoliOrdine;
import net.bcsoft.bcvinaino.entity.Menu;
import net.bcsoft.bcvinaino.entity.Ordini;
import net.bcsoft.bcvinaino.mapper.ArticoliOrdineMapper;
import net.bcsoft.bcvinaino.mapper.MenuMapper;
import net.bcsoft.bcvinaino.mapper.OrdiniMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {
    @Autowired
    MenuMapper menuMapper;
    @Autowired
    ArticoliOrdineMapper articoliOrdineMapper;
    @Autowired
    OrdiniMapper ordiniMapper;
    public String calcolaIncassi(){
        String report = "";

        List<Menu> menuList = menuMapper.selectAll();
        List<ArticoliOrdine> articoliOrdineList = articoliOrdineMapper.SelectAll();
        List<Ordini> ordiniList = ordiniMapper.SelectAll();

        return report;
    }
}
