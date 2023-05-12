package net.bcsoft.esthread;

public class Counter {
    private int count;

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount(){
        return count;
    }

    public int increment(int count){
        count++;

        return count;
    }
}
