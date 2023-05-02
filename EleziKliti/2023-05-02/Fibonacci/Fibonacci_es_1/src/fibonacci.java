
public class fibonacci {


    static int countFib(int cicli){


        // valori di partenza per fibonacci
        int val_1=0; int val_2=1;

        // Cicla per l'input dell'utente e segui la serie di fibonacci(somma i ultimi due numeri partendo da 0 e 1)
        for(int i=0; i < cicli/2; i++)
        {
            System.out.println((val_1));
            System.out.println((val_2));
            val_1=val_2+val_1;
            val_2=val_2+val_1;
        }
        return 0;
    }

    static String countFib(String cicli){

        int conv = Integer.parseInt((cicli));

        // valori di partenza per fibonacci
        int val_1=0; int val_2=1;

        // Cicla per l'input dell'utente e segui la serie di fibonacci(somma i ultimi due numeri partendo da 0 e 1)
        for(int i=0; i < conv/2; i++)
        {
            System.out.println((val_1));
            System.out.println((val_2));
            val_1=val_2+val_1;
            val_2=val_2+val_1;
        }
        return "";
    }

    static long countFib(long cicli){

        // valori di partenza per fibonacci
        int val_1=0; int val_2=1;

        // Cicla per l'input dell'utente e segui la serie di fibonacci(somma i ultimi due numeri partendo da 0 e 1)
        for(int i=0; i < cicli/2; i++)
        {
            System.out.println((val_1));
            System.out.println((val_2));
            val_1=val_2+val_1;
            val_2=val_2+val_1;
        }
        return 0;
    }

}
