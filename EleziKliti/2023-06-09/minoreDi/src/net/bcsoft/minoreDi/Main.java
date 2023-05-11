package net.bcsoft.minoreDi;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> listNumeric = new ArrayList<>();
        listNumeric.add(3);
        listNumeric.add(15);
        listNumeric.add(25);
        listNumeric.add(8);
         listNumeric.add(null);

        ArrayList<Integer> risultato = minoreDi(listNumeric, Integer.valueOf(10));

        for(Integer x : risultato){
            System.out.println("Il numeri minori sono: " + x.intValue());
        }

    }

    public static <T> ArrayList<T> minoreDi(ArrayList<T> listNumeric, T valore){
        ArrayList<T> resultList = new ArrayList<>();
        if(valore instanceof Comparable){
            Comparable compVal = (Comparable) valore;
            for(T numeric:listNumeric) {
                Comparable compNum = (Comparable) numeric;
                int c = compNum.compareTo(compVal);
                if (c < 0) resultList.add(numeric);
            }
        }
        return resultList;
    }
}