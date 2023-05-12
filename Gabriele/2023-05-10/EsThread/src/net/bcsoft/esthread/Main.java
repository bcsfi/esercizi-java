package net.bcsoft.esthread;


public class Main {
    public static void main(String[] args) {
        Thread100 thread100 = new Thread100();
        Thread50 thread50 = new Thread50();

        thread100.start();

        thread50.start();

    }
}