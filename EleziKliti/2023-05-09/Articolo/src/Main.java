

import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Catalogo catalogo = new Catalogo();
        System.out.print("Quanti oggetti vuoi aggiungere (default 3): ");
        Scanner scan_c = new Scanner(System.in);
        int b = 0;
        String name = "";
        double price = 0.0;
        int amountUserToAdd;
        if (scan_c.hasNextInt()) {
            amountUserToAdd = scan_c.nextInt();
        } else {
            System.out.print("\n Valore non accettato è stato preso in input il valore di default 3.");
            amountUserToAdd = 3;
        }

        while(b < amountUserToAdd) {
            System.out.printf("\n Dai un nome al tuo articolo n. %d : ", amountUserToAdd);
            Scanner scan_String = new Scanner(System.in);
            if (scan_String.hasNextLine()) {
                name = scan_String.nextLine();
                System.out.printf("\n Dai un Prezzo al tuo articolo n. %d : ", amountUserToAdd);
                Scanner scan_int = new Scanner(System.in);
                if (scan_int.hasNextDouble()) {
                    price = scan_int.nextDouble();
                    Articolo newArticolo = new Articolo(name, price);
                    System.out.printf("\n Prodotto n. %d aggiunto. \n", amountUserToAdd);
                    --amountUserToAdd;
                    catalogo.AggiungiArticolo(newArticolo);
                } else {
                    System.out.print("\n Errore, valore non amesso. Ricominciamo da capo.");
                }
            } else {
                System.out.print("\n Errore, valore non amesso. Ricominciamo da capo.");
            }
        }

        catalogo.getArticoliSottoPrezzo(10.0);
        System.out.printf(catalogo.toString());
    }
}
