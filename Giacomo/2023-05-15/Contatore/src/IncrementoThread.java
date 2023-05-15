public class IncrementoThread extends Thread {

    private Contatore contatore;
    private int incrementoThread;

    public IncrementoThread(Contatore contatore, int incrementoThread){

        this.contatore = contatore;
        this.incrementoThread = incrementoThread;
    }
    @Override
    public void run (){
        for (int i = 0; i < incrementoThread; i++){
            contatore.increment();
        }
        System.out.println("Thread completato: incrementato di "+ incrementoThread);
    }
}
