package net.bcsoft.bank;

public class BankAccount {
    protected Integer numeroConto;
    protected String nomeTitolare;
    protected String cognomeTitolare;
    protected double saldo;

    public BankAccount(Integer numeroConto, String nomeTitolare, String cognomeTitolare, double saldo) {
        this.numeroConto = numeroConto;
        this.nomeTitolare = nomeTitolare;
        this.cognomeTitolare = cognomeTitolare;
        this.saldo = saldo;
    }

    public Integer getNumeroConto() {
        return numeroConto;
    }

    public String getNomeTitolare() {
        return nomeTitolare;
    }

    public String getCognomeTitolare() {
        return cognomeTitolare;
    }

    public double setSaldo() {
        this.saldo
    }
    public double getSaldo() {
        return saldo;
    }


    public void collect(double importo) {
            if(getSaldo() < importo) throw new InsufficientFundsException("Disponibilità insufficente");
            else {
                setSaldo(getSaldo() + importo);
            }
    }
}
