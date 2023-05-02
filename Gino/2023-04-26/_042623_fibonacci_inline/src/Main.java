public class Main {
    public static void main(String[] args)
    {
        long currentNumber = 0, nextNumber = 1, support;
        int value = Integer.parseInt(args[0]);
        
        for (int i = 0; i < value; i++)
        {
            System.out.println(currentNumber);
            support = currentNumber;
            currentNumber = nextNumber;
            nextNumber += support;
        }
    }
}