import java.util.ArrayList;
import java.util.Scanner;
public class ContaListe {
    public static void main(String[] args) {
        ArrayList<Integer> lista1 = new ArrayList<Integer>();
        ArrayList<Integer> lista2 = new ArrayList<Integer>();
        Scanner input = new Scanner(System.in);
        System.out.print("inserisci elementi di lista1: lascia spazio tra un elemento e l'altro: ");
        String[] elementi1 = input.nextLine().split(" ");
        for (String numero : elementi1) {
            lista1.add(Integer.parseInt(numero));
        }
        System.out.print("inserisci elementi di lista2: lascia spazio tra un elemento e l'altro: ");
        String[] elementi2 = input.nextLine().split(" ");
        for (String numero : elementi2) {
            lista2.add(Integer.parseInt(numero));
        }
        //controllo
        ArrayList<Integer> listaComuni = new ArrayList<Integer>();
        for (Integer numero : lista2 ){
            if (lista1.contains(numero)){
                listaComuni.add(numero);
            }
        }
        int n = listaComuni.size();
        if (n > 0){
            System.out.print("lista1 contiene" +  n  + "elementi di lista2: ");
            for (int i = 0; i < n -1; i++){
                System.out.print(listaComuni.get(i) + ", ");
            }
            System.out.print(listaComuni.get(n - 1));
        }
        else {
            System.out.println("nessun elemento in comune");
        }
    }
}