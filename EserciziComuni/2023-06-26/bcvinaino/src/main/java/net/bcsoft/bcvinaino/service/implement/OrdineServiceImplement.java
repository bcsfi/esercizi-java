package net.bcsoft.bcvinaino.service.implement;

import net.bcsoft.bcvinaino.dao.OrdineDAO;
import net.bcsoft.bcvinaino.entity.Ordine;
import net.bcsoft.bcvinaino.entity.dettaglio.ArticoliOrdineCompleto;
import net.bcsoft.bcvinaino.entity.dettaglio.OrdineCompleto;
import net.bcsoft.bcvinaino.service.ArticoliOrdineService;
import net.bcsoft.bcvinaino.service.OrdineService;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.NoRouteToHostException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrdineServiceImplement implements OrdineService {
    private final OrdineDAO ordineDAO;
    private final ArticoliOrdineService articoliOrdineService;

    public OrdineServiceImplement(OrdineDAO ordineDAO, ArticoliOrdineService articoliOrdineService) {
        this.ordineDAO = ordineDAO;
        this.articoliOrdineService = articoliOrdineService;
    }


    @Override
    public Ordine insert(OrdineCompleto ordineCompleto) {
        List<ArticoliOrdineCompleto> articoliOrdineList = ordineCompleto.getArticoliOrdineCompletoList();
        ordineDAO.insert(ordineCompleto);
        Integer idOrdine = ordineCompleto.getIdOrdine();

        for (ArticoliOrdineCompleto articolo : articoliOrdineList) {

            articoliOrdineService.insert(articolo, idOrdine);
        }
        return ordineCompleto;
    }

    @Override
    public List<Ordine> selectAll() {
        return ordineDAO.selectAll();
    }

    @Override
    public OrdineCompleto getById(Integer id) throws NotFoundException {
        if (id == null) {
            throw new IllegalArgumentException("ID NULLO");
        } else {
            if (this.ordineDAO.getById(id) == null) {
                throw new NotFoundException("ORDINE NON TROVATO");
            } else {
                return this.ordineDAO.getById(id);
            }
        }
    }

    @Override
    public void deleteOrdinePerId(Integer id) throws NotFoundException {
        if (this.ordineDAO.getIdOrdine(id) == null) {
            throw new NotFoundException("ORDINE NON TROVATO");
        } else {
            this.articoliOrdineService.deletePerIdOrdine(id);
            this.ordineDAO.deletePerId(id);
        }
    }

    @Override
    public void deleteOrdinePerData(LocalDate data){
        List<Integer> idOrdineEliminato = ordineDAO.getOrdiniPerData(data);

        for (Integer idOrdine : idOrdineEliminato) {
            articoliOrdineService.deletePerIdOrdine(idOrdine);
            ordineDAO.deletePerId(idOrdine);
        }
    }
}
