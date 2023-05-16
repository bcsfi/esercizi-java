class IncrementoThread implements Runnable {
    private Counter counter;
    private int incrementAmount;

    public IncrementoThread(Counter counter, int incrementAmount) {
        this.counter = counter;
        this.incrementAmount = incrementAmount;
    }

    @Override
    public void run() {
        for (int i = 0; i < incrementAmount; i++) {
            counter.increment();
        }
    }
}
