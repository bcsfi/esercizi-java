package net.bcsoft.controllolista2;

public class Coppia<T,S> {
    private T t;
    private S s;

    public Coppia(T tCostruttore, S sCostruttore) {
        this.t = tCostruttore;
        this.s = sCostruttore;
    }
    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public S getS() {
        return s;
    }

    public void setS(S s) {
        this.s = s;
    }

    @Override
    public String toString(){
        return "" + this.t + this.s;
    }
}
