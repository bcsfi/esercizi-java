package org.bcbank.controller;
import org.bcbank.model.Conto;
import org.bcbank.model.Estratto;
import org.bcbank.model.Risultati;
import org.bcbank.model.Transazione;
import java.time.LocalDate;
import java.util.*;

public class ElaboratoreDati {
    private final List<Transazione> elencoTransazioni;
    private final List<Conto> elencoConti;
    private final List<Estratto> elencoEstratti;
    public ElaboratoreDati(List<Transazione> elencoTransazioni, List<Conto> elencoConti, List<Estratto> elencoEstratti){
            this.elencoTransazioni=elencoTransazioni;
            this.elencoConti=elencoConti;
            this.elencoEstratti=elencoEstratti;
    }

    public List<Risultati> creaListaDeiRisultati(){
        List<Risultati> listaDeiRisultati = new ArrayList<>();
        for(Conto conto : this.elencoConti){
            Risultati res = new Risultati(conto.getIban(), 0, 0.0);
            res.setNumero(calcolaTransazioni(conto));
            res.setGiacenza(calcolaGiacenza(conto));
            if(verificaData()){
                listaDeiRisultati.add(res);
                System.out.print("Aggiunto alla lista res... \n");
            } else {
                System.out.print("FALSEE|");
            }
        }
        return listaDeiRisultati;
    }

    private int calcolaTransazioni(Conto conto){
        int count = 0;

        for(Transazione transazione : this.elencoTransazioni){
            if(transazione.getIdCc() == conto.getId()){
                count++;
            }
        }
        return count;
    }

    private double calcolaGiacenza(Conto conto){
        double giacenza=0;
        for(Estratto estratto : elencoEstratti)
        {
            if(conto.getId() == estratto.getIdCc())
            {
                giacenza = estratto.getGiacenza();

                for(Transazione transazione : elencoTransazioni)
                {
                    if(conto.getId() == transazione.getIdCc())
                    {
                        giacenza += transazione.getImporto();
                    }

                }
                return giacenza;
            }
        }

        return giacenza;
    }

    private boolean verificaData(){
        boolean status = false;

        for(Transazione transazione : this.elencoTransazioni){
            LocalDate dataInizio = LocalDate.of(2023, 5, 1);
            LocalDate dataFine = LocalDate.of(2023, 5, 31);

            if (transazione.getDataTransazione().isBefore(dataInizio) || transazione.getDataTransazione().isAfter(dataFine)) {
                 status = true;
            } else {
                 status = true;
            }

        }
        return status;
    }




}

