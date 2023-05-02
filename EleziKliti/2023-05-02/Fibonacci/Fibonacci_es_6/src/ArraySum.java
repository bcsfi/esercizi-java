import java.util.Vector;

public class ArraySum {
    static int arrayStringSum(Vector<String> someWord ){

        int sum = 0;

        for(int a=0; a < someWord.size()-1; a++)
        {
            System.out.print("Lunghezza vettore: "+  someWord.size());
            String captureWord = someWord.get(a);


            boolean verifica = Character.isUpperCase(captureWord.charAt(0));

            if(verifica)
            {
                System.out.println(captureWord + "is capitalized.");
                sum++;
            }

        }

        System.out.println(someWord);
        return sum;
    }

}
