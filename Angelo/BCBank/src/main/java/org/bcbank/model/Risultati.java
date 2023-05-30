package org.bcbank.model;

public class Risultati {

    private String iban;
    private double numeroTransazioni;
    private double giacenzaMensileConto;

    public Risultati(String iban, double numeroTransazioni, double giacenzaMensileConto){
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
    public double getNumero() {
        return numeroTransazioni;
    }
    public void setNumero(double numero_transizioni) {
        this.numeroTransazioni = numero_transizioni;
    }
    public void addOne(){
        this.numeroTransazioni+=1;
    }
    public double getGiacenza() {
        return giacenzaMensileConto;
    }
    public void setGiacenza(double giacenza_mensile_conto) {
        this.giacenzaMensileConto = giacenza_mensile_conto;
    }
}
