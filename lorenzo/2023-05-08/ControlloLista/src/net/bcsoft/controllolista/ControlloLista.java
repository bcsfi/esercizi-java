import javax.print.DocFlavor;
import java.util.ArrayList;

public class ControlloLista {
    public static void main(String[] args) {
        int number4List = UserInput.getNumber4List();

        ArrayList<Integer> list1 = UserInput.getCreateList(number4List,1);
        ArrayList<Integer> list2 = UserInput.getCreateList(number4List,2);

        ArrayList<Integer> comparingList = ManageList.getComparing(list1, list2);
        String comparingString = ManageList.getList2String(comparingList);

        System.out.print("'Lista1' contiene " + comparingList.size() +
                " elementi di 'Lista2': " + comparingString);
    }
}

