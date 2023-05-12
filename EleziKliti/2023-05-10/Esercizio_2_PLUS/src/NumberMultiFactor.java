import java.util.ArrayList;
import java.util.List;

public class NumberMultiFactor<N> {

    List<N> d = new ArrayList<N>();
    List<String> typeList = new ArrayList<String>();

    public void addToList(N items){
        if(items instanceof Integer){
            Integer itemsConv = (Integer) items;
            d.add(items);
            typeList.add("Intero");
        } else if(items instanceof Long){
            Long itemsConv = (Long) items;
            d.add(items);
            typeList.add("Long");
        } else if(items instanceof Double){
            Double itemsConv = (Double) items;
            d.add(items);
            typeList.add("Double");
        } else {
            System.out.print("Errore, L'oggetto che hai provato ad aggiungere non risulta essere, Integer, Boolean oppure Double.");
        }

    }

    public List<N> returnArrayOfNumber(){
        return d;
    }

    public List<String> returnArrayOfType(){
        return typeList;
    }


}
