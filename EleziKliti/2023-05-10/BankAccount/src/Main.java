import com.sun.source.tree.TryTree;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws EccezionePersonalizzata {
        String email, password;
        System.out.println("Benvenuto in BancaItalia.\n");
        System.out.print("Prima di procede bisogna seguire la registrazione \n");

        while (true){

            UserManage utente = new UserManage();

            System.out.print("Email: ");
            Scanner scan = new Scanner(System.in);
            email = scan.next();
            System.out.print("Password: ");
            password = scan.next();

            if(email.length() < 7){
                System.out.print("\n Errore email troppo corta! \n");
            } else if(password.length() < 6){
                System.out.print("\n Errore password troppo corta \n");
            } else {
                try {
                    boolean statusRegistrazione = utente.createUtente(email, password);
                    if(statusRegistrazione){
                        System.out.print("\n Utente registrato!, login effettuato.");
                        System.out.print("\n Il tuo conto ha un budget di 50 euro, regalati come bonus dalla banca. \n");
                        break;
                    }
                }catch (EccezionaValoreNull x){
                    System.out.print(x.getMessage());
                }
            }



        }

        BankAccount user = new BankAccount(50);
        while (true) {
            System.out.print("\nCODICE IDENTIFICATIVO: " + user.generateConto());
            System.out.print("\nUSER: " + email );
            System.out.print("\nSOLDI: " +  user.getSoldiTitolare());
            Scanner scan = new Scanner(System.in);
            System.out.printf("\n(quantità prelevabile %f) ", user.getSoldiTitolare());
            System.out.print("Quanto vuoi prelevare: " );

            try {
                if(scan.hasNextInt() || scan.hasNextDouble()){
                    double prelievo = scan.nextDouble();
                    user.collect((double) prelievo);
                } else {
                    System.out.println("\n Quantità non accettata. ");

                }
            } catch (EccezionePersonalizzata d){
                System.out.println(d.getMessage());
            }

        }

    }
}