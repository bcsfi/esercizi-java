package net.bcsoft.es2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Catalogo {
    private List <Articolo> articoloList = new ArrayList<Articolo>();

    public Catalogo(List <Articolo> articoloList){
        this.articoloList = articoloList;
    }


    public void aggiungiArticolo(Articolo articolo){
        articoloList.add(articolo);
    }


    public List <Articolo> getArticoliSottoPrezzo(double prezzo){
        List <Articolo> articoliPrezzominoreList = new ArrayList<>();
        for (int i = 0; i < articoloList.size(); i++){
            if (articoloList.get(i).getPrezzo() < prezzo){
                articoliPrezzominoreList.add(articoloList.get(i));
            }
        }
        return articoliPrezzominoreList;
    }

    public String toString(){
        String stampa = "";
        for (int i = 0; i < articoloList.size(); i++){
            stampa = stampa + "Elemento numero " + (i + 1) +" : " + "\n " + "nome: " + articoloList.get(i).getNome() + "\n" + "prezzo: " +  articoloList.get(i).getPrezzo() + "\n";
        }
        return stampa;
    }



}
