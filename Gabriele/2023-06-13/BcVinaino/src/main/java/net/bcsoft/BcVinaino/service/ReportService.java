package net.bcsoft.bcvinaino.service;

import net.bcsoft.bcvinaino.entity.ArticoliOrdini;
import net.bcsoft.bcvinaino.entity.Menu;
import net.bcsoft.bcvinaino.entity.Ordini;
import net.bcsoft.bcvinaino.mapper.ArticoliOrdiniMapper;
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
    OrdiniMapper ordiniMapper;
    @Autowired
    ArticoliOrdiniMapper articoliOrdiniMapper;

    public String calcolaIncassi(){
        String report = null;
        List <ArticoliOrdini> articoliOrdiniList= articoliOrdiniMapper.selectAll();
        List <Menu> menuList = menuMapper.selectAll();
        List <Ordini> ordiniList = ordiniMapper.selectAll();


        return report;
    }
}
