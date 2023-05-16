import java.util.HashMap;
import java.util.Map;

public class UserManage {
    Map<String, String> userList = new HashMap<String, String>();



    public boolean createUtente(String email, String password) throws EccezionaValoreNull {

        if(email == null){
            throw new EccezionaValoreNull("Errore, valore null non amesso!");
        }

        if(password == null){
            throw new EccezionaValoreNull("Errore, valore null non amesso!");
        }

        userList.put(email, password);

        if(userList.containsKey(email) && userList.containsValue(password)){return true;} else {
            return false;
        }

    }
}
