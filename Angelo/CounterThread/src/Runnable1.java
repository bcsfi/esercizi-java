public class Runnable1 implements Runnable{
    private Counter contatore;
    private int incrementCount;
    public Runnable1(Counter contatore, int incrementCount){
        this.contatore = contatore;
        this.incrementCount = incrementCount;
    }
    public void run(){
        for (int i = 0; i < incrementCount; i++){
            contatore.increment();
        }
        System.out.println("Thread incrementato per " + incrementCount + "volte.");
    }
}
