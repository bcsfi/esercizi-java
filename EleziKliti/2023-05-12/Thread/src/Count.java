public class Count {

    private int count;

    public int getCount(){
        return this.count;
    }

    // Vieta l'utilizzo del metodo da più thread contemporaneamente
    public synchronized void increment(){
        count++;
    }

}
