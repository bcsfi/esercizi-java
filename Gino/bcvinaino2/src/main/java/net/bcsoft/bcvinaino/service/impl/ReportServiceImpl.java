package net.bcsoft.bcvinaino.service.impl;

import net.bcsoft.bcvinaino.entity.ArticoliOrdine;
import net.bcsoft.bcvinaino.entity.Menu;
import net.bcsoft.bcvinaino.entity.Ordine;
import net.bcsoft.bcvinaino.dao.ArticoliOrdineDAO;
import net.bcsoft.bcvinaino.dao.MenuDAO;
import net.bcsoft.bcvinaino.dao.OrdineDAO;
import net.bcsoft.bcvinaino.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    MenuDAO menuDAO;

    @Autowired
    ArticoliOrdineDAO articoliOrdineDAO;

    @Autowired
    OrdineDAO ordineDAO;

    @Override
    public String getFocacce() {
        List<Menu> menuList = menuDAO.selectAll();
        List<ArticoliOrdine> articoliOrdineList = articoliOrdineDAO.selectAll();
        List<Ordine> ordiniList = ordineDAO.selectAll();

        StringBuffer response = new StringBuffer();
        int quantita;

        for (Menu menu : menuList) {
            quantita = 0;

            for (ArticoliOrdine articoliOrdine : articoliOrdineList) {
                if (menu.getIdMenu() == articoliOrdine.getIdMenu()) {
                    for (Ordine ordine : ordiniList) {
                        if (articoliOrdine.getIdOrdine() == ordine.getIdOrdine() && LocalDate.now().minusMonths(1).isBefore(ordine.getDataOrdine())) {
                            quantita += articoliOrdine.getQta();
                        }
                    }
                }
            }

            response.append(menu.getFocaccia()).append(" ").append(quantita).append("<br>");
        }

        return response.toString();
    }

    @Override
    public String getIncassi() {
        List<Menu> menuList = menuDAO.selectAll();
        List<ArticoliOrdine> articoliOrdineList = articoliOrdineDAO.selectAll();
        List<Ordine> ordiniList = ordineDAO.selectAll();

        StringBuffer response = new StringBuffer();
        double totale;

        LocalDate endDate = LocalDate.now().minusMonths(1);
        LocalDate startDate = LocalDate.now();

        for (LocalDate date = startDate; date.isAfter(endDate); date = date.minusDays(1)) {
            totale = 0D;

            for (Ordine ordine : ordiniList) {
                if (date.getDayOfMonth() == ordine.getDataOrdine().getDayOfMonth()) {
                    for (ArticoliOrdine articoliOrdine : articoliOrdineList) {
                        if (ordine.getIdOrdine() == articoliOrdine.getIdOrdine()) {
                            for (Menu menu : menuList) {
                                if (articoliOrdine.getIdMenu() == menu.getIdMenu()) {
                                    totale += articoliOrdine.getQta() * menu.getPrezzo();
                                }
                            }
                        }
                    }
                }
            }

            response.append(date).append(" ").append(totale).append("<br>");
        }

        return response.toString();
    }

    @Override
    public String getOrdini(LocalDate dataInput) {
        List<Menu> menuList = menuDAO.selectAll();
        List<ArticoliOrdine> articoliOrdineList = articoliOrdineDAO.selectAll();
        List<Ordine> ordiniList = ordineDAO.selectAll();

        StringBuffer response = new StringBuffer();
        double totale;

        LocalDate startDate = LocalDate.now();

        for (LocalDate data = startDate; data.isAfter(dataInput); data = data.minusDays(1)) {
            totale = 0D;

            for (Ordine ordine : ordiniList) {
                if (data.getDayOfMonth() == ordine.getDataOrdine().getDayOfMonth()) {
                    for (ArticoliOrdine articoliOrdine : articoliOrdineList) {
                        if (ordine.getIdOrdine() == articoliOrdine.getIdOrdine()) {
                            for (Menu menu : menuList) {
                                if (articoliOrdine.getIdMenu() == menu.getIdMenu()) {
                                    totale += articoliOrdine.getQta() * menu.getPrezzo();
                                }
                            }
                        }
                    }
                }
            }

            response.append(data).append(" ").append(totale).append("<br>");
        }

        return response.toString();
    }

    @Override
    public String getSogliaOrdini(Double min, Double max) {
        List<Menu> menuList = menuDAO.selectAll();
        List<ArticoliOrdine> articoliOrdineList = articoliOrdineDAO.selectAll();
        List<Ordine> ordiniList = ordineDAO.selectAll();

        StringBuffer response = new StringBuffer();
        double totale;

        LocalDate endDate = LocalDate.now().minusMonths(1);
        LocalDate startDate = LocalDate.now();

        for (LocalDate data = startDate; data.isAfter(endDate); data = data.minusDays(1)) {
            totale = 0D;

            for (Ordine ordine : ordiniList) {
                if (startDate.getDayOfMonth() == ordine.getDataOrdine().getDayOfMonth()) {
                    for (ArticoliOrdine articoliOrdine : articoliOrdineList) {
                        if (ordine.getIdOrdine() == articoliOrdine.getIdOrdine()) {
                            for (Menu menu : menuList) {
                                if (articoliOrdine.getIdMenu() == menu.getIdMenu()) {
                                    totale += articoliOrdine.getQta() * menu.getPrezzo();
                                }
                            }
                        }
                    }
                }
            }
            if (min < totale && totale < max){
                response.append(data).append(" ").append(totale).append("<br>");
            }
        }

        return response.toString();
    }
}
