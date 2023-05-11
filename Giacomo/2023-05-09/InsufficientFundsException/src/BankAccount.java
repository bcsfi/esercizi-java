public class BankAccount {
    private Integer numeroConto = 0;
    private String nomeTitolare ;
    private double saldoConto = 0 ;
 public BankAccount(Integer numeroConto, String nomeTitolare, double saldoConto) {
     this.numeroConto = numeroConto;
     this.nomeTitolare = nomeTitolare;
     this.saldoConto = saldoConto;
 }

    public void collect(Double amount) throws InsufficientFundsException {
        if (amount > saldoConto) {
            throw new InsufficientFundsException("saldo insufficiente.");
        } else {
            saldoConto -= amount;
        }
    }

    public Integer getNumeroConto() {
        return numeroConto;
    }

    public String getNomeTitolare() {
        return nomeTitolare;
    }

    public Double getsaldoConto() {
        return saldoConto;
    }
}

