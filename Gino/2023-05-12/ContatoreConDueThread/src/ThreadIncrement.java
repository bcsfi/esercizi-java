public class ThreadIncrement extends Thread
{
    private Counter counter;
    private int laps;
    private String message;

    public ThreadIncrement(Counter counter, int laps, String message)
    {
        this.counter = counter;
        this.laps = laps;
        this.message = message;
    }
    public void run()
    {
        for (int i = 0; i < laps; i++)
        {
            counter.increment();
        }

        System.out.println(message + " Adesso il contatore vale " + counter.getCount());
    }
}
