package net.bcsoft.es2;

public class PcGame implements Articolo{
    private String nome;
    private double prezzo;

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setPrezzo(double prezzo){
        this.prezzo = prezzo;
    }

    public String getNome() {
        return nome;
    }

    public double getPrezzo() {
        return prezzo;
    }
    public String toString(){
        String stampa =  "Nome: " + getNome() + "\n" + "prezzo: " +  getPrezzo();
        return stampa;
    }
}
