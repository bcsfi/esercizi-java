import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListaGenericDouble {

    List<Coppie<?, ?>> list = new ArrayList<>();



    public void addInstance(Coppie<?,?>  instance){
        list.add(instance);
    }


}
