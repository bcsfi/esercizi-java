package net.bcsoft.es2;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean controlloMenu = true;
        String nome = null;
        double prezzo = 0.0;
        List <Articolo> catalogoList = new ArrayList<>();
        Catalogo catalogo = new Catalogo(catalogoList);
        int scelta, dimensione;
        double limitePrezzo;
        do {
            System.out.println("Cosa vuoi fare? \n"+
                    "1) Aggiungere un articolo alla lista; \n" +
                    "2) Stampare l'intero catalogo; \n" +
                    "3) Ottenere la lista di articoli sotto un determinato prezzo; \n" +
                    "4) Uscire dal menu. ");
            scelta = input.nextInt();
            switch (scelta){
                case 1:
                    System.out.println("Quanti articoli vuoi aggiungere? ");
                    dimensione = input.nextInt();
                    for(int i = 0; i < dimensione; i++){
                        Articolo newGame = new PcGame();
                        System.out.println("Inserisci il nome: ");
                        nome = input.next();
                        newGame.setNome(nome);
                        System.out.println("Inserisci il prezzo (nel formato " + Locale.getDefault().getDisplayCountry() + ")");
                        prezzo = input.nextDouble();
                        newGame.setPrezzo(prezzo);
                        catalogo.aggiungiArticolo(newGame);
                    }
                    break;
                case 2:
                    System.out.println(catalogo.toString());
                    break;
                case 3:
                    System.out.println("Sotto quale prezzo vuoi vedere gli elementi? ");
                    limitePrezzo = input.nextInt();
                    List <Articolo> articoloList = catalogo.getArticoliSottoPrezzo(limitePrezzo);
                    for (int i = 0; i < articoloList.size(); i++) {
                        System.out.println(articoloList.get(i));
                    }
                    break;
                case 4:
                    controlloMenu = false;
            }
        }while(controlloMenu);
    }
}