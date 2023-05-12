package net.bcsoft.es5;

import java.util.HashMap;
import java.util.Map;

public class GestioneMenu {
    private Map <Studente, Double>pagella = new HashMap();

    public GestioneMenu(Map<Studente, Double> pagella) {
        this.pagella = pagella;
    }
    public void addVoto(Studente studente, double voto) {
        pagella.put(studente, voto);
    }

    public void aggiornaVoto (double voto, Studente studente) throws StudentNotFoundException{
       if(pagella.get(studente) == null){
           throw new StudentNotFoundException("STUDENTE NON ESISTENTE");
       }
       else{
            pagella.replace(studente, voto);
       }
    }

    public void rimuoviVoto(Studente studente) throws StudentNotFoundException{
        if(pagella.get(studente.getNome()) == null){
            throw new StudentNotFoundException("STUDENTE NON ESISTENTE");
        }
        else{
            pagella.remove(studente);
        }
    }

    public void mostraVoto(Studente studente) throws StudentNotFoundException{
        if(pagella.get(studente) == null){
            throw new StudentNotFoundException("STUDENTE NON ESISTENTE");
        }
        else{
            System.out.println("Il voto di " + studente.getNome() + " " + studente.getCognome() + " e: " + pagella.get(studente));
            }
        }
    }

