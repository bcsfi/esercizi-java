package net.bcsoft.controllolista;

import java.util.ArrayList;

public class ControlloLista {
    public static void main(String[] args) {
        int number4List = UserInput.getNumber4List();

        ArrayList<Integer> list1 = UserInput.createList(number4List,1);
        ArrayList<Integer> list2 = UserInput.createList(number4List,2);

        ArrayList<Integer> comparedList = ManageList.compareList(list1, list2);
        String comparingString = ManageList.getList2String(comparedList);

        System.out.print("'Lista1' contiene " + comparedList.size() +
                " elementi di 'Lista2': " + comparingString);
    }
}

