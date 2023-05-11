public class Main {
    public static void main(String[] args) {
        BankAccount myAccount = new BankAccount(123456, "Angelo Marini", 0.89);
        Double withdrawalAmount = 0.90;
        try {
            myAccount.collect(withdrawalAmount);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
        System.out.printf("il conto: " + myAccount.getNumeroConto()+ "\ndi:" + myAccount.getNomeTitolare()+ "\nil saldo è di: "+ myAccount.getsaldoConto() + " €");
    }
}