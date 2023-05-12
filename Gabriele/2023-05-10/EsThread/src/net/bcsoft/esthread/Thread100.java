package net.bcsoft.esthread;

public class Thread100 extends Thread implements Runnable{
    private Counter conteggio = new Counter();

    public void run(){
        int risultato = 0;
        for (int i = 0; i < 100; i++){
            risultato = conteggio.increment(conteggio.getCount());
            conteggio.setCount(risultato);
        }
        System.out.println(risultato);
    }

}
