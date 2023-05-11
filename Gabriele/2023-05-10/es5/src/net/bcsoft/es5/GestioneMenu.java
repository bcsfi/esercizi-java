package net.bcsoft.es5;

import java.util.Map;

public class GestioneMenu {
    public void addVoto(String nome, double voto, Map pagella) {
        pagella.put(nome, voto);
    }

    public void aggiornaVoto (String nome, double voto, Map pagella) throws StudentNotFoundException{
       if(pagella.get(nome) == null){
           throw new StudentNotFoundException("STUDENTE NON ESISTENTE");
       }
       else{
           pagella.replace(nome, voto);
       }
    }

    public void rimuoviVoto(String nome, Map pagella) throws StudentNotFoundException{
        if(pagella.get(nome) == null){
            throw new StudentNotFoundException("STUDENTE NON ESISTENTE");
        }
        else{
            pagella.remove(nome);
        }
    }

    public void mostraVoto(String nome, Map pagella) throws StudentNotFoundException{
        if(pagella.get(nome) == null){
            throw new StudentNotFoundException("STUDENTE NON ESISTENTE");
        }
        else{
             System.out.println("Il voto di " + nome + "e: " + pagella.get(nome));
        }
    }
}
