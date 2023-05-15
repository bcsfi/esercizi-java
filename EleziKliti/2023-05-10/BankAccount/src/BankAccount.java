import java.util.Collection;
import java.util.Random;

public class BankAccount extends UserManage {

    private StringBuilder codeNumber= new StringBuilder("@BankItalia#");
    private double soldiTitolare = 0;

    BankAccount(Integer soldiTitolare){
        this.codeNumber = generateConto();
        this.soldiTitolare = soldiTitolare;
    }


    public double getSoldiTitolare(){
        return this.soldiTitolare;
    }

    public void collect(double prelievo) throws EccezionePersonalizzata{

        if(soldiTitolare < prelievo)
            throw new EccezionePersonalizzata("Errore, il tuo conto sembra non avere abbstanza fondi");

        this.soldiTitolare = soldiTitolare - prelievo;

    }


    public StringBuilder generateConto(){

        Random rand = new Random();
        for(int i=0; i < 6; i++){
            int nCasuale = rand.nextInt(100);
            codeNumber.append(nCasuale);
        }

        return this.codeNumber;
    }
}
