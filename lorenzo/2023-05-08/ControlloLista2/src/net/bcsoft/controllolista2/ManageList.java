package net.bcsoft.controllolista2;

import java.util.ArrayList;

public class ManageList {
    public static ArrayList<Integer> getComparing(ArrayList<Integer> list1, ArrayList<Integer> list2){
        ArrayList<Integer> returnList = new ArrayList<Integer>();

        for (Integer i : list1) {
            if(list2.contains(i)) returnList.add(i);
        }
        return returnList;
    }

    public static String getList2String(ArrayList<Integer> comparingList){
        String comparingString;
        comparingString = comparingList.toString()
                .replace("[", "").replace("]", "");

        return comparingString;
    }
}