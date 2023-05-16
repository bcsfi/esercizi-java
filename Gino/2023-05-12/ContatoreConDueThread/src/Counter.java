public class Counter
{
    private int count;

    public Counter(int count)
    {
        this.count = count;
    }

    public void increment()
    {
        count++;
    }

    public int getCount()
    {
        return count;
    }

    public void setCount(int count)
    {
        this.count = count;
    }
}