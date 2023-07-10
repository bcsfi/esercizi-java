package net.bcsoft.BcVinaino.service.implement;

import net.bcsoft.BcVinaino.dao.OrdiniDAO;
import net.bcsoft.BcVinaino.entity.Ordine;
import net.bcsoft.BcVinaino.entity.dettaglio.ArticoliOrdineCompleto;
import net.bcsoft.BcVinaino.entity.dettaglio.OrdineCompleto;
import net.bcsoft.BcVinaino.service.ArticoliOrdineService;
import net.bcsoft.BcVinaino.service.OrdineService;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrdineServiceImplement implements OrdineService {
    private final OrdiniDAO ordineDAO;
    private final ArticoliOrdineService articoliOrdineService;

    public OrdineServiceImplement(OrdiniDAO ordiniDAO, ArticoliOrdineService articoliOrdineService) {
        this.ordineDAO = ordiniDAO;
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
    public OrdineCompleto getById(Integer id) throws IllegalArgumentException, NotFoundException {
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
    public void deleteOrdinePerId(Integer id) throws IllegalArgumentException, NotFoundException {
        if (this.ordineDAO.getIdOrdine(id) == null) {
            throw new NotFoundException("ORDINE NON TROVATO");
        } else {
            this.articoliOrdineService.deletePerIdOrdine(id);
            this.ordineDAO.deletePerId(id);
        }
    }

    @Override
    public void deleteOrdinePerData(LocalDate data) throws NotFoundException {
        List<Integer> idOrdineEliminato = ordineDAO.getOrdiniPerData(data);
        if(idOrdineEliminato.isEmpty()){
            throw new NotFoundException("ORDINE NON TROVATO");
        }
        else{
            for (Integer idOrdine : idOrdineEliminato) {
                articoliOrdineService.deletePerIdOrdine(idOrdine);
                ordineDAO.deletePerId(idOrdine);
            }
        }
    }

}