public class Main {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Hello world!");


        ThreadUno t1 = new ThreadUno();
        Thread thread1 = new Thread(t1);

        ThreadDue t2 = new ThreadDue();
        Thread thread2 = new Thread(t2);

        // Avvia thread
        thread1.start();
        thread2.start();

        // Crea la "coda"
        thread1.join();
        thread2.join();


        System.out.print("Risultato Thread 1: " + t1.getRes() + "\n");
        System.out.print("Risultato Thread 2: " + t2.getRes() + "\n");
    }
}