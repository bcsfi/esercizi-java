package com.bcvinaini.bcvinaini.services;

import com.bcvinaini.bcvinaini.entity.ArticoliOrdine;
import com.bcvinaini.bcvinaini.entity.Menu;
import com.bcvinaini.bcvinaini.entity.Ordini;
import com.bcvinaini.bcvinaini.entity.tmp.FocacceTMP;
import com.bcvinaini.bcvinaini.entity.tmp.IncassiTmp;
import com.bcvinaini.bcvinaini.entity.tmp.OrdiniTmp;
import com.bcvinaini.bcvinaini.mapper.MapperNoXML.ArticoliOrdiniMapper;
import com.bcvinaini.bcvinaini.mapper.MapperNoXML.MenuMapper;
import com.bcvinaini.bcvinaini.mapper.MapperNoXML.OrdiniMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.logging.Handler;


@Component
public class ReportService {

    @Autowired
    MenuMapper menuMapper;

    @Autowired
    OrdiniMapper ordiniMapper;

    @Autowired
    ArticoliOrdiniMapper articoliOrdiniMapper;


    public String getReportOrdini(){

        List<Menu> tabellaMenu = menuMapper.selectAll();
        List<Ordini> tabellaOrdini = ordiniMapper.selectAll();
        List<ArticoliOrdine> tabellaArticoliOrdini = articoliOrdiniMapper.selectAll();

        ArrayList<OrdiniTmp> listaOrdiniDTO = new ArrayList<>();

        for(Ordini ordine : tabellaOrdini){

            OrdiniTmp ordineTmp = new OrdiniTmp();
            boolean contains;

            if(listaOrdiniDTO.contains(ordineTmp)){
                contains = false;
            } else {
                listaOrdiniDTO.add(ordineTmp);
                ordineTmp.setIdOrdine(ordine.getId());
                ordineTmp.setGiorno(ordine.getData());
                contains=true;
            }

            if(contains)
            {
                for(ArticoliOrdine articolo : tabellaArticoliOrdini)
                {
                    if(Objects.equals(ordine.getId(), articolo.getIdOrdine()))
                    {
                        for(Menu menu : tabellaMenu)
                        {
                            if(Objects.equals(menu.getId(), articolo.getIdMenu()))
                            {
                                ordineTmp.setImportoTotale(ordineTmp.sumImportTotale(menu.getPrezzo()));
                            }
                        }
                    }
                }
            }

        }

        String html = "<html> <body>";

        html += "ID ";
        html += "GIORNO ";
        html += "       IMPORTO  " + "</br>";

        for(OrdiniTmp ordine: listaOrdiniDTO){
            html += ordine.getIdOrdine() + "  ";
            html += ordine.getGiorno() + "  ";
            html += ordine.getImportoTotale() + "$ <br> ";
        }

        html += "</body></html>";

        return html;
    }

    public String getReportIncassi(){

        List<Menu> tabellaMenu = menuMapper.selectAll();
        List<Ordini> tabellaOrdini = ordiniMapper.selectAll();
        List<ArticoliOrdine> tabellaArticoliOrdini = articoliOrdiniMapper.selectAll();

        HashMap<Date, Double> mappa = new HashMap<Date, Double>();
        List<IncassiTmp> listaIncassi = new ArrayList<>();


        for(Ordini ordine : tabellaOrdini)
        {

            if(mappa.containsKey(ordine.getData())){
                System.out.print("elemento già presente");
            } else {


                    IncassiTmp incasso = new IncassiTmp();


                    for(ArticoliOrdine articolo : tabellaArticoliOrdini)
                    {
                        if(articolo.getIdOrdine().equals(ordine.getId()))
                        {
                            for(Menu menu : tabellaMenu){
                                if(menu.getId().equals(articolo.getIdMenu()))
                                {
                                    incasso.sommaIncasso(menu.getPrezzo());
                                }
                            }
                        }
                    }

                    incasso.setGiorno(ordine.getData());
                    mappa.put(incasso.getGiorno(), incasso.getIncassi());
                    listaIncassi.add(incasso);

                System.out.print("Aggiunto!");
            }


        }



        String html = "<html> <body>";

        html += "INCASSO ";
        html += "GIORNO " + "</br>";

        for(IncassiTmp incasso: listaIncassi){
            System.out.print(incasso.getIncassi());
            html += incasso.getIncassi() + "  ";
            html += incasso.getGiorno() + " </br> ";
        }


        html += "</body></html>";

        return html;
    }

    public String getReportFocacce(){


        List<Menu> tabellaMenu = menuMapper.selectAll();
        List<Ordini> tabellaOrdini = ordiniMapper.selectAll();
        List<ArticoliOrdine> tabellaArticoliOrdini = articoliOrdiniMapper.selectAll();
        List<FocacceTMP> listaRiusltatiFocacce = new ArrayList<FocacceTMP>();

        for(Menu menu : tabellaMenu){

            FocacceTMP focaccia = new FocacceTMP();
            focaccia.setFocacce(menu.getFocaccia());

            for(ArticoliOrdine articolo : tabellaArticoliOrdini){
                if(articolo.getIdMenu().equals(menu.getId())){
                    for(Ordini ordine : tabellaOrdini){
                        if(ordine.getId().equals(articolo.getIdOrdine())){
                            focaccia.summOrdine(1);
                            System.out.print("Ordini aggiornati");
                        }
                    }
                }
            }

            listaRiusltatiFocacce.add(focaccia);

        }


        String html = "<html>";

        for(FocacceTMP focacce : listaRiusltatiFocacce){
            html += focacce.getFocacce() + "  ";
            html += focacce.getOrdiniTotali() + "</br>";
        }

        return html;
    }

    public String getReportSogliaOrdini(int varSoglia){
        int soglia = varSoglia;

        List<Menu> tabellaMenu = menuMapper.selectAll();
        List<Ordini> tabellaOrdini = ordiniMapper.selectAll();
        List<ArticoliOrdine> tabellaArticoliOrdini = articoliOrdiniMapper.selectAll();
        List<FocacceTMP> listaRiusltatiFocacce = new ArrayList<FocacceTMP>();

        for(Menu menu : tabellaMenu){

            FocacceTMP focaccia = new FocacceTMP();
            focaccia.setFocacce(menu.getFocaccia());

            for(ArticoliOrdine articolo : tabellaArticoliOrdini){
                if(articolo.getIdMenu().equals(menu.getId())){
                    for(Ordini ordine : tabellaOrdini){
                        if(ordine.getId().equals(articolo.getIdOrdine())){
                            focaccia.summOrdine(1);
                        }
                    }
                }
            }

            if(focaccia.getOrdiniTotali() >= soglia){
                listaRiusltatiFocacce.add(focaccia);
            }
        }

        String html = "<html>";

        for(FocacceTMP focacce : listaRiusltatiFocacce){
            html += focacce.getFocacce() + "  ";
            html += focacce.getOrdiniTotali() + "<br>";
        }

        return html;
    }
}
