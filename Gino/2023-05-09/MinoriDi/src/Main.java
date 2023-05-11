import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main<T>
{
    private static <T> List<T> minoriDi(List<T> list, T value)
    {
        List<T> returnList = new ArrayList<>();

        //if (!(value instanceof Integer))
        //{
            list.forEach(element ->
            {
                if (T.compareTo(element, value) < 0)
                {
                    returnList.add(element);
                }
            });

        //}

        return returnList;
    }

    public static void main(String[] args)
    {

    }
}