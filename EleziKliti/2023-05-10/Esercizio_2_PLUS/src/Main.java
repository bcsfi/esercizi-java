import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] string) {

        boolean start = true;
        Scanner scan = new Scanner(System.in);
        NumberMultiFactor<Number> listNumberMultiFactor = new NumberMultiFactor<Number>();


        try {
            while(start){

                System.out.print("\n Seleziona il numero da inserire (scrivi una stringa per fermarti): ");

                if(scan.hasNextInt()){
                    int capture = scan.nextInt();
                    listNumberMultiFactor.addToList(capture);
                } else if(scan.hasNextLong()){
                    Long capture = scan.nextLong();
                    listNumberMultiFactor.addToList(capture);
                } else if(scan.hasNextDouble()){
                    double capture = scan.nextDouble();
                    listNumberMultiFactor.addToList(capture);
                } else {
                    break;
                }

                System.out.print("\n Valore inserito correttamente.");

            }
        } catch(InputMismatchException inp){
            System.out.print("\n Errore, Input inserito del tipo non valido. \n ");
        } catch (ArrayIndexOutOfBoundsException aid){
            System.out.print("\n Errore, Sei uscito fuori dal range dell'array \n");
        }


        System.out.print("\tLista valori:\t\n");

        for(int i=0; i < listNumberMultiFactor.returnArrayOfNumber().size(); i++){
            System.out.print("\t \t Valore: " + listNumberMultiFactor.returnArrayOfNumber().get(i));
            System.out.print(" Tipo " + listNumberMultiFactor.returnArrayOfType().get(i));
            System.out.print("\n");
        }




    }
}

