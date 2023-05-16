public class ThreadUno implements Runnable {

    Count x = new Count();

    public  void  run() {
        for(int i =0; i<100; i++){
            x.increment();
        }
    }

    public synchronized int getRes(){
        return x.getCount();
    }
}
