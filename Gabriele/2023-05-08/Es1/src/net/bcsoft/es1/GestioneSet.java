package net.bcsoft.es1;

import java.util.HashSet;
import java.util.Set;

public class GestioneSet {
    private Set<Integer> set = new HashSet<>();

    public GestioneSet(Set <Integer> set){
        this.set = set;
    }

    public void stampaSet(Set <Integer> set){
        for (Integer integer : set) {
            System.out.println(integer);
        }
    }
}
