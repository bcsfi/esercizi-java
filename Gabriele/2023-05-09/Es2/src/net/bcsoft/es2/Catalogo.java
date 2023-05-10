package net.bcsoft.es2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Catalogo implements Articolo{
    private List <Articolo> catalogoList = new ArrayList<Articolo>();
    private String nome;
    private double prezzo;

    public Catalogo(String nome, double prezzo, List <Articolo> catalogoList){
        this.nome = nome;
        this.prezzo = prezzo;
        this.catalogoList = catalogoList;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setPrezzo(double prezzo){
        this.prezzo = prezzo;
    }

    public void aggiungiArticolo(Articolo articolo){
        catalogoList.add(articolo);
    }
    public void getArticoliSottoPrezzo(double prezzo){
        List <Articolo> articoliPrezzominoreList = new ArrayList<>();
        for (int i = 0; i < catalogoList.size(); i++){
            if (catalogoList.get(i).getPrezzo() < prezzo){
                articoliPrezzominoreList.add(catalogoList.get(i));
                System.out.println("Elemento numero " + (i + 1) + ": \n" + "Nome: " + articoliPrezzominoreList.get(i).getNome() + "\n" + "Prezzo: " + articoliPrezzominoreList.get(i).getPrezzo());
            }
        }
    }

    public String toString(){
        String stampa = "";
        for (int i = 0; i < catalogoList.size(); i++){
            stampa = stampa + "Elemento numero " + (i + 1) +" : " + "\n " + "nome: " + catalogoList.get(i).getNome() + "\n" + "prezzo: " +  catalogoList.get(i).getPrezzo() + "\n";
        }
        return stampa;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public double getPrezzo() {
        return prezzo;
    }
}
