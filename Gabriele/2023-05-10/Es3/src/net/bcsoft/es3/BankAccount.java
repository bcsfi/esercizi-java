package net.bcsoft.es3;

public class BankAccount {
    private int numeroConto;
    private String nomeTitolare;
    private double saldoConto;

    public int getNumeroConto(){
        return numeroConto;
    }
    public String getNomeTitolare(){
        return nomeTitolare;
    }
    public double getSaldoConto(){
        return saldoConto;
    }
    public void setSaldoConto(double saldoConto){
        this.saldoConto = saldoConto;
    }

    public void setNomeTitolare(String nomeTitolare) {
        this.nomeTitolare = nomeTitolare;
    }

    public void setNumeroConto(int numeroConto) {
        this.numeroConto = numeroConto;
    }

    public void collect (double detrazione) throws InsufficentFoundException{
        double risultato;
        risultato = saldoConto - detrazione;
        if (risultato < 0){
            throw new InsufficentFoundException("SALDO NON SUFFICENTE");
        }
        else{
            setSaldoConto(risultato);
            System.out.println("Saldo prelevato correttamente.");
        }
    }

    public void controlloAttributi() throws AttributeNullException{
        if(nomeTitolare == null || numeroConto == 0 || saldoConto == 0.0){
            throw new AttributeNullException("ERRORE, UNO O TUTTI GLI ATTRIBUTI SONO VUOTI");
        }
    }

}
