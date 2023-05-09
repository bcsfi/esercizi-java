public class Coppie<T, E> {
    private T a;
    private E b;

    public Coppie (T x, E y){
        this.a = x;
        this.b = y;
    }

    public T getb() {
        return a;
    }

    public E geta() {
        return b;
    }

}