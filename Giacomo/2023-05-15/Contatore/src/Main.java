public class Main {
    public static void main(String[] args) {
        Contatore contatore = new Contatore();

        IncrementoThread thread1 = new IncrementoThread(contatore, 100);
        IncrementoThread thread2 = new IncrementoThread(contatore, 50);

        thread1.start();
        thread2.start();

        try{
            thread1.join();
            thread2.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.print("conteggio finale: " + contatore.getCount());
    }
}