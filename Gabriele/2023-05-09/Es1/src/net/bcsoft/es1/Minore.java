package net.bcsoft.es1;

import java.util.ArrayList;
import java.util.List;

public class Minore<T extends Number>  {


    public List<T> minorDi(List <T> lista, T valore) {
        List<T> minori = new ArrayList<>();
            for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).doubleValue() < valore.doubleValue()) {
                minori.add(lista.get(i));
                }
            }
        return minori;
    }
}