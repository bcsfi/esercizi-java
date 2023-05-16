public class BankAccount
{
    private Integer numeroDiConto;
    private String nomeDelTitolareDelConto;
    private Double saldoDelConto;

    public BankAccount (Integer numeroDiConto, String nomeDelTitolareDelConto, Double saldoDelConto)
    {
        setNumeroDiConto(numeroDiConto);
        setNomeDelTitolareDelConto(nomeDelTitolareDelConto);
        setSaldoDelConto(saldoDelConto);
    }

    public Integer getNumeroDiConto() {
        return numeroDiConto;
    }

    public void setNumeroDiConto(Integer numeroDiConto) {
        this.numeroDiConto = numeroDiConto;
    }

    public String getNomeDelTitolareDelConto() {
        return nomeDelTitolareDelConto;
    }

    public void setNomeDelTitolareDelConto(String nomeDelTitolareDelConto) {
        this.nomeDelTitolareDelConto = nomeDelTitolareDelConto;
    }

    public Double getSaldoDelConto() {
        return saldoDelConto;
    }

    public void setSaldoDelConto(Double saldoDelConto) {
        this.saldoDelConto = saldoDelConto;
    }

    public void collect(double detrazione) throws InsufficientFundsException
    {
        if(getSaldoDelConto() >= detrazione)
        {
            setSaldoDelConto(getSaldoDelConto() - detrazione);
        }
        else
        {
            throw new InsufficientFundsException("Detrazione bloccata per saldo insufficiente");
        }
    }
}