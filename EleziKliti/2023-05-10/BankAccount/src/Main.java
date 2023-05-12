import com.sun.source.tree.TryTree;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws EccezionePersonalizzata {
        String email, password;

        while (true){

            UserManage utente = new UserManage();

            System.out.println("Benvenuto in BancaItalia.\n");
            System.out.print("Prima di procede bisogna seguire la registrazione \n");

            System.out.print("Email: ");
            Scanner scan = new Scanner(System.in);
            email = scan.next();
            System.out.print("Password: ");
            password = scan.next();

            if(email.length() < 8)
                System.out.print("\n Errore email troppo corta!");

            if(password.length() < 8)
                    System.out.print("\n Errore password troppo corta");


            boolean statusRegistrazione = utente.createUtente(email, password);

            if(statusRegistrazione){
                System.out.print("\n Utente registrato!, login effettuato.");
                System.out.print("\n Il tuo conto ha un budget di 50 euro, regalati come bonus dalla banca. \n");
                break;
            }
        }

        BankAccount user = new BankAccount(email, 50);
        while (true) {

            System.out.println("\nUSER: " + email);
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