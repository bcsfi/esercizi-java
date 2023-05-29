package org.example.Functions;

import org.example.POJO.ContoCorrente;
import org.example.POJO.EstrattoContoMensile;
import org.example.POJO.Transazione;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TransazioniPerConto {

    public static Map<String, Double> elaboraPerIban(
            ArrayList<Transazione> listaTransizioni,
            ArrayList<ContoCorrente> listaConti
            ArrayList<EstrattoContoMensile> listaEstrattiContiMensile
    ){

        Map<String, Double> transazioniPerIban = new HashMap<>();


        for(ContoCorrente conto : listaConti){
            for(Transazione transizioni : listaTransizioni){
                if(conto.getId_cc() == transizioni.getId_cc() && transazioniPerIban.containsKey(conto.getIban())){
                    double numeroTransazioniAnticedenti = transazioniPerIban.get(conto.getIban()) + 1;
                    transazioniPerIban.put(conto.getIban(), numeroTransazioniAnticedenti);
                } else {
                    transazioniPerIban.put(conto.getIban(), 1.0);
                }
            }
        }
        return transazioniPerIban;
    }




}
