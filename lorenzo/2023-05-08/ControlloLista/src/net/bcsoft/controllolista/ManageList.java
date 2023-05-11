package net.bcsoft.controllolista;

import java.util.ArrayList;

public class ManageList {
    public static ArrayList<Integer> compareList(ArrayList<Integer> list1, ArrayList<Integer> list2){
        ArrayList<Integer> returnList = new ArrayList<Integer>();

        for (Integer i : list1) {
            if(list2.contains(i)) returnList.add(i);
        }
        return returnList;
    }

    public static String getList2String(ArrayList<Integer> comparingList){
        String comparingString = "";
        for(int i = 0; comparingList.size() > i; i++){
            String s = comparingList.get(i).toString();
            if(comparingString.length() != 0) comparingString = comparingString + ",";
            comparingString = comparingString + s;
        }

        return comparingString;
    }
}
