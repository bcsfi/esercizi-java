import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BankAccount myAccount = new BankAccount(33333, "Arcangioli Giacomo", 100000);

        System.out.print("Quanto vuoi ritirare ?  ");
        Double withdrawalAmount = scanner.nextDouble();

        try {
            myAccount.collect(withdrawalAmount);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
        System.out.printf("il conto: " + myAccount.getNumeroConto()+ "\ndi:" + myAccount.getNomeTitolare()+ "\nil saldo è di: "+ myAccount.getsaldoConto() + " €");
    }
}