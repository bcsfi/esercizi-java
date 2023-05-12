package net.bcsoft.esthread;

public class Thread50  extends Thread implements Runnable{
    private Counter conteggio = new Counter();

    public void run(){
        int risultato = 0;
        for (int i = 0; i < 50; i++){
            risultato = conteggio.increment(conteggio.getCount());
            conteggio.setCount(risultato);
        }
        System.out.println(risultato);
    }
}
