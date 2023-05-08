package net.bcsoft.es2;

public class Coppie<T, E> {
    private T x;
    private E y;

    public Coppie (T x, E y){
        this.x = x;
        this.y = y;
    }

    public T getX() {
        return x;
    }

    public E getY() {
        return y;
    }

}
