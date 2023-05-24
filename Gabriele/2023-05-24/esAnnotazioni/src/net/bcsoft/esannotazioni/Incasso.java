package net.bcsoft.esannotazioni;

public class Incasso {
    private String nome;

    public Incasso(String nome){
        this.nome = nome;
    }

    @Special
    public String getName(){
        return nome;
    }
}
