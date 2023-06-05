package org.bcbank.model;

public class Risultati {

    private String iban;
    private int numeroTransazioni;
    private double giacenzaMensileConto;

    public Risultati(String iban, int numeroTransazioni, double giacenzaMensileConto){
        this.iban=iban;
        this.numeroTransazioni=numeroTransazioni;
        this.giacenzaMensileConto=giacenzaMensileConto;
    }

    public String getIban() {
        return iban;
    }
    public void setIban(String iban) {
        this.iban = iban;
    }
    public int getNumero() {
        return numeroTransazioni;
    }
    public void setNumero(int numeroTransazioni) {
        this.numeroTransazioni = numeroTransazioni;
    }
    public void addOne(){
        this.numeroTransazioni+=1;
    }
    public double getGiacenza() {
        return giacenzaMensileConto;
    }
    public void setGiacenza(double giacenzaMensileConto) {
        this.giacenzaMensileConto = giacenzaMensileConto;
    }
}
