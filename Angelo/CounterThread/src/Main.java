// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter contatore = new Counter();
        Runnable1 thread1 = new Runnable1(contatore, 100);
        Runnable1 thread2 = new Runnable1(contatore, 49);
        Thread t1 = new Thread(thread1);
        Thread t2 = new Thread(thread2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("valore de lconteggio finale: " + contatore.getCount());
    }
}