package net.bcsoft.controllolista2;

import java.util.ArrayList;
import java.util.List;

public class ControlloLista2 {
    public static void main(String[] args) {
        int number4List = UserInput.Number4List();

        List<Coppia> listaDiCoppie = new ArrayList<>();
        List<Coppia<Integer,Integer>> listaDiCoppieInt = new ArrayList<>();

        Coppia c = new Coppia(number4List, number4List);
        listaDiCoppieInt.add(c);

        Coppia a = new Coppia("Ciao", "aaaa");
        listaDiCoppieInt.add(a);

        for (int i=0; i<listaDiCoppieInt.size(); i++){
            System.out.print(listaDiCoppieInt.get(i).toString());
        }

      /*
        ArrayList<Integer> list1 = UserInput.getCreateList(number4List,1);
        ArrayList<Integer> list2 = UserInput.getCreateList(number4List,2);

        ArrayList<Integer> comparingList = ManageList.getComparing(list1, list2);
        String comparingString = ManageList.getList2String(comparingList);

        System.out.print("'Lista1' contiene " + comparingList.size() +
                " elementi di 'Lista2': " + comparingString); */
    }
}
